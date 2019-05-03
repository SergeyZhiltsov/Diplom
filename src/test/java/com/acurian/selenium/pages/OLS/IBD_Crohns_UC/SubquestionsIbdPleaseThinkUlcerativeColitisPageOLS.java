package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionsIbdPleaseThinkUlcerativeColitisPageOLS extends MainPageOLS {

    public final String titleExpected1 = "Please think about your Ulcerative Colitis symptoms when answering the questions below.";
    public final String titleExpected2 = "On an average day, how many total bowel movements do you have?";
    public final String titleExpected3 = "In the past 24 hours, how many total bowel movements did you have?";
    public final String titleExpected4 = "Over the past 24 hours, did you notice any blood in your stool, on toilet tissue, or in the toilet bowl?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//input")
    WebElement avgDayBowel;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//input")
    WebElement past24hrBowel;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;


    public SubquestionsIbdPleaseThinkUlcerativeColitisPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsIbdPleaseThinkUlcerativeColitisPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected1);
        waitForPageLoad(1, titleExpected2);
        waitForPageLoad(2, titleExpected3);
        waitForPageLoad(3, titleExpected4);
        return this;
    }

    @Step
    public SubquestionsIbdPleaseThinkUlcerativeColitisPageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex - 1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionsIbdPleaseThinkUlcerativeColitisPageOLS setTotalBowelMovements(String text) {
        typeText(avgDayBowel, text);
        return this;
    }

    @Step
    public SubquestionsIbdPleaseThinkUlcerativeColitisPageOLS setTotalpast24hrBowelMovements(String text) {
        typeText(past24hrBowel, text);
        return this;
    }


    @Step
    public SubquestionsIbdPleaseThinkUlcerativeColitisPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex) {
        return getText(titlesText.get(titleIndex - 1));
    }
}
