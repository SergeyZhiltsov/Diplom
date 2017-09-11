package com.acurian.selenium.listeners;

import com.acurian.selenium.pages.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class TestListener extends TestListenerAdapter{

    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot();
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
