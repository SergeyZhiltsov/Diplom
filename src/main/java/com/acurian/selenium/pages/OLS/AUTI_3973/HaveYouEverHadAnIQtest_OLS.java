package com.acurian.selenium.pages.OLS.AUTI_3973;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverHadAnIQtest_OLS extends MainPageOLS{

    public final String titleExpected = "Have you ever had an IQ test? It is also called an intelligence test.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public HaveYouEverHadAnIQtest_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverHadAnIQtest_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverHadAnIQtest_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
