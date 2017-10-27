package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LastTimeYouTookPageOLS;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HS1PageOLS extends MainPageOLS{

    public final String titleExpected = "When was the last time you took medication for your diabetes?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//button[span/text()='OK']")
    WebElement popButtonOk;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//div[@class='m-signature-document-field--component']/div[contains(@class,'m-document-text-input-field')]/textarea[@tabindex='1']")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@id='signer-mobile-application']//div[@class='m-signature-document-field--component']/div[contains(@class,'m-document-text-input-field')]/textarea[@tabindex='22']")
    WebElement nameField;

    @FindBy(xpath = "")
    WebElement clickToSignButton;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

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
        acceptAlert();
        acceptAlert();
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
        WebElement el = getDriver().findElement(By.xpath(""));
        for (int i = 0; i < 3; i++) {
            el.sendKeys(Keys.TAB);
        }
        return this;
    }

    @Step
    public HS1PageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
