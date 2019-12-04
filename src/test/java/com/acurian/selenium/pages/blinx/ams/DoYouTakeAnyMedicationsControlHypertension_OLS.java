package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouTakeAnyMedicationsControlHypertension_OLS extends MainPageBlinx {

    public final String titleExpected = "Do you take any medications to control high blood pressure or hypertension?";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public DoYouTakeAnyMedicationsControlHypertension_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouTakeAnyMedicationsControlHypertension_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouTakeAnyMedicationsControlHypertension_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
