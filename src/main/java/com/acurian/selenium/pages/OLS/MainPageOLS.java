package com.acurian.selenium.pages.OLS;

import com.acurian.selenium.constants.FULType;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import com.acurian.utils.PassPID;
import com.acurian.utils.db.AnomalyResults;
import com.acurian.utils.db.ChildResult;
import com.acurian.utils.db.RadiantResults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class MainPageOLS extends BasePage {

    private static Logger Log = LogManager.getLogger(MainPageOLS.class.getName());

    @FindBy(xpath = "//button[@id='submit']")
    WebElement nextButton;

    @FindBy(xpath = "//img[starts-with(@src,'http')]")
    private List<WebElement> images;

    @FindBy(xpath = "//*[@id='debug_pid']")
    WebElement pidNumberPath;

    String pid;
    String childPid;
//    String cpid;
    String dispoParent;
    String dispoChild;
    String pidNumber;


    public MainPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForAnimation() {
        ngDriver.waitForAngularRequestsToFinish();
    }

    @Step
    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
        textToAttachment(this.getClass().getSimpleName() + " class with:");
        textToAttachment(titleExpected, "Title text expected");
        waitForAnimation();
        waitforVisibility(titleText);
        try {
            wait.until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
        } catch (TimeoutException ex) {
            Assert.assertEquals(titleText.getText(), titleExpected, "Failed after timeout wait cause Title is diff");
            throw ex;
        }
//        try {
//            wait.until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
//        }
//        catch (NullPointerException ex){
//            wait.until((ExpectedCondition<Boolean>) w -> titleText.getText().contains(titleExpected));
//        }
        waitForAnimation();
    }

    /**
    Wait for images from third party resources to load both on mobile and desktop
    Use it when you need to wait until all external images are loaded
     */
    @Step
    protected void waitForImagesToLoad() {
        try {
            for (WebElement image : images) {
                wait.until((ExpectedCondition<Boolean>) webDriver -> (Boolean) ((JavascriptExecutor) webDriver).executeScript("return arguments[0].complete", image));
            }
        } catch (TimeoutException e) {
            Assert.fail("Failed to load images");
            throw e;
        }
    }

    @Step
    public <T extends MainPageOLS> T clickNextButton(T page) {
        nextButton.click();
        return (T) page;
    }

    protected void clickOnRadioButton(List<WebElement> radioButtonList, String answerText) {
        radioButtonList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
    }

    protected void clickOnCheckBoxes(List<WebElement> checkBoxList, String... answerText) {
        waitForAnimation();
        List<String> answerTextList = Arrays.asList(answerText);
        try {
            checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
                    .forEach(el -> getActions().moveToElement(el.findElement(By.xpath("ancestor::label/span[contains(@class,'debug-question-helper')]")), 5, 5).click().build().perform());
        }catch(WebDriverException e){
            checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
                    .forEach(el ->  {scrollToElement(el, true).click(); getActions().moveToElement(el.findElement(By.xpath("ancestor::label/span[contains(@class,'debug-question-helper')]")), 5, 5).click().build().perform();});
        }
//            for (WebElement el : checkBoxList) {
//                if (answerTextList.contains(el.getText())) {
////                scrollToElement(el, true);
//                    getActions().moveToElement(el.findElement(By.xpath("ancestor::label")), 5, 5).click().perform();
//                }
//            }
        waitForAnimation();
    }

    @Step
    public <T extends MainPageOLS> T getPage(T page) {
        return (T) page;
    }

    public MainPageOLS assertChildDOBIsNull(String env, String studyId) {
        String childDOBCell = getDbConnection().dbReadChildDOB(env, pid, studyId);
        Assert.assertNull(childDOBCell, "Child DOB is not NULL");
        textToAttachment("Child DOB cell: " + childDOBCell);
        return this;
    }

    @Step
    public MainPageOLS pidFromDbToLog(String env) {
        pid = PassPID.getInstance().getPidNumber();
        getDbConnection().dbReadPID(env, pid);
        dispoParent = getDbConnection().getDispo();
        textToAttachment("Parent dispoBlinx = " + dispoParent + " for PID " + pid);
        return this;
    }

    @Step
    public String getHostName(){
        String hostname = null;

        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            Log.info("Hostname can not be resolved");
        }
        return hostname;
    }

    @Step
    public MainPageOLS assertGeneratedFul(String env, Site site) {
        if (site.hasFul) {
            String fulValueField = getDbConnection().dbReadFulValue(env, pid);
            logTextToAllureAndConsole("Fetched DB value of FUL cell: " + fulValueField);
            Assert.assertNotEquals(fulValueField, "", "FUL VALUE is empty string!");
            Assert.assertNotEquals(fulValueField.toLowerCase(), "null", "FUL VALUE is null string!");
            if (site.withMedicalRecords) {
                Assert.assertTrue(fulValueField.contains(FULType.MEDICAL_RECORD.toString()),
                        String.format("FUL VALUE contains different string. Expected [%s] but found [%s]",
                                FULType.MEDICAL_RECORD.toString(), fulValueField));
            }
        }
        return this;
    }

    @Step
    public MainPageOLS assertGeneratedFulNEW(String env, Site site) {
        if (site.hasFul) {
            String fulValueField = getDbConnection().dbReadFulValue(env, pid);
            logTextToAllureAndConsole("Fetched DB value of FUL cell: " + fulValueField);
            Assert.assertNotEquals(fulValueField, "", "FUL VALUE is empty string!");
            Assert.assertNotEquals(fulValueField.toLowerCase(), "null", "FUL VALUE is null string!");
            if (site.withMedicalRecords) {
                Assert.assertTrue(fulValueField.contains(FULType.MEDICAL_RECORD_NEW.toString()),
                        String.format("FUL VALUE contains different string. Expected [%s] but found [%s]",
                                FULType.MEDICAL_RECORD_NEW.toString(), fulValueField));
            }
        }
        return this;
    }

    @Step
    public MainPageOLS assertGeneratedFulDERM(String env, Site site) {
        if (site.hasFul) {
            String fulValueField = getDbConnection().dbReadFulValue(env, pid);
            logTextToAllureAndConsole("Fetched DB value of FUL cell: " + fulValueField);
            Assert.assertNotEquals(fulValueField, "", "FUL VALUE is empty string!");
            Assert.assertNotEquals(fulValueField.toLowerCase(), "null", "FUL VALUE is null string!");
            if (site.withMedicalRecords) {
                Assert.assertTrue(fulValueField.contains(FULType.DERMCC.toString()),
                        String.format("FUL VALUE contains different string. Expected [%s] but found [%s]",
                                FULType.DERMCC.toString(), fulValueField));
            }
        }
        return this;
    }

    @Step
    public MainPageOLS assertGeneratedFulRAD(String env, Site site) {
        if (site.hasFul) {
            String fulValueField = getDbConnection().dbReadFulValue(env, pid);
            logTextToAllureAndConsole("Fetched DB value of FUL cell: " + fulValueField);
            Assert.assertNotEquals(fulValueField, "", "FUL VALUE is empty string!");
            Assert.assertNotEquals(fulValueField.toLowerCase(), "null", "FUL VALUE is null string!");
            if (site.withMedicalRecords) {
                Assert.assertTrue(fulValueField.contains(FULType.RADIANT.toString()),
                        String.format("FUL VALUE contains different string. Expected [%s] but found [%s]",
                                FULType.RADIANT.toString(), fulValueField));
            }
        }
        return this;
    }


    @Step
    public MainPageOLS assertRmgOrderPriority(String env, String projectCode) {
        String studyId = getDbConnection().getStudyIdByProjectCode(env, projectCode);
        List<String> priorityList = getDbConnection().getRmgOrderPriorityList(env);
        Assert.assertTrue(priorityList.contains(studyId), String.format("The STUDY_RMG_PRIORITY_CONFIG not contains " +
                "expected study id. Expected [%s] but found [%s].", studyId, priorityList));
        return this;
    }

    @Step
    public MainPageOLS copyRun(String env) {
        getDbConnection().dbCOPYProc(env, pid);
        //dispoParent = getDbConnection().getDispo();
        //textToAttachment("Parent dispoBlinx = " + dispoParent + " for PID " + pid);
        return this;
    }

    /**
    Save site name to temp file for further validation

     @param siteName to queue for validation
     */
    @Step
    public synchronized void queueSiteForFULCheck(String siteName) {
        FollowupLetter ful = new FollowupLetter();
        String stringQuery = pid + "," + siteName;
        StringBuilder sb = new StringBuilder();
        String line;

        if(ful.getFulsToBeVerifiedFile().exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(ful.getFulsToBeVerifiedFile()))) {
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                Log.info("Rewriting existing data from file:");
                Log.info(sb);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ful.getFulsToBeVerifiedFile()))) {
            bw.write(sb.toString());
            Log.info("Queued new site for FUL validation to file: " + stringQuery);
            bw.write(stringQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step
    public MainPageOLS childPidFromDbToLog(String env, String... firstPartOfChildPhoneNumber) {
//        cpid = PassPID.getInstance().getPidNumber();
        ChildResult childResult = getDbConnection().dbReadChildPID(env, pid, firstPartOfChildPhoneNumber);
        dispoChild = childResult.getDispoCd() + childResult.getApplicantStatus();
        childPid = childResult.getChildPid();
        textToAttachment("Child dispoBlinx =" + childResult.getDispoCd() + childResult.getApplicantStatus() + " for PID " + pid +
        " with child pid = "+ childResult.getChildPid());
        return this;
    }

    @Step
    public MainPageOLS childPidFromDbToLogWithCopy(String env, String... firstPartOfChildPhoneNumber) {
//        cpid = PassPID.getInstance().getPidNumber();
        copyRun(env);
        ChildResult childResult = getDbConnection().dbReadChildPID(env, pid, firstPartOfChildPhoneNumber);
        dispoChild = childResult.getDispoCd() + childResult.getApplicantStatus();
        childPid = childResult.getChildPid();
        textToAttachment("Child dispoBlinx =" + childResult.getDispoCd() + childResult.getApplicantStatus() + " for PID " + pid +
                " with child pid = "+ childResult.getChildPid());
        return this;
    }

    @Step
    public MainPageOLS convert54Cto1R(String env) {
        getDbConnection().convert54Cto1R(env, pid);
        textToAttachment("54 to 1R conversion completed");
        getDbConnection().dbReadPID(env, pid);
        dispoParent = getDbConnection().getDispo();
        textToAttachment("Dispo = " + dispoParent + " for PID " + pid + "  after conversion");
        return this;
    }

    @Step
    public MainPageOLS getRadiantDbToLog(String env, String ... assertStudyReference) {
        if(env.equals("QA")) {
            RadiantResults radiantResults = getDbConnection().dbReadRadiant(env, pid);
            textToAttachment("Radiant : current status = " + radiantResults.getCurrentStatus() +
                    ", response message = " + radiantResults.getResponseMessage() +
                    ", study reference = " + radiantResults.getStudyReference() +
                    " for PID " + pid);
            Assert.assertEquals(radiantResults.getCurrentStatus(), "SENT", "Current status is not SENT");
            Assert.assertEquals(radiantResults.getResponseMessage(), "Success", "Response message is not Success");
            Assert.assertNotNull(radiantResults.getStudyReference(), "Study reference is NULL");
            List<String> studyReference = Arrays.asList(radiantResults.getStudyReference().split(":"));
            Assert.assertFalse(studyReference.size() < 2, "Study reference response is not full");
            Assert.assertFalse(studyReference.get(0).isEmpty() || studyReference.get(0).contentEquals("null"),
                    "First part is empty or null");
            Assert.assertFalse(studyReference.get(1).isEmpty() || studyReference.get(1).contentEquals("null"),
                    "Second part is empty or null");
            if (assertStudyReference.length == 1) {
                Assert.assertNotNull(radiantResults.getStudyReference(), "Study reference is NULL");
                Assert.assertEquals(radiantResults.getStudyReference(), assertStudyReference[0], "Study reference is not matched!");
            }
        }
        return this;
    }

    @Step
    public MainPageOLS getAnomalyDbToLog(String env) {
        AnomalyResults anomalyResults = getDbConnection().dbReadAnomaly(env, pid);
        textToAttachment("Anomaly : current status = " + anomalyResults.getCurrentStatus() +
                        ", request status id = " + anomalyResults.getRequestStatus() + " for PID " + pid);
        Assert.assertEquals(anomalyResults.getCurrentStatus(), "SENT", "Current status is not SENT");
        Assert.assertEquals(anomalyResults.getRequestStatus(), "2", "Request status is not 2");
        return this;
    }

    @Step
    public MainPageOLS flareCodeShouldMatch(String env, String statusCode) {
        String flareStatus = getDbConnection().dbGetStatusFlare(env, pid);
        textToAttachment("Flare : current status = "+ flareStatus + " for childPID " + pid);
        Assert.assertEquals(flareStatus, statusCode, "Current status for Flare is diff");
        return this;
    }

    @Step
    public MainPageOLS getPID(){
        pidNumber = getText(pidNumberPath);
        textToAttachment("PID = " + pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        Log.info("PID = " + pidNumber);
        return this;
    }

    public String getPid() {
        return pid;
    }

    public String getParentDispo() {
        return dispoParent;
    }

    public String getChildDispo() {
        return dispoChild;
    }

    @Step
    public MainPageOLS dispoShouldMatch(String expectedParentDispo, String ...expectedChildDispo) {
        Assert.assertEquals(getParentDispo(), expectedParentDispo, "Dispo for Parent is different");
        if (expectedChildDispo.length == 1){
            Assert.assertEquals(getChildDispo(), expectedChildDispo[0], "Dispo for Child is different");
        }
        return this;
    }

    @Override
    public String toString() {
        Class aClass = this.getClass();
        return aClass.getSimpleName() + " - " + aClass.getPackage().toString();
    }

    @Step
    public <T extends MainPageOLS> T back(T page) {
        back();
        return (T) page;
    }

//MainPageOLS<Z> and DateOfBirthPageOLS extends MainPageOLS<DateOfBirthPageOLS>
//    public Z assertSome(){
//        return (Z)this;
//    }
}
