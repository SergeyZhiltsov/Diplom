package com.acurian.selenium.pages.CC.shared;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class DoYouHaveRegularMenstrualCyclesUF_CC extends MainPageCC{

    public final String titleExpected = "Do you have regular menstrual cycles, meaning you are able to predict when you are getting your period every month and it usually lasts about the same number of days each month?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public DoYouHaveRegularMenstrualCyclesUF_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouHaveRegularMenstrualCyclesUF_CC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DoYouHaveRegularMenstrualCyclesUF_CC clickOnAnswer(String answerText) {
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
