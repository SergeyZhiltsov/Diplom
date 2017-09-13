package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouCurrentlyOnPageCC extends BasePage{

    public final String titleExpected = "Are you currently on a long term steroid prescription medication for more than 10 days?\n" +
            "Commonly used types of steroids include prednisone, prednisolone, dexamethasone, methylprednisolone, and Medrol.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyOnPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyOnPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public AreYouCurrentlyOnPageCC clickOnAnswer(String answerText) {
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
