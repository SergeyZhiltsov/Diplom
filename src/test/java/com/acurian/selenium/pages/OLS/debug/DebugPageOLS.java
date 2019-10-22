package com.acurian.selenium.pages.OLS.debug;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DebugPageOLS extends MainPageOLS {

    @FindBy(xpath = "//a[@id='question-debug-link']/span")
    WebElement questionLink;
    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//span[text()='Close']")
    WebElement closeButton;

    //info window
    @FindBy(xpath = "//div[contains(@class,'k-widget')][1]//span[text()='Close']")
    WebElement infoCloseButton;
    @FindBy(xpath = "//a[@id = 'info-debug-link'] | //a[@id = 'debug_toolbar_props_lnk']")
    WebElement infoButton;
    @FindBy(xpath = "//div[@class='k-window-content k-content']//div/strong[contains(text(),'Verity Score')]/..")
    WebElement verity4Field;
    @FindBy(xpath = "(//div[@class='k-window-content k-content']//div/strong[contains(text(),'Status Set ID:')])[1]")
    WebElement statusSetID;
    @FindBy(xpath = "(//div[@class='k-window-content k-content']//div/strong[contains(text(),'Status Set Member ID:')])[1]")
    WebElement statusSetMemberID;
    @FindBy(xpath = "(//*[@id='info-debug-window']/div[contains(.,'Study Status Set:')])[2]")
    WebElement studyStatus;

    @FindBy(xpath = "//div[@class='k-window-content k-content']//div/strong[contains(text(),'Design')]/..")
    WebElement themeField;
    @FindBy(xpath = "//div[@class='k-window-content k-content']//div/strong[contains(text(),'Patient LatLong:')]/..")
    WebElement patientLatLongText;
    @FindBy(xpath = "//div[@class='k-window-content k-content']/div/strong[1]")
    WebElement projectInfoNameField;


    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//tbody//tr/td[3]")
    List<WebElement> questionList1;
    @FindBy(xpath = "//debug-popup//tbody//tr/td[3]")
    List<WebElement> questionList2;
    List<WebElement> questionList;

    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//tbody//tr/td[1]")
    List<WebElement> questionNumberList1;
    @FindBy(xpath = "//debug-popup//tbody//tr/td[1]")
    List<WebElement> questionNumberList2;
    List<WebElement> questionNumberList;

    @FindBy(xpath = "(//*[@id='server_props']/following-sibling::div/div)[1] | (//*[@id='info-debug-window']/div[contains(., 'SERVER')])[2]")
    WebElement server;
    String env = System.getProperty("acurian.env", "STG");
    public DebugPageOLS() {
        PageFactory.initElements(getDriver(), this);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                questionNumberList = questionNumberList1;
                questionList = questionList1;
                break;
            case Platforms.TABLET:
                questionNumberList = questionNumberList1;
                questionList = questionList1;
                break;
            case Platforms.MOBILE:
                questionNumberList = questionNumberList2;
                questionList = questionList2;
                break;
        }
    }

    public DebugPageOLS openDebugWindow() {
        questionLink.click();
        return this;
    }

    public DebugPageOLS openInfoWindow() {
        infoButton.click();
        return this;
    }

    public DebugPageOLS closeDebugWindow() {
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                closeButton.click();
                break;
            case Platforms.TABLET:
                closeButton.click();
                break;
            case Platforms.MOBILE:
                openDebugWindow();
                break;
        }
        waitForAnimation();
