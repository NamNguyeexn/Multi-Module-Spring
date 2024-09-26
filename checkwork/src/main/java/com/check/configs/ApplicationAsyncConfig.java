package com.check.configs;

import com.check.exceptions.CustomAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ApplicationAsyncConfig {
    /**
     * Quan ly bang task executor
     *
     * Cac Field co y nghia nhu sau :
     * _setCorePoolsize() : So thread luon san co
     * _setMaxPoolsize() : So thread lon nhat co the duoc tao ra
     * -keepAliveTime() : luong thoi cac luong nhan doi duoc phep lam viec
     * */
    @Bean(name = "MailExecutor")
    public ThreadPoolTaskExecutor mailExecutor() {
        TaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4); // Dong nay co
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("MailThread::");
        executor.initialize();
        return executor;
    }
    @Bean(name = "BatchExecutor")
    public ThreadPoolTaskExecutor batchExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("BatchThread::");
        executor.initialize();
        return executor;
    }
    @Bean
    public CustomAsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler(){
        return new CustomAsyncUncaughtExceptionHandler();
    }
}
