package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.nt.listener.JobMonitoringListener;
import com.nt.processor.BookInfoItemProcessor;
import com.nt.reader.BookInfoItemReader;
import com.nt.writer.BookInfoItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private BookInfoItemReader reader;

    @Autowired
    private BookInfoItemProcessor processor;

    @Autowired
    private BookInfoItemWriter writer;

    @Autowired
    private JobMonitoringListener listener;

    @Bean(name="step1")
	public Step createstep1(JobRepository repo,PlatformTransactionManager manager) {
		
		
		return new StepBuilder("step1",repo)
				.<String,String>chunk(3,manager)		//chunk = list
				.reader(reader)
				.writer(writer)
				.processor(processor)
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
