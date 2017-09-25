package com.acurian.selenium.pages.OLS.shared;


import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class GenderPageOLS extends MainPageOLS{

    public final String titleExpected = "Please select your gender:";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    //span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']
    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public GenderPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public GenderPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
//        waitForAnimation();
//        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public GenderPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
//        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
//                .findFirst()
//                .get()
//                .click();
//        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

