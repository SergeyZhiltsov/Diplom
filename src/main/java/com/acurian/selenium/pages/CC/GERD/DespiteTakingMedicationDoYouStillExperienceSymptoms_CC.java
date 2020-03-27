package com.acurian.selenium.pages.CC.GERD;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class DespiteTakingMedicationDoYouStillExperienceSymptoms_CC extends MainPageCC{

    public final String titleExpected = "Despite taking medication, do you still experience symptoms of heartburn, reflux, or GERD?";

    public final String titleExpected2 = "Despite taking medication, about how many days per week do you have symptoms of heartburn, reflux, or GERD?\n" +
            "Please think about the past 2 months.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public DespiteTakingMedicationDoYouStillExperienceSymptoms_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DespiteTakingMedicationDoYouStillExperienceSymptoms_CC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DespiteTakingMedicationDoYouStillExperienceSymptoms_CC waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public DespiteTakingMedicationDoYouStillExperienceSymptoms_CC clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
