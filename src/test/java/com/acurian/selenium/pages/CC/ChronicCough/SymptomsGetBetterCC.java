package com.acurian.selenium.pages.CC.ChronicCough;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class SymptomsGetBetterCC extends MainPageCC{

    public final String titleExpected = "Do any of these symptoms get better when you take medication?\n" +
    		"Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkbox_container']//span")
    List<WebElement> checkBoxList;

    public SymptomsGetBetterCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SymptomsGetBetterCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SymptomsGetBetterCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
