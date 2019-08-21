package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionsIbdPleaseThinkCrohnsPageOLS extends MainPageOLS{

    public final String titleExpected1 = "Please think about your Crohn's disease symptoms when answering the questions below.";
    public final String titleExpected2 = "Over the past week, how many liquid or very soft bowel movements, or episodes of diarrhea per day did you have on average?";
    public final String titleExpected3 = "Over the past week, how would you rate your average level of abdominal pain or cramping?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;
    
    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//input")
    WebElement avgDayBowel;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//input")
    WebElement past24hoursTotalBowelMovements;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;
    

    public SubquestionsIbdPleaseThinkCrohnsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsIbdPleaseThinkCrohnsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected1);
        waitForPageLoad(1,titleExpected2);
        waitForPageLoad(2, titleExpected3);
        return this;
    }

    @Step
    public SubquestionsIbdPleaseThinkCrohnsPageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionsIbdPleaseThinkCrohnsPageOLS setAvgDayBowelMovements(String text) {
        typeText(avgDayBowel, text);
        return this;
    }

    @Step
    public SubquestionsIbdPleaseThinkCrohnsPageOLS setPast24hoursTotalBowelMovements(String text) {
        typeText(past24hoursTotalBowelMovements, text);
        return this;
    }

    @Step
    public SubquestionsIbdPleaseThinkCrohnsPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
