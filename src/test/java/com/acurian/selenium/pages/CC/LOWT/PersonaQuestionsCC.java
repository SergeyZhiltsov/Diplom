package com.acurian.selenium.pages.CC.LOWT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class PersonaQuestionsCC extends MainPageCC {

    public final String titleExpected = "These next few rather personal questions will help us assess your health status. We appreciate your patience.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;


    public PersonaQuestionsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PersonaQuestionsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
