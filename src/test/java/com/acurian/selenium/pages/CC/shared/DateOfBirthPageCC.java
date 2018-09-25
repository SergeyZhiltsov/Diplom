package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DateOfBirthPageCC extends MainPageCC{

    public final String titleExpected = "May I have your date of birth?";

    public final String titleExpectedLBP = "If you qualify and participate in a low back pain study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $900 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleExpectedMIG = "If you qualify and participate in a Migraine study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $1,150 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleExpectedDYS = "If you qualify and participate in a cholesterol or heart health study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $500 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    
    public final String titleExpectedDiabetes_4356 = "If you qualify and participate in a study for diabetics, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $600 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleExpectedAkc_4691 = "If you qualify and participate in a study for people with diabetes and related health conditions, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $850 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleExpectedOA = "If you qualify and participate in an arthritis study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $1000 for time and travel, for qualified participants who complete study related visits\n" +
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

    public final String titleExpectedCrohns_3485 = "If you qualify and participate in a Crohn's study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $700 for time and travel, for qualified participants who complete study related visits\n" +
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
    
    public final String titleExpected3962Med = "If you qualify and participate in a high cholesterol and heart disease study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $500 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleExpectedRA2821 = "If you qualify and participate in a rheumatoid arthritis (RA) study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $625 for time and travel, for qualified participants who complete study related visits\n" +
            "\n" +
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleDPNExpected = "If you qualify and participate in a study for diabetics, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $300 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleCLHExpected = "If you qualify and participate in a cluster headache study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $300 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleDIA4241Expected = "If you qualify and participate in a study for diabetics, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $600 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleExpectedLOWT = "If you qualify and participate in a men's low testosterone study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $600 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";

    public final String titleIBD3264 = "If you qualify and participate in a Crohn's or colitis study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $700 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleKAD4631 = "If you qualify and participate in an eczema (atopic dermatitis) study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $1750 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleAUT3973 = "If you qualify and participate in an autism spectrum disorder study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $750 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
			
	public final String titleGERD_4301_Expected ="If you qualify and participate in a heartburn or reflux study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $850 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\""; 		
    
    
    @FindBy(xpath = "//div[@class='subquestion']//div[@class='show-in-cc']")
    WebElement questionText;
    
    @FindBy(xpath = "//div[@class='subquestion'][2]//div[@class='show-in-cc']")
    WebElement questionTextAKC;
    
    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']/div[@class='show-in-cc']")
    WebElement questionTextIBD;

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;
    
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


    public DateOfBirthPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DateOfBirthPageCC waitForPageLoad() {
        waitForPageLoadMain(questionText, titleExpected);
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
    public String getQuestionTextAKC() {
        return getText(questionTextAKC);
    }
    
    @Step
    public String getTitleText1() {
        return getText(titleText1);
    }
    
    @Step
    public DateOfBirthPageCC waitForPageLoadIBD() {
        waitForPageLoadMain(questionTextIBD, titleIBD3264);
        return this;
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
        return this;
    }

}
