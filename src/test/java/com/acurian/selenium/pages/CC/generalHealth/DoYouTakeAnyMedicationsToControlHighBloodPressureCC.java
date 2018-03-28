package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouTakeAnyMedicationsToControlHighBloodPressureCC extends MainPageCC{

    public final String titleExpected = "Do you take any medications to control your high blood pressure or hypertension?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public DoYouTakeAnyMedicationsToControlHighBloodPressureCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouTakeAnyMedicationsToControlHighBloodPressureCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DoYouTakeAnyMedicationsToControlHighBloodPressureCC clickOnAnswer(String answerText) {
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
