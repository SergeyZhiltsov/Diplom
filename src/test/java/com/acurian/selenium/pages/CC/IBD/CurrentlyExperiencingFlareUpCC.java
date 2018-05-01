package com.acurian.selenium.pages.CC.IBD;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.ManageYourCrohnsPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class CurrentlyExperiencingFlareUpCC extends MainPageCC{

    public final String titleExpected = "A Crohn's or colitis flare-up is when your symptoms suddenly get worse or return. You may experience frequent or urgent bowel movements, unusual gas, diarrhea, bloody stool, abdominal cramps, or fever. Other symptoms may include lack of appetite, weight loss, or fatigue.\n" +
             "Are you currently experiencing a flare-up?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public CurrentlyExperiencingFlareUpCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlyExperiencingFlareUpCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CurrentlyExperiencingFlareUpCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
