package com.acurian.selenium.pages.OLS.AUTI_3973;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouHadSeizureInLast6Mon_OLS extends MainPageOLS{

    public final String titleExpected = "Have you had a seizure in the last 6 months?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public HaveYouHadSeizureInLast6Mon_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouHadSeizureInLast6Mon_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouHadSeizureInLast6Mon_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
