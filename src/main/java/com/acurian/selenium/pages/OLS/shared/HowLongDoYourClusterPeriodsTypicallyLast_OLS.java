package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowLongDoYourClusterPeriodsTypicallyLast_OLS extends MainPageOLS {

    public final String titleExpected = "A cluster headache cycle, cluster period, or bout is a period of time in which you experience cluster headaches daily or frequently. Many people with cluster headaches have one or two cluster periods each year.\n" +
            "How long do your cluster periods typically last?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    @Step
    public HowLongDoYourClusterPeriodsTypicallyLast_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowLongDoYourClusterPeriodsTypicallyLast_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
