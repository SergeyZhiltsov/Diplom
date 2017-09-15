package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.CC.LBP_2108.InTotalHowMany;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class LetMeSeePageCC extends BasePage{

    public final String titleExpected = "Thank you, let me see if there are any follow-up questions that we need to ask based on the conditions that you experience.\n" +
            "Agent Note: Click \"Next\" to continue";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    public LetMeSeePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LetMeSeePageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
