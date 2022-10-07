package com.bas.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * The type Async service.
 *
 * @author Baskar
 */
@Service
@Slf4j
public class AsyncService {

    /**
     * Gets async 1.
     *
     * @return the async 1
     * @throws InterruptedException the interrupted exception
     */
    @Async
    public CompletableFuture<String> getAsync1() throws InterruptedException {
        log.info("Async 1 triggered");
        Thread.sleep(3000);
        log.info("Async 1 done");
        return CompletableFuture.completedFuture("Async 1");
    }

    /**
     * Gets async 2.
     *
     * @return the async 2
     * @throws InterruptedException the interrupted exception
     */
    @Async
    public CompletableFuture<String> getAsync2() throws InterruptedException {
        log.info("Async 2 triggered");
        Thread.sleep(3000);
        log.info("Async 2 done");
        return CompletableFuture.completedFuture("Async 2");
    }

}
