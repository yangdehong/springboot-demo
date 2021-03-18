package com.ydh.redsheep.springbatch;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BatchTests {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job processJob;
    @Autowired
    Job processJob2;
    @Autowired
    Job processJob3;
    @Autowired
    Job processJob4;
    @Autowired
    Job processJob5;

    @Test
    void contextLoads() throws Exception{
        System.out.println("begin============");
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        jobLauncher.run(processJob5, jobParameters);
        System.out.println("end============");
    }

}
