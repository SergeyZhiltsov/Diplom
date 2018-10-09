package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WithinThePast6MonthsHaveYouHadNumbness_OLS extends MainPageOLS{

    public final String titleExpected = "Within the past 6 months have you had numbness, tingling, or shooting pains in your hands and/or wrists due to your carpal tunnel syndrome?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public WithinThePast6MonthsHaveYouHadNumbness_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WithinThePast6MonthsHaveYouHadNumbness_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WithinThePast6MonthsHaveYouHadNumbness_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
