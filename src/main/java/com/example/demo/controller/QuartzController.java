package com.example.demo.controller;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jobImpl.SampleJobImpl;

@RestController
@RequestMapping(path = "/quartz")
public class QuartzController {
	
	@Autowired
	private Scheduler scheduler;
	
	@GetMapping(path = "/test1/{cron}")
	public String test1(@RequestParam(value = "cron") String cron) throws SchedulerException {
		
        String jobName = "sampleTrigger";

        JobDetail build = JobBuilder.newJob(SampleJobImpl.class)
        		.withIdentity("sampleJob")
        		.storeDurably()
        		.build();
        
    	CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
    			.cronSchedule(cron);
//    			.cronSchedule("0/5 * * * * ?");
    	
    	JobKey jobKey = JobKey.jobKey(jobName);
    	String triggerId = jobKey.getName();
    	TriggerKey triggerKey = TriggerKey.triggerKey(triggerId);

    	CronTrigger trigger = TriggerBuilder.newTrigger()
                .forJob(build)
                .withIdentity("sampleTrigger")
                .withSchedule(scheduleBuilder)
                .build();

        scheduler.rescheduleJob(triggerKey, trigger);
		
		return "OK";
		
	}
	
}
