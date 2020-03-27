package com.acurian.selenium.pages.blinx.ams.autism_3973;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverBeenToldByDoctorAutism_OLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever been told by a doctor that you have autism or an autism spectrum disorder?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HaveYouEverBeenToldByDoctorAutism_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverBeenToldByDoctorAutism_OLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverBeenToldByDoctorAutism_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
