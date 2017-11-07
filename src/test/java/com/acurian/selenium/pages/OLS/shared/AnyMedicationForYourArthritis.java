package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class AnyMedicationForYourArthritis extends MainPageOLS{

    public final String titleExpected = "About how many days per week do you take any type of medication for your arthritis pain?\n" +
            "This can include over the counter, prescription, or a combination of both.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS4520_')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> radioButtonsList;

    public AnyMedicationForYourArthritis() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AnyMedicationForYourArthritis waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AnyMedicationForYourArthritis clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
