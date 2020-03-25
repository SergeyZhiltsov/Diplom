package com.acurian.selenium.pages.blinx.ams.glaucoma;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SurgeryOrImplantToTreatGlaucomaOLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever had any type of surgery or implant to treat your glaucoma or ocular hypertension?\n" +
            "This includes laser surgery or surgery involving an incision.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public SurgeryOrImplantToTreatGlaucomaOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SurgeryOrImplantToTreatGlaucomaOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
