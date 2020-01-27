package com.acurian.selenium.pages.CC.DPN_3769_4557;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class DoYouExperienceDPN_CC extends MainPageCC{

    public final String titleExpected = "Do you experience diabetic peripheral neuropathy or diabetic nerve pain?\n" +
    		"This condition can cause pain, tingling, or numbness in your feet, legs, hands, or arms.";
    public final String titleExpectedDPN = "Do you experience diabetic peripheral neuropathy (DPN) or diabetic nerve pain?\n" +
            "This condition can cause pain, tingling, or numbness in your feet, legs, hands, or arms.";
    public final String titleExpectedNew = "Do you experience pain, tingling, or numbness in your feet or legs, symptoms caused by diabetic peripheral neuropathy (DPN) or diabetic nerve pain?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    @Step
    public DoYouExperienceDPN_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }


    @Step
    public DoYouExperienceDPN_CC waitForPageLoadDPN() {
        waitForPageLoadMain(titleText, titleExpectedDPN);
        return this;
    }

    @Step
    public DoYouExperienceDPN_CC waitForPageLoadNew() {
        waitForPageLoadMain(titleText, titleExpectedNew);
        return this;
    }

    @Step
    public DoYouExperienceDPN_CC clickOnAnswer(String answerText) {
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
