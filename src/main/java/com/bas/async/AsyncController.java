package com.bas.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * The type Async controller.
 *
 * @author Baskar
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class AsyncController {

    private final AsyncService asyncService;

    /**
     * Gets data.
     *
     * @throws InterruptedException the interrupted exception
     * @throws ExecutionException   the execution exception
     */
    @GetMapping("/")
    public String getData() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> s1 = asyncService.getAsync1();
        CompletableFuture<String> s2 = asyncService.getAsync2();

        // 'allOf' is used to wait until all the futures (provided as a var-arg - s1 and s2) are completed.
        CompletableFuture.allOf(s1, s2).join();

        //other variant:
        /*
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(s1, s2);
        combinedFuture.get();
        */
        log.info("Executed both async methods. Time to get the results.");
        // to check if individual future is done, use the following
        // s1.isDone();

        // this is to get the value returned from each async calls
        log.info("s1--> " + s1.get());
        log.info("s2--> " + s2.get());
        long endTime = System.currentTimeMillis();
        return "Done running async methods in spring way with a sleep time of 3s in each methods. Total execution time (ms) : " + (endTime - startTime);
    }

}

