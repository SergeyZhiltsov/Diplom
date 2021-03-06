package com.acurian.selenium.pages.OLS.DIA_4241;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TakeYourInsulinPageOLS extends MainPageOLS{

    public final String titleExpected = "How do you take your insulin?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    public TakeYourInsulinPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TakeYourInsulinPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TakeYourInsulinPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
