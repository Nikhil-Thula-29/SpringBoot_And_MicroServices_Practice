package com.main.listener;



import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;


@Component("listener")
public class JobMonitoringListener implements JobExecutionListener {

	private long start,end;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		start=System.currentTimeMillis();
		System.out.println("JobMonitoringListener.beforeJob()"+new Date());
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		end=System.currentTimeMillis();
		System.out.println("JobMonitoringListener.afterJob()"+new Date());
		System.out.println("Jobexecution status: "+jobExecution.getExitStatus());
	}
}
