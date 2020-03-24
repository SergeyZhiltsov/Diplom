package com.acurian.selenium.pages.CC.IBD;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class MostRecentColonoscopyCC extends MainPageCC{

    public final String titleExpected = "When was your most recent colonoscopy?";
    

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public MostRecentColonoscopyCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MostRecentColonoscopyCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public MostRecentColonoscopyCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
