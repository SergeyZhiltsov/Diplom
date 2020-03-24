package com.acurian.selenium.pages.OLS.cv_study;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TransitionStatementCVbeginPageOLS extends MainPageOLS{

    public final String titleExpected = "We would like to ask you a few more questions about your health to better match you with a research study in your area.\n" +
            "You may be asked similar information in this next set of questions. We appreciate your patience.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    public TransitionStatementCVbeginPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TransitionStatementCVbeginPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
