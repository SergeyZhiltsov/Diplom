package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.CC.LBP_2108.InTotalHowMany;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HistoryOfDrugPageCC extends BasePage{

    public final String titleExpected = "Do you have a history of drug or alcohol abuse?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HistoryOfDrugPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HistoryOfDrugPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HistoryOfDrugPageCC clickOnAnswer(String answerText) {
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
