package com.acurian.selenium.pages.CC.RA_2821;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowOldWereUWhenDiagnosedWithRACC extends MainPageCC{

    public final String titleExpected = "Approximately how old were you when you were diagnosed with RA?\n" +
    		"Agent Note: If patient is unsure, say \"Please take your best guess.\"";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    //@FindBy(xpath = "//div[@class='radio_btns_container']//label")
    //List<WebElement> radioButtonsList;

    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement ageMig;
    
    public HowOldWereUWhenDiagnosedWithRACC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowOldWereUWhenDiagnosedWithRACC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowOldWereUWhenDiagnosedWithRACC typeAge(String text) {
        //typeTextWithoutClear(ageMig, text);
        typeText(ageMig, text);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
