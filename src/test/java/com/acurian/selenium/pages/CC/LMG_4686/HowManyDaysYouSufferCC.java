package com.acurian.selenium.pages.CC.LMG_4686;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyDaysYouSufferCC extends MainPageCC{

    public final String titleExpected = "A migraine attack could last from a few hours to a few days.\n" +
            "In a typical month, how many days do you suffer from migraines?\n" +
    		"If you have a migraine that starts on a Monday and ends on a Tuesday, that counts as two separate days.\n" +
            "Agent Note: If the caller is unsure, ask them to, \"Just take your best guess.\" If the caller gives a range, gradually prompt them to select a single number.";

    @FindBy(xpath = "//div[@class='question_text']/div[@class='show-in-cc']")
    WebElement titleText;    

    @FindBy(xpath = "//select[@id='QS6005']")
    WebElement days;
    
    public HowManyDaysYouSufferCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyDaysYouSufferCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowManyDaysYouSufferCC selectDay(String text) {        
    	selectDropDownListOptionByText(days, text);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}