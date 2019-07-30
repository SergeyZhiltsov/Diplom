package com.acurian.selenium.pages.OLS.COPD_5042;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenWereYouDiagnosedWithCopdOLS extends MainPageOLS {

    public final String titleExpected = "When were you diagnosed with COPD?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    //*[@id="question_view"]/div[1]/div/form/div/div[1]/div[2]/div/question/div/div/div/div/div[1]/div/h4/div[1]
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public WhenWereYouDiagnosedWithCopdOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenWereYouDiagnosedWithCopdOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenWereYouDiagnosedWithCopdOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
