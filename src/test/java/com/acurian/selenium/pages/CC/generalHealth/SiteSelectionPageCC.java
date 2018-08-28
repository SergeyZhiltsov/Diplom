package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.utils.PassPID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SiteSelectionPageCC extends MainPageCC {

    @Parameter("My PID")
    private String pidNumber;

    //%s = studyName variable
    public final String titleExpected = "The closest doctor's office available for %s is located at [name of street and city]. Is that convenient for you?\n" +
            "\n" +
            "[Agent Note: The patient may have responded to outreach for a specific type of study within a broader indication, such as \"diabetics with foot ulcer\" or \"diabetics with stomach problems,\" and are referring for (for example) a different diabetes complication study or for a general diabetes study. If there is confusion about which study they are being referred for, the following type of clarification can be offered: \"You may have seen a letter or ad that mentioned a specific diabetes complication such as stomach problems due to diabetes or foot sores or ulcers due to diabetes. Based on your answers, you are not an exact match for that study; however, you have prequalified for another study for people with diabetes.\"]\n" +
            "\n" +
            "[Offer second closest site if necessary and if reasonable]\n" +
            "If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that site isn't very convenient. We have a couple of options: we can make a note to contact you if a more convenient site becomes available. Or, I can send your information over to the site in (town), and you can talk to them about the study and see if they might be able to help arrange transportation for you. Which would you prefer?\"";
    
    public final String titleExpectedMCC = "The closest doctor's office available for %s is located at [name of street and city]. Is that convenient for you?\n" +
            "\n" +
            "[Agent Note: The patient may have responded to outreach for a specific type of study within a broader indication, such as \"diabetic nerve pain\" or \"diabetics with foot ulcer\" or \"diabetics with stomach problems,\" and are referring for (for example) a different diabetes complication study or for a general diabetes study. If there is confusion about which study they are being referred for, the following type of clarification can be offered:\n" + 
            "“Based on your answers, you are not an exact match for the study referenced in the letter or ad about specific diabetes complications to which you originally responded. However, you have prequalified for another study for people with diabetes.”]\n" +
            "\n" +
            "[Offer second closest site if necessary and if reasonable]\n" +
            "If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that none of these sites are convenient. We can either make a note to contact you if a more convenient site becomes available, or I can send your information over to a site and you can talk to them about the study. Which would you prefer?\"";


    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

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
        String titleExpectedMod = String.format(titleExpected, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpectedMod));
        return this;
    }
    
    @Step
    public SiteSelectionPageCC waitForPageLoadMCC(String studyName) {
        waitForAnimation();
        String titleExpected = String.format(titleExpectedMCC, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public SiteSelectionPageCC clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().equals(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }
    
    @Step
    public SiteSelectionPageCC selectAnswer(String answerText) {
        radioButtonsList1.stream().filter(el -> el.getText().equals(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public SiteSelectionPageCC clickOnDebugSiteName(String debugSiteName) {
        clickOnRadioButton(debuqQuestionList, debugSiteName);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    @Step
    public SiteSelectionPageCC getPID(){
        pidNumber = getText(pidNumberPath);
        logTextToAllure("PID="+pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        System.out.println("PID = "+pidNumber);
        return this;
    }

//    @Step("{0}")
//    private void logTextToAllure(String text) {
//        //empty method
//    }
    }