package com.acurian.selenium.pages.CC.MDD_3159;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class MostRecentHeartProcedurePageСС extends MainPageCC{

    public final String titleExpected = "When was your most recent heart procedure?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public MostRecentHeartProcedurePageСС() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MostRecentHeartProcedurePageСС waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public MostRecentHeartProcedurePageСС clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
