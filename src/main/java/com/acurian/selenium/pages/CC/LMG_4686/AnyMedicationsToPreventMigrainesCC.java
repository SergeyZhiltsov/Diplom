package com.acurian.selenium.pages.CC.LMG_4686;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AnyMedicationsToPreventMigrainesCC extends MainPageCC {
    public final String titleExpected = "Have you ever tried taking any daily prescription medications to prevent migraines from occurring?\n" +
            "These could include anticonvulsants such as topiramate, beta-blockers such as propranolol, anti-depressants, or any other prescription medication that was taken daily specifically for migraine prevention.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public AnyMedicationsToPreventMigrainesCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AnyMedicationsToPreventMigrainesCC waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AnyMedicationsToPreventMigrainesCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
