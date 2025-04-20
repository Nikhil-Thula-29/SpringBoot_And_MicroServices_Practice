package com.main.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.main.entity.Employee;
import com.main.processor.Employeeprocessor;
import com.main.repository.IEmployee;

//sir has developed db to csv also check that also with scheduling

@Configuration
public class Batchconfig {

	@Autowired
	private Employeeprocessor processor;
	
	
	
	@Autowired
	private IEmployee emprepo;
	
	
	@Bean
	public FlatFileItemReader<Employee> createReader(){
		return new FlatFileItemReaderBuilder<Employee>()
				.name("employeeItemReader")
				.resource(new ClassPathResource("EmployeeInfo.csv"))
				.delimited()
				.names("empno","ename","eadd","salary")
				.targetType(Employee.class)
				.build();
	}
	
	
	@Bean
	public RepositoryItemWriter<Employee> createWriter(){
		return new RepositoryItemWriterBuilder<Employee>()
				.repository(emprepo)
				.methodName("save")
				.build();
				
	}
	
	
	@Bean(name="step1")
	public Step createstep(JobRepository repo,PlatformTransactionManager manager) {
		return new StepBuilder("step1", repo)
				.<Employee,Employee>chunk(3,manager)
				.reader(createReader())
				.processor(processor)
				.writer(createWriter())
				.build();
	}
	
	@Bean(name="job1")
	public Job createJob(JobRepository repo,Step step1) {
		return new JobBuilder("job1",repo)
				.incrementer(new RunIdIncrementer())
				.start(step1)
				.build();
	}
}
