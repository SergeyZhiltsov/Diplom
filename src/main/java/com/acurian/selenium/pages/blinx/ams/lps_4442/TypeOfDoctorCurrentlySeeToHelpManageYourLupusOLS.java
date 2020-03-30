package com.acurian.selenium.pages.blinx.ams.lps_4442;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS extends MainPageBlinx {

    public final String titleExpected = "What type of doctor(s) do you currently see to help manage your lupus?\n" +
            "Please select all that apply.";
    public final String titleExpected2 = "Do you currently see a healthcare professional for your lupus symptoms?";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> checkBoxList;

    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS waitForPageLoad2() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
