package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class NoSiteConvenientGmegaPageOLS extends MainPageBlinx {

    public final String titleExpected = "We are sorry that no study site is convenient for you. We will contact you if a more convenient site becomes available.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public NoSiteConvenientGmegaPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NoSiteConvenientGmegaPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public NoSiteConvenientGmegaPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
