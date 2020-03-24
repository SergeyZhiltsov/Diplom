package com.acurian.selenium.pages.OLS.AS_4319;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class FollowingSymptomsMoreThanOnceWeekOLS extends MainPageOLS{

    public final String titleExpected = "Do you experience any of the following symptoms more than once a week?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public FollowingSymptomsMoreThanOnceWeekOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingSymptomsMoreThanOnceWeekOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FollowingSymptomsMoreThanOnceWeekOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
