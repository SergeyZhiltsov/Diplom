package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.utils.PassPID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SiteSelectionPageCC extends MainPageCC {

    private static Logger Log = LogManager.getLogger(SiteSelectionPageCC.class.getName());

    @Parameter("My PID")
    public String pidNumber;

    private final String unstableTitleText = "//div[@class='question_text']//span[@class='show-in-cc']";

    //%s = studyName variable
    public final String titleExpected2 = "The closest doctor's office available for %s is located at [name of street and city]. Is that convenient for you?\n" +
            "\n" +
            "[Agent Note: The patient may have responded to outreach for a specific type of study within a broader indication, such as \"diabetic nerve pain\" or \"diabetics with foot ulcer\" or \"diabetics with stomach problems,\" and are referring for (for example) a different diabetes complication study or for a general diabetes study. If there is confusion about which study they are being referred for, the following type of clarification can be offered:\n" +
            "“Based on your answers, you are not an exact match for the study referenced in the letter or ad about specific diabetes complications to which you originally responded. However, you have prequalified for another study for people with diabetes.”]\n" +
            "\n" +
            "[Offer second closest site if necessary and if reasonable]\n" +
            "If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that none of these locations are convenient. We can either make a note to contact you if a more convenient location becomes available, or I can send your information over to a study doctor's office and you can talk to them about the study. Which would you prefer?\"";

    public final String titleExpected = "The closest doctor's office available for an irritable bowel syndrome (IBS) study is located at [name of street and city]. Is that convenient for you?\n" +
            "\n" +
            "[Agent Note: The patient may have responded to outreach for a specific type of study within a broader indication, such as \"diabetic nerve pain\" or \"diabetics with foot ulcer\" or \"diabetics with stomach problems,\" and are referring for (for example) a different diabetes complication study or for a general diabetes study. If there is confusion about which study they are being referred for, the following type of clarification can be offered:\n" +
            "“Based on your answers, you are not an exact match for the study referenced in the letter or ad about specific diabetes complications to which you originally responded. However, you have prequalified for another study for people with diabetes.”]\n" +
            "\n" +
            "[Offer second closest site if necessary and if reasonable]\n" +
            "If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that none of these locations are convenient. We can either make a note to contact you if a more convenient location becomes available, or I can send your information over to a study doctor's office and you can talk to them about the study. Which would you prefer?\"";
    public final String titleExpectedMCC = "The closest doctor's office available for %s is located at [name of street and city]. Is that convenient for you?\n" +
            "\n" +
            "[Agent Note: The patient may have responded to outreach for a specific type of study within a broader indication, such as \"diabetic nerve pain\" or \"diabetics with foot ulcer\" or \"diabetics with stomach problems,\" and are referring for (for example) a different diabetes complication study or for a general diabetes study. If there is confusion about which study they are being referred for, the following type of clarification can be offered:\n" +
            "“Based on your answers, you are not an exact match for the study referenced in the letter or ad about specific diabetes complications to which you originally responded. However, you have prequalified for another study for people with diabetes.”]\n" +
            "\n" +
            "[Offer second closest site if necessary and if reasonable]\n" +
            "If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that none of these sites are convenient. We can either make a note to contact you if a more convenient site becomes available, or I can send your information over to a site and you can talk to them about the study. Which would you prefer?\"";
    public final String titleExpectedVacc = "The closest doctor's office available for %s is located at [name of street and city]. Is that convenient for you?\n" +
            "\n" +
            "[Agent Note: The patient may have responded to outreach for a specific type of study within a broader indication, such as \"diabetic nerve pain\" or \"diabetics with foot ulcer\" or \"diabetics with stomach problems,\" and are referring for (for example) a different diabetes complication study or for a general diabetes study. If there is confusion about which study they are being referred for, the following type of clarification can be offered:\n" +
            "“Based on your answers, you are not an exact match for the study referenced in the letter or ad about specific diabetes complications to which you originally responded. However, you have prequalified for another study for people with diabetes.”]\n" +
            "\n" +
            "[Offer second closest site if necessary and if reasonable]\n" +
            "If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that none of these locations are convenient. We can either make a note to contact you if a more convenient location becomes available, or I can send your information over to a study doctor's office and you can talk to them about the study. Which would you prefer?\"";

    public final String titleGmegaExpected = "The closest doctor's office available for %s is located at [name of street and city]. Is that convenient for you?\n" +
            "\n" +
            "[Agent Note: The patient may have responded to outreach for a specific type of study within a broader indication, such as \"diabetic nerve pain\" or \"diabetics with foot ulcer\" or \"diabetics with stomach problems,\" and are referring for (for example) a different diabetes complication study or for a general diabetes study. If there is confusion about which study they are being referred for, the following type of clarification can be offered:\n" +
            "“Based on your answers, you are not an exact match for the study referenced in the letter or ad about specific diabetes complications to which you originally responded. However, you have prequalified for another study for people with diabetes.”]\n" +
            "\n" +
            "[Offer second closest site if necessary and if reasonable]\n" +
            "If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that none of these locations are convenient. We can either make a note to contact you if a more convenient location becomes available, or I can send your information over to a study doctor's office and you can talk to them about the study. Which would you prefer?\"";

    public final String titleExpected5 = "The closest doctor's office available for %s is located at [name of street and city]. Is that convenient for you?\n" +
            "\n" +
            "[Agent Note: The patient may have responded to outreach for a specific type of study within a broader indication, such as \"diabetics with foot ulcer\" or \"diabetics with stomach problems,\" and are referring for (for example) a different diabetes complication study or for a general diabetes study. If there is confusion about which study they are being referred for, the following type of clarification can be offered: \"You may have seen a letter or ad that mentioned a specific diabetes complication such as stomach problems due to diabetes or foot sores or ulcers due to diabetes. Based on your answers, you are not an exact match for that study; however, you have prequalified for another study for people with diabetes.\"]\n" +
            "\n" +
            "[Offer second closest site if necessary and if reasonable]\n" +
            "If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that site isn't very convenient. We have a couple of options: we can make a note to contact you if a more convenient site becomes available. Or, I can send your information over to the site in (town), and you can talk to them about the study and see if they might be able to help arrange transportation for you. Which would you prefer?\"";

    @FindBy(xpath = unstableTitleText)
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_CC)
    WebElement titleTextGMEGA;

    @FindBy(xpath = "//div[@class='site_selection_container']//span[@class='site_sel_radio_facilityName']")
    List<WebElement> radioButtonsList;

    @FindBy(xpath = "//div[@class='site_selection_container']//span[@class='question_helper']")
    List<WebElement> radioButtonsList1;

    @FindBy(xpath = "//em[@id='debug-pid']")
    WebElement pidNumberPath;

    @FindBy(xpath = "//div[@class='site_selection_container']//span[@class='question_helper']")
    List<WebElement> debuqQuestionList;

    public SiteSelectionPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SiteSelectionPageCC waitForPageLoad(String studyName) {
        waitForAnimation();
        attachPageScreenshot();    //--Take Screenshot of Site selection page
        String titleExpectedMod = String.format(titleExpected2, studyName);
        try {
            waitForPageLoadMain(titleText, titleExpectedMod);
            return this;
        } catch (StaleElementReferenceException e) {
            waitForPageLoadMain(getDriver().findElement(By.xpath(unstableTitleText)), titleExpectedMod);
            return this;
        }
    }

    @Step
    public SiteSelectionPageCC waitForPageLoadGMEGA(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected5, studyName);
        try {
            waitForPageLoadMain(titleTextGMEGA, titleExpectedMod);
            return this;
        } catch (StaleElementReferenceException e) {
            waitForPageLoadMain(getDriver().findElement(By.xpath(unstableTitleText)), titleExpectedMod);
            return this;
        }
    }

    @Step
    public SiteSelectionPageCC waitForPageLoad3(String studyName) {
        waitForAnimation();
        attachPageScreenshot();    //--Take Screenshot of Site selection page
        String titleExpectedMod = String.format(titleExpectedVacc, studyName);
        try {
            waitForPageLoadMain(titleText, titleExpectedMod);
            return this;
        } catch (StaleElementReferenceException e) {
            waitForPageLoadMain(getDriver().findElement(By.xpath(unstableTitleText)), titleExpectedMod);
            return this;
        }
    }

    @Step
    public SiteSelectionPageCC waitForPageLoadMCC(String studyName) {
        waitForAnimation();
        String titleExpected = String.format(titleExpectedMCC, studyName);
        wait.until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public SiteSelectionPageCC waitForPageLoadGmega(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleGmegaExpected, studyName);
        try {
            waitForPageLoadMain(titleText, titleExpectedMod);
            return this;
        } catch (StaleElementReferenceException e) {
            waitForPageLoadMain(getDriver().findElement(By.xpath(unstableTitleText)), titleExpectedMod);
            return this;
        }
    }

    @Step
    public SiteSelectionPageCC waitForPageLoad5(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected5, studyName);
        try {
            waitForPageLoadMain(titleText, titleExpectedMod);
            return this;
        } catch (StaleElementReferenceException e) {
            waitForPageLoadMain(getDriver().findElement(By.xpath(unstableTitleText)), titleExpectedMod);
            return this;
        }
    }

    @Step
    public SiteSelectionPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    public SiteSelectionPageCC assertTestSiteIndicator(String answerText) {
        String bacgroundColorActual = radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .findElement(By.xpath("ancestor::span[@class='site_info_wrapper']//strong[@class='site_sel_radio_location']"))
                .getCssValue("background-color");
        Assert.assertEquals(bacgroundColorActual, "rgba(255, 255, 0, 1)", "background color is diff");
        waitForAnimation();
        return this;
    }

    @Step
    public SiteSelectionPageCC clickOnDebugSiteName(String debugSiteName) {
        clickOnRadioButton(debuqQuestionList, debugSiteName);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

    @Step
    public SiteSelectionPageCC getPID() {
        pidNumber = getText(pidNumberPath);
        textToAttachment("PID = " + pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        Log.info("PID = " + pidNumber);
        return this;
    }

//    @Step("{0}")
//    private void textToAttachment(String text) {
//        //empty method
//    }
}