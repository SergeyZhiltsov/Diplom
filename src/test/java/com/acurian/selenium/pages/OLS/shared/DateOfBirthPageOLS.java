package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.utils.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    public final String titleDiabetes_4356A_Expected = "Let's get started to see if you qualify for a Diabetes study!\n" +
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
            "Payment which varies by study up to $750\n" +
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
    
    //visible-xs-block xs - Extra small devices Phones (<768px)
    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement questionText;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'text-date-input')]")
    WebElement dateField;

    public DateOfBirthPageOLS() {
        PageFactory.initElements(getDriver(), this);
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

}
