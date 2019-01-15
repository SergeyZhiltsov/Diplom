package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS extends MainPageOLS {

    public final String titleExpected = "Which parts of your body are currently affected by eczema (atopic dermatitis)?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
