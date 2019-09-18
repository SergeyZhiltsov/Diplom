package com.acurian.selenium.pages.OLS.DPN_3769_4557;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WhereDoYouExperienceDiabeticNervePain_OLS extends MainPageOLS{

    public final String titleExpected = "Where do you experience diabetic nerve pain symptoms or sensations?\n" + 
    "Please select all that apply.";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhereDoYouExperienceDiabeticNervePain_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhereDoYouExperienceDiabeticNervePain_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhereDoYouExperienceDiabeticNervePain_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}