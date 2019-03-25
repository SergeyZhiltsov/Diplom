package com.acurian.selenium.pages.CC.DYS_4356C;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouCurrentlyTakingStatinMedsCC extends MainPageCC{

    public final String titleExpected = "Are you currently taking (read medication listed below)?\n" +
            "Agent Notes:\n" +
            "If applicable, ask about each medication separately.\n" +
            "If caller is not sure of the names of their medications, say \"Please first get your medication bottles or packages to confirm the names of your medications.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']/span[@class='sub_question_text']")
    List<WebElement> subQuestions;

    public AreYouCurrentlyTakingStatinMedsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyTakingStatinMedsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyTakingStatinMedsCC clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = subQuestions.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
