package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class GenderPageCC extends MainPageCC {

    public final String titleExpected = "This part of the questionnaire requires that we ask about your gender. To confirm, please tell me, is your gender male or female?";
    public final String titleExpected2 = "May I have your date of birth?";
    public final String titleExpected3 = "Please confirm your gender:";

    public final String titleExpectedNew = "This part of the questionnaire requires that we ask about your gender. To confirm, please tell me, is your gender male or female?";

    public final String titleExpectedStandAlone1 = "May I have your date of birth? (text1)";
    public final String titleExpectedStandAlone2 = "May I have your date of birth? (text2)";


    @FindBy(xpath = "//div[@class='subquestion'][2]//span[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//span[@class='sub_question_text']/span[@class='show-in-cc']")
    WebElement titleTextStandAlone;

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='show-in-cc']")
    WebElement titleText2;

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText3;

    @FindBy(xpath = "//div[@class='radio_btns_container']//span")
    List<WebElement> radioButtonsList;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsListGmega;

    @FindBy(xpath = "//select[@name='month']")
    WebElement monthSelect;

    @FindBy(xpath = "//select[@name='date']")
    WebElement daySelect;

    @FindBy(xpath = "//input[@name='year']")
    WebElement yearField;

    @FindBy(xpath = "//div[@class='question_text']/span[@class='show-in-cc']")
    WebElement titleTextSelectGenderStandAlone;

    public GenderPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public GenderPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        waitForPageLoadMain(titleText2, titleExpected2);
        return this;
    }

    /**
     * In Stand Alone test we can use two different titles.
     * If in SB we used first title, then after block try we will have Assertion error.
     * Then we try title number 2.
     * We write results in log and compare with logs of first test.
     * @return
     */
    @Step
    public GenderPageCC waitForPageLoadStandAlone(){
            try {
                waitForPageLoadMain(titleTextStandAlone, titleExpectedStandAlone1);
                logTextToAllureAndConsole("In Screener test modified title 1 is presented. In SB test must be set title 1, too");
            } catch (AssertionError e){
                waitForPageLoadMain(titleTextStandAlone, titleExpectedStandAlone2);
                logTextToAllureAndConsole("In Screener test modified title 2 is presented. In SB test must be set title 2, too");
            }
            return this;
    }

    @Step
    public GenderPageCC waitForPageLoadByTitle(String titleExpected) {
        waitForPageLoadMain(titleText3, titleExpected);
        return this;
    }

    @Step
    public GenderPageCC waitForPageLoadSelectGenderStandAlone() {
        waitForPageLoadMain(titleTextSelectGenderStandAlone, titleExpected);
        return this;
    }

    @Step
    public GenderPageCC waitForPageLoadByTitleNew() {
        waitForPageLoadMain(titleText3, titleExpectedNew);
        return this;
    }

    @Step
    public GenderPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public GenderPageCC clickOnAnswerGmega(String answerText) {
        clickOnRadioButton(radioButtonsListGmega, answerText);
        return this;
    }

    @Step
    public GenderPageCC setMonth(String month) {
        selectDropDownListOptionByText(monthSelect, month);
        return this;
    }

    @Step
    public GenderPageCC setDay(String day) {
        selectDropDownListOptionByText(daySelect, day);
        return this;
    }

    @Step
    public GenderPageCC setYear(String year) {
        typeText(yearField, year);
//        clickOnAnswer("Yes");//def click
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
