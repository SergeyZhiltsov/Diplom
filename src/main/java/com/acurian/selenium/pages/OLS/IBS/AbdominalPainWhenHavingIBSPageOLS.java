package com.acurian.selenium.pages.OLS.IBS;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AbdominalPainWhenHavingIBSPageOLS extends MainPageOLS{

    public final String titleExpected = "Do you experience abdominal pain when you are having IBS symptoms?\n" +
            "Abdominal pain means any pain in your stomach or abdomen.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public AbdominalPainWhenHavingIBSPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AbdominalPainWhenHavingIBSPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AbdominalPainWhenHavingIBSPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
