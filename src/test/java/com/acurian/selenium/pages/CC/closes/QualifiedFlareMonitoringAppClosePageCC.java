package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedFlareMonitoringAppClosePageCC extends MainPageCC{

    //Qualified Flare Monitoring App Close----------------
    public final String titleExpected = "This research study requires you to be in active disease (also known as flare) with your digestive condition. There is a helpful app called My Colo that you can download to your android or iPhone. The app will help you monitor your symptoms and determine if you are in active disease (or flare). Your information will be sent to the study site once the app determines you are in active disease.";

    public final String titleEmail = "We're glad the location is convenient for you.\n" +
    		"\n" +
    		"The last step is to provide information about the doctors who are currently treating, or have previously treated, your Migraines so we can send your medical records to the study doctor. Please complete all details required on the next screen.\n" +
    		"\n" +
    		"Please be assured that your records will be kept confidential and only shared with the research facility.\n" + 
    		"\n" +
    		"You will need to provide us with an email address to start this process. What email address should we use:";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;
    
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
    public QualifiedFlareMonitoringAppClosePageCC waitForEmailPage() {
        waitForPageLoadMain(titleText, titleEmail);
        return this;
    }
    
    @Step
    public QualifiedFlareMonitoringAppClosePageCC getActivationCode(){
        String activationCode = getText(activationCodePath);
        logTextToAllure("Activation Code "+activationCode);
        System.out.println("Activation Code = "+activationCode);
        return this;
    }
    
    @Step
    public QualifiedFlareMonitoringAppClosePageCC enterEmail(String emailid) {
        typeText(emailidField, emailid);
        logTextToAllure("Email_ID "+emailid);
        System.out.println("Email_ID = "+emailid);
        return this;
    }
    
    @Step
    public QualifiedFlareMonitoringAppClosePageCC provideEmail(String emailid) {
        typeText(email, emailid);
           return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
