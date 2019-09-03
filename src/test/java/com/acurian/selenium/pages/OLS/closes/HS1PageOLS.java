package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

public class HS1PageOLS extends MainPageOLS {

    public final String titleExpected = "If the e-signature form did not appear or if you were unable to complete the Medical Record Release process please do not worry. We will contact you if additional information is needed.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//button[span/text()='OK']")
    WebElement popButtonOk;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//div[@class='m-signature-document-field--component']/div[contains(@class,'m-document-text-input-field')]/textarea[@tabindex='1']")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//div[@class='m-signature-document-field--component']/div[contains(@class,'m-document-text-input-field')]/textarea[@tabindex='22']")
    WebElement nameField;
    
    @FindBy(xpath = "//div[@id='signer-mobile-application']//div[@class='m-document-signature-field input']/span[text()='Click to sign']")
    WebElement clickToSignButton;

    @FindBy(xpath = "//div[@class='m-sign-modal-popup']//div[@class='m-sign-modal--menu']//span[text()='Type it in']")
    WebElement typeItInButton;

    @FindBy(xpath = "//button[@id='insertButton']")
    WebElement insertButton;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//div[@class='m-signer-mobile-header-alert-message']")
    WebElement messageAllRequred;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//button[//text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//button[//text()='I agree']")
    WebElement agreeButton;
    


    public HS1PageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    private void waitJQuery(){
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) getDriver()).executeScript(
                "return document.readyState"
        ).equals("complete"));
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) wdriver -> (boolean)((JavascriptExecutor) getDriver()).executeScript(
                "return jQuery.active == 0"
        ));
    }

    @Step
    public HS1PageOLS waitForPageLoad() {
        waitForAnimation();
        try {
            acceptAlert();
            acceptAlert();
        }
        catch (Exception ex){
            logTextToAllure("alerts was not appeared");
        }
        waitForAnimation();
        return this;
    }

    @Step
    public HS1PageOLS clickOkInPopUp() {
        waitForAnimation();
        getDriver().switchTo().frame("hsEmbeddedFrame");
        driverWait.waitforVisibility(popButtonOk);
        popButtonOk.click();
        return this;
    }

    @Step
    public HS1PageOLS setSignature() {
        waitForAnimation();
        firstNameField.click();
        for (int i = 0; i < 18; i++) {
            threadSleep(500);
            getActions().sendKeys(Keys.TAB).build().perform();
        }
        waitForAnimation();
        threadSleep(1000);
        nameField.click();
        typeTextWithoutClear(nameField,"Acurian trial");
        waitForAnimation();
        waitJQuery();
        threadSleep(1000);
        driverWait.waitforVisibility(clickToSignButton);
        clickToSignButton.click();
        waitJQuery();
        waitForAnimation();
        driverWait.waitforVisibility(typeItInButton);
        typeItInButton.click();
        waitJQuery();
        waitForAnimation();
        driverWait.waitforVisibility(insertButton);
        insertButton.click();
        waitForAnimation();
        driverWait.waitforVisibility(continueButton);
        continueButton.click();
        waitForAnimation();
        driverWait.waitforVisibility(agreeButton);
        agreeButton.click();
        waitForAnimation();
        return this;
    }

    @Step
    public HS1PageOLS waitToClickNext() {
    	driverWait.getWaitDriver().withTimeout(2, TimeUnit.MINUTES).until(ExpectedConditions
                .visibilityOf(titleText));
        waitForAnimation();
        driverWait.getWaitDriver().withTimeout(15, TimeUnit.SECONDS).until(ExpectedConditions
                .invisibilityOfElementWithText(By.xpath(Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS), titleExpected));
    	return this;
    }
    
    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }
    
}