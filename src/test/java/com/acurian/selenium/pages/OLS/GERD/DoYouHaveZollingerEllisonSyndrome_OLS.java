package com.acurian.selenium.pages.OLS.GERD;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouHaveZollingerEllisonSyndrome_OLS extends MainPageOLS {

    public final String titleExpected = "Do you have Zollinger-Ellison syndrome, a condition that causes the stomach to produce too much acid?";

    @FindBy(xpath = "(//*[contains(@class, 'visible-md-block')])[1]")
    WebElement titleText;

    @FindBy(xpath = "//*[contains(@class, 'choice')]")
    List<WebElement> radioButtonsList;

    public DoYouHaveZollingerEllisonSyndrome_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouHaveZollingerEllisonSyndrome_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouHaveZollingerEllisonSyndrome_OLS clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}