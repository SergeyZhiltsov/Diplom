package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LetMeSeePageCC extends MainPageCC {

    public final String titleExpected = "Thank you, let me see if there are any follow-up questions that we need to ask based on the conditions that you experience.\n" +
            "Agent Note: Click \"Next\" to continue";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    public LetMeSeePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LetMeSeePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}