package com.acurian.selenium.pages.OLS.IBS;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SufferFromIrritablePageOLS extends MainPageOLS{

    public final String titleExpected = "Irritable bowel syndrome (IBS) is a digestive disorder that causes cramping, abdominal pain, gas, bloating, and constipation or diarrhea.\n" +
            "Abdominal pain means any pain in your stomach or abdomen.\n" +
            "\n" +
            "Do you suffer from irritable bowel syndrome or IBS?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public SufferFromIrritablePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SufferFromIrritablePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SufferFromIrritablePageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
