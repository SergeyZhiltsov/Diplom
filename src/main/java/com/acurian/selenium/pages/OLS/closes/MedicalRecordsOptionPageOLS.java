package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class MedicalRecordsOptionPageOLS extends MainPageOLS {

    public final String titleExpected1 = "Why are Medical Records Important?";
    public final String titleExpected2 = "It is important for the study doctor to have your full health history in a timely manner. Your medical records are the best way to provide the study doctor with this very important health information.\n\n" +
            "The information contained in your medical records is confidential. If you agree to let us access your medical records, please know that your records will be kept secure. They will only be shared with the study doctor's office.\n\n" +
            "Your medical record information is likely stored in multiple locations, so this service not only helps us protect your safety and health during a study by providing the study doctor with all your health information, but also will help speed up your first appointment at the study doctor's office. Your email is required to move to the next step of the medical records process.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText1;
    @FindBy(xpath = "//div[@class='subquestion ng-scope']//div[@class='visible-md-block visible-lg-block ng-scope']")
    WebElement titleText2;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public MedicalRecordsOptionPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText1, titleExpected1);
        waitForPageLoadMain(titleText2, titleExpected2);
        return this;
    }

    @Step
    public MedicalRecordsOptionPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText1() {
        return getText(titleText1);
    }

    @Step
    public String getTitleText2() {
        return getText(titleText2);
    }
}