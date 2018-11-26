package com.acurian.selenium.pages.OLS.LOWT_3017;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenWasTheLastTimeThatYouReceivedHeartProc_OLS extends MainPageOLS{

    public final String titleExpected = "When was your most recent heart procedure?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public WhenWasTheLastTimeThatYouReceivedHeartProc_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenWasTheLastTimeThatYouReceivedHeartProc_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenWasTheLastTimeThatYouReceivedHeartProc_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
