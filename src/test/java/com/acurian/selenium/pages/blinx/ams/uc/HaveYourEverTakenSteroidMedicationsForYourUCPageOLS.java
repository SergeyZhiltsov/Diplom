package com.acurian.selenium.pages.blinx.ams.uc;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYourEverTakenSteroidMedicationsForYourUCPageOLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever taken steroid medications for your ulcerative colitis?\n" +
            "These include medications like prednisone or hydrocortisone, usually taken by mouth or sometimes as an enema or injection.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HaveYourEverTakenSteroidMedicationsForYourUCPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYourEverTakenSteroidMedicationsForYourUCPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYourEverTakenSteroidMedicationsForYourUCPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
