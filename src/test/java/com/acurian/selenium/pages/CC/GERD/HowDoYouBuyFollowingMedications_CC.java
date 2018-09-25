package com.acurian.selenium.pages.CC.GERD;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowDoYouBuyFollowingMedications_CC extends MainPageCC{

    public final String titleExpected = "Some medications for heartburn, reflux, or GERD are available with or without a prescription from a doctor.\n" +
"How do you buy the following medication(s)?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HowDoYouBuyFollowingMedications_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowDoYouBuyFollowingMedications_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowDoYouBuyFollowingMedications_CC clickOnAnswer(String answerText) {
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
