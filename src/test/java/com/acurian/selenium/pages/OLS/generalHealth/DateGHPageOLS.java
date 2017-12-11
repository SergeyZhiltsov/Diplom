package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.utils.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DateGHPageOLS extends MainPageOLS{

    public final String titleExpected = "What is your date of birth?";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement questionText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'text-date-input')]")
    WebElement dateField;

    public final String titleGHExpected = "Let's get started to see if you qualify for a study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $1,000\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    public DateGHPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DateGHPageOLS openPage(String environment, String phoneNumber){
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
    public DateGHPageOLS waitForPageLoad() {
        waitForPageLoadMain(questionText,titleExpected);
//        waitForAnimation();
//        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> questionText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DateGHPageOLS setDate(String date) {
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
