package com.acurian.selenium.pages.CC.LPS_4442;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class WhatTypeOfLupusCC extends MainPageCC{

    public final String titleExpected = "What type of lupus were you diagnosed with? (Agent Note: LOOP-us)";

    @FindBy(xpath = "//div[@class='question_text']/div[@class='show-in-cc']")
    WebElement titleText;    

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;
    
    public WhatTypeOfLupusCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhatTypeOfLupusCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WhatTypeOfLupusCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
