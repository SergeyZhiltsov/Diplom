package com.acurian.selenium.pages.CC.Derm_4631;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class OverallHowWellDidTopicalMedicationYouTried_CC extends MainPageCC{

    public final String titleExpected = "Overall, how well did the topical medication(s) you tried, either over-the-counter or prescription, work to treat your eczema (atopic dermatitis)?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public OverallHowWellDidTopicalMedicationYouTried_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OverallHowWellDidTopicalMedicationYouTried_CC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public OverallHowWellDidTopicalMedicationYouTried_CC clickOnAnswer(String answerText) {
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
