package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class SynexusDirectScheduleWTC3PageCC extends MainPageCC{

    //4356 Synexus Direct Schedule Warm Transfer Close 3
    public final String titleExpected = "Agent note: bring all 3 parties on the line.";

    //need rewrite this because this page has variables for  child pid and protocols
    @FindBy(xpath = "//div[@class='question_text']/span")
    WebElement titleText;

    public SynexusDirectScheduleWTC3PageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SynexusDirectScheduleWTC3PageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
