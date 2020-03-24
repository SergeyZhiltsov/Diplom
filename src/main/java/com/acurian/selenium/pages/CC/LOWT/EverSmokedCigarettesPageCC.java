package com.acurian.selenium.pages.CC.LOWT;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverSmokedCigarettesPageCC extends MainPageCC {

    public final String titleExpected = "Have you ever smoked cigarettes?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    @Step
    public EverSmokedCigarettesPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverSmokedCigarettesPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
