package com.acurian.selenium.pages.OLS.GERD;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS extends MainPageOLS {

    public final String titleExpected = "Despite taking medication, do you still experience symptoms of heartburn, reflux, or GERD?";

    public final String titleExpected2 = "Despite taking medication, about how many days per week do you have symptoms of heartburn, reflux, or GERD?\n" +
            "Please think about the past 2 months.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    @Step
    public DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}