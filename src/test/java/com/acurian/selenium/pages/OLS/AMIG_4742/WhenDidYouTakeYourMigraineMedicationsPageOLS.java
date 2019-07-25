package com.acurian.selenium.pages.OLS.AMIG_4742;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenDidYouTakeYourMigraineMedicationsPageOLS extends MainPageOLS {
    public final String titleExpected = "When did you take your migraine medication(s)?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhenDidYouTakeYourMigraineMedicationsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public com.acurian.selenium.pages.OLS.AMIG_4742.WhenDidYouTakeYourMigraineMedicationsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public com.acurian.selenium.pages.OLS.AMIG_4742.WhenDidYouTakeYourMigraineMedicationsPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
