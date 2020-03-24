package com.acurian.selenium.pages.CC.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class LessThan18YearsOldPageCC extends MainPageCC{
    
    public final String titleExpected = "We certainly appreciate your interest in clinical trials. Unfortunately, we cannot ask you any health-related questions because you are under 18 years old. If you are interested in pre-screening for a study, please ask your parent or guardian to call back and provide information on your behalf. Goodbye.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public LessThan18YearsOldPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LessThan18YearsOldPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
