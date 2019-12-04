package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class SiteSelectionPageOLS extends MainPageBlinx {

    public final String titleExpected = "Good news! You have been matched with the doctor(s) below for %s\n" +
            "Please select a doctor and click the \"Next\" button.";

    //@FindBy(xpath = "//div[@class='show-in-ols'][contains(., 'Searching for a Study …')]")
    @FindBy(xpath = "//div[@class='show-in-ols'][contains(., 'Searching for a study doctor in your area  …')]")
    WebElement loadingAnimation;
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(id = "expandLocationsCta")
    WebElement showOthersAdditionalLocations;

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
        driverWait.waitforVisibility(loadingAnimation);
        waitForAbsence(loadingAnimation);
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
}
