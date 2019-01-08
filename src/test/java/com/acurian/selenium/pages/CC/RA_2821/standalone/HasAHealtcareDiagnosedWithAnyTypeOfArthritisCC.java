package com.acurian.selenium.pages.CC.RA_2821.standalone;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC extends MainPageCC {
    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following types of arthritis?\n" +
            "Please check all that apply:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_CC)
    List<WebElement> checkBoxList;

    public HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasAHealtcareDiagnosedWithAnyTypeOfArthritisCC clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
