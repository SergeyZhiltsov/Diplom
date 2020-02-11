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

    public final String titleExpected = "Please select your gender:";

    public final String titleExpectedGmega = "Please confirm your gender:";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText1;

    @FindBy(xpath = "//div[contains(@class,'visible-xs-block')]//div[@class='show-in-ols' and contains(text(),'Please select your gender:')]")
    WebElement titleTextNew;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement titleText2;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement titleText3;

    @FindBy(xpath = "//*[@id=\"question_view\"]/div[1]/div/form/div/div[1]/div/question/div/div/div/div/div[1]/div/h4/div[1]/div[2]")
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText4;

    //span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']
    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    @FindBy(xpath = "//input[contains(@class,'text-date-input')]")
    WebElement dateField;

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
            System.out.println("usual xpath working");
            return this;
    }

    @Step
    public GenderPageOLS waitForPageLoadByTitle(String titleExpected) {
        waitForPageLoadMain(titleText4, titleExpected);
        return this;
    }

    @Step
    public GenderPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public GenderPageOLS setDate(String date) {
        typeText(dateField, date);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

