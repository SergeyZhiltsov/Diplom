package com.acurian.selenium.pages.CC.MDD_3159;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class YouHaveNotTakenANYPrescriptionCC extends MainPageCC{

    public final String titleExpected = "To confirm, you have indicated that you have not taken ANY prescription medication for your current episode of depression.\n" +
    		"\n" +
    		"Is this correct?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public YouHaveNotTakenANYPrescriptionCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public YouHaveNotTakenANYPrescriptionCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public YouHaveNotTakenANYPrescriptionCC clickOnAnswer(String answerText) {
    	clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
