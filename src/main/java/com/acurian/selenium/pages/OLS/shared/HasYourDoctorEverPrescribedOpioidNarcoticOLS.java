package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HasYourDoctorEverPrescribedOpioidNarcoticOLS extends MainPageOLS{

    public final String titleExpected = "Doctors often prescribe opioid or narcotic medications for pain.\n" +
    		"Has your doctor ever prescribed an opioid or narcotic for your pain?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public HasYourDoctorEverPrescribedOpioidNarcoticOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasYourDoctorEverPrescribedOpioidNarcoticOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasYourDoctorEverPrescribedOpioidNarcoticOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
