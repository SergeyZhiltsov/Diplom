package com.acurian.selenium.pages.CC.IBS;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AbdominalPainWhenHavingIBSPageCC extends MainPageCC{

    public final String titleExpected = "Do you experience abdominal pain when you are having IBS symptoms?\n" +
            "Abdominal pain means any pain in your stomach or abdomen.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public AbdominalPainWhenHavingIBSPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AbdominalPainWhenHavingIBSPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AbdominalPainWhenHavingIBSPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
