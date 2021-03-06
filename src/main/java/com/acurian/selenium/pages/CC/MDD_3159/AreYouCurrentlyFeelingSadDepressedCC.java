package com.acurian.selenium.pages.CC.MDD_3159;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class AreYouCurrentlyFeelingSadDepressedCC extends MainPageCC{

    public final String titleExpected = "Are you currently feeling depressed, or experiencing any of the following symptoms?\n" +
    		"Lacking interest in activities you previously enjoyed\n" +
    		"Feeling guilty or worthless\n" +
    		"Having difficulty concentrating or making decisions\n" +
    		"Having trouble sleeping\n" +
    		"Significant weight gain or loss\n" +
    		"Fatigue or loss of energy";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyFeelingSadDepressedCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyFeelingSadDepressedCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public AreYouCurrentlyFeelingSadDepressedCC clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
