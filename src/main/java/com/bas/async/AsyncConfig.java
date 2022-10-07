package com.bas.async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The type Async config.
 *
 * @author Baskar
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    // Use it to Customize the executor bean.
    /*
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Async Thread-");
        executor.initialize();
        return executor;
    }
    */

}
