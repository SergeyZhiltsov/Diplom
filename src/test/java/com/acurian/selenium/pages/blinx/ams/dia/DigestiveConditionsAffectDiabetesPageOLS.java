package com.acurian.selenium.pages.blinx.ams.dia;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DigestiveConditionsAffectDiabetesPageOLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever been diagnosed with any of the following digestive conditions which affect some people with diabetes?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public DigestiveConditionsAffectDiabetesPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DigestiveConditionsAffectDiabetesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DigestiveConditionsAffectDiabetesPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
