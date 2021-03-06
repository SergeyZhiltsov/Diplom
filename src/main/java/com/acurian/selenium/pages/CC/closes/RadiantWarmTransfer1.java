package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class RadiantWarmTransfer1 extends MainPageCC{

    public final String titleExpected ="We're glad the location is convenient for you.\n" +
            "\n" +
            "Agent Note:\n" +
            "If CSR has ability to direct schedule in clinical conductor, then Follow the Scheduling Script\n" +
            "\n" +
            "If CSR does NOT have ability to direct schedule in clinical conductor, then Continue with the Warm Transfer\n" +
            "\n" +
            "I would like to transfer you to the doctor's scheduling center.\n" +
            "Please hold for just a minute while I try to reach the scheduling center.";
    
    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public RadiantWarmTransfer1() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public RadiantWarmTransfer1 waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public RadiantWarmTransfer1 clickOnAnswer(String answerText) {
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

