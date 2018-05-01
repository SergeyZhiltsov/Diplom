package com.acurian.selenium.pages.CC.IBD;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowWouldYouRateCC extends MainPageCC{

    public final String titleExpected = "In general, how would you rate your health, living with Crohn's or colitis?";
    
    public final String titleCompared = "Compared to the past few months, how would you rate your health now?";
    
    public final String titleSymptoms = "Which of the following symptoms are you currently experiencing?\n" +
            "Agent Note: Select all that apply";
    
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    
    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']//div[@class='show-in-cc']")
    WebElement titleTextIBD;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;
    
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleTextRatePage;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public HowWouldYouRateCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowWouldYouRateCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public HowWouldYouRateCC waitForPageLoadIBD() {
        waitForPageLoadMain(titleTextIBD, titleExpected);
        return this;
    }

    @Step
    public HowWouldYouRateCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }
    
    @Step
    public HowWouldYouRateCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
