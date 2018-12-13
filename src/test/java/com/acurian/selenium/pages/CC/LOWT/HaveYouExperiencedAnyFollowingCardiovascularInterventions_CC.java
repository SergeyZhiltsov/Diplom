package com.acurian.selenium.pages.CC.LOWT;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouExperiencedAnyFollowingCardiovascularInterventions_CC extends MainPageCC {
    public final String titleExpected = "Have you experienced any of the following cardiovascular interventions or surgeries? \n" +
            "Agent note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public HaveYouExperiencedAnyFollowingCardiovascularInterventions_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouExperiencedAnyFollowingCardiovascularInterventions_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouExperiencedAnyFollowingCardiovascularInterventions_CC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
