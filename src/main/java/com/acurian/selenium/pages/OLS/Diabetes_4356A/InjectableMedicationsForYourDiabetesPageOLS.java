package com.acurian.selenium.pages.OLS.Diabetes_4356A;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InjectableMedicationsForYourDiabetesPageOLS extends MainPageOLS{

    public final String titleExpected = "Do you currently take any of the following injectable medications for your diabetes?\n" +
            "These are medications that are injected using a shot, needle, or pen.\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public InjectableMedicationsForYourDiabetesPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InjectableMedicationsForYourDiabetesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public InjectableMedicationsForYourDiabetesPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
