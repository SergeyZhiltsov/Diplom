package com.acurian.selenium.pages.OLS.generalHealth;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWithOLS;

import ru.yandex.qatools.allure.annotations.Step;


public class WhichOfFollowingDiagnosedWithByDoctorOLS extends MainPageOLS{

    public final String titleExpected = "You indicated that you have a digestive condition.\n" +
    		"Which of the following have you been diagnosed with by a doctor?\n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhichOfFollowingDiagnosedWithByDoctorOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfFollowingDiagnosedWithByDoctorOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichOfFollowingDiagnosedWithByDoctorOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
