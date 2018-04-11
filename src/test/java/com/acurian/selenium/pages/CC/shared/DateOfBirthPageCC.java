package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.CC.MainPageCC;
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

    
    public final String titleExpectedDiabetes_4356 = "If you qualify and participate in a Diabetes study, you may receive:\n" +
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $600 for time and travel, for qualified participants who complete study related visits\n" +
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
    
    public final String titleDPNExpected = "If you qualify and participate in a diabetic nerve pain study, you may receive:\n" +
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
    
    public final String titleDIA4241Expected = "If you qualify and participate in a Diabetes study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $600 for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    public final String titleExpectedLOWT = "If you qualify and participate in a men's low testosterone study, you may receive:\n" +
    		"Study medication or placebo, at no-cost to you\n" +
    		"Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
    		"And depending on the study, compensation of up to $others for time and travel, for qualified participants who complete study related visits\n" +
    		"\n" +
    		"Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If you qualify, I'll let you know which research doctor's offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we'll send them your information, so they can get in touch with you to continue the screening process.\"";
    
    @FindBy(xpath = "//div[@class='subquestion']//div[@class='show-in-cc']")
    WebElement questionText;

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//select[@name='month']")
    WebElement monthSelect;

    @FindBy(xpath = "//select[@name='date']")
    WebElement daySelect;

    @FindBy(xpath = "//input[@name='year']")
    WebElement yearField;


    public DateOfBirthPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DateOfBirthPageCC waitForPageLoad() {
        waitForPageLoadMain(questionText, titleExpected);
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
