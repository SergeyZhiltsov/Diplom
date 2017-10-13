package com.acurian.selenium.pages.OLS.Diabetes_4356A;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ForYourKidneysPageOLS extends MainPageOLS{

    public final String titleExpected = "Do you take medication for high blood pressure or for your kidneys?\n" +
            "Some of these medications are called diuretics or \"water pills.\"";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public ForYourKidneysPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ForYourKidneysPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ForYourKidneysPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
