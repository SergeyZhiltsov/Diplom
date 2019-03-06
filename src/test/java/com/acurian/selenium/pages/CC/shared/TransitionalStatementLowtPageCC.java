package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class TransitionalStatementLowtPageCC extends MainPageCC {

    //%s = studyName variable
    private final String titleExpected = "Thank you for answering these initial questions.\n" +
            "We would like to ask you a few more questions about your health to better match you with a research study in your area.\n" +
            "You may be asked similar information in this next set of questions. We appreciate your patience.";
    
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    public TransitionalStatementLowtPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TransitionalStatementLowtPageCC waitForPageLoad(String studyName) {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected, studyName);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public TransitionalStatementLowtPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
