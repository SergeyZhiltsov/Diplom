package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class YourNormalBaselinePageCC extends MainPageCC{

    public final String titleExpected = "How does your abdominal pain or cramping over the past week from Crohn’s compare to your normal baseline?\n" +
            "Your normal baseline is your level of pain or cramping over the past few months.\n" +
            "\n" +
            "Would you say it is….\n" +
            "Agent Note: Read list";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public YourNormalBaselinePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public YourNormalBaselinePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public YourNormalBaselinePageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
