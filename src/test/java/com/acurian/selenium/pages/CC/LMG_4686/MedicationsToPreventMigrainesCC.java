package com.acurian.selenium.pages.CC.LMG_4686;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class MedicationsToPreventMigrainesCC extends MainPageCC{

    public final String titleExpected = "Over the past 10 years, have you ever taken any of the following medications to prevent migraines?\n" +
            "This includes any medications you are currently taking to prevent migraines.\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public MedicationsToPreventMigrainesCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MedicationsToPreventMigrainesCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public MedicationsToPreventMigrainesCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
