package com.acurian.selenium.pages.OLS.LOWT_3017;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverSmokedCigarettesPageOLS extends MainPageOLS {

    public final String titleExpected = "Have you ever smoked cigarettes?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public EverSmokedCigarettesPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EverSmokedCigarettesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverSmokedCigarettesPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
