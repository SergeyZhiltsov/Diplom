package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BasedOnInformationGmegaPageCC extends MainPageCC {

    public final String titleExpected = "Based on the information you have provided, you have prequalified for this study. " +
            "Unfortunately, study sites in your area are not accepting patients at this time. " +
            "We will contact you as soon as a study site near you accepts new patients or if another study opens in your area.";

    public final String titleExpectedQA = "Based on the information you have provided, you have prequalified for this study. " +
            "Unfortunately, study sites in your area are not accepting patients at this time. " +
            "We will contact you as soon as a study site near you accepts new patients.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public BasedOnInformationGmegaPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public BasedOnInformationGmegaPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
