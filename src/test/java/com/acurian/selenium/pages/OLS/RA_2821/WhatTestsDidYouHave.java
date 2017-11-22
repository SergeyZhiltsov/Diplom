package com.acurian.selenium.pages.OLS.RA_2821;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;


import ru.yandex.qatools.allure.annotations.Step;

public class WhatTestsDidYouHave extends MainPageOLS {
	
	public final String titleExpected = "What tests did you have that led to your doctor diagnosing your Rheumatoid Arthritis?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS506_')]/span[@class='copy']")
    List<WebElement> checkBoxList;

    public WhatTestsDidYouHave() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhatTestsDidYouHave waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhatTestsDidYouHave clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}
