package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WeightLossSurgeryPageOLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever had any of the following types of bariatric or weight loss surgery?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public WeightLossSurgeryPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WeightLossSurgeryPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WeightLossSurgeryPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
