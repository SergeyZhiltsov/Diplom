package com.acurian.selenium.pages.OLS.OAB_4867;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DoYouTakeAnyMedicationsControlHypertension_OLS extends MainPageOLS{

    public final String titleExpected = "Do you take any medications to control high blood pressure or hypertension?";
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public DoYouTakeAnyMedicationsControlHypertension_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouTakeAnyMedicationsControlHypertension_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouTakeAnyMedicationsControlHypertension_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
