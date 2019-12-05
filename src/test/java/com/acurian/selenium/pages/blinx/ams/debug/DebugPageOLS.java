package com.acurian.selenium.pages.blinx.ams.debug;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.selenium.utils.PassPID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DebugPageOLS extends MainPageBlinx {
    public String pidNumber;

    @FindBy(xpath = "//a[@id='question-debug-link']/span")
    WebElement questionLink;
    @FindBy(xpath = "//div[@id='questionHistory']//a[@role='button']/i[@class='fa fa-times-circle']")
    WebElement closeButton;

    @FindBy(xpath = "//a[@id='info-debug-link']/span")
    WebElement infoButton;
    @FindBy(xpath = "//div[@id='studyInfo']//a[@role='button']/i[@class='fa fa-times-circle']")
    WebElement infoCloseButton;

    @FindBy(xpath = "//div[contains(@class,'p-1')][1]//tbody//tr/td[1] | //div[contains(@class,'p-1')][1]//tbody//tr/td/div/div")
    List<WebElement> questionNumberList;

    @FindBy(xpath = "//table[@id='questionHistoryTable']/tbody/tr[1]/td[3]")
    List<WebElement> questionList;

    @FindBy(xpath = "(//*[@id='info-debug-window']/div[contains(.,'Study Status Set:')])[2]")
    WebElement studyStatus;



    @FindBy(xpath = "//*[@id='collapsedContent1']/div[1]")
    WebElement pid;

//    public DebugPageBlinxOLS() {
//        PageFactory.initElements(getDriver(), this);
//                toBeDeletedNumber = questionNumberList;
//                toBeDeleted = questionList;
//    }

    @Step
    public DebugPageOLS getPID(){
        driverWait.waitforVisibility(pid);
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

    private List<String> getProtocolsForQuestionNumber(String questionNumber) {
        openDebugWindow();
        waitForAnimation();
        List<String> temp = questionNumberList.stream()
                .filter(el -> questionNumber.equals(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("//div[contains(@class,'container')]//following-sibling::tr/td/div/div"))
//                .findElements(By.xpath("/html//table[@id='questionHistoryTable']/tbody/tr[1]/td[5]"))
                .stream().map(el -> el.getText()).collect(Collectors.toList());
        closeDebugWindow();
        logTextToAllure("Protocol = " + temp);
        return temp;
    }

    @Step
    public DebugPageOLS checkProtocolsContainsForQNumber(String questionNumber, String... expectedProtocols) {
        List<String> actualProtocols = getProtocolsForQuestionNumber(questionNumber);
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

}
