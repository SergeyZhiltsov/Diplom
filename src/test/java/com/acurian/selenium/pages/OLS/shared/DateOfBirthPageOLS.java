package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.utils.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DateOfBirthPageOLS extends MainPageOLS {

    public final String titleExpected = "Are you age 18 or older?";
    public final String titleExpected1 = "What is your date of birth?";

    public final String titleCommonExpected = "Let's get started to see if there is %2$s that's right for you!\n" +
            "\n"+
            "If you attend all required study visits, you may receive*:\n" +
            "Payment up to $%1$s, which varies by study\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleCommonExpectedCrohns = "Let's get started to see if there is %2$s that's right for you.\n"+
            "\n"+
            "If you attend all required study visits, you may receive:\n"+
            "\n"+
            "Study medication or placebo, at no-cost to you\n" +
            "Study-related care from a local doctor for the length of the study, at no-cost to you\n" +
            "And depending on the study, compensation of up to $%1$s for time and travel, for qualified participants who complete study related visits\n"+
            "\n"+
            "Agent Note: If caller has questions about the process, or availability of sites in their area, read: \"If there is a study that's right for you, I’ll let you know which study doctor’s offices in your area are participating in the study, and you can select the one that is most convenient for you. Then we’ll send the study doctor's office your information, so they can get in touch with you to continue the process to make sure you are a match for the study.\"\n"+
            "\n"+
            "If you have any questions, you can contact information@acurian.com.";

    public final String titleCommonExpectedGMEGA = "Let's get started to see if you qualify for %2$s study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $%1$s\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

//    public final String titleCommonExpected2 = "Let's get started to see if there is %2$s that's right for you!\n" +
//            "\n" +
//            "First, please complete this questionnaire. Your information will only be used for this purpose.\n" +
//            "Then, if there is a study right for you, you'll schedule an in person visit at the study doctor's office.\n" +
//            "If you attend all required study visits, you may receive*:\n" +
//            "Payment up to $%1$s, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleCommonExpected3 = "Let's get started to see if you qualify for %s study!\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment which varies by study up to $%s\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleLBPExpected = "Let's get started to see if you qualify for a low back pain study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $900, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleMIGExpected = "Let's get started to see if you qualify for a migraine study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $400, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleLMGExpected = "Let's get started to see if you qualify for a migraine study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $400, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleKADExpected = "Let's get started to see if you qualify for an eczema (atopic dermatitis) study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $1750, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleLPSExpected = "Let's get started to see if you qualify for a lupus study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleMCCExpected = "Let's get started to see if you qualify for a chronic cough study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $350, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleDYSExpected = "Let's get started to see if you qualify for a heart health study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $750, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleDiabetes_4356A_Expected = "Let's get started to see if you qualify for a study for diabetics!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $600, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleAKC_4691_Expected = "This is the first part of the process to match you with a research study.\n" +
//            "First, please complete this questionnaire to see if there is a study that's right for you.\n" +
//            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
//            "Finally, if the study doctor confirms you are a match for the study, and you attend all required study visits, you may receive*:\n" +
//            "Payment up to $750, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication\n" +
//            "\n" +
//            "Let’s get started to see if there is a study for people with diabetes and related health conditions that's right for you!";
//
//    public final String titleOA_Expected = "Let's get started to see if you qualify for an arthritis study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $1,000, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleCrohns_3485_Expected = "Let's get started to see if you qualify for a Crohn's study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $700, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleSUI_Expected = "Let's get started to see if you qualify for a women's bladder control study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleInsomnia_Expected = "Let's get started to see if you qualify for an insomnia study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $1,250, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleAsthma_4337_Expected = "Let's get started to see if you qualify for an asthma study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $900, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleMDD_3159_Expected = "Let's get started to see if you qualify for a depression study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleENDExpected = "Let's get started to see if you qualify for an endometriosis study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleHTNExpected = "Let's get started to see if you qualify for a high blood pressure study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $550, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleUF_4384_Expected = "Let's get started to see if you qualify for a uterine fibroids study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleMEDExpected = "Let's get started to see if you qualify for a high cholesterol and heart disease study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleDPNExpected = "Let's get started to see if you qualify for a study for diabetics!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $300, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleCLHExpected = "Let's get started to see if you qualify for a cluster headache study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $300, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleGmegaExpected = "Let's get started to see if you qualify for a study!\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment which varies by study up to $1,000\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleLOWT_3017_Expected = "This is the first part of the process to match you with a research study.\n" +
//            "First, please complete this questionnaire to see if there is a study that's right for you.\n" +
//            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
//            "Finally, if the study doctor confirms you are a match for the study, and you attend all required study visits, you may receive*:\n" +
//            "Payment up to $600, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication\n" +
//            "\n" +
//            "Let's get started to see if there is a study that's right for you!";
//
//    public final String titleGERD_4301_Expected = "Let's get started to see if you qualify for a heartburn or reflux study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleGERD_5098_Expected = "Let's get started to see if you qualify for an indigestion, heartburn, or stomach ulcers study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $300, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleIBD_Expected = "This is the first part of the process to match you with a research study.\n" +
//            "First, please complete this questionnaire to see if there is a study that's right for you.\n" +
//            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
//            "Finally, if the study doctor confirms you are a match for the study, and you attend all required study visits, you may receive*:\n" +
//            "Payment up to $700, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication\n" +
//            "\n" +
//            "Let’s get started to see if there is a Crohn's or colitis study that's right for you!";
//
//    public final String titleDerm_Expected = "Let's get started to see if you qualify for an eczema (atopic dermatitis) study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $400, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titelAutism_Expected = "Let's get started to see if you qualify for an autism spectrum disorder study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $800, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleHeartFailure4722_Expected = "Let's get started to see if you qualify for a heart failure study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleAS_Expected = "Let's get started to see if you qualify for an ankylosing spondylitis (AS) study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleEND_Expected = "Let's get started to see if you qualify for an endometriosis study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $1775, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//
//    public final String titleOAB_Expected = "Let's get started to see if you qualify for an overactive bladder study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $300, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleIBSExpected = "Let's get started to see if you qualify for an irritable bowel syndrome (IBS) study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $300, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//    public final String titleRA2821Expected = "Let's get started to see if you qualify for a rheumatoid arthritis (RA) study!\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment which varies by study up to $625\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleCVExpected = "This is the first part of the process to match you with a research study.\n" +
//            "First, please complete this questionnaire to see if there is a study that's right for you.\n" +
//            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
//            "Finally, if the study doctor confirms you are a match for the study, and you attend all required study visits, you may receive*:\n" +
//            "Payment up to $750, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication\n" +
//            "\n" +
//            "Let’s get started to see if there is a heart health study that's right for you!";
//
//    public final String titleNASHExpected = "Let's get started to see if you qualify for a fatty liver study for diabetics!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $750, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleAllegranNASHExpected = "Let's get started to see if you qualify for a fatty liver study for diabetics!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $750, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleObesityExpected = "This is the first part of the process to match you with a research study.\n" +
//            "First, please complete this questionnaire to see if there is a study that's right for you.\n" +
//            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
//            "Finally, if the study doctor confirms you are a match for the study, and you attend all required study visits, you may receive*:\n" +
//            "Payment up to $25 per visit, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication\n" +
//            "\n" +
//            "Let's get started to see if there is a genetic obesity study that's right for you!";
//
//    public final String titleVaccineExpected = "Let's get started to see if you qualify for a pneumonia vaccine study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $170, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleDermExpected = "Let's get started to see if you qualify for an eczema (atopic dermatitis) study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $400, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String title4656Expected = "Let's get started to see if you qualify for a psoriasis study!\n" +
//            "\n" +
//            "Those who qualify may receive*:\n" +
//            "Payment up to $350, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
    public final String titleAHExpected = "Let's get started to see if there is a study that’s right for you!"; /*+
            "First, please complete this questionnaire. Your information will only be used for this purpose.\n" +
            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor’s office.";*/
//
//    public final String titlePsoriaticArthritisExpected = "Let's get started to see if there is a psoriatic arthritis study that's right for you!\n" +
//            "\n" +
//            "First, please complete this questionnaire. Your information will only be used for this purpose.\n" +
//            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor's office.\n" +
//            "If you attend all required study visits, you may receive*:\n" +
//            "Payment up to $300, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
//    public final String titleHeartBurn= "Let's get started to see if there is a heartburn or reflux study that's right for you!\n" +
//            "\n" +
//            "First, please complete this questionnaire. Your information will only be used for this purpose.\n" +
//            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor's office.\n" +
//            "If you attend all required study visits, you may receive*:\n" +
//            "Payment up to $500, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//
    public final String titleExpectedGBAN = "The Generation Study is enrolling now.";
//
    public final String titleExpectedGBAN1 = "Let's start!";
//    //GH pathes
    public final String titleGHExpected = "This is the first part of the process to match you with a research study.\n" +
            "First, please complete this questionnaire to see if there is a study that's right for you.\n" +
            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor’s office.\n" +
            "Finally, if the study doctor confirms you are a match for the study, and you attend all required study visits, you may receive*:\n" +
            "Payment up to $1,000, which varies by study\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication\n" +
            "\n" +
            "Let's get started to see if there is a study that's right for you!";
//
    public final String titleExpectedJANRSV = "Let's get started to see if there is a vaccine study that's right for you!\n" +
        "\n" +
        "First, please complete this questionnaire. Your information will only be used for this purpose.\n" +
        "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor's office.\n" +
        "If you attend all required study visits, you may receive*:\n" +
        "Payment up to $650, which varies by study\n" +
        "No-cost study-related care from doctors\n" +
        "No-cost study medication";

//    public final String titleExpectedCrohns = "Let's get started to see if there is a Crohn's study that's right for you!\n" +
//            "\n" +
//            "First, please complete this questionnaire. Your information will only be used for this purpose.\n" +
//            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor's office.\n" +
//            "If you attend all required study visits, you may receive*:\n" +
//            "Payment up to $700, which varies by study\n" +
//            "No-cost study-related care from doctors\n" +
//            "No-cost study medication";
//    //visible-xs-block xs - Extra small devices Phones (<768px)
    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement questionText1;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement questionText2;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement questionText3;

    WebElement questionText;

    @FindBy(xpath = "//*[@id=\"question_view\"]/div[1]/div/form/div/div[1]/div[1]/question/div/div/div/div/div/div/h4/div[1]/div[2]")
    WebElement titleTextJANRSV;

    @FindBy(xpath = "(//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols'])[2]")
    WebElement questionTextGER1;


    //--------------WorkAround for IBD due to Rel.52 dev changes in Xpath of Question and title Texts--------
    @FindBy(xpath = "(//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols'])[2]")
    WebElement questionTextGROUP;


    @FindBy(xpath = "(//div[contains(@class,'visible-md-block')]//div[contains(@class,'show-in-ols')])[3]")
    WebElement questionText2Ver;

    @FindBy(xpath = "(//div[@class='visible-md-block visible-lg-block ng-scope'])[1]")
    WebElement questionTextAH1;

    @FindBy(xpath = "(//div[@class='visible-md-block visible-lg-block ng-scope'])[2]")
    WebElement questionTextCrohns;

    @FindBy(xpath = "(.//*[contains(@class, 'show-in-ols')][contains(text(), \"Let's get started\")])[1]")
    WebElement titleText1;

    @FindBy(xpath = "(//div[@class='visible-md-block visible-lg-block ng-scope'])[1]")
    WebElement titleText2;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement titleText3;

    //--------------WorkAround for IBD due to Rel.52 dev changes in Xpath of Question and title Texts--------
    @FindBy(xpath = "(//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols'])[1]")
    WebElement titleText;
   //WebElement titleTextGROUP;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText2Ver1;

    WebElement titleText2Ver;


    @FindBy(xpath = "//input[contains(@class,'text-date-input')]")
    WebElement dateField;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleTextAH;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleTextGH1;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement titleTextGH2;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement titleTextGH3;

    @FindBy(xpath = "//*[@id='command']/div[1]/div[2]")
    WebElement titleTextArthritis;

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleTextGBAN;

    @FindBy(xpath = "//*[@id='command']/div[1]/div[2] | //div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement combinedLocator;

    @FindBy(xpath = "//*[@id='command']/div[2]/span[1]/div[1] ")
    WebElement titleTextCrohns;

    WebElement titleTextGH;


    public DateOfBirthPageOLS() {
        PageFactory.initElements(getDriver(), this);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                questionText = questionText1;
                titleText = titleText1;
                titleTextGH = titleTextGH1;
                titleTextAH = questionTextAH1;
                titleText2Ver = titleText2Ver1;
                break;
            case Platforms.TABLET:
                titleText = titleText2;
                questionText = questionText2;
                titleTextGH = titleTextGH2;
                break;
            case Platforms.MOBILE:
                titleText = titleText3;
                questionText = questionText3;
                titleTextGH = titleTextGH3;
                break;
        }
    }

    @Step
    public DateOfBirthPageOLS openPage(String environment, String phoneNumber) {
        switch (environment) {
            case "QA":
                openURL(String.format(URLs.OLS_QA, phoneNumber));
                break;
            case "STG":
                openURL(String.format(URLs.OLS_STG, phoneNumber));
                break;
            case "PRD":
                openURL(String.format(URLs.OLS_PROD, phoneNumber, URLs.CODE_FOR_DEBUG_OLS));
                break;
            case "AH_STG":
                openURL(String.format(URLs.AH_STG, phoneNumber));
                break;
            case "AH_PROD":
                openURL(String.format(URLs.AH_PROD, phoneNumber, URLs.CODE_FOR_DEBUG_OLS));
                break;
            default:
                openURL(Properties.getBaseURL());
                break;
        }
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadServer() {
        waitForPageLoadMain(questionText1, titleExpected);
        return this;
    }


    @Step
    public DateOfBirthPageOLS waitForPageLoad(String indication, String compensation) {
        waitForPageLoadMain(titleText, getExpectedModifiedTitle(indication, compensation));
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadGMEGA(String indication, String compensation) {
        waitForPageLoadMain(titleText, getExpectedModifiedTitleGMEGA(indication, compensation));
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadCrohns(String indication, String compensation) {
        waitForPageLoadMain(titleTextCrohns, getExpectedModifiedTitleCrohns(indication, compensation));
        return this;
    }
    public String getExpectedModifiedTitleGMEGA(String indication, String compensation) {
        return String.format(titleCommonExpectedGMEGA, compensation, indication);
    }
    public String getExpectedModifiedTitle(String indication, String compensation) {
        return String.format(titleCommonExpected, compensation, indication);
    }
    public String getExpectedModifiedTitleCrohns(String indication, String compensation) {
        return String.format(titleCommonExpectedCrohns, compensation, indication);
    }

//    @Step
//    public DateOfBirthPageOLS waitForPageLoad2() {
//        waitForPageLoadMain(questionTextCrohns, titleExpected);
//        waitForPageLoadMain(titleText2, titleExpectedCrohns);
//        return this;
//    }

//    @Step
//    public DateOfBirthPageOLS waitForPageLoadGER() {
//        waitForPageLoadMain(questionTextGER1, titleExpected);
//        return this;
//    }
//
    @Step
    public DateOfBirthPageOLS waitForPageLoad1() {
        waitForPageLoadMain(questionText, titleExpected1);
        return this;
    }

//    @Step
//    public DateOfBirthPageOLS waitForPageLoad(String indication, String compensation) {
//        waitForPageLoadMain(titleText, String.format(titleCommonExpected, indication, compensation));
//        return this;
//    }

//    @Step
//    public DateOfBirthPageOLS waitForPageLoad2Ver() {
//        waitForPageLoadMain(questionText2Ver, titleExpected);
//        return this;
//    }

    @Step
    public DateOfBirthPageOLS waitForPageGHLoad() {
        waitForPageLoadMain(questionText, titleGHExpected);
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageAHLoad() {
        waitForPageLoadMain(questionTextAH1, titleAHExpected);
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadGBAN() {
        waitForPageLoadMain(titleTextGBAN, titleExpectedGBAN);
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadByTitle(String titleExpected) {
        waitForPageLoadMain(titleTextGBAN, titleExpected);
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoadJANRSV() {
        waitForPageLoadMain(titleTextJANRSV, titleExpectedJANRSV);
        return this;
    }

//    @Step
//    public DateOfBirthPageOLS waitForPageLoadPsoariaticArthritis() {
//        waitForPageLoadMain(titleTextArthritis, titlePsoriaticArthritisExpected);
//        return this;
//    }
//
//    @Step
//    public DateOfBirthPageOLS waitForPageLoadHeartBurn() {
//        waitForPageLoadMain(combinedLocator, titleHeartBurn);
//        return this;
//    }

    @Deprecated
    @Step
    public DateOfBirthPageOLS setDate(String date) {
        typeText(dateField, date);
        return this;
    }

    @Step
    public DateOfBirthPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
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

//    public String getExpectedModifiedTitle(String indication, String compensation/*, boolean... isVerticalComa*/) {
////        if (isVerticalComa.length == 1 && isVerticalComa[0]) { //some anti patern for workaround;)
////            return String.format(titleCommonExpected2, compensation, indication);
////        }
//        return String.format(titleCommonExpected, compensation, indication);
//    }

    //GH methods
//    @Step
//    public String getQuestionTextGH() {
//        return getText(titleTextGH);
//    }
//
    @Step
    public String getTitleTextGH() {
        return getText(titleTextGH);
    }
//
    @Step
    public String getTitleTextAH() {
        return getText(questionTextAH1);
    }
//
//    @Step
//    public String getTitleTextGROUP() {
//        return getText(titleTextGROUP);
//    }
//
//    @Step
//    public String getTitleText2Ver() {
//        return getText(titleText2Ver);
//    }
//
//    @Step
//    public String getTitleTextVer3() {
//        return getText(titleText2Ver);
//    }
}
