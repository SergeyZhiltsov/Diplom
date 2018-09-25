package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.utils.PassPID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class IncongruentSiteSelectionCloseCC extends MainPageCC {

    @Parameter("My PID")
    private String pidNumber;

    //%s = studyName variable
    public final String titleExpected = "Based on your answers, it looks like you are not an exact match for an arthritis study at this moment. The good news is, you have prequalified for %s study.\n" +
    		"\n" +
    		"The closest research site available to you is located at [name of street and city]. Is that convenient for you?\n" +
    		"\n" +
    		"[Offer second closest site if necessary and if reasonable]\n" +
    		"If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that site isn't very convenient. We have a couple of options: we can make a note to contact you if a more convenient site becomes available. Or, I can send your information over to the site in (town), and you can talk to them about the study and see if they might be able to help arrange transportation for you. Which would you prefer?\"";
    
    public final String titleIBDShort = "Based on your answers, it looks like you are not an exact match for a Crohn's study at this moment. The good news is, you have prequalified for %s study.\n" +
            "\n" +
            "The closest research site available to you is located at [name of street and city]. Is that convenient for you?\n" +
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

    public IncongruentSiteSelectionCloseCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public IncongruentSiteSelectionCloseCC waitForPageLoad(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpectedMod));
        return this;
    }
    
    @Step
    public IncongruentSiteSelectionCloseCC waitForPageLoadIBD(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleIBDShort, studyName);
        waitForPageLoadMain(titleText,titleExpectedMod);
//        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpectedMod));
        return this;
    }

    @Step
    public IncongruentSiteSelectionCloseCC clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().equals(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }
    
    @Step
    public IncongruentSiteSelectionCloseCC selectAnswer(String answerText) {
        radioButtonsList1.stream().filter(el -> el.getText().equals(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public IncongruentSiteSelectionCloseCC clickOnDebugSiteName(String debugSiteName) {
        clickOnRadioButton(debuqQuestionList, debugSiteName);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    @Step
    public IncongruentSiteSelectionCloseCC getPID(){
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