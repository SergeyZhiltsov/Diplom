package com.acurian.selenium.pages.CC.LOWT;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiagnosedYouWithLowTestosteroneCC extends MainPageCC {

    public final String titleExpected = "Testosterone (Agent note: tes-TOS-ter-one) is the male sex hormone. Levels may drop as men age.\n" +
            "Has a doctor ever diagnosed you with low testosterone or hypogonadism? (Agent note: hi-pō-gō-nad-izm)";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    @Step
    public DiagnosedYouWithLowTestosteroneCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedYouWithLowTestosteroneCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
