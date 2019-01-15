package com.acurian.selenium.pages.OLS.Derm;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class WeWantToMakeSureTheImagesDisplayProperly_OLS extends MainPageOLS {

    public final String titleExpected = "Next, we are going to show you images to help us understand the area(s) of your body currently affected by eczema (atopic dermatitis).\n" +
            "We want to make sure the images display properly on your screen.  What device are you using to answer this screener?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public WeWantToMakeSureTheImagesDisplayProperly_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WeWantToMakeSureTheImagesDisplayProperly_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WeWantToMakeSureTheImagesDisplayProperly_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
