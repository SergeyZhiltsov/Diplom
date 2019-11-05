package com.acurian.selenium.pages.OLS.UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverTakenAnyMedicationsToTreatYourUCPageOLS extends MainPageOLS {

	public final String titleExpected = "Have you ever taken any medications to treat or manage your ulcerative colitis?\n" +
			"Please think about medications that you take now or that you have taken in the past.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HaveYouEverTakenAnyMedicationsToTreatYourUCPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverTakenAnyMedicationsToTreatYourUCPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverTakenAnyMedicationsToTreatYourUCPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
