package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OverallHowWellDidTopicalMedicationYouTried_OLS extends MainPageOLS{

    public final String titleExpected = "Overall, how well did the topical medication(s) you tried, either over-the-counter or prescription, work to treat your eczema (atopic dermatitis)?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public OverallHowWellDidTopicalMedicationYouTried_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OverallHowWellDidTopicalMedicationYouTried_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OverallHowWellDidTopicalMedicationYouTried_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
