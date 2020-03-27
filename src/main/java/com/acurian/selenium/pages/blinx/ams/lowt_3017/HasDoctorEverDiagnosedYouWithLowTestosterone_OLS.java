package com.acurian.selenium.pages.blinx.ams.lowt_3017;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasDoctorEverDiagnosedYouWithLowTestosterone_OLS extends MainPageBlinx {

    public final String titleExpected = "Testosterone is the male sex hormone. Levels may drop as men age.\n" +
            "Has a doctor ever diagnosed you with low testosterone or hypogonadism?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;


    @Step
    public HasDoctorEverDiagnosedYouWithLowTestosterone_OLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasDoctorEverDiagnosedYouWithLowTestosterone_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
