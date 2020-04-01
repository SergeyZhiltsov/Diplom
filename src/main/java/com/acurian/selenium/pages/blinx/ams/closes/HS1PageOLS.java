package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

public class HS1PageOLS extends MainPageBlinx {

    public final String titleExpected = "If the e-signature form did not appear or if you were unable to complete the Medical Record Release process please do not worry. We will contact you if additional information is needed.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//button[span/text()='OK']")
    WebElement popButtonOk;

    @FindBy(xpath = "//textarea[@placeholder='Enter First Name'] | //*[@id='page-0']/div[1]/div/div[1]/div/textarea")
    WebElement firstNameField;

    @FindBy(xpath = "(//textarea[@data-qa-ref='text-input'])[18] | //*[@id='page-1']/div[5]/div/div[1]/div/textarea")
    WebElement nameField;

    //@FindBy(xpath = "//div[@id='signer-mobile-application']//div[@class='m-document-signature-field input']/span[text()='Click to sign']")
    @FindBy (xpath = "//div[@data-qa-ref = 'signature-input'] | //*[@id='page-1']/div[6]/div/div[1]")
    WebElement clickToSignButton;

    @FindBy(xpath = "//body[@id='signer-mobile-body']//div[@role='dialog']//div[@class='m-sign-modal--menu']/div[3]/span[@class='m-sign-modal--menu--item--label']")
    WebElement typeItInButton;

    @FindBy(xpath = "//button[@id='insertButton']")
    WebElement insertButton;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//div[@class='m-signer-mobile-header-alert-message']")
    WebElement messageAllRequred;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//button[//text()='Continue'] | //button[@data-qa-ref='button-next']")
    WebElement continueButton;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//button[//text()='I agree']")
    WebElement agreeButton;


    private void waitJQuery(){
        wait.until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) getDriver()).executeScript(
                "return document.readyState"
        ).equals("complete"));
        wait.until((ExpectedCondition<Boolean>) wdriver -> (boolean)((JavascriptExecutor) getDriver()).executeScript(
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
            textToAttachment("alerts was not appeared");
        }
        waitForAnimation();
        return this;
    }

    @Step
    public HS1PageOLS clickOkInPopUp() {
        waitForAnimation();
        getDriver().switchTo().frame("hsEmbeddedFrame");
        waitforVisibility(popButtonOk);
        popButtonOk.click();
        return this;
    }

    @Step
    public HS1PageOLS setSignature() {
        waitForAnimation();
        firstNameField.click();
        for (int i = 0; i < 18; i++) {
            threadSleep(5);
            getActions().sendKeys(Keys.TAB).build().perform();
        }
        waitForAnimation();
        nameField.click();
        typeTextWithoutClear(nameField,"Acurian trial");
        waitForAnimation();
        waitJQuery();
        clickToSignButton.click();
        waitJQuery();
        waitForAnimation();
        waitforVisibility(typeItInButton);
        typeItInButton.click();
        waitJQuery();
        waitForAnimation();
        waitforVisibility(insertButton);
        insertButton.click();
        waitForAnimation();
        waitforVisibility(continueButton);
        continueButton.click();
        waitForAnimation();
        waitforVisibility(agreeButton);
        agreeButton.click();
        waitForAnimation();
        return this;
    }

    @Step
    public HS1PageOLS waitToClickNext() {
        wait.until(ExpectedConditions
                .visibilityOf(titleText));
        waitForAnimation();
        wait.until(ExpectedConditions
                .invisibilityOfElementWithText(By.xpath(Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS), titleExpected));
        return this;
    }


    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
