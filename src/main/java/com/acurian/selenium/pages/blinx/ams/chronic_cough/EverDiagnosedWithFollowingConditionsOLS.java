package com.acurian.selenium.pages.blinx.ams.chronic_cough;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverDiagnosedWithFollowingConditionsOLS extends MainPageBlinx {

    public final String titleExpected ="Have you ever been diagnosed with any of the following conditions?";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public EverDiagnosedWithFollowingConditionsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EverDiagnosedWithFollowingConditionsOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }


    @Step
    public EverDiagnosedWithFollowingConditionsOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }


}
