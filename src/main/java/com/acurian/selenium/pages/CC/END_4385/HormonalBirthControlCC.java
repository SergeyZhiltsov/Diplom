package com.acurian.selenium.pages.CC.END_4385;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class HormonalBirthControlCC extends MainPageCC{

    public final String titleExpected = "Are you currently taking a hormonal form of birth control?\n" +
            "This could include the Pill, patch, vaginal ring (such as NuvaRing), shot (such as Depo-Provera), implant (such as Implanon or Nexplanon), or certain IUDs (Liletta, Mirena, Skyla, Kyleena).";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HormonalBirthControlCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HormonalBirthControlCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HormonalBirthControlCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
