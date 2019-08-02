package com.acurian.selenium.pages.OLS.cv_study;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionHeartPageOLS extends MainPageOLS {

    public final String titleExpected1 = "When was the last time that you had a heart attack?";
    public final String titleExpected2 = "When was the last time that you had a stroke?";
    public final String titleExpected3 = "When was the last time that you had a mini-stroke or TIA?";
    public final String titleExpected4 = "When was the last time that you suffered from angina or chest pain that required you to stay in a hospital overnight?";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;

    public SubquestionHeartPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionHeartPageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex - 1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionHeartPageOLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> radiobuttonListFromTitle = titlesText.get(questionNumber - 1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(radiobuttonListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionHeartPageOLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> radiobuttonListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(radiobuttonListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex - 1));
    }
}