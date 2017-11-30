package com.acurian.selenium.pages.CC.MDD_3159;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class WhenDidYourCurrentEpisodeDepressionStartCC extends MainPageCC{

    public final String titleExpected = "We'd like to make a distinction between the beginning of your depression overall versus the beginning of your current episode of depression.\n" +
    		"When did your current episode of depression start?\n" +
    		"If you are unsure, please take your best guess.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public WhenDidYourCurrentEpisodeDepressionStartCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDidYourCurrentEpisodeDepressionStartCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WhenDidYourCurrentEpisodeDepressionStartCC clickOnAnswer(String answerText) {
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
