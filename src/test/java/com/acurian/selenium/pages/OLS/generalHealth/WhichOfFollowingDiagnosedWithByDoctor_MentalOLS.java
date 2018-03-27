package com.acurian.selenium.pages.OLS.generalHealth;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;


public class WhichOfFollowingDiagnosedWithByDoctor_MentalOLS extends MainPageOLS{

    public final String titleExpected = "You indicated that you have a mental or emotional health condition.\n" +
    		"Which of the following have you been diagnosed with by a doctor?\n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhichOfFollowingDiagnosedWithByDoctor_MentalOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfFollowingDiagnosedWithByDoctor_MentalOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichOfFollowingDiagnosedWithByDoctor_MentalOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
