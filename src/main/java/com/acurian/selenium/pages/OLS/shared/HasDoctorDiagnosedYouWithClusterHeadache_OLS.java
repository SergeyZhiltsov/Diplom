package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasDoctorDiagnosedYouWithClusterHeadache_OLS extends MainPageOLS {

    public final String titleExpected = "Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occurs in periods of attacks and remissions. It is different from the more common headache types such as migraine or tension headache.\n" +
            "Has a doctor diagnosed you with cluster headache?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    @Step
    public HasDoctorDiagnosedYouWithClusterHeadache_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasDoctorDiagnosedYouWithClusterHeadache_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
