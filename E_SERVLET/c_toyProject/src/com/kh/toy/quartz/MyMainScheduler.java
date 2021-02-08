package com.kh.toy.quartz;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DateBuilder.*;

public class MyMainScheduler {

	public static void main(String[] args) throws SchedulerException{
		
		JobDetail j = JobBuilder.newJob(MyObject.class).build();
		
		Trigger trigger = newTrigger() 
			    .withIdentity("trigger3", "group1") 
			    .withSchedule(cronSchedule("0 53 10 * * ?")) //cron 표현식 매일 10시 53분에 실행
			    .forJob(j)
			    .build();
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		scheduler.start();
		scheduler.scheduleJob(j, trigger);
	}
}

