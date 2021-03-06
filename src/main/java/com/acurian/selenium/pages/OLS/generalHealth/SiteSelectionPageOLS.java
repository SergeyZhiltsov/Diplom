package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.utils.DBConnection;
import com.acurian.utils.PassPID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SiteSelectionPageOLS extends MainPageOLS {

    private static Logger Log = LogManager.getLogger(SiteSelectionPageOLS.class.getName());

    @Parameter("My PID OLS")
    public String pidNumber;

    //%s = studyName variable
    public final String titleExpected = "Good news! You have been matched with the doctor(s) below for %s study!\n" +
            "Please select a doctor and click the \"Next\" button.";

    public final String titleExpected1 = "Good news! You have been matched with the doctor(s) below for %s\n" +
            "Please select a doctor and click the \"Next\" button.";

    public final String titleAKC = "Good news! You have been matched with the doctor(s) below for a study for diabetics!\n" +
            "Please select a doctor and click the \"Next\" button.";

    public final String titleExpectedGBAN = "Please select a research site that is convenient to you and click the next button.";

    public final String titleExpected2 = "Good news! You have been matched with the doctor(s) below for %s!\n" +
            "Please select a doctor and click the \"Next\" button.";

//    @FindBy(xpath = "//div[contains(@class,'question')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
//    WebElement titleText1;

    @FindBy(xpath = "//div[contains(@class,'question')]//div[contains(@class,'visible-md-block')]/span[@class='show-in-ols']")
    WebElement titleText1;

    @FindBy(xpath = "//div[contains(@class,'question')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleTextGMEGA;

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

    public SiteSelectionPageOLS() {
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
    public SiteSelectionPageOLS waitForPageLoad(String studyName) {
        waitForAnimation();
        attachPageScreenshot();
        String titleExpectedMod = String.format(titleExpected, studyName);
        try {
            waitForPageLoadMain(titleText, titleExpectedMod);
            return this;
        } catch (StaleElementReferenceException e) {
            waitForPageLoadMain(titleText, titleExpectedMod);
            return this;
        }
    }

    @Step
    public SiteSelectionPageOLS waitForPageLoadGMEGA(String studyName) {
        waitForAnimation();
        attachPageScreenshot();
        String titleExpectedMod = String.format(titleExpected, studyName);
        try {
            waitForPageLoadMain(titleTextGMEGA, titleExpectedMod);
            return this;
        } catch (StaleElementReferenceException e) {
            waitForPageLoadMain(titleTextGMEGA, titleExpectedMod);
            return this;
        }
    }

    @Step
    public SiteSelectionPageOLS waitForPageLoad1(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected1, studyName);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public SiteSelectionPageOLS waitForPageLoad2(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected2, studyName);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public SiteSelectionPageOLS waitForPageLoadAKC() {
        waitForAnimation();
        String titleExpectedMod1 = String.format(titleAKC);
        waitForPageLoadMain(titleText, titleExpectedMod1);
        return this;
    }

    @Step
    public SiteSelectionPageOLS waitForPageLoadGBAN() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpectedGBAN);
        return this;
    }

    private void clickOnAddLocLinkIfExist() {
        if (isElementPresent(By.xpath("//b[@id='additional-sites-toggle']"))) {
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
    public String getTitleText() {
        return getText(titleText);
    }

    @Step
    public SiteSelectionPageOLS getPID() {
        pidNumber = getText(pidNumberPath);
        textToAttachment("PID = " + pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        Log.info("PID = " + pidNumber);
        return this;
    }

    @Step
    public SiteSelectionPageOLS GETPIDRegex() {
        pidNumber = getText(pidNumberPath);
        pidNumber = pidNumber.split(" ")[1];
        textToAttachment("PID = " + pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        Log.info("PID = " + pidNumber);
        return this;
    }

    public String getPidNumber() {
        return pidNumber;
    }
}
