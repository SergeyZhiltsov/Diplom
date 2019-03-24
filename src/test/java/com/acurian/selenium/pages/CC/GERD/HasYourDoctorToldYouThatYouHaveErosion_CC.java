package com.acurian.selenium.pages.CC.GERD;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasYourDoctorToldYouThatYouHaveErosion_CC extends MainPageCC{

    public final String titleExpected = "Has your doctor told you that you have an erosion in your esophagus, esophageal erosions or erosive esophagitis?\n" +
            "This refers to ulceration or \"wearing away\" of the esophageal lining, and is seen on endoscopy.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HasYourDoctorToldYouThatYouHaveErosion_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasYourDoctorToldYouThatYouHaveErosion_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HasYourDoctorToldYouThatYouHaveErosion_CC clickOnAnswer(String answerText) {
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
