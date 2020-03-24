package com.acurian.selenium.pages.CC.AST_4337;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class RescueInhalersPageCC extends MainPageCC{

    public final String titleExpected = "Rescue inhalers are used for quick relief when you're having asthma symptoms.\n" +
            "Do you use any of the following rescue inhalers?\n" +
            "Agent Note: Read medications in the following way: \"ProAir, Proventil, Ventolin, or VoSpire, also known as albuterol\" etc. Select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public RescueInhalersPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public RescueInhalersPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public RescueInhalersPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
