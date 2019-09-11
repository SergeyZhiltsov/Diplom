package com.acurian.selenium.pages.blinx.gmega;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SiteSelectionPageOLS extends MainPageBlinx {

    public final String titleExpected = "Good news! You have been matched with the doctor(s) below for %s\n" +
            "Please select a doctor and click the \"Next\" button.";

    @FindBy(xpath = "//div[@class='show-in-ols'][contains(., 'Matching You With a Study Doctor...')]")
    WebElement loadingAnimation;
    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleText;
    @FindBy(xpath = "//div[contains(@class,'address2')]")
    List<WebElement> radioButtonsList;


    @Step
    public SiteSelectionPageOLS waitForPageLoad(String studyName) {
        waitForVisibility(loadingAnimation);
        waitForAbsence(loadingAnimation);
        waitForPageLoadMain(titleText, String.format(titleExpected, studyName));
        attachPageScreenshot();
        return this;

    }

    @Step
    public SiteSelectionPageOLS clickOnFacilityName(String facilityName) {
        waitAndClickWebElement(By.xpath(String
                .format("//div[contains(@class,'choiceSelectionContainer')][contains(.,'%s')]", facilityName)));
        return this;
    }
}
