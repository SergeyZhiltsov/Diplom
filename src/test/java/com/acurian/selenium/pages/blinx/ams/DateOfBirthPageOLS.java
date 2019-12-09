package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.selenium.utils.Properties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DateOfBirthPageOLS extends MainPageBlinx {

    private final String titleExpectedPart1 = "Let's get started to see if there is %s that's right for you!\n\n" +
            //"First, please complete this questionnaire. Your information will only be used for this purpose.\n" +
            //"Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor's office.\n" +
            "If you attend all required study visits, you may receive*:\n" +
            "Payment up to $%s, which varies by study\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleExpected = "Let's get started to see if there is %2$s that's right for you!\n" +
            "\n"+
            "If you attend all required study visits, you may receive*:\n" +
            "Payment up to $%1$s, which varies by study\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";


    private final String titleExpectedPart2 = "Are you age 18 or older?";

    @FindBy(xpath = "//div[@id='questions']/div[1]//div[@class='show-in-ols']")
    WebElement titleTextPart;

    @FindBy(xpath = "(//div[@class='question-text']/div)[2]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text']/div)[3]")
    WebElement titleTextPart2;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> singleChoiceButtonsList;

    @Step
    public DateOfBirthPageOLS waitForPageLoad0(String indication, String compensation) {
        waitForPageLoadMain(titleTextPart, getExpectedModifiedTitle(indication, compensation));
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadCrohns(String indication, String compensation) {
        waitForPageLoadMain(titleTextPart, getExpectedModifiedTitle(indication, compensation));
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoad(String indication, String compensation) {
        waitForPageLoadMain(titleTextPart1, String.format(titleExpectedPart1, indication, compensation));
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    @Step
    public DateOfBirthPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }

    @Step
    public DateOfBirthPageOLS openPage(String environment, String phoneNumber) {
        switch (environment) {
            case "STG":
                openURL(String.format(URLs.BLINX_STG, phoneNumber));
                break;
            case "PRD":
                openURL(String.format(URLs.BLINX_PROD, phoneNumber, URLs.CODE_FOR_DEBUG_OLS));
                break;
            default:
                openURL(Properties.getBaseURL());
                break;
        }
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleTextPart);
    }

    public String getExpectedModifiedTitle(String indication, String compensation) {
        return String.format(titleExpected, compensation, indication);
    }

}
