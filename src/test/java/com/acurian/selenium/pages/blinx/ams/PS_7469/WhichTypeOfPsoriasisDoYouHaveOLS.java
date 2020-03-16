package com.acurian.selenium.pages.blinx.ams.PS_7469;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichTypeOfPsoriasisDoYouHaveOLS extends MainPageBlinx {

    public final String titleExpected = "There are a few types of psoriasis. Which type(s) of psoriasis do you have?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public WhichTypeOfPsoriasisDoYouHaveOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichTypeOfPsoriasisDoYouHaveOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichTypeOfPsoriasisDoYouHaveOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
