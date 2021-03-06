package com.acurian.selenium.pages.CC.MDD_3159;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HowManyDifferentPrescriptionAntidepresMedsCC extends MainPageCC{

    public final String titleExpected = "For this question, please continue to think ONLY about your CURRENT episode of depression.\n" +
			"\n" +
			"How many different prescription antidepressant medications have you taken during your current episode of depression?\n" +
			"Please count antidepressant medications you are taking NOW as well as those you have taken before for this current episode but no longer use.";

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
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
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
