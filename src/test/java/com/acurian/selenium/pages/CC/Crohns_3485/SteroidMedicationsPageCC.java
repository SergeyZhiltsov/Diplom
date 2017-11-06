package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SteroidMedicationsPageCC extends MainPageCC{

    public final String titleExpected = "Have you ever treated your Crohn's with any of the following steroid medications?\n" +
            "Steroids can come as pills or tablets, or occasionally as an IV, usually given in the hospital.\n" +
            "Agent Notes:\n" +
            "\n" +
            "    Read medications in the following way: \"Prednisone, also known as Deltasone or Rayos\" etc.\n" +
            "    Please read the full list of medications to the respondent\n" +
            "    Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public SteroidMedicationsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SteroidMedicationsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SteroidMedicationsPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
