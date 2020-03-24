package com.acurian.selenium.pages.CC.shared;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HasDoctorDiagnosedYouWithClusterHeadache_CC extends MainPageCC{

    public final String titleExpected = "Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occurs in periods of attacks and remissions. It is different from the more common headache types such as migraine or tension headache.\n" +
    		"Has a doctor diagnosed you with cluster headache?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HasDoctorDiagnosedYouWithClusterHeadache_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasDoctorDiagnosedYouWithClusterHeadache_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HasDoctorDiagnosedYouWithClusterHeadache_CC clickOnAnswer(String answerText) {
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
