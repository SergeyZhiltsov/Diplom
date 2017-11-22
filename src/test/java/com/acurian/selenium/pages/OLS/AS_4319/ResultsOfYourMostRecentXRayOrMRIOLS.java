package com.acurian.selenium.pages.OLS.AS_4319;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class ResultsOfYourMostRecentXRayOrMRIOLS extends MainPageOLS{

    public final String titleExpected = "What did your doctor tell you about the results of your most recent x-ray or MRI?";
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public ResultsOfYourMostRecentXRayOrMRIOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ResultsOfYourMostRecentXRayOrMRIOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ResultsOfYourMostRecentXRayOrMRIOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
