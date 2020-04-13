package com.acurian.selenium.pages.blinx.ams.autism_3973;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InThePast3MonthsHaveYouExperienced_OLS extends MainPageBlinx {

    public final String titleExpected = "The following can be common difficulties for people with autism.\n" +
            "In the past three months, have you experienced any of the following?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public InThePast3MonthsHaveYouExperienced_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InThePast3MonthsHaveYouExperienced_OLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public InThePast3MonthsHaveYouExperienced_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
