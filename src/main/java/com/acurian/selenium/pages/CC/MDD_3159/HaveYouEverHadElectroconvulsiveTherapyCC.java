package com.acurian.selenium.pages.CC.MDD_3159;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HaveYouEverHadElectroconvulsiveTherapyCC extends MainPageCC{

    public final String titleExpected = "Electroconvulsive therapy (ECT), sometimes known as electroshock therapy or \"shock treatment,\" is a procedure done under general anesthesia in which small electric currents are passed through the brain, often helping to relieve symptoms of certain mental illnesses.\n" +
    		"Have you ever had electroconvulsive therapy or ECT?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HaveYouEverHadElectroconvulsiveTherapyCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverHadElectroconvulsiveTherapyCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HaveYouEverHadElectroconvulsiveTherapyCC clickOnAnswer(String answerText) {
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
