package com.acurian.selenium.pages.CC.AUTI_3973;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverBeenToldByDoctorAutism_CC extends MainPageCC{

    public final String titleExpected = "Have you ever been told by a doctor that you have autism or an autism spectrum disorder?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HaveYouEverBeenToldByDoctorAutism_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverBeenToldByDoctorAutism_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HaveYouEverBeenToldByDoctorAutism_CC clickOnAnswer(String answerText) {
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
