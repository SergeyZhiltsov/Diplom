package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.CC.LBP_2108.InTotalHowMany;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class OtherThanSkinCancerPageCC extends BasePage{

    public final String titleExpected = "Have you ever been diagnosed with cancer, other than skin cancer?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public OtherThanSkinCancerPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OtherThanSkinCancerPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public OtherThanSkinCancerPageCC clickOnAnswer(String answerText) {
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
