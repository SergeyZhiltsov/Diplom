package com.acurian.selenium.pages.OLS.GERD;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OnaTypicalDayWhenDoYouUsually_OLS extends MainPageOLS {
    public final String titleExpected1 = "On a typical day, when do you usually take Nexium (esomeprazole)?\n" +
            "Please select all that apply.";
    public final String titleExpected2 = "On a typical day, when do you usually take Prevacid (lansoprazole)?\n" +
            "Please select all that apply.";
    public final String titleExpected3 = "On a typical day, when do you usually take Prilosec (omeprazole)?\n" +
            "Please select all that apply.";
    public final String titleExpected4 = "On a typical day, when do you usually take Zegerid (omeprazole and sodium bicarbonate)?\n" +
            "Please select all that apply.";
    public final String titleExpected5 = "On a typical day, when do you usually take Aciphex (rabeprazole)?\n" +
            "Please select all that apply.";
    public final String titleExpected6 = "On a typical day, when do you usually take Dexilant (dexlansoprazole)?\n" +
            "Please select all that apply.";
    public final String titleExpected7 = "On a typical day, when do you usually take Protonix (pantoprazole)?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    @FindBy(xpath = "(//div[contains(@class,'visible-md-block')])[1]")
    WebElement maintitleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    List<WebElement> titlesText;


    public OnaTypicalDayWhenDoYouUsually_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    
    @Step
    public OnaTypicalDayWhenDoYouUsually_OLS waitForMainPageLoad() {
        waitForAnimation();
        waitforVisibility(maintitleText);
        return this;
    }
    
    @Step
    public OnaTypicalDayWhenDoYouUsually_OLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public OnaTypicalDayWhenDoYouUsually_OLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public OnaTypicalDayWhenDoYouUsually_OLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public OnaTypicalDayWhenDoYouUsually_OLS clickOnAnswersForSubQuestion(int questionNumber, String ...answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("//ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public OnaTypicalDayWhenDoYouUsually_OLS clickOnAnswersForSubQuestion(String questionText, String ...answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("//ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}