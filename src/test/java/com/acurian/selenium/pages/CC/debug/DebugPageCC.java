package com.acurian.selenium.pages.CC.debug;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DebugPageCC extends MainPageCC{

    @FindBy(id = "debug_toolbar_questions_lnk")
    WebElement questionLink;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-titlebar')]//span[text()='Question Information']/following-sibling::*[5]")
    WebElement closeButton;

    @FindBy(xpath = "//div[@class='debug_toolbar_content']//tbody//tr/td[@class='question_txt']")
    List<WebElement> questionList;

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


}
