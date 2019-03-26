package com.acurian.selenium.pages.CC.RA;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class AreYouCurrentlyTakingMethotrexateCC extends MainPageCC{

    public final String titleExpected = "Methotrexate is a common RA medication. It is usually taken once a week. Methotrexate can come as a shot or as pills or tablets. The brand names include Otrexup, Rasuvo, Rheumatrex, or Trexall.\n" +
            "Are you currently taking methotrexate for your Rheumatoid Arthritis?";
    
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyTakingMethotrexateCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyTakingMethotrexateCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyTakingMethotrexateCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
