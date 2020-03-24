package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiagnosedWithCrohnsPageCC extends MainPageCC{

    public final String titleExpected = "Have you ever been officially diagnosed with any of the following digestive conditions?\n" +
    		"Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public DiagnosedWithCrohnsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithCrohnsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithCrohnsPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
