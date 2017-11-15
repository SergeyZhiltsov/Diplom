package com.acurian.selenium.pages.OLS.Insomnia_3792;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.shared.StudyQuestionMigPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.MetforminMedicationsPageOLS;

import ru.yandex.qatools.allure.annotations.Step;


public class WhatTmeYouUsuallyGoToBed_OLS extends MainPageOLS {

   public final String titleExpected ="What time do you usually go to bed to try to sleep?";
  
    @FindBy(xpath = "(//div[contains(@class,'visible-md-block')])[1]")
    WebElement titleText;
    

    @FindBy(xpath = "//select[@id='QS3915A']")
    WebElement gotobedSelect;

    @FindBy(xpath = "//select[@id='QS3915B']")
    WebElement getoutofbedSelect;



    public WhatTmeYouUsuallyGoToBed_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    
    @Step
    public WhatTmeYouUsuallyGoToBed_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
  
    @Step
    public String getTitleText() {
        return getText(titleText);
    }

    @Step
    public WhatTmeYouUsuallyGoToBed_OLS selectGo_to_bed(String go_to_bed) {
    	selectDropDownListOptionByText(gotobedSelect, go_to_bed);
        return this;
    }

    @Step
    public WhatTmeYouUsuallyGoToBed_OLS selectGet_out_of_bed(String get_out_of_bed) {
    	selectDropDownListOptionByText(getoutofbedSelect, get_out_of_bed);
    	//selectDropDownListOptionByValue(getoutofbedSelect, get_out_of_bed);
        return this;
    }
}