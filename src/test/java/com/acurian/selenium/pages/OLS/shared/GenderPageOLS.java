package com.acurian.selenium.pages.OLS.shared;


import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class GenderPageOLS extends MainPageOLS{

    public final String titleExpected = "Please confirm your gender:";

    public final String titleExpectedGmega = "This part of the questionnaire requires that we ask about your gender. To confirm, please tell me, is your gender male or female?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText1;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement titleText2;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement titleText3;

    WebElement titleText;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleTextGmega;

    //span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']
    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public GenderPageOLS() {
        PageFactory.initElements(getDriver(), this);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                titleText = titleText1;
                break;
            case Platforms.TABLET:
                titleText = titleText2;
                break;
            case Platforms.MOBILE:
                titleText = titleText3;
                break;
        }
    }

    @Step
    public GenderPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public GenderPageOLS waitForPageLoadGmega() {
        waitForPageLoadMain(titleTextGmega, titleExpected);
        return this;
    }

    @Step
    public GenderPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}

