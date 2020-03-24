package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class NSAIDMedicationOLS extends MainPageOLS {
	public final String titleExpected = "The following medications are called NSAIDs. They may be available over-the-counter or with a prescription.\n" + 
            "Have you ever taken any of the following medications for your pain?\n" +
			"Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public NSAIDMedicationOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NSAIDMedicationOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public NSAIDMedicationOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
    

}
