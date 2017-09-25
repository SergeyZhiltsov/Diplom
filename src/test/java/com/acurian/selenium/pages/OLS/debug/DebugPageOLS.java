package com.acurian.selenium.pages.OLS.debug;



import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

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
}

