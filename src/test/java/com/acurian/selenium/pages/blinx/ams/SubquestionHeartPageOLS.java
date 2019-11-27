package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionHeartPageOLS extends MainPageBlinx {

    private final String titleExpected1 = "When was the last time that you had a heart attack?";
    private final String titleExpected2 = "When was the last time that you had a stroke?";
    private final String titleExpected3 = "When was the last time that you had a mini-stroke or TIA?";
    private final String titleExpected4 = "When was the last time that you suffered from angina or chest pain that required you to stay in a hospital overnight?";


    @FindBy(xpath = "//div[@class='question-text']")
    List<WebElement> titlesText;

    @FindBy(xpath = "//div[@class='answer-text']")
    List<WebElement> titlesText2;

    @Step
    public SubquestionHeartPageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        driverWait.getWaitDriver().until(ExpectedConditions.numberOfElementsToBeMoreThan(By
                .xpath("//div[@class='question-text']"), actualTitleIndex));
        waitForPageLoadMain(titlesText.get(actualTitleIndex), expectedTitle);
        return this;
    }

    @Step
    public SubquestionHeartPageOLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> radiobuttonListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("following-sibling::div[@class='answers-container']" +
                        "//div[@class='single-choice-answers-container w-100']/button"));
        clickOnRadioButton(radiobuttonListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionHeartPageOLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> radiobuttonListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("//div[@class='answer-text']"));
        clickOnRadioButton(radiobuttonListFromTitle, answerText);
        return this;
    }


    public String getTitleExpected1() {
        return titleExpected1;
    }

    public String getTitleExpected2() {
        return titleExpected2;
    }

    public String getTitleExpected3() {
        return titleExpected3;
    }

    public String getTitleExpected4() {
        return titleExpected4;
    }
}
