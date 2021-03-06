package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.constants.Version;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.utils.Properties;
import com.acurian.utils.VersionGetter;
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

    public final String titleExpected2 = "Let's get started to see if you qualify for %s study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $%s\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleExpected = "Let's get started to see if there is %2$s that's right for you!\n" +
            "\n" +
            "If you attend all required study visits, you may receive*:\n" +
            "Payment up to $%1$s, which varies by study\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleExpectedСС1 = "Let's get started to see if there is a COPD study that's right for you.\n" +
            "\n" +
            "If you attend all required study visits, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $700 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If there is a study that's right for you, I’ll let you know which study doctor’s offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we’ll send the study doctor's office your information, so they can get in touch with you to continue the process to make sure you are a match for the study.\"\n" +
            "\n" +
            "If you have any questions, you can contact information@acurian.com.";

    public final String titleExpectedСС2 = "Do I have your permission to proceed with the questionnaire?\n" +
            "Agent Note: if the caller does not give permission, please abort screening.";

    public final String titleExpectedССAF = "Let's get started to see if there is %s that's right for you.\n" +
            "\n" +
            "If you attend all required study visits, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $%s for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If there is a study that's right for you, I’ll let you know which study doctor’s offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we’ll send the study doctor's office your information, so they can get in touch with you to continue the process to make sure you are a match for the study.\"\n" +
            "\n" +
            "If you have any questions, you can contact information@acurian.com.";


    private final String titleExpectedPart2 = "Are you age 18 or older?";

    public final String titleAHExpected = "Let's get started to see if there is a study that’s right for you!";

    public final String titleExpected1 = "The Generation Study is enrolling now.";

    @FindBy(xpath = "//div[@id='questions']/div[1]//span[@class='show-in-ols']")
    WebElement titleTextPart;
    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    WebElement dateField;
    @FindBy(xpath = "(//div[@class='question-text']/div)[2]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text']/div)[3]")
    WebElement titleTextPart2;
    @FindBy(xpath = "(//div[@class='question-text']/span)[1]")
    WebElement titleTextPartGMEGA1;
    @FindBy(xpath = "(//div[@class='question-text']/span)[2]")
    WebElement titleTextPartGMEGA2;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> singleChoiceButtonsList;
    //    @FindBy(xpath = "//*[@id='QSI8002']/div/div")
//    WebElement titleText;
    @FindBy(xpath = "(//div[contains(@class,'question-text')])[1]")
    WebElement titleTextCC1;
    @FindBy(xpath = "(//div[@class='mt-2 mt-sm-4']//div[contains(@class,'question-text')])[2]")
    WebElement titleTextCC;

    @FindBy(xpath = "(//div[@class='mt-2 mt-sm-4']//div[contains(@class,'question-text')])[1]")
    WebElement titleTextCCAF;

    WebElement titleTextCC2;
    @FindBy(xpath = "//*[@id='QSI8002']/div/span")
    WebElement titleText2;
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @Step
    public DateOfBirthPageOLS waitForPageLoad0(String indication, String compensation) {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart, getExpectedModifiedTitle(indication, compensation));
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadGMEGA(String indication, String compensation) {
        waitForAnimation();
        waitForPageLoadMain(titleText, getExpectedModifiedTitle2(indication, compensation));
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadCrohns(String indication, String compensation) {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart, getExpectedModifiedTitle(indication, compensation));
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoad2(String indication, String compensation) {
        waitForAnimation();
        waitForPageLoadMain(titleText2, getExpectedModifiedTitle2(indication, compensation));
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadCV5034(String indication, String compensation) {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart1, String.format(titleExpected, indication, compensation));
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoad(String indication, String compensation) {
        waitForAnimation();
        if (VersionGetter.getVersion().equals("CC")) {
            waitForPageLoadMain(titleTextCC1, String.format(titleExpectedСС1, indication, compensation));
            waitForPageLoadMain(titleTextCC2, String.format(titleExpectedСС2, indication, compensation));

        } else {
            waitForPageLoadMain(titleTextPartGMEGA1, String.format(titleExpectedPart1, indication, compensation));
            waitForPageLoadMain(titleTextPartGMEGA2, titleExpectedPart2);
        }
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadAF(String indication, String compensation) {
        waitForAnimation();
        if (VersionGetter.getVersion().equals("CC")) {
            waitForPageLoadMain(titleTextCCAF, String.format(titleExpectedССAF, indication, compensation));

        } else {
            waitForPageLoadMain(titleTextPartGMEGA1, String.format(titleExpectedPart1, indication, compensation));
            waitForPageLoadMain(titleTextPartGMEGA2, titleExpectedPart2);
        }
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadCrohnsNew(String indication, String compensation) {
        waitForAnimation();
        waitForPageLoadMain(titleTextPartGMEGA1, String.format(titleExpectedPart1, indication, compensation));
        waitForPageLoadMain(titleTextPartGMEGA2, titleExpectedPart2);
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageAHLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleAHExpected);
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoad1() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public DateOfBirthPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleTextAH() {
        return getText(titleText);
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
            case "QA":
                openURL(String.format(URLs.BLINX_QA, phoneNumber));
                break;
            case "AH_STG":
                openURL(String.format(URLs.AH_STG, phoneNumber));
                break;
            case "AH_PROD":
                openURL(String.format(URLs.AH_PROD_BLINX, phoneNumber, URLs.CODE_FOR_DEBUG_BLINX));
                break;
            default:
                openURL(Properties.getBaseURL());
                break;
        }
        return this;
    }

    @Step
    public String getTitleText2() {
        return getText(titleTextPart);
    }

    public String getTitleText() {
        return getText(titleTextPart);
    }

    public String getExpectedModifiedTitle(String indication, String compensation) {
        return String.format(titleExpected, compensation, indication);
    }

    public String getExpectedModifiedTitle2(String indication, String compensation) {
        return String.format(titleExpected2, indication, compensation);
    }

    @Step
    public DateOfBirthPageOLS setDate(String date) {
        typeText(dateField, date);
        return this;
    }

}
