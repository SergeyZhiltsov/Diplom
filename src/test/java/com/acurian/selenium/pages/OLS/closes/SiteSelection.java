package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;


import ru.yandex.qatools.allure.annotations.Step;

public class SiteSelection extends MainPageOLS{

    public final String titleExpected = "Good news! You have been matched with the doctor(s) below for a rheumatoid arthritis (RA) study!\n" +
            "Please select a doctor and click the Next button.";

    @FindBy(xpath = "//div[contains(@class,'question')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//u[contains(.,'Additional Locations')]")
    WebElement additionalLocations;
    
    @FindBy(xpath = "//label[contains(@for,'QSC9004_2821_AUT_RA2821_Site')]")
    WebElement siteSelect;
    
    @FindBy(xpath = "//label[contains(@for,'QSC9004_4356C_AUT_DYSL')]")
    WebElement siteExton;

    public SiteSelection() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SiteSelection waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }
    
    @Step
    public SiteSelection selectSite() {
       siteSelect.click();
        return this;
    }
    
    @Step
    public SiteSelection selectExton() {
       siteExton.click();
        return this;
    }
    
    @Step
    public SiteSelection clickAdditional() {
    	additionalLocations.click();
        return this;
    }

}
