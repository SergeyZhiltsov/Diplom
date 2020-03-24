package com.acurian.selenium.pages.CC.Diabetes_4356A;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InsulinForYourDiabetesPageCC extends MainPageCC{

    public final String titleExpected = "Do you currently take any of the following types of insulin for your diabetes?\n" +
            "Insulin is a medication that is injected using a shot, needle, or pen.\n" +
            "Agent Note: Can be read to patients if needed: \"I will be happy to stay on hold while you retrieve your medication bottles.\" Read medications in the following way: \"Lantus or Toujeo, also known as insulin glargine\" etc.\n" +
            "Select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public InsulinForYourDiabetesPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InsulinForYourDiabetesPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public InsulinForYourDiabetesPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
