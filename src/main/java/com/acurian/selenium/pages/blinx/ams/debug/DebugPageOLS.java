package com.acurian.selenium.pages.blinx.ams.debug;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.utils.PassPID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DebugPageOLS extends MainPageBlinx {
    public String pidNumber;

    @FindBy(xpath = "//a[@id='question-debug-link']/span")
    WebElement questionLink;
    @FindBy(xpath = "//div[@id='questionHistory']//a[@role='button']/i[@class='fa fa-times']")
    WebElement closeButton;

    @FindBy(xpath = "//a[@id='info-debug-link']/span")
    WebElement infoButton;
    @FindBy(xpath = "//div[@id='studyInfo']//a[@role='button']/i[@class='fa fa-times-circle']")
    WebElement infoCloseButton;
    @FindBy(xpath = "//div[@id='studyInfo']//a[(contains(@class,'btnClose'))]")
    WebElement infoCloseButton1;
    @FindBy(xpath = "//div[@id='questionHistory']/div[contains(@class, 'ui-icon')]")
    WebElement expandButton;

//    @FindBy(xpath = "//div[contains(@class,'p-1')][1]//tbody//tr/td[1] | //div[contains(@class,'p-1')][1]//tbody//tr/td/div/div")
//    List<WebElement> questionNumberList;

    @FindBy(xpath = "//table[@class='table'][1]//tbody/tr/td[1] | //table[@class='table'][1]//tbody/tr/td/div/div")
    List<WebElement> questionNumberList;

    @FindBy(xpath = "//table[@id='questionHistoryTable']/tbody/tr[1]/td[3]")
    List<WebElement> questionList;

    @FindBy(xpath = "(//*[@id='info-debug-window']/div[contains(.,'Study Status Set:')])[2]")
    WebElement studyStatus;

    @FindBy(xpath = "//*[@id='collapsedContent1']/div[1]")
    WebElement pid;

    @FindBy(xpath = "//div[@id='studyInfoContent']//strong[contains(text(),'Patient LatLong:')]/..")
    WebElement patientLatLongText;

    @FindBy(xpath = "//div[@id='studyInfoContent']//strong[contains(text(),'Design(not used):')]/..")
    WebElement themeField;
    @FindBy(xpath = "//div[@id='studyInfoContent']//strong[contains(text(),'Verity Score')]/..")
    WebElement verity4Field;
    @FindBy(xpath = "//div[@id='studyInfoContent']/strong[1]")
    WebElement projectInfoNameField;

//    public DebugPageBlinxOLS() {
//        PageFactory.initElements(getDriver(), this);
//                toBeDeletedNumber = questionNumberList;
//                toBeDeleted = questionList;
//    }

    @Step
    public DebugPageOLS getPID(){
        waitforVisibility(pid);
        pidNumber = pid.getText().replace("pid: ", "");
        logTextToAllureAndConsole("PID from page = " + pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        return this;
    }

    public String getPidNumber() {
        return pidNumber;
    }

    public DebugPageOLS openDebugWindow() {
        questionLink.click();
        return this;
    }

    public DebugPageOLS closeDebugWindow() {
        closeButton.click();
        waitForAnimation();
        return this;
    }

    public DebugPageOLS openInfoWindow() {
        infoButton.click();
        return this;
    }

    public DebugPageOLS closeInfoWindow() {
        infoCloseButton.click();
        return this;
    }

    public DebugPageOLS closeInfoWindow1() {
        infoCloseButton1.click();
        return this;
    }

    private List<String> getSlowlyLoadedNumbers(String questionNumber) {
        By locatorForDQNumbers = By.xpath(Locators.DEBUG_DQ_NUMBERS);
        String xpathForDesiredSection = Locators.DEBUG_QUESTION;
        WebElement parentOfQuestion;
        List<WebElement> dqNumberElements;
        List<String> dqNumbers = new ArrayList<String>() {
            {
                add("");
            }
        };
        for (int i = 0; i < 20; i++) {
            parentOfQuestion = getDriver().findElement(By.xpath(String.format(xpathForDesiredSection, questionNumber)));
            dqNumberElements = parentOfQuestion.findElements(locatorForDQNumbers);
            dqNumbers = dqNumberElements.stream().map(WebElement::getText).collect(Collectors.toList());
            if (dqNumbers.contains("")) {
                logTextToAllureAndConsole("dq numbers loaded slowly. Attempt #" + (i + 1));
                threadSleep(1);
            } else {
                break;
            }
        }
        if (dqNumbers.contains("")) {
            logTextToAllureAndConsole("Dq numbers not found  after 20 attempts");
            dqNumbers = null;
        }
        return dqNumbers;
    }

    private List<String> getProtocolsForQuestionNumber(String questionNumber, String... expectedProtocols) {
        By locatorForDQNumbers = By.xpath(Locators.DEBUG_DQ_NUMBERS);
        String xpathForDesiredSection = Locators.DEBUG_QUESTION;
        openDebugWindow();
        waitForAnimation();
        //WebElement parentOfQuestion = getDriver().findElement(By.xpath("//table[@id='questionHistoryTable']//a[text()='"+questionNumber+"']/ancestor::tr"));
        WebElement parentOfQuestion = getDriver().findElement(By.xpath(String.format(xpathForDesiredSection, questionNumber)));
        List<WebElement> dqNumberElements = parentOfQuestion.findElements(locatorForDQNumbers);
        List<String> dqNumbers = dqNumberElements.stream().map(WebElement::getText).collect(Collectors.toList());

        for (String expectedProtocol : expectedProtocols) {
            if (!dqNumbers.contains(expectedProtocol)) {
                try {
                    dragAndDropButton(expandButton, 70, 150);
                } catch (Exception e) {
                    scrollToElement(getDriver().findElement(By.xpath("//div[@class='protoContainer ']")), false);
                }

                dqNumbers = dqNumberElements.stream().map(WebElement::getText).collect(Collectors.toList());
            }
        }
        closeDebugWindow();
        textToAttachment("Protocols = " + dqNumbers);
        return dqNumbers;

        /*List<String> temp = dqNumberElements.stream()
                .filter(el -> questionNumber.equals(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("//div[contains(@class,'container')]//following-sibling::tr/td/div/div"))
//                .findElements(By.xpath("/html//table[@id='questionHistoryTable']/tbody/tr[1]/td[5]"))
                .stream().map(el -> el.getText()).collect(Collectors.toList());

        return temp;*/
    }

    @Step
    public DebugPageOLS checkProtocolsContainsForQNumber(String questionNumber, String... expectedProtocols) {
        threadSleep(1);
        List<String> actualProtocols = getProtocolsForQuestionNumber(questionNumber, expectedProtocols);
        Assert.assertTrue(actualProtocols.containsAll(Arrays.asList(expectedProtocols)), "Protocol expected "
                + Arrays.toString(expectedProtocols) + " are not included in actual " + actualProtocols.toString());
        return this;
    }

    @Step
    public DebugPageOLS clickOnQNumber(String questionNumber) {
        openDebugWindow();
        waitForAnimation();
        questionNumberList.stream()
                .filter(el -> questionNumber.equals(el.getText()))
                .findFirst()
                .get()
                .findElement(By.xpath(".//a"))
                .click();
        closeDebugWindow();
        return this;
    }

    public DebugPageOLS checkStudyStatusContainsForQNumber(String expectedStudyStatus) {
        String actualStudyStatus = getStudyStatus();
        logTextToAllureAndConsole("Status Set displayed = " + actualStudyStatus);
        Assert.assertEquals(actualStudyStatus, expectedStudyStatus, "Study status is different!");
        return this;
    }

    private String getStudyStatus() {
        openInfoWindow();
        String[] statusSetParts = studyStatus.getText().split("\n");
        closeInfoWindow();
        return statusSetParts[1].replaceAll("[^0-9]", "") + "-"
                + statusSetParts[2].replaceAll("[^0-9]", "");
    }
    public String getPatientLatLongText() {
        return getTextFromInfoRowByElement(patientLatLongText);
    }

    public String getThemeText() {return getTextFromInfoRowByElement(themeField); }

    public String getVerityText() { return getTextFromInfoRowByElement(verity4Field);
    }
    private String getTextFromInfoRowByElement(WebElement el) {
        openInfoWindow();
        waitForAnimation();
        String text = getText(el);
        closeInfoWindow1();
        return text;
    }

    public String getProjectNameText() {
        return getTextFromInfoRowByElement(projectInfoNameField);
    }

}
