package com.acurian.selenium.pages.CC.GERD;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouHaveZollingerEllisonSyndrome_CC extends MainPageCC {

    public final String titleExpected = "Do you have Zollinger-Ellison syndrome, a condition that causes the stomach to produce too much acid?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public DoYouHaveZollingerEllisonSyndrome_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouHaveZollingerEllisonSyndrome_CC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DoYouHaveZollingerEllisonSyndrome_CC clickOnAnswer(String answerText) {
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