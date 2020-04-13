package com.acurian.selenium.listeners;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.utils.analyzer.RetryAnalyzer;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Iterator;

public class TestListener extends TestListenerAdapter implements ITestListener {

    private static Logger Log = LogManager.getLogger(TestListener.class.getName());

    @Override
    public void onTestFailure(ITestResult result) {
        //add allure attach
        if (result.getMethod().getRetryAnalyzer() != null) {
            RetryAnalyzer retryAnalyzer = (RetryAnalyzer) result.getMethod().getRetryAnalyzer();

            if (retryAnalyzer.isRetryAvailable()) {
                // do nothing
            } else {
                result.setStatus(ITestResult.FAILURE);
                Log.error("Test has failed. Test case - " + result.getMethod().getMethodName() +
                        " has failed due to reason:  " + result.getThrowable());
                attachScreenshot();
                //add allure attach
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        Iterator<ITestResult> failedTestCases = context.getFailedTests().getAllResults().iterator();
        while (failedTestCases.hasNext()) {
            ITestResult failedTestCase = failedTestCases.next();
            ITestNGMethod method = failedTestCase.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                failedTestCases.remove();
            } else {

                if (context.getPassedTests().getResults(method).size() > 0) {
                    failedTestCases.remove();
                }
            }
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Test - " + result.getName() + " started");
        super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Test is successful. Test case - " + result.getMethod().getMethodName() + " has passed");
        super.onTestSuccess(result);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        byte[] screenshotAs = null;
        try {
            screenshotAs = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            fail(e);
        }
        return screenshotAs;
    }

    @Attachment(value = "Element screenshot", type = "image/png")
    public static byte[] attachScreenshot(Screenshot screenshot) {
        byte[] screenshotAs = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(screenshot.getImage(), "png", baos);
            screenshotAs = baos.toByteArray();
        } catch (Exception ignored) {
        }
        return screenshotAs;
    }

    @Attachment(value = "Marked Image diff", type = "image/png")
    public static byte[] attachScreenshot(ImageDiff screenshot) {
        byte[] screenshotAs = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(screenshot.getMarkedImage(), "png", baos);
            screenshotAs = baos.toByteArray();
        } catch (Exception ignored) {
        }
        return screenshotAs;
    }

    @Attachment(value = "Unable to save screenshot")
    private String fail(Exception e) {
        return String.format("%s\n%s", e.getMessage(), Arrays.toString(e.getStackTrace()));
    }

}
