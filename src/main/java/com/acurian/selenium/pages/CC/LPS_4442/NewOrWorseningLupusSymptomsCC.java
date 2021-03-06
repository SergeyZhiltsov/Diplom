package com.acurian.selenium.pages.CC.LPS_4442;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class NewOrWorseningLupusSymptomsCC extends MainPageCC {

    public final String titleExpected = "Are you experiencing new or worsening lupus symptoms?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> checkBoxList;

    public NewOrWorseningLupusSymptomsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NewOrWorseningLupusSymptomsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public NewOrWorseningLupusSymptomsCC clickOnAnswer(String answerText) {
        clickOnRadioButton(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
