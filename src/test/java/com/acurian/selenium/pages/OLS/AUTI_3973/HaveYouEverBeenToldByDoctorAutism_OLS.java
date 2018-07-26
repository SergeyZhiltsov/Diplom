package com.acurian.selenium.pages.OLS.AUTI_3973;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverBeenToldByDoctorAutism_OLS extends MainPageOLS{

    public final String titleExpected = "Have you ever been told by a doctor that you have autism or an autism spectrum disorder?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public HaveYouEverBeenToldByDoctorAutism_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverBeenToldByDoctorAutism_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverBeenToldByDoctorAutism_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
