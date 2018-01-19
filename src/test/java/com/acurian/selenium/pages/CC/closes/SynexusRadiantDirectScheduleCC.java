package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.shared.ProcedureForWeightLossPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SynexusRadiantDirectScheduleCC extends MainPageCC{

    public final String titleExpected = "The next step is to get you scheduled for an appointment with the study doctor. During this visit, the study doctor will further discuss the study requirements and answer any questions you may have. Let me look at the study doctor’s calendar..\n" +
            "\n" +
            "Agent note: Go to Clinical Conductor and enter the required Acurian information\n";
            

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public SynexusRadiantDirectScheduleCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SynexusRadiantDirectScheduleCC waitForPageLoad() {
    	 waitForAnimation();
         driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
