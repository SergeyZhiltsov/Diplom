package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.CC.MainPageCC;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowOldWereYouMigHeadachePageCC extends MainPageCC{

    public final String titleExpected = "Approximately how old were you when you were diagnosed with migraine headaches?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    //@FindBy(xpath = "//div[@class='radio_btns_container']//label")
    //List<WebElement> radioButtonsList;

    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement ageMig;
    
    public HowOldWereYouMigHeadachePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowOldWereYouMigHeadachePageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowOldWereYouMigHeadachePageCC typeAge(String text) {
        //typeTextWithoutClear(ageMig, text);
        typeText(ageMig, text);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
