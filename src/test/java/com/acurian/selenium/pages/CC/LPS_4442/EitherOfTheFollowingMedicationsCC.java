package com.acurian.selenium.pages.CC.LPS_4442;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class EitherOfTheFollowingMedicationsCC extends MainPageCC{

    public final String titleExpected = "Have you ever taken of the following medications?\n" +            
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public EitherOfTheFollowingMedicationsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EitherOfTheFollowingMedicationsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EitherOfTheFollowingMedicationsCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
