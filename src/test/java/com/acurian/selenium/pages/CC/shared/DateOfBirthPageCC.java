package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DateOfBirthPageCC extends MainPageCC{

    public final String titleExpected = "First, may I have your date of birth? You must be 18 years or older to complete this questionnaire.";

    public final String titleCommonExpected = "Let's get started to see if there is %2$s that's right for you.\n" +
            "\n" +
            "You'll first complete this questionnaire with me right now. You don’t have to answer any questions you don’t want to answer. Your answers will be recorded, but your information will only be used to see if there is a study that's right for you.\n" +
            "Then, if there is a study that's right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
            "If you attend all required study visits, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $%1$s for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If there is a study that's right for you, I’ll let you know which study doctor’s offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we’ll send the study doctor's office your information, so they can get in touch with you to continue the process to make sure you are a match for the study.\"\n" +
            "\n" +
            "If you have any questions, you can contact information@acurian.com.";

    public final String titleExpectedLBP = "If you qualify and participate in a low back pain study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $900 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedMIG = "If you qualify and participate in a Migraine study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $400 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedDYS = "If you qualify and participate in a high cholesterol and heart health study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $750 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";


    public final String titleExpectedDiabetes_4356 = "If you qualify and participate in a study for diabetics, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $750 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedAkc_4691 = "Let's get started to see if there is a study for people with diabetes and related health conditions that's right for you!\n" +
            "\n" +
            "You'll first complete this questionnaire with me right now. You don’t have to answer any questions you don’t want to answer. Your answers will be recorded, but your information will only be used to see if there is a study that's right for you.\n" +
            "Then, if there is a study that's right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
            "If you attend all required study visits, you may receive:\n" +
            "\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $750 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If there is a study that's right for you, I’ll let you know which study doctor’s offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we’ll send the study doctor's office your information, so they can get in touch with you to continue the process to make sure you are a match for the study.\"\n" +
            "\n" +
            "If you have any questions, you can contact information@acurian.com.";

    public final String titleExpectedOA3138 = "If you qualify and participate in an osteoarthritis study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $850 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedSUI_3923 = "If you qualify and participate in a women's bladder control study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $500 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedInsomnia_3792 = "If you qualify and participate in an insomnia study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $1,250 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedAST_4337 = "If you qualify and participate in an asthma study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $900 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedMDD_3159 = "If you qualify and participate in a depression study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $500 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedUF_4384 = "If you qualify and participate in a uterine fibroids study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $500 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpected4356D = "If you qualify and participate in a high blood pressure study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $550 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedRA2821 = "If you qualify and participate in a rheumatoid arthritis (RA) study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $625 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleGmega3RAexpected = "If you qualify and participate in a rheumatoid arthritis (RA) study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $625 for time and travel, for qualified participants who complete study-related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleDPNExpected = "If you qualify and participate in a study for diabetics, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $300 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleExpectedLOWT = "Let's get started to see if there is a study that's right for you!\n" +
            "\n" +
            "You'll first complete this questionnaire with me right now. You don’t have to answer any questions you don’t want to answer. Your answers will be recorded, but your information will only be used to see if there is a study that's right for you.\n" +
            "Then, if there is a study that's right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
            "If you attend all required study visits, you may receive:\n" +
            "\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $600 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If there is a study that's right for you, I’ll let you know which study doctor’s offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we’ll send the study doctor's office your information, so they can get in touch with you to continue the process to make sure you are a match for the study.\"\n" +
            "\n" +
            "If you have any questions, you can contact information@acurian.com.";

    public final String titleIBD3264 = "Let's get started to see if there is a Crohn's or colitis study that's right for you!\n" +
            "\n" +
            "You'll first complete this questionnaire with me right now. You don’t have to answer any questions you don’t want to answer. Your answers will be recorded, but your information will only be used to see if there is a study that's right for you.\n" +
            "Then, if there is a study that's right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
            "If you attend all required study visits, you may receive:\n" +
            "\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $700 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If there is a study that's right for you, I’ll let you know which study doctor’s offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we’ll send the study doctor's office your information, so they can get in touch with you to continue the process to make sure you are a match for the study.\"\n" +
            "\n" +
            "If you have any questions, you can contact information@acurian.com.";

    public final String titleIBSExpected = "If you qualify and participate in an irritable bowel syndrome (IBS) study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $300 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleCVExpected = "Let's get started to see if there is a heart health study that's right for you!\n" +
            "\n" +
            "You'll first complete this questionnaire with me right now. You don’t have to answer any questions you don’t want to answer. Your answers will be recorded, but your information will only be used to see if there is a study that's right for you.\n" +
            "Then, if there is a study that's right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
            "If you attend all required study visits, you may receive:\n" +
            "\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $750 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If there is a study that's right for you, I’ll let you know which study doctor’s offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we’ll send the study doctor's office your information, so they can get in touch with you to continue the process to make sure you are a match for the study.\"\n" +
            "\n" +
            "If you have any questions, you can contact information@acurian.com.";

    public final String titleGmegaExpected = "If you qualify and participate in a study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $1,000 for time and travel, for qualified participants who complete study-related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";


    @FindBy(xpath = "//div[@class='subquestion'][2]//div[@class='show-in-cc']")
    WebElement questionText;

    @FindBy(xpath = "//div[@class='subquestion'][3]//div[@class='show-in-cc']")
    WebElement questionText2Ver;

    @FindBy(xpath = "//div[@class='subquestion'][2]//div[@class='show-in-cc']")
    WebElement questionTextAKC;

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']/div[@class='show-in-cc']")
    WebElement questionTextIBD;

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion'][1]//div[@class='show-in-cc']")
    WebElement titleText2Ver;

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText1;

    @FindBy(xpath = "//div[@class='subquestion'][2]//span[@class='sub_question_text']/div[@class='show-in-cc']")
    WebElement titleTextIBD;

    @FindBy(xpath = "//select[@name='month']")
    WebElement monthSelect;

    @FindBy(xpath = "//select[@name='date']")
    WebElement daySelect;

    @FindBy(xpath = "//input[@name='year']")
    WebElement yearField;

    //GH pathes
    public final String titleGHExpected = "If you qualify and participate in a study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $1,000 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    @FindBy(xpath = "//div[@class='subquestion'][2]//div[@class='show-in-cc']")
    WebElement questionTextGH;

    @FindBy(xpath = "//div[@class='subquestion'][1]//div[@class='show-in-cc']")
    WebElement titleTextGH;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;


    public DateOfBirthPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DateOfBirthPageCC waitForPageLoad() {
        waitForPageLoadMain(questionText, titleExpected);
        return this;
    }

    @Step
    public DateOfBirthPageCC waitForPageLoad2Ver() {
        waitForPageLoadMain(questionText2Ver, titleExpected);
        return this;
    }

    @Step
    public DateOfBirthPageCC waitForPageGHLoad() {
        waitForPageLoadMain(questionTextGH,titleExpected);
        return this;
    }

    @Step
    public DateOfBirthPageCC waitForPageLoadAKC() {
        waitForPageLoadMain(questionTextAKC, titleExpected);
        return this;
    }

    @Step
    public String getQuestionText() {
        return getText(questionText);
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

    public String getExpectedModifiedTitle(String indication, String compensation) {
        return String.format(titleCommonExpected, compensation, indication);
    }

    @Step
    public String getTitleText2Ver() {
        return getText(titleText2Ver);
    }

    @Step
    public String getTitleTextVer3() {
        return getText(titleText2Ver);
    }

    //GH methods

    @Step
    public String getQuestionTextGH() {
        return getText(questionTextGH);
    }

    @Step
    public String getTitleTextGH() {
        return getText(titleTextGH);
    }


    @Step
    public String getTitleText1() {
        return getText(titleText1);
    }

    @Step
    public String getQuestionTextIBD() {
        return getText(questionTextIBD);
    }

    @Step
    public String getTitleTextIBD() {
        return getText(titleTextIBD);
    }

    @Step
    public DateOfBirthPageCC setMonth(String month) {
        selectDropDownListOptionByText(monthSelect, month);
        return this;
    }

    @Step
    public DateOfBirthPageCC setDay(String day) {
        selectDropDownListOptionByText(daySelect, day);
        return this;
    }

    @Step
    public DateOfBirthPageCC setYear(String year) {
        typeText(yearField, year);
        clickOnAnswer("Yes");//def click
        return this;
    }

    @Step
    public DateOfBirthPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }
}
