package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HeartFailureIsAlsoPageCC extends MainPageCC {

    public final String titleExpected = "Heart failure is also called congestive heart failure or CHF. It is an ongoing health problem. It happens when your heart cannot pump as well as it should. Common symptoms of CHF include: fluid retention, swelling of the feet and ankles, bloating, and difficulty breathing.\n" +
            "\n" +
            "Many people with heart failure have a history of other heart problems, like a heart attack or blocked arteries. However, heart failure is a different, specific medical condition. Not everyone who has had a heart attack will develop heart failure.\n" +
            "Has a healthcare professional told you that you have heart failure, congestive heart failure, or CHF?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HeartFailureIsAlsoPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HeartFailureIsAlsoPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HeartFailureIsAlsoPageCC clickOnAnswer(String answerText) {
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
