package com.acurian.selenium.pages.CC.MDD_3159;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class CurrentEpisodeOfDepressionCC extends MainPageCC{

    public final String titleExpected = "We'd like to make a distinction between the beginning of your depression overall versus the beginning of your current episode of depression.\n" +
    		"When did your current episode of depression start?\n" +
    		"If you are unsure, please take your best guess.\n" +
    		"Agent Note: please read all options";
    

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public CurrentEpisodeOfDepressionCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentEpisodeOfDepressionCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public CurrentEpisodeOfDepressionCC clickOnAnswer(String answerText) {
    	clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
