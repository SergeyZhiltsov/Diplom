package com.acurian.selenium.pages.blinx.ams.dia;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TakeYourInsulinPageOLS extends MainPageBlinx {

    public final String titleExpected = "How do you take your insulin?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public TakeYourInsulinPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TakeYourInsulinPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TakeYourInsulinPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
