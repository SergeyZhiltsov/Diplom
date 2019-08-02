package com.acurian.selenium.pages.CC.GERD;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class AreYouCurrentlyAbleToSwallowTablets_CC extends MainPageCC{

    public final String titleExpected = "Are you currently able to swallow tablets and pills?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyAbleToSwallowTablets_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyAbleToSwallowTablets_CC waitForPageLoad() {
        //waitForAnimation();
        //driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyAbleToSwallowTablets_CC clickOnAnswer(String answerText) {
//        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
//                .findFirst()
//                .get()
//                .click();
//        waitForAnimation();
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
