package com.acurian.selenium.pages.CC.shared;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HaveYouEverTreatedYourEczema_CC extends MainPageCC{

    public final String titleExpected = "Have you ever treated your eczema (atopic dermatitis) with any topical products such as creams, ointments, gels, foams and/or sprays which are applied directly onto your skin?\n" +
	"Topical products include both over the counter and prescription medications.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HaveYouEverTreatedYourEczema_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverTreatedYourEczema_CC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HaveYouEverTreatedYourEczema_CC clickOnAnswer(String answerText) {
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
