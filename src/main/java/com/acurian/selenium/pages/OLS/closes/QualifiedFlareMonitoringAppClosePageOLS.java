package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedFlareMonitoringAppClosePageOLS extends MainPageOLS {
    private String activationCode;
    private String emailAddress;

    private static Logger Log = LogManager.getLogger(QualifiedFlareMonitoringAppClosePageOLS.class.getName());

    //Qualified Flare Monitoring App Close----------------
    public final String titleExpected = "This research study requires you to be in active disease (also known as flare) with your digestive condition. There is a helpful app called My Colo that you can download to your android or iPhone. The app will help you monitor your symptoms and determine if you are in active disease (or flare). Your information will be sent to the study site once the app determines you are in active disease.";

    public final String titleExpectedHealthCheck = "We’re glad the location is convenient for you.\n" +
            "\n" +
            "This research study requires you to be in active disease (also known as flare) with your digestive condition Crohn's Disease. There is a monitoring app called My Colo that you can download to your android or iPhone. The app will monitor your symptoms and determine if you are in active disease (or flare) so you can contact your study site and let them know. Please note that use of this app is not required to take part in the study.";

    public final String titleExpectedCrohns = "Once you download and activate the MyColo app, take time to answer the 3 daily questions. This will measure your disease activity and alert you when you are experiencing active disease (also known as flare). Once the app alerts you to being in flare, you will be prompted to call us so we can connect you to your study site staff who will discuss your qualifications for the study and next steps.";

    public final String titleExpectedQuestion = "Please confirm your email address to ensure you receive your My Colo activation key email.";

    @FindBy(xpath = "(//*[contains(@class, 'visible-md-block')][contains(@class, 'ng-scope')])[2]")
    WebElement titleTextQuestion;

    @FindBy(xpath = "//div[@class='question']")
    WebElement titleText;

    @FindBy(xpath = "(//*[contains(@class, 'visible-md-block')])[2]")
    WebElement titleText2;

    @FindBy(xpath = "(//*[contains(@class, 'visible-xs-block')])[2]")
    WebElement titleText5;

    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]//u")
    WebElement activationCodePath;

    @FindBy(xpath = "//div[contains(@class,'visible-xs-block')]//u")
    WebElement activationCodePath5;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailidField;

    public QualifiedFlareMonitoringAppClosePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageOLS waitForPageLoadCrohns() {
        waitForPageLoadMain(titleText2, titleExpectedCrohns);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageOLS waitForPageLoadCrohns5() {
        waitForPageLoadMain(titleText5, titleExpectedCrohns);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageOLS waitForPageLoadHealthCheck() {
        waitForPageLoadMain(titleTextQuestion, titleExpectedQuestion);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageOLS getActivationCodeCrohns() {
        activationCode = getText(activationCodePath5);
        logTextToAllure("Activation Code " + activationCode);
        Log.info("Activation Code = " + activationCode);
        return this;
    }


    @Step
    public QualifiedFlareMonitoringAppClosePageOLS getActivationCode() {
        activationCode = getText(activationCodePath);
        logTextToAllure("Activation Code " + activationCode);
        Log.info("Activation Code = " + activationCode);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageOLS getActivationCodeQA() {
        String titleTextTemp = titleText.getText();
        activationCode = titleTextTemp.substring(titleTextTemp.lastIndexOf("is:") + 4, titleTextTemp.lastIndexOf(":") + 8);
        logTextToAllure("Activation Code " + activationCode);
        Log.info("Activation Code = " + activationCode);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppClosePageOLS enterEmail(String emailid) {
        emailAddress = emailid;
        typeText(emailidField, emailid);
        logTextToAllure("Email_ID " + emailid);
        Log.info("Email_ID = " + emailid);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
