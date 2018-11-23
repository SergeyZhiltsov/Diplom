package com.acurian.selenium.pages.CC.LOWT;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class WhenWasTheLastTimeYouReceivedHeartProcedure_CC extends MainPageCC{

    public final String titleExpected = "When was your most recent heart procedure?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public WhenWasTheLastTimeYouReceivedHeartProcedure_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenWasTheLastTimeYouReceivedHeartProcedure_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WhenWasTheLastTimeYouReceivedHeartProcedure_CC clickOnAnswer(String answerText) {
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
