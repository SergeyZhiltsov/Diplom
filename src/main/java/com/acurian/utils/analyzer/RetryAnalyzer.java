package com.acurian.utils.analyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryAnalyzer implements IRetryAnalyzer {


    /**
     * The Log.
     */
    private static Logger Log = LogManager.getLogger(RetryAnalyzer.class.getName());

    /**
     * The max retry count.
     */
    private static int MAX_RETRY_COUNT = System.getProperty("retryCount") == null ? 1
            : Integer.parseInt(System.getProperty("retryCount"));

    /**
     * The count.
     */
    AtomicInteger count = new AtomicInteger(MAX_RETRY_COUNT);

    /**
     * Checks if is retry available.
     *
     * @return true, if is retry available
     */
    public boolean isRetryAvailable() {
        return (count.intValue() > 0);
    }

    /*
     *
     *
     * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
     */
    @Override
    public boolean retry(ITestResult result) {
        boolean retry = false;
        if (isRetryAvailable()) {
            Log.info("RETRYING TEST : " + result.getMethod() + ", "
                    + ((MAX_RETRY_COUNT - count.intValue()) + 1) + " out of " + MAX_RETRY_COUNT);
            retry = true;
            count.decrementAndGet();
        }
        return retry;
    }

}
