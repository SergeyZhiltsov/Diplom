package com.acurian.selenium.pages.CC.debug;

import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DebugPageCC extends MainPageCC{

    @FindBy(id = "debug_toolbar_questions_lnk")
    WebElement questionLink;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-titlebar')]//span[text()='Question Information']/following-sibling::*[5]")
    WebElement closeButton;

    @FindBy(xpath = "//div[@class='debug_toolbar_content']//tbody//tr/td[@class='question_txt']")
    List<WebElement> questionList;
    
    @FindBy(xpath = "//div[@class='debug_toolbar_content']//tbody//tr/td[@class='question_dq question_pdq_true']")
    WebElement protocolList;

    @FindBy(xpath = "//div[@class='debug_toolbar_content']//tbody//tr/td[@class='question_code']")
    List<WebElement> questionNumberList;

    public DebugPageCC() {
        PageFactory.initElements(getDriver(), this);
    }
    
    public DebugPageCC openDebugWindow(){
        questionLink.click();
        return this;
    }

    public DebugPageCC closeDebugWindow(){
        closeButton.click();
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
                .findElement(By.xpath("following-sibling::*[3]"))
                .getText();
        closeDebugWindow();
        logTextToAllure("Protocol="+temp);
        return temp;
    }
    
    @Step
    public String getProtocol() {
    	return getText(protocolList);
    } 

    private String[] getProtocolsForQuestion(String questionText){
        openDebugWindow();
        waitForAnimation();
        String questionTextMod = questionText.replace("\n", "");
        String temp = questionList.stream()
                .filter(el -> questionTextMod.contains(el.getText().replace("...","")))
                .findFirst()
                .get()
                .findElement(By.xpath("following-sibling::*[3]"))
                .getText();
        String[] tempArr = temp.split("\n");
        closeDebugWindow();
        logTextToAllure("Protocol(s)="+tempArr);
        return tempArr;
    }

    @Step
    public DebugPageCC checkProtocolsEquals(String previousPageTitle, String...expectedProtocols){
        Object[] actualProtocols =  getProtocolsForQuestion(previousPageTitle);
        Assert.assertEqualsNoOrder(actualProtocols, expectedProtocols, "Protocol expected "
                + Arrays.toString(expectedProtocols)+"not equal in actual "+Arrays.toString(actualProtocols));
        return this;
    }

    private String[] getProtocolsForQuestionNumber(String questionNumber){
        openDebugWindow();
        waitForAnimation();
        String temp = questionNumberList.stream()
                .filter(el -> questionNumber.equals(el.getText()))
                .findFirst()
                .get()
                .findElement(By.xpath("following-sibling::*[5]"))
                .getText();
        String[] tempArr = temp.split("\n");
        closeDebugWindow();
        logTextToAllure("Protocol(s)="+tempArr);
        return tempArr;
    }

    //use checkProtocolsEqualsForQNumber if same questions in debug window
    @Step
    public DebugPageCC checkProtocolsEqualsForQNumber(String questionNumber, String...expectedProtocols){
        Object[] actualProtocols =  getProtocolsForQuestionNumber(questionNumber);
        Assert.assertEqualsNoOrder(actualProtocols, expectedProtocols, "Protocol expected "
                + Arrays.toString(expectedProtocols)+"not equal in actual "+Arrays.toString(actualProtocols));
        return this;
    }

    @Step
    public DebugPageCC checkProtocolsContainsForQNumber(String questionNumber, String...expectedProtocols){
        List<String> actualProtocols =  Arrays.asList(getProtocolsForQuestionNumber(questionNumber));
        Assert.assertTrue(actualProtocols.containsAll(Arrays.asList(expectedProtocols)), "Protocol expected "
                + Arrays.toString(expectedProtocols)+" are not included in actual "+actualProtocols.toString());
        return this;
    }

    @Step
    public DebugPageCC checkIsNoProtocolsForQuestion(String previousPageTitle){
        Object[] actualProtocols = getProtocolsForQuestion(previousPageTitle);
        Object[] expected = {"false"};
        Assert.assertEqualsNoOrder(actualProtocols, expected, "Protocols are present ");
        return this;
    }

}
