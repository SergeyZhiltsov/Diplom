package com.acurian.selenium.pages.OLS.COPD_5042;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenDidYouHaveYourMostRecentLungSurgeryOLS extends MainPageOLS {

    public final String titleExpected = "When did you have your most recent lung surgery?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public WhenDidYouHaveYourMostRecentLungSurgeryOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDidYouHaveYourMostRecentLungSurgeryOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenDidYouHaveYourMostRecentLungSurgeryOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
