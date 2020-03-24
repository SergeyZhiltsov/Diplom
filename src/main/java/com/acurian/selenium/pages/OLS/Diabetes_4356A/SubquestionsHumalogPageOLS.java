package com.acurian.selenium.pages.OLS.Diabetes_4356A;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class SubquestionsHumalogPageOLS extends MainPageOLS{

    public final String titleExpected1 = "What type of Humalog do you currently use?";
    public final String titleExpected2 = "What type of Humulin do you currently use?";
    public final String titleExpected3 = "What type of Novolin do you currently use?";
    public final String titleExpected4 = "What type of Novolog do you currently use?";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    public SubquestionsHumalogPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionsHumalogPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public SubquestionsHumalogPageOLS clickOnAnswersForSubQuestion(int questionNumber, String ...answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("//ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionsHumalogPageOLS clickOnAnswersForSubQuestion(String questionText, String ...answerText) {
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
