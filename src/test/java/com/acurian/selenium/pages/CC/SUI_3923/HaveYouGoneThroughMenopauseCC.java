package com.acurian.selenium.pages.CC.SUI_3923;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HaveYouGoneThroughMenopauseCC extends MainPageCC{

    public final String titleExpected = "Menopause is the period in a woman's life in which menstruation stops permanently and she is no longer able to bear children.\n" +
"Have you gone through menopause?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HaveYouGoneThroughMenopauseCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouGoneThroughMenopauseCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HaveYouGoneThroughMenopauseCC clickOnAnswer(String answerText) {
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