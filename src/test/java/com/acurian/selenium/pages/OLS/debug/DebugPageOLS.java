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

public class DebugPageOLS extends MainPageOLS{

    @FindBy(xpath = "//a[@id='question-debug-link']/span")
    WebElement questionLink;

    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//span[text()='Close']")
    WebElement closeButton;

    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//tbody//tr/td[3]")
    List<WebElement> questionList1;

    @FindBy(xpath = "//debug-popup//tbody//tr/td[3]")
    List<WebElement> questionList2;

    List<WebElement> questionList;

    @FindBy(xpath = "//div[contains(@class,'k-content')]//td[text()='VK2809_201']")
    WebElement protocolVK;

    @FindBy(xpath = "//div[contains(@class,'k-content')]//td[text()='20150230']")
    WebElement protocol201;   
    
    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//tbody//tr/td[1]")
    List<WebElement> questionNumberList1;

    @FindBy(xpath = "//debug-popup//tbody//tr/td[1]")
    List<WebElement> questionNumberList2;

    List<WebElement> questionNumberList;

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

    public DebugPageOLS openDebugWindow(){
        questionLink.click();
        return this;
    }

    public DebugPageOLS closeDebugWindow(){
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
        return this;
    }

    @Step
    public String getProtocolForQuestion(String questionText){
        openDebugWindow();
        waitForAnimation();
        String questionTextMod = questionText.replace("\n", "");
        String temp = questionList.stream()
                .filter(el -> questionTextMod.contains(el.getText().replace("...","")))
                .findFirst()
                .get()
                .findElement(By.xpath("following-sibling::*[2]//tbody"))
                .getText();
        closeDebugWindow();
        logTextToAllure("Protocol="+temp);
        return temp;
    }

    private String getTextFromProtocolColumn(String questionText){
        openDebugWindow();
        waitForAnimation();
        String questionTextMod = questionText.replace("\n", "");
        Assert.assertTrue(questionList.stream().anyMatch(el -> el.getText().equals(questionTextMod)),"Q Text is not found");
        String temp = questionList.stream()
                .filter(el -> questionTextMod.contains(el.getText().replace("...","")))
                .findFirst()
                .get()
                .findElement(By.xpath("following-sibling::td[2]"))
                .getText();
        closeDebugWindow();
        logTextToAllure("Protocol="+temp);
        return temp;
    }

    @Step
    public List<String> getProtocolsForQuestion(String questionText){
        openDebugWindow();
        waitForAnimation();
        String questionTextMod = questionText.replace("\n", "");
        List<String> temp = questionList.stream()
                .filter(el -> questionTextMod.contains(el.getText().replace("...","")))
                .findFirst()
                .get()
                .findElements(By.xpath("following-sibling::*[2]//tbody/tr/td"))
                .stream().map(el -> el.getText()).collect(Collectors.toList());
        closeDebugWindow();
        logTextToAllure("Protocol="+temp);
        return temp;
    }

    @Step
    public DebugPageOLS checkProtocolsEquals(String previousPageTitle, String...expectedProtocols){
        Object[] actualProtocols =  getProtocolsForQuestion(previousPageTitle).toArray();
        Assert.assertEqualsNoOrder(actualProtocols, expectedProtocols, "Protocol expected "
                + Arrays.toString(expectedProtocols)+"not equal in actual "+Arrays.toString(actualProtocols));
        return this;
    }

    @Step
    public String getProtocolVK() {
        return getText(protocolVK);
    }

    @Step
    public String getProtocol201() {
        return getText(protocol201);

    }   
 

    private List<String> getProtocolsForQuestionNumber(String questionNumber){
        openDebugWindow();
        waitForAnimation();
        List<String> temp = questionNumberList.stream()
                .filter(el -> questionNumber.equals(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("following-sibling::*[4]//tbody/tr/td"))
                .stream().map(el -> el.getText()).collect(Collectors.toList());
        closeDebugWindow();
        logTextToAllure("Protocol="+temp);
        return temp;
    }

//use checkProtocolsEqualsForQNumber if same questions in debug window
    @Step
    public DebugPageOLS checkProtocolsEqualsForQNumber(String questionNumber, String...expectedProtocols){
        Object[] actualProtocols =  getProtocolsForQuestionNumber(questionNumber).toArray();
        Assert.assertEqualsNoOrder(actualProtocols, expectedProtocols, "Protocol expected "
                + Arrays.toString(expectedProtocols)+"not equal in actual "+Arrays.toString(actualProtocols));
        return this;
    }

    @Step
    public DebugPageOLS checkProtocolsContainsForQNumber(String questionNumber, String...expectedProtocols){
        List<String> actualProtocols =  getProtocolsForQuestionNumber(questionNumber);
        Assert.assertTrue(actualProtocols.containsAll(Arrays.asList(expectedProtocols)), "Protocol expected "
                + Arrays.toString(expectedProtocols)+" are not included in actual "+actualProtocols.toString());
        return this;
    }

    @Step
    public DebugPageOLS checkIsNoProtocolsForQuestion(String previousPageTitle){
        String actualText = getTextFromProtocolColumn(previousPageTitle);
        Assert.assertTrue("".equals(actualText), "Actual text is "+actualText);
        return this;
    }

    @Step
    public DebugPageOLS clickOnQNumber(String questionNumber){
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

}
