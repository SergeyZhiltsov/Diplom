package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DoYouSufferFromLbpPageCC extends BasePage{

    public final String titleExpected = "Do you suffer from low back pain?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public DoYouSufferFromLbpPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouSufferFromLbpPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DoYouSufferFromLbpPageCC clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }




}
