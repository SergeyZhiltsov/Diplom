package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdobeSignMedAuthFormPage extends MainPageBlinx {

    final String titleTextExpected = "Authorization Form";

    @FindBy(css = "div.agreement-band-inner span.title")
    WebElement titleText;
    @FindBy(css = "button[class='popover coachmark down left sticky']")
    WebElement startLabel;
    @FindBy(css = "input[placeholder='Click here to sign']")
    WebElement signatureField;
    @FindBy(css = "div.signature-pad input[class='form-control signature-type-name adobehanda']")
    WebElement typeYourSignatureHereField;
    @FindBy(css = "button[class='btn btn-primary apply']")
    WebElement applyButton;
    @FindBy(css = "button[class='btn btn-primary click-to-esign ']")
    WebElement clickToSign;

    @Step
    public AdobeSignMedAuthFormPage waitForPageLoad() {
        waitForAnimation();
        getDriver().switchTo().frame("adobeSign");
        waitForPageLoadMain(titleText, titleTextExpected);
        return this;
    }

    @Step
    public AdobeSignMedAuthFormPage setSignature(String signature) {
        waitAndClickWebElement(startLabel);
        getActions().
                moveToElement(signatureField)
                .click().build().perform();
        waitForVisibility(typeYourSignatureHereField);
        typeTextWithoutClear(typeYourSignatureHereField, signature);
        waitAndClickWebElement(applyButton);
        return this;
    }

    @Step
    public <T extends MainPageBlinx> T clickToSignButton(T page) {
        waitAndClickWebElement(clickToSign);
        return (T) page;
    }

    @Step()
    protected WebElement waitAndClickWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;
    }

    @Step()
    private WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
