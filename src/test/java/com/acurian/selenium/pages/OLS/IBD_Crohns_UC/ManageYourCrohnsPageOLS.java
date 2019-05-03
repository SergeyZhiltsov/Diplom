package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class ManageYourCrohnsPageOLS extends MainPageOLS {

	public final String titleExpected = "Have you ever taken any medications to treat or manage your Crohn's or colitis?\n" +
			"Please think about medications that you take now or that you have taken in the past.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public ManageYourCrohnsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ManageYourCrohnsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ManageYourCrohnsPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
