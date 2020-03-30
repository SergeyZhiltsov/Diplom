package com.acurian.selenium.pages.FUL_Letters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Step;

public class MedicalRecordsFUL extends FollowupLetter {
    private SoftAssert sa = new SoftAssert();

    @FindBy(xpath = "//div[contains(@style,'padding')]/p[5]")
    WebElement firstParag;

    @FindBy(xpath = "//div[contains(@style,'padding')]/p[7]")
    WebElement secondParag;

    @FindBy(xpath = "//div[contains(@style,'padding')]/p[9]")
    WebElement thirdParag;

    @FindBy(xpath = "//span[contains(@id,'group')]")
    WebElement siteName;

    @FindBy(xpath = "//div[contains(@style,'padding')]//table//span")
    WebElement mrButton;

    @FindBy(xpath = "//div[contains(@style,'padding')]/p[14]")
    WebElement fourthParag;

    @FindBy(xpath = "//div[contains(@style,'padding')]/h3")
    WebElement fifthParag;

    private final String firstParagText = "We have forwarded your information to the study doctor’s office that you selected. If the study doctor’s office has not " +
            "already contacted you, they should be contacting you within the next few days to further discuss the study and to set up an in-person evaluation.";
    private final String secondParagText;
    private final String thirdParagText = "The study doctor’s office that you selected is:";
    private final String fourthParagText = "Please be assured that your records will be kept confidential and only shared with the study research facility.";
    private final String mrButtonText = "Please click here to learn more.";
    private final String fifthParagText = "Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and " +
            "we appreciate your interest in participation.\n" +
            "The AcurianHealth Team";

    public MedicalRecordsFUL() {
        PageFactory.initElements(getDriver(), this);
        secondParagText = "If you are not contacted within the next 5 business days, please contact them directly.";
    }

    public MedicalRecordsFUL(String businessDays) {
        PageFactory.initElements(getDriver(), this);
        secondParagText =  String.format("If you are not contacted within the next %s business days, please contact them directly.", businessDays);
    }

    @Step
    public FollowupLetter assertgmailMRFUL(String pid, String siteNameText) {
        By emailLocator = new By.ByXPath("//div[2]/span/span[contains(text(),'" + pid + "')]");
        WebElement emailTitle;
        typeText(emailSearchBox, pid);
        emailSearchBox.sendKeys(Keys.ENTER);
        logTextToAllureAndConsole("Waiting for email...");
        try {
            emailTitle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
            logTextToAllureAndConsole("Recieved email: " + emailTitle.getText());
            driver.findElement(emailLocator).click();
        } catch (TimeoutException e) {
            Assert.fail("Email wasn't received within 15 mins timeout");
        }
        wait.until(ExpectedConditions.visibilityOf(firstParag));
        sa.assertEquals(firstParag.getText(), firstParagText, "First <p> is Diff");
        sa.assertEquals(secondParag.getText(), secondParagText, "Second <p> is Diff");
        sa.assertEquals(thirdParag.getText(), thirdParagText, "Third <p> is Diff");
        sa.assertEquals(siteName.getText(), siteNameText, "Site name is Diff");
        sa.assertEquals(mrButton.getText(), mrButtonText, "Medical Records button name is Diff");
        sa.assertEquals(fourthParag.getText(), fourthParagText, "Fourth <p> is Diff");
        sa.assertEquals(fifthParag.getText(), fifthParagText, "Fifth <p> is Diff");
        sa.assertAll();
        return this;
    }
}
