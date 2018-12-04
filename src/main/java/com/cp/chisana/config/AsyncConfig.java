package com.cp.chisana.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {


    @Value("${chisana.async.thread.core.pool.size}")
    private String corePoolSize;
    @Value("${chisana.async.thread.max.pool.size}")
    private String maxPoolSize;
    @Value("${chisana.async.thread.queue.capacity}")
    private String queueCapacity;
    @Value("${chisana.async.thread.name.prefix}")
    private String threadNamePrefix;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Integer.valueOf(corePoolSize));
        executor.setMaxPoolSize(Integer.valueOf(maxPoolSize));
        executor.setQueueCapacity(Integer.valueOf(queueCapacity));
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }
}
