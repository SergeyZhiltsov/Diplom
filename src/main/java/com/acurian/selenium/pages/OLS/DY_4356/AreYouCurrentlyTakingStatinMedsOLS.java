package com.acurian.selenium.pages.OLS.DY_4356;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouCurrentlyTakingStatinMedsOLS extends MainPageOLS{

    public final String titleExpected = "Are you currently taking the following statin medication(s)?\n" +
            "If you are not sure of the names of your medications, please first get your medication bottles or packages to confirm.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;

    public AreYouCurrentlyTakingStatinMedsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyTakingStatinMedsOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyTakingStatinMedsOLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }
    // can be an issue with ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]
    // because clickOnRadioButton method use label at the end, so need add ancestor::label

    @Step
    public AreYouCurrentlyTakingStatinMedsOLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
