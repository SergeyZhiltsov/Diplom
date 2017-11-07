package com.acurian.selenium.pages.OLS.OA_3138;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class ParticipatedInAnotherClinicalResearch extends MainPageOLS{

    public final String titleExpected = "Have you participated in another clinical research study in the past month?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS1326_')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> radioButtonsList;

    public ParticipatedInAnotherClinicalResearch() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ParticipatedInAnotherClinicalResearch waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ParticipatedInAnotherClinicalResearch clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
