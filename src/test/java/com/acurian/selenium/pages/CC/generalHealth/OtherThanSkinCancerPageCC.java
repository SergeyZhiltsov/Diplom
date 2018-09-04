package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OtherThanSkinCancerPageCC extends MainPageCC {

    public final String titleExpected = "When were you diagnosed with cancer (other than skin cancer)?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public OtherThanSkinCancerPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OtherThanSkinCancerPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText,titleExpected);
        return this;
    }

    @Step
    public OtherThanSkinCancerPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
