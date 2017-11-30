package com.acurian.selenium.pages.CC.MDD_3159;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HowManyDifferentPrescriptionAntidepresMedsCC extends MainPageCC{

    public final String titleExpected = "How many different prescription antidepressant medications have you taken during your current episode of depression?\n" +
"Please include all antidepressant medications. Include those which you are currently taking and those you previously took for this current episode but are no longer taking.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HowManyDifferentPrescriptionAntidepresMedsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyDifferentPrescriptionAntidepresMedsCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowManyDifferentPrescriptionAntidepresMedsCC clickOnAnswer(String answerText) {
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