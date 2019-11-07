package com.acurian.selenium.pages.CC.UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYourEverTakenSteroidMedicationsForYourUCPageCC extends MainPageCC {

    public final String titleExpected = "Have you ever taken steroid medications for your ulcerative colitis?\n" +
            "These include medications like prednisone (Agent Note: PRED-nis-own) or hydrocortisone (Agent Note: hi-dro-CORT-i-sone), usually taken by mouth or sometimes as an enema or injection.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HaveYourEverTakenSteroidMedicationsForYourUCPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYourEverTakenSteroidMedicationsForYourUCPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYourEverTakenSteroidMedicationsForYourUCPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
