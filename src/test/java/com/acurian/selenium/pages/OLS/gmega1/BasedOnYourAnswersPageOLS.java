package com.acurian.selenium.pages.OLS.gmega1;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BasedOnYourAnswersPageOLS extends MainPageOLS{

    public final String titleExpected = "Based on your answers, your child may be a candidate for a study in your area. Would you like to see if they qualify?";
    public final String titleExpected1 = "We're glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you for further evaluation using the phone number you provided. Or you can schedule your appointment now by calling 855-382-9810.";

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    WebElement titleText1;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-sm-block')]")
    WebElement titleText2;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-xs-block')]")
    WebElement titleText3;

    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public BasedOnYourAnswersPageOLS() {
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
    public BasedOnYourAnswersPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);

        return this;
    }

    @Step
    public BasedOnYourAnswersPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
