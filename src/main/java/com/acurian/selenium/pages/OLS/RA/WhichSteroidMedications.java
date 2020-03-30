package com.acurian.selenium.pages.OLS.RA;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.BasePage;

import ru.yandex.qatools.allure.annotations.Step;

public class WhichSteroidMedications extends BasePage{
	public final String titleExpected = "Which of the following steroid medications are you taking for your RA?";

    @FindBy(xpath = "html/body/div[1]/div[2]/div/div[1]/div/form/div/div[1]/div[2]/div[1]/question/div/div/div/div/div[1]/div/h4/div[1]/div[2]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS511A_')]/span[@class='copy']")
    List<WebElement> radioButtonsList;
    
    @FindBy(xpath = "//label[contains(@for,'QS511B_')]/span[@class='copy']")
    List<WebElement> radioButtonsList2;

    public WhichSteroidMedications() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichSteroidMedications waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhichSteroidMedications clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }
    
    @Step
    public WhichSteroidMedications selectAnswer(String answerText) {
        radioButtonsList2.stream().filter(el -> el.getText().contains(answerText))
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
