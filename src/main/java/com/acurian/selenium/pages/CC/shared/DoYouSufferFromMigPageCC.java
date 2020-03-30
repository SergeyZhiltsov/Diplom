package com.acurian.selenium.pages.CC.shared;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import com.acurian.selenium.pages.CC.MainPageCC;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DoYouSufferFromMigPageCC extends MainPageCC{

    public final String titleExpected = "Do you suffer from migraine headaches?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public DoYouSufferFromMigPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouSufferFromMigPageCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DoYouSufferFromMigPageCC clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }




}
