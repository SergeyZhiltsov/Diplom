package com.acurian.selenium.pages.CC.OAB_4867;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class DoYouTakeAnyMedicationsControlHypertension_CC extends MainPageCC{

    public final String titleExpected = "Do you take any medications to control your high blood pressure or hypertension?";
    

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public DoYouTakeAnyMedicationsControlHypertension_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouTakeAnyMedicationsControlHypertension_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouTakeAnyMedicationsControlHypertension_CC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
