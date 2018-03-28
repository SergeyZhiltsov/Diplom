package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.utils.PassPID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SiteSelectionPageOLS extends MainPageOLS{

    @Parameter("My PID OLS")
	public String pidNumber;

    //%s = studyName variable
    public final String titleExpected = "Good news! You have been matched with the doctor(s) below for %s study!\n" +
            "Please select a doctor and click the \"Next\" button.";  

    @FindBy(xpath = "//div[contains(@class,'question')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'address2')]")
    List<WebElement> radioButtonsList;

    @FindBy(xpath = "//debug-popup//span[@id='debug_pid']")
    WebElement pidNumberPath;

    @FindBy(xpath = "//b[@id='additional-sites-toggle']")
    WebElement additionalLocationLink;

    @FindBy(xpath = "//div[contains(@class,'debug-question-helper')]")
    List<WebElement> debuqQuestionList;

    public SiteSelectionPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SiteSelectionPageOLS waitForPageLoad(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected, studyName);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }
    
    private void clickOnAddLocLinkIfExist(){
        if(isElementPresent(7, By.xpath("//b[@id='additional-sites-toggle']"))){
            additionalLocationLink.click();
            waitForAnimation();
        }
    }

    @Step
    public SiteSelectionPageOLS clickOnFacilityName(String facilityName) {
        clickOnAddLocLinkIfExist();
        clickOnRadioButton(radioButtonsList, facilityName);
        return this;
    }

    @Step
    public SiteSelectionPageOLS clickOnDebugSiteName(String debugSiteName) {
        clickOnAddLocLinkIfExist();
        clickOnRadioButton(debuqQuestionList, debugSiteName);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    @Step
    public SiteSelectionPageOLS getPID(){
        pidNumber = getText(pidNumberPath);
        logTextToAllure("PID="+pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        System.out.println("PID = "+pidNumber);
        return this;
    }

    public String getPidNumber(){
        return pidNumber;
    }
}
