package com.acurian.selenium.pages.blinx.ams.uc;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DidYouHaveBloodInYourStoolPageOLS extends MainPageBlinx {

    public final String titleExpected = "Thinking about your ulcerative colitis symptoms…\n"+
            "Over the previous day, did you have blood in your stool?";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public DidYouHaveBloodInYourStoolPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DidYouHaveBloodInYourStoolPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DidYouHaveBloodInYourStoolPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
