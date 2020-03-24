package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class YourNormalBaselinePageOLS extends MainPageOLS{

    public final String titleExpected = "How does your abdominal pain or cramping over the past week from Crohn’s compare to your normal baseline?\n" +
            "Your normal baseline is your level of pain or cramping over the past few months.\n" +
            "\n" +
            "Would you say it is….";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public YourNormalBaselinePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public YourNormalBaselinePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public YourNormalBaselinePageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
