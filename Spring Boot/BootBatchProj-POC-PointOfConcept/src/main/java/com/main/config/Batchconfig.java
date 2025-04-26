package com.main.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.main.listener.JobMonitoringListener;
import com.main.processor.BookItemProcessor;
import com.main.reader.BookItemReader;
import com.main.writer.BookItemWriter;


//flow->joblauncher(jobrepository)->there will be n no.of steps in steps there will reader, processor,writer -> to required convertor

@Configuration
public class Batchconfig {

	@Autowired
	private BookItemReader itemreader;
	
	@Autowired
	private BookItemProcessor itemprocessor;
	
	@Autowired
	private BookItemWriter itemwriter;
	
	@Autowired
	private JobMonitoringListener listener;
	
	
	@Bean(name="step1")
	public Step createstep1(JobRepository repo,PlatformTransactionManager manager) {
		
		
		return new StepBuilder("step1",repo)
				.<String,String>chunk(3,manager)		//chunk = list
				.reader(itemreader)
				.writer(itemwriter)
				.processor(itemprocessor)
				.build();
	}
	
	
	
	@Bean(name="job1")
	public Job createdjob1(JobRepository repo,Step step1) {  //rem we need to pass above step in jobrepo
		System.out.println("Createdjob");
		return new JobBuilder("job1",repo)
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(step1)
				.build();
	}
}
