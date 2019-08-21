package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class TransitionStatementCC extends MainPageCC {

    //%s = studyName variable
    private final String titleExpected = "Thank you for answering the questions about your %s history.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
            "Agent Note: If \"no\" to all items in a question, select \"None of the above\"";
    
    private final String titleExpectedWithCurves = "Thank you for answering the questions about your %s history.\n" +
    		"I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me “yes” or “no,” and I will check off each condition that you do have.\n" +
    		"Agent note: If “no” to all items in a question, select “None of the above”";
    
    private final String titleExpectedCurves1 = "Thank you for answering the questions about your %s history.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
            "Agent note: If “no” to all items in a question, select “None of the above”";
    
    private final String titleExpectedKAD = "Thank you for answering the questions about your %s history.\n" +
    		"I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me “yes” or “no,” and I will check off each condition that you do have.\n" +
    		"Agent note: If \"no\" to all items in a question, select \"None of the above\"";
    
    private final String titleExpectedNew = "Thank you for answering the questions about your %s.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me “yes” or “no,” and I will check off each condition that you do have.\n" +
            "Agent Note: If \"no\" to all items in a question, select \"None of the above\"";
    
    private final String titleExpectedMCC = "Thank you for answering the questions about your %s.\n" +
    		"I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
            "Agent Note: If \"no\" to all items in a question, select \"None of the above\"";
    
    private final String titleExpectedGERD = "Thank you for answering the questions about your %s.\n" +
    		"I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
    		"Agent note: if \"no\" to all items in a question, select \"None of the above\"";  
    
    private final String titleExpectedMDD = "Thank you for answering the questions about your %s.\n" +
    		"I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
    		"Agent note: If \"no\" to all items in a question, select \"None of the above\"";

    private final String titleExpectedDYS = "Thank you for answering these specific health questions.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
            "Agent Note: If \"no\" to all items in a question, select \"None of the above\"";

    public final String titleExpectedEndo = "Thank you for answering the questions about your endometriosis history.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
            "Agent note: If \"no\" to all items in a question, select \"None of the above\"";

    public final String titleIBSExpected = "Thank you for answering these questions about your IBS.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
            "Agent note: If \"no\" to all items in a question, select \"None of the above\"";

    public final String titleInitialQuestionsExpected = "Thank you for answering these initial questions.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
            "Agent Note: If \"no\" to all items in a question, select \"None of the above\"";

    public final String titleExpectedPsoriasis = "Thank you for answering the questions about your psoriasis.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me “yes” or “no,” and I will check off each condition that you do have.\n" +
            "Agent note: If “no” to all items in a question, select “None of the above”";

    public final String titleCOPDExpected = "Thank you for answering the questions about your COPD history.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
            "Agent Note: If \"no\" to all items in a question, select \"None of the above\"";
    		
    
    
    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    public TransitionStatementCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TransitionStatementCC waitForPageLoad(String studyName) {
        String titleExpectedMod = String.format(titleExpected, studyName);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public TransitionStatementCC waitForPageLoadWithTitle(String titleExpected) {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TransitionStatementCC waitForPageLoadDYS() {
        waitForPageLoadMain(titleText, titleExpectedDYS);
        return this;
    }
    
    @Step
    public TransitionStatementCC waitForPageLoadMCC(String studyName) {
        waitForAnimation();
        String titleExpected = String.format(titleExpectedMCC, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    
    @Step
    public TransitionStatementCC waitForPageLoadGERD(String studyName) {
        waitForAnimation();
        String titleExpected = String.format(titleExpectedGERD, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    
    
    @Step
    public TransitionStatementCC waitForPageLoadMDD(String studyName) {
        waitForAnimation();
        String titleExpected = String.format(titleExpectedMDD, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    
    @Step
    public TransitionStatementCC waitForPageLoadNew(String studyName) {
        waitForAnimation();
        String titleExpected = String.format(titleExpectedNew, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public TransitionStatementCC waitForPageLoadWithCurves(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpectedWithCurves, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpectedMod));
        return this;
    }
    
    @Step
    public TransitionStatementCC waitForPageLoadWithCurves1(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpectedCurves1, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpectedMod));
        return this;
    }
    
    @Step
    public TransitionStatementCC waitForPageLoadWithCurvesKAD(String studyName) {
        waitForAnimation();
        String titleExpectedkad = String.format(titleExpectedKAD, studyName);
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpectedkad));
        return this;
    }

    @Step
    public TransitionStatementCC waitForPageLoadPsoriasis() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpectedPsoriasis);
        return this;
    }

    @Step
    public TransitionStatementCC waitForPageLoadWithInitialQuestions() {
        waitForAnimation();

        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    public String getTitleExpected(String studyName){
        return String.format(titleExpected, studyName);
    }

    public String getTitleExpectedWithCurves(String studyName){
        return String.format(titleExpectedWithCurves, studyName);
    }


}