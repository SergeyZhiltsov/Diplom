package com.acurian.selenium.pages.OLS.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HeartrelatedMedicalConditionsProceduresPageOLS extends MainPageOLS{

    public final String titleExpected = "Have you ever been diagnosed with or undergone any of the following additional heart-related medical conditions or procedures?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public HeartrelatedMedicalConditionsProceduresPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HeartrelatedMedicalConditionsProceduresPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HeartrelatedMedicalConditionsProceduresPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
