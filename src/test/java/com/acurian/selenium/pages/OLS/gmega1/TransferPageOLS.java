package com.acurian.selenium.pages.OLS.gmega1;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TransferPageOLS extends MainPageOLS{

    public final String titleExpected = "Transfer not attempted - patient not interested in being transferred";

    @FindBy(xpath = "//question/descendant::span[contains(@class,'visible-md-inline')][1]")
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public TransferPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TransferPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TransferPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
