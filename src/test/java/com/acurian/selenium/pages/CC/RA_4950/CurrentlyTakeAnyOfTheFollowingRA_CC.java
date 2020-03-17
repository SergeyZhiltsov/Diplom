package com.acurian.selenium.pages.CC.RA_4950;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CurrentlyTakeAnyOfTheFollowingRA_CC extends MainPageCC {

    public final String titleExpected = "Methotrexate is a common rheumatoid arthritis (RA) medication. It is usually taken once a week. Methotrexate can come as a shot or as pills or tablets. The brand names include Otrexup, Rasuvo, Rheumatrex, or Trexall.\n"+
            "Are you currently taking methotrexate in either its generic form or under one of its brand names to treat your rheumatoid arthritis (RA)?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public CurrentlyTakeAnyOfTheFollowingRA_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlyTakeAnyOfTheFollowingRA_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CurrentlyTakeAnyOfTheFollowingRA_CC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
