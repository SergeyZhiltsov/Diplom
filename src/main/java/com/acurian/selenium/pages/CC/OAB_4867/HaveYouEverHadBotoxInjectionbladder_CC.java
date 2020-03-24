package com.acurian.selenium.pages.CC.OAB_4867;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverHadBotoxInjectionbladder_CC extends MainPageCC{

    public final String titleExpected = "Botox (botulinum toxin) injections are sometimes given as a treatment for overactive bladder.\n" +
    		"Have you ever had a Botox injection into your bladder muscle?";
    

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HaveYouEverHadBotoxInjectionbladder_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverHadBotoxInjectionbladder_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverHadBotoxInjectionbladder_CC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
