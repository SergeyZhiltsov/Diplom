package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.shared.ProcedureForWeightLossPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class RadiantWarmTransferClose1PageCC extends MainPageCC{

    public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "\n" +
            "Agent Note:\n" +
            "If CSR has ability to direct schedule in clinical conductor, then Follow the Scheduling Script\n" +
            "\n" +
            "If CSR does NOT have ability to direct schedule in clinical conductor, then Continue with the Warm Transfer\n" +
            "\n" +
            "I would like to transfer you to the doctor's scheduling center.\n" +
            "Please hold for just a minute while I try to reach the scheduling center.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public RadiantWarmTransferClose1PageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public RadiantWarmTransferClose1PageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public RadiantWarmTransferClose1PageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
