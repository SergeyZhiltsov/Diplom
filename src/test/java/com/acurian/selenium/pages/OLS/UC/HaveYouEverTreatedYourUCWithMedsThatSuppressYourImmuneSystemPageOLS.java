package com.acurian.selenium.pages.OLS.UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS extends MainPageOLS{

    public final String titleExpected = "Have you ever treated your ulcerative colitis with any of the following medications that suppress your immune system?\n" +
    		"Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public HaveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverTreatedYourUCWithMedsThatSuppressYourImmuneSystemPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
