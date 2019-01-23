package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedFlareMonitoringAppCLose_OLS extends MainPageOLS{
    private String activationCode;
    private String emailAddress;

    //Qualified Flare Monitoring App Close----------------
    public final String titleExpected = "We’re glad the location is convenient for you.\n" +
    		"\n" +
    		"This research study requires you to be in active disease (also known as flare) with your digestive condition. There is a monitoring app called My Colo " +
            "that you can download to your android or iPhone. The app will monitor your symptoms and determine if you are in active disease (or flare) so you can contact your " +
            "study site and let them know. Please note that use of this app is not required to take part in the study.";

    @FindBy(xpath = "//div[@class='question']")
    WebElement titleText;
    
    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]//u")
    WebElement activationCodePath;
    
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailidField;

    public QualifiedFlareMonitoringAppCLose_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedFlareMonitoringAppCLose_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    
    @Step
    public QualifiedFlareMonitoringAppCLose_OLS getActivationCode(){
        activationCode = getText(activationCodePath);
        logTextToAllure("Activation Code " + activationCode);
        System.out.println("Activation Code = " + activationCode);
        return this;
    }

    @Step
    public QualifiedFlareMonitoringAppCLose_OLS getActivationCodeQA(){
        String titleTextTemp = titleText.getText();
        activationCode = titleTextTemp.substring(titleTextTemp.lastIndexOf("is:") + 4, titleTextTemp.lastIndexOf(":") + 8);
        logTextToAllure("Activation Code " + activationCode);
        System.out.println("Activation Code = " + activationCode);
        return this;
    }
    
    @Step
    public QualifiedFlareMonitoringAppCLose_OLS enterEmail(String emailid) {
        emailAddress = emailid;
        typeText(emailidField, emailid);
        logTextToAllure("Email_ID "+emailid);
        System.out.println("Email_ID = "+emailid);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
