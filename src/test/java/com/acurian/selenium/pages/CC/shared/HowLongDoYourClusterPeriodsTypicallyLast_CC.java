package com.acurian.selenium.pages.CC.shared;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HowLongDoYourClusterPeriodsTypicallyLast_CC extends MainPageCC{

    public final String titleExpected = "A cluster headache cycle, cluster period, or bout is a period of time in which you experience cluster headaches daily or frequently. Many people with cluster headaches have one or two cluster periods each year.\n" +
    		"How long do your cluster periods typically last?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HowLongDoYourClusterPeriodsTypicallyLast_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongDoYourClusterPeriodsTypicallyLast_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowLongDoYourClusterPeriodsTypicallyLast_CC clickOnAnswer(String answerText) {
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
