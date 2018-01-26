package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WhenLastTimeYouHadHeartProceduresOLS extends MainPageOLS{

    public final String titleExpected = "When was the last time that you had one of the heart procedures from the last question?";
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> radioButtonsList;

    public WhenLastTimeYouHadHeartProceduresOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenLastTimeYouHadHeartProceduresOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenLastTimeYouHadHeartProceduresOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
