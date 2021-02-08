package com.kh.toy.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyObject implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello! My Scheduler is running !!!");
		System.out.println("지금 시간은 : "+ new Date());
	}
	
}
