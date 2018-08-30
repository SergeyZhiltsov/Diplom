package com.acurian.selenium.pages.CC.LOWT;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class DiagnosedYouWithLowTestosteroneCC extends MainPageCC{

    public final String titleExpected = "Testosterone (Agent note: tes-TOS-ter-one) is the male sex hormone. Levels may drop as men age.\n" +
    		"Has a doctor ever diagnosed you with low testosterone or hypogonadism? (Agent note: hi-pō-gō-nad-izm)";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public DiagnosedYouWithLowTestosteroneCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedYouWithLowTestosteroneCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DiagnosedYouWithLowTestosteroneCC clickOnAnswer(String answerText) {
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
