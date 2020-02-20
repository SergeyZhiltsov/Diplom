package com.acurian.selenium.pages.CC.ADG_4357;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverDiagnosedGastroparesisOrStomachEmptyingCC extends MainPageCC {

    public final String titleExpected = "Gastroparesis, or delayed stomach emptying, is a condition where food moves out of the stomach slower than normal or stops and normal digestion may not occur. It can cause symptoms such as nausea, vomiting, bloating, feeling excessively full while eating and after meals, or abdominal pain.\n" +
            "\n" +
            "Has a healthcare professional ever diagnosed you with gastroparesis or delayed stomach emptying?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public EverDiagnosedGastroparesisOrStomachEmptyingCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EverDiagnosedGastroparesisOrStomachEmptyingCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverDiagnosedGastroparesisOrStomachEmptyingCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
