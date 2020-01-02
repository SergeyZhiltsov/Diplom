package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.selenium.utils.PassPID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SiteSelectionPageOLS extends MainPageBlinx {

    @Parameter("My PID OLS")
    public String pidNumber;

    public final String titleExpected = "Good news! You have been matched with the doctor(s) below for %s\n" +
            "Please select a doctor and click the \"Next\" button.";

    @FindBy(xpath = "//div[@class='show-in-ols'][contains(., 'Matching You With a Study Doctor...')]")
    WebElement loadingAnimation;
    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[contains(@class,'address2')]")
    List<WebElement> radioButtonsList;
    @FindBy(id = "expandLocationsCta")
    WebElement showOthersAdditionalLocations;

    @FindBy(xpath = "//*[@id='collapsedContent1']/div[1]")
    WebElement pidNumberPath;


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
}
