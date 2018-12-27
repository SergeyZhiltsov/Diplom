package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SynexusRadiantDirectScheduleCC extends MainPageCC{

    public final String titleExpected = "The next step is to get you scheduled for an appointment with the study doctor. During this visit, the study doctor will further discuss the study requirements and answer any questions you may have. Let me look at the study doctor’s calendar.\n" +
            "\n" +
            "Agent note: Go to Clinical Conductor and enter the required Acurian information";
    
    public final String titleSynExpected = "The next step is to get you scheduled for an appointment with the study doctor's team. During this visit, the study doctor's team will further discuss the study requirements and answer any questions you may have. Let me look at the site's calendar.\n" +
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
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public SynexusRadiantDirectScheduleCC waitForPageLoadSyn() {
        waitForPageLoadMain(titleText, titleSynExpected);
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
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstNameField.getText(), "Patient First Name: " + firstName, "Patient First Name is diff");
        softAssert.assertEquals(secondNameField.getText(), "Patient Last Name: " + secondName, "Patient Last Name is diff");
        softAssert.assertEquals(dateOfBirthField.getText(), "Date of Birth: " + dateOfBirth, "Date of Birth is diff");
        softAssert.assertEquals(countryField.getText(), "Country: " + country, "Country is diff");
        softAssert.assertEquals(cityAndStateField.getText(), "City & State: " + cityAndState, "City & State is diff");
        softAssert.assertEquals(emailField.getText(), "Email: " + email, "Email is diff");
        softAssert.assertEquals(phoneNumberField.getText(), "Phone Number: " + phoneNumber, "Phone number is diff");
        softAssert.assertEquals(zipCodeField.getText(), "Zip Code: " + zipCode, "Zip code is diff");
        softAssert.assertTrue(allText.getText().contains("Site: " + siteNumber + " - " + siteName), "Site not contains" + siteNumber +" - "+siteName);
        softAssert.assertTrue(allText.getText().contains("Study: " + studyName), "Study not contains " +studyName);
        softAssert.assertAll();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
