package com.example.demo.jobImpl;

import java.io.Serializable;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SampleJobImpl implements Job, Serializable {

    private static final long serialVersionUID = 1L;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		log.warn("-------- job executed...");
//		System.err.println("-------- job executed...");
		
	}

}
