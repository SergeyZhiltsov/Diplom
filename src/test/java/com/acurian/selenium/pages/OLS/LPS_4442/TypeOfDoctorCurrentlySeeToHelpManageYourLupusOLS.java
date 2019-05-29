package com.acurian.selenium.pages.OLS.LPS_4442;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS extends MainPageOLS{

    public final String titleExpected = "What type of doctor(s) do you currently see to help manage your lupus?\n" +
            "Please select all that apply.";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TypeOfDoctorCurrentlySeeToHelpManageYourLupusOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
