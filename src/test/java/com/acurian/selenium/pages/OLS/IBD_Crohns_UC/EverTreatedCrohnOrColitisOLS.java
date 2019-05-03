package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class EverTreatedCrohnOrColitisOLS extends MainPageOLS{

    public final String titleExpected = "Have you ever treated your Crohn's or colitis with any of the following medications that suppress your immune system?\n" +
    		"Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public EverTreatedCrohnOrColitisOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EverTreatedCrohnOrColitisOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverTreatedCrohnOrColitisOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
