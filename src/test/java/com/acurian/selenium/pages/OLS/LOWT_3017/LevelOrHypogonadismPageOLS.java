package com.acurian.selenium.pages.OLS.LOWT_3017;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class LevelOrHypogonadismPageOLS extends MainPageOLS {

    public final String titleExpected = "The following medications are prescribed for men who have been diagnosed with a low testosterone (male hormone) level or hypogonadism.\n" +
            "Are you currently taking any of the following medications?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public LevelOrHypogonadismPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LevelOrHypogonadismPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public LevelOrHypogonadismPageOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
