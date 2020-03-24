package com.acurian.selenium.pages.OLS.DPN_3769_4557;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouExperienceDPN_OLS extends MainPageOLS {

    public final String titleExpected = "Do you experience diabetic peripheral neuropathy or diabetic nerve pain?\n" +
            "This condition can cause pain, tingling, or numbness in your feet, legs, hands, or arms.";
    public final String titleExpectedDPN = "Do you experience diabetic peripheral neuropathy (DPN) or diabetic nerve pain?\n" +
            "This condition can cause pain, tingling, or numbness in your feet, legs, hands, or arms.";
    public final String titleExpectedNew = "Do you experience pain, tingling, or numbness in your feet or legs, symptoms caused by diabetic peripheral neuropathy (DPN) or diabetic nerve pain?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    @Step
    public DoYouExperienceDPN_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouExperienceDPN_OLS waitForPageLoadDPN() {
        waitForPageLoadMain(titleText, titleExpectedDPN);
        return this;
    }

    @Step
    public DoYouExperienceDPN_OLS waitForPageLoadNew() {
        waitForPageLoadMain(titleText, titleExpectedNew);
        return this;
    }

    @Step
    public DoYouExperienceDPN_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}