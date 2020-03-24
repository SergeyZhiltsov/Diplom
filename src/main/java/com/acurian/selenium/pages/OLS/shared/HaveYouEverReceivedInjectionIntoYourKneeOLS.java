package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverReceivedInjectionIntoYourKneeOLS extends MainPageOLS {

    public final String titleExpected = "Have you ever received an injection into your knee to treat your arthritis pain?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    @Step
    public HaveYouEverReceivedInjectionIntoYourKneeOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverReceivedInjectionIntoYourKneeOLS clickOnAnswer(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
