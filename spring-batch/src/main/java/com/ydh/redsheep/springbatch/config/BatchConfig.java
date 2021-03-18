package com.ydh.redsheep.springbatch.config;

import com.ydh.redsheep.springbatch.decider.MyDecider;
import com.ydh.redsheep.springbatch.listen.JobCompletionListener;
import com.ydh.redsheep.springbatch.step.Processor;
import com.ydh.redsheep.springbatch.step.Reader;
import com.ydh.redsheep.springbatch.step.Writer;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MyDecider myDecider;

    @Bean
    public Job processJob() {
        return jobBuilderFactory.get("processJob")
//                .listener(listener())
                .start(step())
                .next(step2())
                .next(step3())
                .build();
    }
    @Bean
    public Job processJob2() {
        return jobBuilderFactory.get("processJob2")
//                .listener(listener())
                .start(step())
                .on(ExitStatus.COMPLETED.getExitCode()).to(step2())
                .from(step2())
                .on(ExitStatus.COMPLETED.getExitCode()).to(step3())
                .from(step3()).end()
                .build();
    }

    /**
     * flow
     * @return
     */
    @Bean
    public Job processJob3() {
        return jobBuilderFactory.get("processJob3")
//                .listener(listener())
                .start(flow())
                .next(step3()).end()
                .build();
    }
    private Flow flow() {
        return new FlowBuilder<Flow>("flow")
                .start(step())
                .next(step2())
                .build();
    }

    private Flow flow2() {
        return new FlowBuilder<Flow>("flow")
                .start(step3())
                .build();
    }
    /**
     * 并行执行
     * @return
     */
    @Bean
    public Job processJob4() {
        return jobBuilderFactory.get("processJob4")
//                .listener(listener())
                .start(flow()).split(new SimpleAsyncTaskExecutor())
                .add(flow2()).end()
                .build();
    }
    /**
     * 决策器
     * @return
     */
    @Bean
    public Job processJob5() {
        return jobBuilderFactory.get("processJob5")
//                .listener(listener())
                .start(step())
                .next(myDecider)
                .from(myDecider).on("weekend").to(step2())
                .from(myDecider).on("workingDay").to(step3())
                .build()
                .build();
    }
//    /**
//     * 任务嵌套
//     * @return
//     */
//    @Bean
//    public Job processJob6() {
//        return jobBuilderFactory.get("processJob6")
////                .listener(listener())
//                .start(step())
//                .next(myDecider)
//                .from(myDecider).on("weekend").to(step2())
//                .from(myDecider).on("workingDay").to(step3())
//                .build()
//                .build();
//    }





    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<String, String> chunk(2)
                .reader(new Reader())
                .processor(new Processor())
                .writer(new Writer())
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2").tasklet((stepContribution, chunkContext) -> {
            System.out.println("执行步骤二操作。。。");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3").tasklet((stepContribution, chunkContext) -> {
            System.out.println("执行步骤三操作。。。");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionListener();
    }

}
