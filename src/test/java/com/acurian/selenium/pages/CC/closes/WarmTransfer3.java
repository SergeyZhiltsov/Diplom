package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WarmTransfer3 extends MainPageCC{

    public final String titleExpected = "Agent note: bring all 3 parties on the line.\n" +
    "Hi, do I have everyone on the line? Great, I have Acurian Trial on the line and he/she is interested in scheduling his/her first appointment. Ms/Mr. Trial's ID # is and the project is Migraines protocol 20150133 (20150133), BHV3000-301 (BHV3000_301), CGP-MD-01 (CGP_MD_01), UBR-MD-01 (UBR_MD_01), UBR-MD-02 (UBR_MD_02). He/She has been referred to Site ID 625252. ";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public WarmTransfer3() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WarmTransfer3 waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WarmTransfer3 clickOnAnswer(String answerText) {
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
