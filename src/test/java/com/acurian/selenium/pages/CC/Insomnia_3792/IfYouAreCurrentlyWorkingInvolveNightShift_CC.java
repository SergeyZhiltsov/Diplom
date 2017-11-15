package com.acurian.selenium.pages.CC.Insomnia_3792;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class IfYouAreCurrentlyWorkingInvolveNightShift_CC extends MainPageCC{

    public final String titleExpected = "If you are currently working, does your schedule involve a night shift, either permanent or rotating?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public IfYouAreCurrentlyWorkingInvolveNightShift_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public IfYouAreCurrentlyWorkingInvolveNightShift_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public IfYouAreCurrentlyWorkingInvolveNightShift_CC clickOnAnswer(String answerText) {
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
