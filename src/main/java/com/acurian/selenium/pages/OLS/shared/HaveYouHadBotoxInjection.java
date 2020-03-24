package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouHadBotoxInjection extends MainPageOLS {

    public final String titleExpected = "Have you ever had a Botox (botulinum toxin) injection?\n" +
            "Botox injections can be used to treat migraines, for certain bladder problems, or as a cosmetic treatment for lines on the face.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    @Step
    public HaveYouHadBotoxInjection waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouHadBotoxInjection clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
