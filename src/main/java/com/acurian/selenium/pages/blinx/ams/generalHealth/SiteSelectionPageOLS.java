package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
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

public class SiteSelectionPageOLS extends MainPageBlinx {

    private static Logger Log = LogManager.getLogger(SiteSelectionPageOLS.class.getName());

    @Parameter("My PID OLS")
    public String pidNumber;

    public final String titleExpected = "Good news! You have been matched with the doctor(s) below for %s\n" +
            "Please select a doctor and click the \"Next\" button.";

    //@FindBy(xpath = "//div[@class='show-in-ols'][contains(., 'Searching for a Study …')]")
//    @FindBy(xpath = "//div[@class='show-in-ols'][contains(., 'Searching for a study doctor in your area  …')]")
    @FindBy(xpath = "//span[@class='show-in-ols'][contains(., 'Searching for a study doctor in your area …')]")
    WebElement loadingAnimation;
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(id = "expandLocationsCta")
    WebElement showOthersAdditionalLocations;
    @FindBy(xpath = "//div[@id='collapsedContent1']/div[1]")
    WebElement pidNumberPath;

    @FindBy(xpath = "//div[contains(@class,'debug-question-helper')]")
    List<WebElement> debuqQuestionList;
    @FindBy(xpath = "//b[@id='additional-sites-toggle']")
    WebElement additionalLocationLink;

    @Step
    public SiteSelectionPageOLS clickOnDebugSiteName(String debugSiteName) {
        clickOnAddLocLinkIfExist();
        clickOnRadioButton(debuqQuestionList, debugSiteName);
        return this;
    }

    private void clickOnAddLocLinkIfExist() {
        if (isElementPresent(By.xpath("//b[@id='additional-sites-toggle']"))) {
            additionalLocationLink.click();
            waitForAnimation();
        }
    }

    @Step
    public SiteSelectionPageOLS waitForPageLoad5(String studyName) {
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
    public SiteSelectionPageOLS waitForPageLoad(String studyName) {
//        waitforVisibility(loadingAnimation);
//        waitForAbsence(loadingAnimation);
        waitForAnimation();
        waitForPageLoadMain(titleText, String.format(titleExpected, studyName));
        attachPageScreenshot();
        return this;
    }

    @Step
    public SiteSelectionPageOLS clickOnFacilityName(String facilityName) {
        if (isElementPresent(showOthersAdditionalLocations)) {
            clickShowOthersAdditionalLocations();
        }
        waitAndClickWebElement(By.xpath(String
                .format("//div[contains(@class,'choiceSelectionContainer')][contains(.,'%s')]", facilityName)));
        return this;
    }

    private SiteSelectionPageOLS clickShowOthersAdditionalLocations() {
        waitAndClickWebElement(showOthersAdditionalLocations);
        return this;
    }

    @Step
    public SiteSelectionPageOLS getPID(){
        pidNumber = getText(pidNumberPath);
        textToAttachment("PID = " + pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        Log.info("PID = " + pidNumber);
        return this;
    }

    @Step
    public String getPidNumber() {
        return pidNumber;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

    public SiteSelectionPageOLS() {
        PageFactory.initElements(getDriver(), this);}

}
