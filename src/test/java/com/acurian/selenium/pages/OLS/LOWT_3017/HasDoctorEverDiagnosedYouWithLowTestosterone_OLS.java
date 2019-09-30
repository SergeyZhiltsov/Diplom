package com.acurian.selenium.pages.OLS.LOWT_3017;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HasDoctorEverDiagnosedYouWithLowTestosterone_OLS extends MainPageOLS {
	public final String titleExpected = "Testosterone is the male sex hormone. Levels may drop as men age.\n" +
			"Has a doctor ever diagnosed you with low testosterone or hypogonadism?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HasDoctorEverDiagnosedYouWithLowTestosterone_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasDoctorEverDiagnosedYouWithLowTestosterone_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasDoctorEverDiagnosedYouWithLowTestosterone_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
