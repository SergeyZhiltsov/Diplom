package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SynexusRadiantDirectScheduleCC extends MainPageCC{

    public final String titleExpected = "The next step is to get you scheduled for an appointment with the study doctor. During this visit, the study doctor will further discuss the study requirements and answer any questions you may have. Let me look at the study doctor’s calendar.\n" +
            "\n" +
            "Agent note: Go to Clinical Conductor and enter the required Acurian information";
    
    public final String titleSyn = "The next step is to get you scheduled for an appointment with the study doctor's team. During this visit, the study doctor's team will further discuss the study requirements and answer any questions you may have. Let me look at the site's calendar.\n" +
            "\n" +
            "Agent note: Go to Clinical Conductor and enter the required Acurian information";
            

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @FindBy(xpath = "//div[@class='question_text']/table/tbody/tr[1]/td[1]")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@class='question_text']/table/tbody/tr[1]/td[2]")
    WebElement secondNameField;

    @FindBy(xpath = "//div[@class='question_text']/table/tbody/tr[2]/td[1]")
    WebElement dateOfBirthField;

    @FindBy(xpath = "//div[@class='question_text']/table/tbody/tr[3]/td[1]")
    WebElement countryField;

    @FindBy(xpath = "//div[@class='question_text']/table/tbody/tr[6]/td[1]")
    WebElement cityAndStateField;

    @FindBy(xpath = "//div[@class='question_text']/table/tbody/tr[7]/td[1]")
    WebElement emailField;

    @FindBy(xpath = "//div[@class='question_text']/table/tbody/tr[8]/td[1]")
    WebElement phoneNumberField;

    @FindBy(xpath = "//div[@class='question_text']/table/tbody/tr[6]/td[2]")
    WebElement zipCodeField;

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement allText;


    //cannot determine because they are nodes
//    @FindBy(xpath = "")
//    WebElement siteCode;
//
//    @FindBy(xpath = "")
//    WebElement siteName;
//
//    @FindBy(xpath = "")
//    WebElement studyName;


    public SynexusRadiantDirectScheduleCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SynexusRadiantDirectScheduleCC waitForPageLoad() {
    	 waitForAnimation();
         driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    
    @Step
    public SynexusRadiantDirectScheduleCC waitForPageLoadSyn() {
        waitForPageLoadMain(titleText, titleSyn);
        return this;
    }
    
    @Step
    public SynexusRadiantDirectScheduleCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public SynexusRadiantDirectScheduleCC assertVariables(String firstName, String secondName, String dateOfBirth, String country,
                                                          String cityAndState, String zipCode, String email, String phoneNumber,
                                                          String siteNumber, String siteName, String studyName) {
        Assert.assertEquals(firstNameField.getText(), "Patient First Name:" + firstName);
        Assert.assertEquals(secondNameField.getText(), "Patient First Name:" + secondName);
        Assert.assertEquals(dateOfBirthField.getText(), "Patient First Name:" + firstName);
        Assert.assertEquals(countryField.getText(), "Patient First Name:" + firstName);
        Assert.assertEquals(cityAndStateField.getText(), "Patient First Name:" + firstName);
        Assert.assertEquals(emailField.getText(), "Patient First Name:" + firstName);
        Assert.assertEquals(phoneNumberField.getText(), "Patient First Name:" + firstName);
        Assert.assertEquals(zipCodeField.getText(), "Patient First Name:" + firstName);
        Assert.assertTrue(allText.getText().contains("Site: " + siteNumber + " - " + siteName));
        Assert.assertTrue(allText.getText().contains("Study: " + studyName));
        return this;
    }


    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
