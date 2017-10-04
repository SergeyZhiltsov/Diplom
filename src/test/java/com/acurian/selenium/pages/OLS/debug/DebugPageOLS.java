package com.acurian.selenium.pages.OLS.debug;

import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    List<WebElement> questionList;

    public DebugPageOLS() {
    }

    public DebugPageOLS openDebugWindow(){
        questionLink.click();
        return this;
    }

    public DebugPageOLS closeDebugWindow(){
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
                .findElement(By.xpath("following-sibling::*[2]//tbody"))
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

    public DebugPageOLS checkProtocolsEquals(String previousPageTitle, String...expectedProtocols){
        Object[] actualProtocols =  getProtocolsForQuestion(previousPageTitle).toArray();
        Assert.assertEqualsNoOrder(actualProtocols, expectedProtocols, "Protocol expected "
                + Arrays.toString(expectedProtocols)+"not equal in actual "+Arrays.toString(actualProtocols));
        return this;
    }

}
