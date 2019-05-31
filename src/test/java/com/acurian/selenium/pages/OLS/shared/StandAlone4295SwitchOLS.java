package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class StandAlone4295SwitchOLS extends MainPageOLS{

    public final String titleExpected = "Thank you for calling Acurian's Alzheimer's risk research line. My name is Online Screening. Are you calling about a research study today?";//"What is your date of birth?";

    @FindBy(xpath = "(//div[contains(@class,'visible-md-block')]//div[@class='show-in-ols'])[2]")
    WebElement titleText;

//    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
//    List<WebElement> radioButtonsList;

    public StandAlone4295SwitchOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StandAlone4295SwitchOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

//    @Step
//    public StandAlone4295SwitchOLS clickOnAnswers(String answerText) {
//        clickOnRadioButton(radioButtonsList, answerText);
//        return this;
//    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
