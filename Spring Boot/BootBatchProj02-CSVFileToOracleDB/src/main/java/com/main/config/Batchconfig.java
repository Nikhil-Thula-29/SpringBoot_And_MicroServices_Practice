package com.main.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.main.listener.JobMonitoringListener;
import com.main.processor.EmployeeInfoItemProcessor;
import com.nt.model.Employee;

@Configuration
@EnableBatchProcessing(dataSourceRef = "dataSource", transactionManagerRef = "transactionManager")
public class Batchconfig {

	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EmployeeInfoItemProcessor processor;
	@Autowired
	private DataSource dataSource;
	
	@Bean(name="reader")
	public FlatFileItemReader<Employee> createReader(){
		//create object for the reader class
		FlatFileItemReader<Employee> reader=new FlatFileItemReader();
		//specify csv file name and location
		reader.setResource(new ClassPathResource("EmployeeInfo.csv"));
		//create the LineMapper(To get each recored of csv file)
		DefaultLineMapper<Employee> lineMapper=new DefaultLineMapper<Employee>();
		//create the DelimitedLineTokenizer
		DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames("eno","ename","eadd","salary");
		//create filedsetmapper to convert the tokens of each line into model class object
		BeanWrapperFieldSetMapper<Employee> mapper=new BeanWrapperFieldSetMapper<Employee>();
		mapper.setTargetType(Employee.class);
		//set Tokenize and fieldsetMapper to linemapper
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(mapper);
		//set linemapper to reader
		reader.setLineMapper(lineMapper);
		//return reader
		return reader;
	}
	
	
	@Bean(name="writer")
	public JdbcBatchItemWriter<Employee> createWriter(){
		//create the writer object
		JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>();
		//set datasource
		writer.setDataSource(dataSource);
		//set SQL Query
		writer.setSql("INSERT INTO EMPLOYEE_INFO VALUES(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)");
		//set Employee class obj data as the named parameter values in the insert sql query
		BeanPropertyItemSqlParameterSourceProvider<Employee> source= new BeanPropertyItemSqlParameterSourceProvider<Employee>();
		writer.setItemSqlParameterSourceProvider(source);
		//return writer obj
		return writer;
	}
	
	@Bean(name="step1")
	public Step createStep1(JobRepository repo,PlatformTransactionManager manager) {
		return new StepBuilder("step1",repo)
				.<Employee,Employee>chunk(10,manager)
				.reader(createReader())
				.processor(processor)
				.writer(createWriter())
				.build();
	}
	
	@Bean(name="job1")
	public Job createJob1(JobRepository repo,Step step1) {
		return new JobBuilder("job1",repo)
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(step1)
				.build();
	}
}
