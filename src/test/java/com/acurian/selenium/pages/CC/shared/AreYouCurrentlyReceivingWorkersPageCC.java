package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouCurrentlyReceivingWorkersPageCC extends MainPageCC {

    public final String titleExpected = "Are you currently receiving worker's compensation, or involved in litigation or a lawsuit related to your pain?";
    public final String titleExpected2 = "Are you currently receiving worker's compensation, disability payments, or involved in litigation or a lawsuit related to your pain?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    @Step
    public AreYouCurrentlyReceivingWorkersPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyReceivingWorkersPageCC waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public AreYouCurrentlyReceivingWorkersPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
