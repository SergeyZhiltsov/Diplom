package com.acurian.selenium.pages.CC.LPS_4442;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TypeOfDoctorCurrentlySeeToHelpManageYourLupusCC extends MainPageCC {

    public final String titleExpected = "What type of doctor(s) do you currently see to help manage your lupus?\n" +
            "Agent Note: Select all that apply";
    public final String titleExpected2 = "Do you currently see a healthcare professional for your lupus symptoms?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> checkBoxList;

    @Step
    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusCC waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusCC clickOnAnswer(String answerText) {
        clickOnRadioButton(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
