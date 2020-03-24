package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedCloseGastroPageOLS extends MainPageOLS{

    //Show for 4357 Gastroparesis - NOT IN FLARE patients with Status: INITIAL_INACTIVE
    public final String titleExpected = "Thank you for your interest in Diabetic Gastroparesis studies. Based on the information you provided, we have matched you with a study.";

    public final String titleExpected2 = "NEXT STEPS:\n" +
            "We will email you weekly reminders to track your symptoms. This will help us send you to the doctor's office at the right time.\n" +
            "The best way to receive these reminders is through email.\n" +
            "If you do not have an email address, we can contact you using the phone number that you provided.";

    public final String titleExpected3 = "*Your contact information will be kept confidential and only be used to send you reminders to track your symptoms\n" +
            "\n" +
            "Thank you for your help in advancing research for Diabetic Gastroparesis!";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    WebElement titleText2;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//div[contains(@class,'visible-md-block')]")
    WebElement titleText3;

    public QualifiedCloseGastroPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedCloseGastroPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        waitForPageLoadMain(titleText2, titleExpected2);
        waitForPageLoadMain(titleText3, titleExpected3);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
