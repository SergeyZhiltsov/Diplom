package com.acurian.selenium.pages.CC.Derm_4631;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC extends MainPageCC {
    public final String titleExpected = "Have you tried any of the following treatments for your eczema?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouTriedAnyFollowingTreatmentsForEczemaPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}