package com.acurian.selenium.pages.OLS.RA_2821;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class UnfortunatelyThisStudyPageOLS extends MainPageOLS {

    public final String titleExpected = "Unfortunately, this study doesn’t appear to be an exact match for you. Let's see if you qualify for another study.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    public UnfortunatelyThisStudyPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public UnfortunatelyThisStudyPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
