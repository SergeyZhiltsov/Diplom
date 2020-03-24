package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS extends MainPageOLS {

    public final String titleExpected = "Have you ever been diagnosed with any of the following additional heart-related medical conditions?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    @Step
    public HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }


}
