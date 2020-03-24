package com.acurian.selenium.pages.CC.Vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouInterestedInVaccineStudiesCC extends MainPageCC {

    private final String titleExpected = "We may have several vaccine studies accepting new participants.\n" +
            "Are you interested in any of the following?\n"+
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    private WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    private List<WebElement> checkboxList;

    @Step
    public AreYouInterestedInVaccineStudiesCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouInterestedInVaccineStudiesCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkboxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
