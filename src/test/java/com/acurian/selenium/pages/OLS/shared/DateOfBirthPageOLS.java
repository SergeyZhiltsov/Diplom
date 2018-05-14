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

public class DateOfBirthPageOLS extends MainPageOLS{

    public final String titleExpected = "What is your date of birth?";

    public final String titleLBPExpected = "Let's get started to see if you qualify for a low back pain study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $900\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    
    public final String titleMIGExpected = "Let's get started to see if you qualify for a Migraine study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $1,150\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    
    public final String titleDYExpected = "Let's get started to see if you qualify for a cholesterol or heart health study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $500\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleDiabetes_4356A_Expected = "Let's get started to see if you qualify for a diabetes study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $600\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    
    public final String titleOA_Expected = "Let's get started to see if you qualify for an arthritis study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $1,000\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    
    public final String titleCrohns_3485_Expected = "Let's get started to see if you qualify for a Crohn's study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $700\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleSUI_Expected = "Let's get started to see if you qualify for a women's bladder control study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $500\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    
    public final String titleInsomnia_Expected = "Let's get started to see if you qualify for an insomnia study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $1,250\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleAsthma_4337_Expected = "Let's get started to see if you qualify for an asthma study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $900\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleMDD_3159_Expected = "Let's get started to see if you qualify for a depression study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $500\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    
    public final String titleENDExpected = "Let's get started to see if you qualify for an endometriosis study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $500\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleHTNExpected = "Let's get started to see if you qualify for a high blood pressure study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $550\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public final String titleUF_4384_Expected = "Let's get started to see if you qualify for a uterine fibroids study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $500\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    
    public final String titleMEDExpected = "Let's get started to see if you qualify for a high cholesterol and heart disease study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $500\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    
    public final String titleDPNExpected = "Let's get started to see if you qualify for a diabetic nerve pain study!\n" +
    		"Those who qualify may receive*:\n" +
    		"Payment which varies by study up to $300\n" +
    		"No-cost study-related care from doctors\n" +
    		"No-cost study medication";
    
    public final String titleCLHExpected = "Let's get started to see if you qualify for a cluster headache study!\n" +
    		"Those who qualify may receive*:\n" +
    		"Payment which varies by study up to $300\n" +
    		"No-cost study-related care from doctors\n" +
    		"No-cost study medication";

    public final String titleGmegaExpected =  "Let's get started to see if you qualify for a study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $1,000\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";
    
    public final String titleLOWT_3017_Expected ="Let's get started to see if you qualify for a men's low testosterone study!\n" +
    		"Those who qualify may receive*:\n" +
    		"Payment which varies by study up to $600\n" +
    		"No-cost study-related care from doctors\n" +
    		"No-cost study medication";
    
    public final String titleIBD_Expected ="Let's get started to see if you qualify for a Crohn's or colitis study!\n" +
    		"Those who qualify may receive*:\n" +
    		"Payment which varies by study up to $700\n" +
    		"No-cost study-related care from doctors\n" +
    		"No-cost study medication";
    
    public final String titleDerm_Expected ="Let's get started to see if you qualify for an eczema (atopic dermatitis) study!\n" +
    		"Those who qualify may receive*:\n" +
    		"Payment which varies by study up to $800\n" +
    		"No-cost study-related care from doctors\n" +
    		"No-cost study medication";
    
    
    //visible-xs-block xs - Extra small devices Phones (<768px)
    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement questionText1;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement questionText2;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement questionText3;
    
    //--------------WorkAround for IBD due to Rel.52 dev changes in Xpath of Question and title Texts--------
    @FindBy(xpath = "(//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols'])[2]")
    WebElement questionTextGROUP;

    WebElement questionText;

    
    
    
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText1;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement titleText2;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement titleText3;
    
    //--------------WorkAround for IBD due to Rel.52 dev changes in Xpath of Question and title Texts--------
    @FindBy(xpath = "(//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols'])[1]")
    WebElement titleTextGROUP;

    WebElement titleText;

    
    @FindBy(xpath = "//input[contains(@class,'text-date-input')]")
    WebElement dateField;

    //GH pathes
    public final String titleGHExpected = "Let's get started to see if you qualify for a study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $1,000\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement questionTextGH;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleTextGH1;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement titleTextGH2;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement titleTextGH3;

    WebElement titleTextGH;
    
    

    public DateOfBirthPageOLS() {
        PageFactory.initElements(getDriver(), this);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                questionText = questionText1;
                titleText = titleText1;
                titleTextGH = titleTextGH1;
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
    public DateOfBirthPageOLS openPage(String environment, String phoneNumber){
        switch (environment) {
            case "QA":openURL(String.format(URLs.OLS_QA, phoneNumber));
                break;
            case "STG":openURL(String.format(URLs.OLS_STG, phoneNumber));
                break;
            case "PRD":openURL(String.format(URLs.OLS_PROD, phoneNumber, URLs.CODE_FOR_DEBUG_OLS));
                break;
            default:openURL(Properties.getBaseURL());
                break;
        }
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageLoad() {
        waitForPageLoadMain(questionText,titleExpected);
//        waitForAnimation();
//        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> questionText.getText().contains(titleExpected));
        return this;
    }
    
    
    //--------------WorkAround for IBD due to Rel.52 dev changes in Xpath of Question and title Texts--------
    @Step
    public DateOfBirthPageOLS waitForPageLoadGROUP() {
        waitForPageLoadMain(questionTextGROUP,titleExpected);
        return this;
    }

    @Step
    public DateOfBirthPageOLS waitForPageGHLoad() {
        waitForPageLoadMain(questionTextGH,titleExpected);
        return this;
    }
  
    @Step
    public DateOfBirthPageOLS setDate(String date) {
        typeText(dateField, date);
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
    
    //--------------WorkAround for IBD due to Rel.52 dev changes in Xpath of Question and title Texts--------
    @Step
    public String getQuestionTextGROUP() {
        return getText(questionTextGROUP);
    }

    @Step
    public String getTitleTextGROUP() {
        return getText(titleTextGROUP);
    }

}
