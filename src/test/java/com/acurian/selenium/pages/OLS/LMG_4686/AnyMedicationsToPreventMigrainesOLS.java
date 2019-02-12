package com.acurian.selenium.pages.OLS.LMG_4686;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.shared.ApproxHowLongSufferingFromMIG;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AnyMedicationsToPreventMigrainesOLS extends MainPageOLS {
    public final String titleExpected = "Have you ever tried taking any daily medications to prevent migraines from occurring?\n" +
            "These could include anticonvulsants such as topiramate, beta-blockers such as propranolol, anti-depressants, or any other medication that " +
            "was taken daily specifically for migraine prevention.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public AnyMedicationsToPreventMigrainesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AnyMedicationsToPreventMigrainesOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AnyMedicationsToPreventMigrainesOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
