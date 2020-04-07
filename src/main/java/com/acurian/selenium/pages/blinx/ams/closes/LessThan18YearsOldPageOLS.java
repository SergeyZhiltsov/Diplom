package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import com.acurian.utils.VersionGetter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LessThan18YearsOldPageOLS extends MainPageBlinx {

    public final String titleExpected = "We certainly appreciate your interest in clinical trials. Unfortunately, we cannot ask you any health-related questions because you are under 18 years old. If you are interested in pre-screening for a study, please ask your parent or guardian to call back and provide information on your behalf.";
    public final String titleExpectedCC = "We're sorry that you're not interested in moving forward with the questionnaire. Please contact us again if you'd like to see if there is a study that's right for you.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC_BLINX)
    WebElement titleTextCC;

    public LessThan18YearsOldPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LessThan18YearsOldPageOLS waitForPageLoad() {
        waitForAnimation();
        if(VersionGetter.getVersion().equals("OLS")) {
        waitForPageLoadMain(titleText, titleExpected);
        }else{
            waitForPageLoadMain(titleTextCC, titleExpectedCC);
        }
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
