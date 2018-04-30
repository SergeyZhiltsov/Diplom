package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.utils.PassPID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class IncongruentSiteSelectionClose_OLS extends MainPageOLS{
	
    @Parameter("My PID OLS")
	public String pidNumber;


    public final String titleExpected = "Good news! Based on the information you provided, you have been matched with the doctor(s) below for a Crohn's study!\n" +
    		"\n" +
    		"We apologize that we were unable to find a Colitis study in your area that was an exact match.\n" +
    		"Please select a doctor and click the \"Next\" button.";

    @FindBy(xpath = "//div[contains(@class,'question')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText1;

    @FindBy(xpath = "//div[contains(@class,'question')]//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement titleText2;

    @FindBy(xpath = "//div[contains(@class,'question')]//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement titleText3;

    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'address2')]")
    List<WebElement> radioButtonsList;

    @FindBy(xpath = "//debug-popup//span[@id='debug_pid']")
    WebElement pidNumberPath;

    @FindBy(xpath = "//b[@id='additional-sites-toggle']")
    WebElement additionalLocationLink;

    @FindBy(xpath = "//div[contains(@class,'debug-question-helper')]")
    List<WebElement> debuqQuestionList;

    public IncongruentSiteSelectionClose_OLS() {
        PageFactory.initElements(getDriver(), this);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                titleText = titleText1;
                break;
            case Platforms.TABLET:
                titleText = titleText2;
                break;
            case Platforms.MOBILE:
                titleText = titleText3;
                break;
        }
    }

    @Step
    public IncongruentSiteSelectionClose_OLS waitForPageLoad(String studyName) {
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
    public IncongruentSiteSelectionClose_OLS clickOnFacilityName(String facilityName) {
        clickOnAddLocLinkIfExist();
        clickOnRadioButton(radioButtonsList, facilityName);
        return this;
    }

    @Step
    public IncongruentSiteSelectionClose_OLS clickOnDebugSiteName(String debugSiteName) {
        clickOnAddLocLinkIfExist();
        clickOnRadioButton(debuqQuestionList, debugSiteName);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    @Step
    public IncongruentSiteSelectionClose_OLS getPID(){
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

