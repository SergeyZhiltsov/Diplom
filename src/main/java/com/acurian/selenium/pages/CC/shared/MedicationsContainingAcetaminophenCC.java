package com.acurian.selenium.pages.CC.shared;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class MedicationsContainingAcetaminophenCC extends MainPageCC {

    public final String titleExpected = "Have you ever treated your arthritis pain with medications containing acetaminophen, also known as Tylenol?\n" +
            "Other examples of medications that contain acetaminophen include Tylenol #3 or #4, Percocet, and Vicodin.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonList;

    public MedicationsContainingAcetaminophenCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MedicationsContainingAcetaminophenCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public MedicationsContainingAcetaminophenCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
