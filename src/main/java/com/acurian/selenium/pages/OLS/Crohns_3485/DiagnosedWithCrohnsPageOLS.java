package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiagnosedWithCrohnsPageOLS extends MainPageOLS{

    public final String titleExpected = "Have you ever been officially diagnosed with Crohn's disease by a doctor at a hospital or doctor's office?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public DiagnosedWithCrohnsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithCrohnsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithCrohnsPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
