package com.acurian.selenium.pages.CC.DYS_4356C;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;


import ru.yandex.qatools.allure.annotations.Step;

public class PregnancyAndFertilityCC extends MainPageCC {

    public final String titleExpected = "Clinical trials often have requirements related to pregnancy and fertility.\n" +
            "Please select the option which most closely applies to you:";

    @FindBy(xpath = "//div[@class='question_container']//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btn_container']//label")
    List<WebElement> radioButtonsList;

    public PregnancyAndFertilityCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public  PregnancyAndFertilityCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public PregnancyAndFertilityCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
