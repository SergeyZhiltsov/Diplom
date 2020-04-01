package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.utils.PassPID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SiteSelectionPageOLS extends MainPageBlinx {

    private static Logger Log = LogManager.getLogger(SiteSelectionPageOLS.class.getName());

    @Parameter("My PID OLS")
    public String pidNumber;

    public final String titleExpected = "Good news! You have been matched with the doctor(s) below for %s\n" +
            "Please select a doctor and click the \"Next\" button.";
    public final String titleExpectedGBAN = "Please select a research site that is convenient to you and click the next button.";

    @FindBy(xpath = "//span[@class='show-in-ols'][contains(., 'Matching You With a Study Doctor...')]")
    WebElement loadingAnimation;
    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[contains(@class,'address2')]")
    List<WebElement> radioButtonsList;
    @FindBy(id = "expandLocationsCta")
    WebElement showOthersAdditionalLocations;

    @FindBy(xpath = "//*[@id='collapsedContent1']/div[1]")
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
    public SiteSelectionPageOLS waitForPageLoad(String studyName) {
        waitForAnimation();
        waitforVisibility(loadingAnimation);
        waitForAbsence(loadingAnimation);
        waitForAnimation();
        waitForPageLoadMain(titleText, String.format(titleExpected, studyName));
        attachPageScreenshot();
        return this;
    }

    @Step
    public SiteSelectionPageOLS waitForPageLoadGBAN() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpectedGBAN);
        return this;
    }

    @Step
    public SiteSelectionPageOLS clickOnFacilityName(String facilityName) {
        By by = By.xpath(String
                .format("//div[contains(@class,'choiceSelectionContainer')][contains(.,'%s')]", facilityName));
        if (isElementPresent(showOthersAdditionalLocations)) {
            waitAndClickWebElement(showOthersAdditionalLocations);
        }
        try {
            waitAndClickWebElement(by);
        } catch (WebDriverException ex) {
            scrollToElement(getDriver().findElement(by), true);
            logTextToAllureAndConsole("Trying to select facility with scrolling to element.");
            waitAndClickWebElement(by);
        }
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

    public String getPidNumber() {
        return pidNumber;
    }
}
