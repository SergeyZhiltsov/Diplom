package com.acurian.selenium.pages.OLS.PS_4656;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ArmsHandsPsoriasisPageOLS extends MainPageOLS {

    public final String titleExpected = "Which of these pictures looks most similar to the amount of psoriasis currently on your arms and hands?\n" +
            "Please focus on the amount of skin covered by psoriasis, rather than the pattern in the pictures. Answer choices appear below the pictures.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    @Step
    public ArmsHandsPsoriasisPageOLS waitForPageLoad() {
        waitForImagesToLoad();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ArmsHandsPsoriasisPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
