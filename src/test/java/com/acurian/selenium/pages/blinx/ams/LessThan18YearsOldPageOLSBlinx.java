package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LessThan18YearsOldPageOLSBlinx extends MainPageBlinx {

    public final String titleExpected = "We certainly appreciate your interest in clinical trials. Unfortunately, we cannot ask you any health-related questions because you are under 18 years old. If you are interested in pre-screening for a study, please ask your parent or guardian to call back and provide information on your behalf.";

    @FindBy(xpath = "//div[@id='questions']/div[@class='question-answers-container']//div[@class='show-in-ols']")
    WebElement titleText;

    public LessThan18YearsOldPageOLSBlinx() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LessThan18YearsOldPageOLSBlinx waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
