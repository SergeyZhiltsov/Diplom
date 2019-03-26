package com.acurian.selenium.pages.CC.RA;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class CurrentlyExperiencingJointSymptomsYourRACC extends MainPageCC{

    public final String titleExpected = "Are you currently experiencing any of the following joint symptoms associated with your RA?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public CurrentlyExperiencingJointSymptomsYourRACC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlyExperiencingJointSymptomsYourRACC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CurrentlyExperiencingJointSymptomsYourRACC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
