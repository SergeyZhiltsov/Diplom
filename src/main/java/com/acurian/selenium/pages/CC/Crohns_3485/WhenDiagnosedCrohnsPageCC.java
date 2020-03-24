package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenDiagnosedCrohnsPageCC extends MainPageCC{

    public final String titleExpected = "When were you diagnosed with Crohn's disease?";
    
    public final String titleExpectedUlcerative = "When were you diagnosed with ulcerative colitis?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public WhenDiagnosedCrohnsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDiagnosedCrohnsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public WhenDiagnosedCrohnsPageCC waitForPageLoadULC() {
        waitForPageLoadMain(titleText, titleExpectedUlcerative);
        return this;
    }

    @Step
    public WhenDiagnosedCrohnsPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
