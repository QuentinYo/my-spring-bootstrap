package me.yukuixing.springwebdemo;

import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@SpringBootApplication
@EnableConfigurationProperties
public class SpringWebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebDemoApplication.class, args);
    }

    @Bean("backgroundTaskExecutor")
    public AsyncTaskExecutor backgroundTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("background-task-executor");
        executor.setMaxPoolSize(2);
        executor.setCorePoolSize(2);
        executor.setQueueCapacity(2000);

        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(50);

        // 设置拒绝策略，尽量把任务完成
        executor.setRejectedExecutionHandler(new CallerRunsPolicy());

        return executor;
    }
}
