package com.acurian.selenium.pages.CC.DPN_3769_4557;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class ApproxHowlongYouBeenExpSymptomsCC extends MainPageCC{

    public final String titleExpected = "Approximately how long have you been experiencing symptoms or sensations of diabetic nerve pain?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public ApproxHowlongYouBeenExpSymptomsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ApproxHowlongYouBeenExpSymptomsCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public ApproxHowlongYouBeenExpSymptomsCC clickOnAnswer(String answerText) {
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