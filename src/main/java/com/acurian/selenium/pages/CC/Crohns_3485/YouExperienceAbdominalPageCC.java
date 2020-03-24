package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class YouExperienceAbdominalPageCC extends MainPageCC{

    public final String titleExpected = "How often would you say that you experience abdominal (stomach) pain or cramping from Crohn’s?\n" +
            "Agent Note: Read list";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public YouExperienceAbdominalPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public YouExperienceAbdominalPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public YouExperienceAbdominalPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
