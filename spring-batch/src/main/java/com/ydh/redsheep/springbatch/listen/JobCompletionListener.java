package com.ydh.redsheep.springbatch.listen;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListener extends JobExecutionListenerSupport {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("开始时候的状态"+jobExecution.getStatus());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("完成任务的状态");
        }
    }

}
