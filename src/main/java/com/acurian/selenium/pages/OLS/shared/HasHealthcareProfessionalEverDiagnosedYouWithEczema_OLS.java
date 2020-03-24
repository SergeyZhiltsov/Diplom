package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS extends MainPageOLS{

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with eczema, also called atopic dermatitis?\n" +
            "Eczema (also called atopic dermatitis) occurs when your skin overreacts to certain environmental triggers or allergens, causing very itchy bumps or rash. It typically occurs in people with a personal or family history of asthma or allergies.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
