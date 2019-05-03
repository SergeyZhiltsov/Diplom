package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class FollowingMedicationsCrohnsPageOLS extends MainPageOLS{

    public final String titleExpected = "Have you ever taken any of the following medications for your Crohn's or colitis?\n" + 
    		"Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;


    public FollowingMedicationsCrohnsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingMedicationsCrohnsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FollowingMedicationsCrohnsPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
