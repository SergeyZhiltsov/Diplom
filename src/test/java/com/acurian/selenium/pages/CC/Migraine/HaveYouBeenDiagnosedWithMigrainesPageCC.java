package com.acurian.selenium.pages.CC.Migraine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HaveYouBeenDiagnosedWithMigrainesPageCC extends MainPageCC {

    public final String titleExpected =
            "Migraines are intense headaches that last for hours to days and:\n" +
                    "Cause pulsing or throbbing pain\n"+
                    "Interfere with work, family, or social activities\n"+
                    "Can trigger nausea or sensitivity to light and/or sound\n\n"+
                    "Have you been diagnosed with migraines?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HaveYouBeenDiagnosedWithMigrainesPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouBeenDiagnosedWithMigrainesPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouBeenDiagnosedWithMigrainesPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
