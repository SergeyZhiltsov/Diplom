package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.utils.PassPID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class IncongruentSiteSelectionClose_OLS extends MainPageOLS{

    private static Logger Log = LogManager.getLogger(IncongruentSiteSelectionClose_OLS.class.getName());

    @Parameter("My PID OLS")
	public String pidNumber;

    private final String titleExpected = "Good news! Based on the information you provided, you have been matched with the doctor(s) below for %1$s!\n" +
            "\n" +
            "Unfortunately, we were unable to find %2$s in your area that was an exact match.\n" +
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
    public IncongruentSiteSelectionClose_OLS waitForPageLoad(String matchedStudy, String dqStudy) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected, matchedStudy, dqStudy);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }
    
    private void clickOnAddLocLinkIfExist(){
        if(isElementPresent(By.xpath("//b[@id='additional-sites-toggle']"))){
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
        textToAttachment("PID="+pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        Log.info("PID = "+pidNumber);
        return this;
    }

    public String getPidNumber(){
        return pidNumber;
    }
}

