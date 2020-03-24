package com.acurian.selenium.pages.blinx.ams.chronic_cough;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CurrentlySufferFromChronicCoughOLS extends MainPageBlinx {

    public final String titleExpected = "A chronic cough is a persistent cough that lasts more than 2 months. It can ruin your sleep and leave you feeling exhausted. Severe cases can cause you to vomit, feel lightheaded and even cause you to fracture your ribs.\n" +
            "Do you currently suffer from chronic cough?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public CurrentlySufferFromChronicCoughOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlySufferFromChronicCoughOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CurrentlySufferFromChronicCoughOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
