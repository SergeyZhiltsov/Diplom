package com.acurian.selenium.pages.OLS.gmega;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasAHealthcareDiagnosedWithAnyTypeOfArthOLS extends MainPageOLS{

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following types of arthritis?\n" +
            "Please check all that apply:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText1;


    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_OLS)
    List<WebElement> checkBoxList_SB;

    public HasAHealthcareDiagnosedWithAnyTypeOfArthOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasAHealthcareDiagnosedWithAnyTypeOfArthOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasAHealthcareDiagnosedWithAnyTypeOfArthOLS waitForPageLoadSB() {
        waitForPageLoadMain(titleText1, titleExpected);
        return this;
    }

    @Step
    public HasAHealthcareDiagnosedWithAnyTypeOfArthOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public HasAHealthcareDiagnosedWithAnyTypeOfArthOLS clickOnAnswers_SB(String ...answerText) {
        clickOnCheckBoxes(checkBoxList_SB, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    @Step
    public String getTitleTextSB() {
        return getText(titleText1);
    }
}
