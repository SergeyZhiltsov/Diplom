package com.acurian.selenium.pages.CC.Insomnia_3792;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class InTotalHowLongAreYouUsuallyAwakeDuringNight_CC extends MainPageCC{

    public final String titleExpected = "In total, after first falling asleep, how long are you usually awake during the night?\n" + 
			"For example, if you awaken 2 times during the night, and it takes 30 minutes for you to get back to sleep each time, your total time awake would be 1 hour.";
    
    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public InTotalHowLongAreYouUsuallyAwakeDuringNight_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InTotalHowLongAreYouUsuallyAwakeDuringNight_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public InTotalHowLongAreYouUsuallyAwakeDuringNight_CC clickOnAnswer(String answerText) {
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
