package com.acurian.selenium.pages.CC.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class BiologicMedicationsCC extends MainPageCC{

    public final String titleExpected = "\"Biologics\" are medications that affect the body's immune system. They are usually given as an infusion (into a vein) or a shot (injection).\n" +
            "Have you ever received any of the following \"biologic\" medications?\n" +
            "Agent Notes:\n" +
            "Please read the full list of medications to the respondent\n" +
            "Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public BiologicMedicationsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public BiologicMedicationsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public BiologicMedicationsCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