//        driverWait.getWaitDriver().withTimeout(15, TimeUnit.SECONDS).until(ExpectedConditions
//                .attributeToBe(By.xpath("/html/body/div[3]"), "display", "none"));
        return this;
    }

    public DebugPageOLS closeInfoWindow() {
        infoCloseButton.click();
        return this;
    }

    private String getTextFromInfoRowByElement(WebElement el) {
        openInfoWindow();
        waitForAnimation();
        String text = getText(el);
        closeInfoWindow();
        return text;
    }

    public String getVerityText() {
        return getTextFromInfoRowByElement(verity4Field);
    }

    public String getStatusSetID() {
        return getTextFromInfoRowByElement(statusSetID);
    }

    public String getStatusSetMemberID() {
        return getTextFromInfoRowByElement(statusSetMemberID);
    }

    public String getThemeText() {
        return getTextFromInfoRowByElement(themeField);
    }

    public String getProjectNameText() {
        return getTextFromInfoRowByElement(projectInfoNameField);
    }

    public String getPatientLatLongText() {
        return getTextFromInfoRowByElement(patientLatLongText);
    }

    @Step
    public String getProtocolForQuestion(String questionText) {
        openDebugWindow();
        waitForAnimation();
        String questionTextMod = questionText.replace("\n", "");
        String temp = questionList.stream()
                .filter(el -> questionTextMod.contains(el.getText().replace("...", "")))
                .findFirst()
                .get()
                .findElement(By.xpath("following-sibling::*[2]//tbody"))
                .getText();
        closeDebugWindow();
        logTextToAllure("Protocol=" + temp);
        return temp;
    }

    private String getTextFromProtocolColumn(String questionText) {
        openDebugWindow();
        waitForAnimation();
        String questionTextMod = questionText.replace("\n", "");
        Assert.assertTrue(questionList.stream().anyMatch(el -> el.getText().equals(questionTextMod)), "Q Text is not found");
        String temp = questionList.stream()
                .filter(el -> questionTextMod.contains(el.getText().replace("...", "")))
                .findFirst()
                .get()
                .findElement(By.xpath("following-sibling::td[2]"))
                .getText();
        closeDebugWindow();
        logTextToAllure("Protocol=" + temp);
        return temp;
    }

    @Step
    public List<String> getProtocolsForQuestion(String questionText) {
        openDebugWindow();
        waitForAnimation();
        String questionTextMod = questionText.replace("\n", "");
        List<String> temp = questionList.stream()
                .filter(el -> questionTextMod.contains(el.getText().replace("...", "")))
                .findFirst()
                .get()
                .findElements(By.xpath("following-sibling::*[2]//tbody/tr/td"))
                .stream().map(el -> el.getText()).collect(Collectors.toList());
        closeDebugWindow();
        logTextToAllure("Protocol=" + temp);
        return temp;
    }

    @Step
    public DebugPageOLS checkProtocolsEquals(String previousPageTitle, String... expectedProtocols) {
        Object[] actualProtocols = getProtocolsForQuestion(previousPageTitle).toArray();
        Assert.assertEqualsNoOrder(actualProtocols, expectedProtocols, "Protocol expected "
                + Arrays.toString(expectedProtocols) + "not equal in actual " + Arrays.toString(actualProtocols));
        return this;
    }

    private List<String> getProtocolsForQuestionNumber(String questionNumber) {
        openDebugWindow();
        waitForAnimation();
        List<String> temp = questionNumberList.stream()
                .filter(el -> questionNumber.equals(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("following-sibling::*[4]//tbody/tr/td"))
                .stream().map(el -> el.getText()).collect(Collectors.toList());
        closeDebugWindow();
        logTextToAllure("Protocol = " + temp);
        return temp;
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

    //use checkProtocolsEqualsForQNumber if same questions in debug window
    @Step
    public DebugPageOLS checkProtocolsEqualsForQNumber(String questionNumber, String... expectedProtocols) {
        Object[] actualProtocols = getProtocolsForQuestionNumber(questionNumber).toArray();
        Assert.assertEqualsNoOrder(actualProtocols, expectedProtocols, "Protocol expected "
                + Arrays.toString(expectedProtocols) + "not equal in actual " + Arrays.toString(actualProtocols));
        return this;
    }

    @Step
    public DebugPageOLS checkProtocolsContainsForQNumber(String questionNumber, String... expectedProtocols) {
        List<String> actualProtocols = getProtocolsForQuestionNumber(questionNumber);
        Assert.assertTrue(actualProtocols.containsAll(Arrays.asList(expectedProtocols)), "Protocol expected "
                + Arrays.toString(expectedProtocols) + " are not included in actual " + actualProtocols.toString());
        return this;
    }

    @Step
    public DebugPageOLS checkIsNoProtocolsForQuestion(String previousPageTitle) {
        String actualText = getTextFromProtocolColumn(previousPageTitle);
        Assert.assertTrue("".equals(actualText), "Actual text is " + actualText);
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

    @Step
    public DebugPageOLS assertServerConnectivity(String expectedServer) {
        Assert.assertEquals(getServerName(), expectedServer);
        return this;
    }

    private String getServerName() {
        infoButton.click();
        return server.getText();
    }

}
