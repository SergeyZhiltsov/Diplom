package com.acurian.selenium.pages.CC.VACC_4556_CC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CalledPrevnarPageCC extends MainPageCC{

    public final String titleExpected = "Have you ever received a pneumococcal vaccine? It is also called Prevnar 13 or Pneumovax 23.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public CalledPrevnarPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CalledPrevnarPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CalledPrevnarPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
