package com.acurian.selenium.pages.CC.ChronicCough;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class TreatingYourChronicCoughCC extends MainPageCC{

    public final String titleExpected = "Have you tried treating your chronic cough with prescription or over the counter medication?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkbox_container']//span")
    List<WebElement> checkBoxList;

    public TreatingYourChronicCoughCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TreatingYourChronicCoughCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TreatingYourChronicCoughCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
