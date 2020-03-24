package com.acurian.selenium.pages.CC.ADG_4357;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class GastroparesisSymptomsCausedByFollowingPageCC extends MainPageCC {

    public final String titleExpected = "Has a healthcare professional told you that your gastroparesis symptoms are caused by any of the following?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public GastroparesisSymptomsCausedByFollowingPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public GastroparesisSymptomsCausedByFollowingPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public GastroparesisSymptomsCausedByFollowingPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
