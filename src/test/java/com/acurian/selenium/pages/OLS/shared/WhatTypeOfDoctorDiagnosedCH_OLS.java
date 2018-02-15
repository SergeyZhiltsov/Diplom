package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WhatTypeOfDoctorDiagnosedCH_OLS extends MainPageOLS{

    public final String titleExpected = "What type of doctor diagnosed you with cluster headache?\n" + 
    		"If multiple doctors confirmed your diagnosis, please select all that apply.";
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public WhatTypeOfDoctorDiagnosedCH_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhatTypeOfDoctorDiagnosedCH_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhatTypeOfDoctorDiagnosedCH_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
