package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.blinx.ams.generalHealth.SiteSelectionPageOLS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedFlareMonitoringAppClosePageCC extends MainPageCC {

    private static Logger Log = LogManager.getLogger(QualifiedFlareMonitoringAppClosePageCC.class.getName());

    //Qualified Flare Monitoring App Close----------------
    public final String titleExpected = "This research study requires you to be in active disease (also known as flare) with your digestive condition. There is a helpful app called My Colo that you can download to your android or iPhone. The app will help you monitor your symptoms and determine if you are in active disease (or flare). Your information will be sent to the study site once the app determines you are in active disease.";

    public final String titleEmail = "We're glad the location is convenient for you.\n" +
            "\n" +
            "The last step is to provide information about the doctors who are currently treating, or have previously treated, your Migraines so we can send your medical records to the study doctor. Please complete all details required on the next screen.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with an email address to start this process. What email address should we use:";

    public final String titleExpectedCrohns = "Once you download and activate the MyColo app, take time to answer the 3 daily questions. This will measure your disease activity and alert you when you are experiencing active disease (also known as flare). Once the app alerts you to being in flare, you will be prompted to call us so we can connect you to your study site staff who will discuss your qualifications for the study and next steps.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//*[contains(@class, 'sub_question_text')]")
    WebElement titleText2;

    @FindBy(xpath = "//div[contains(@class,'question_text')]//u")
    WebElement activationCodePath;

    @FindBy(xpath = "//input[@id='answersQSC9114A.rawAnswer']")
    WebElement emailidField;

    @FindBy(xpath = "//div[@class='text_email_container']/input")
    WebElement email;

    public QualifiedFlareMonitoringAppClosePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageCC waitForPageLoadCrohns() {
        waitForPageLoadMain(titleText2, titleExpectedCrohns);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageCC waitForEmailPage() {
        waitForPageLoadMain(titleText, titleEmail);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageCC getActivationCode() {
        String activationCode = getText(activationCodePath);
        logTextToAllure("Activation Code " + activationCode);
        Log.info("Activation Code = " + activationCode);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageCC enterEmail(String emailid) {
        typeText(emailidField, emailid);
        logTextToAllure("Email_ID " + emailid);
        Log.info("Email_ID = " + emailid);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageCC provideEmail(String emailid) {
        typeText(email, emailid);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
