package com.acurian.selenium.pages.blinx.ams.lps_4442;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CurrentlyTakingPrescriptionMedicationsOLS extends MainPageBlinx {

    public final String titleExpected = "Are you currently taking any prescription medication(s) to treat your lupus symptoms?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> checkBoxList;

    public CurrentlyTakingPrescriptionMedicationsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlyTakingPrescriptionMedicationsOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CurrentlyTakingPrescriptionMedicationsOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
