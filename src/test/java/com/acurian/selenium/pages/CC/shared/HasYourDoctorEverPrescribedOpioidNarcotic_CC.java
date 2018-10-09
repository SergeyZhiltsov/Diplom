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

public class HasYourDoctorEverPrescribedOpioidNarcotic_CC extends MainPageCC {

    public final String titleExpected = "Doctors often prescribe opioid or narcotic medications for pain.\n" +
    		"Has your doctor ever prescribed an opioid or narcotic for your pain?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonList;

    public HasYourDoctorEverPrescribedOpioidNarcotic_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasYourDoctorEverPrescribedOpioidNarcotic_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HasYourDoctorEverPrescribedOpioidNarcotic_CC clickOnAnswer(String answerText) {
        radioButtonList.stream().filter(el -> el.getText().contains(answerText))
        .findFirst()
        .get()
        .click();
        waitForAnimation();
      return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
