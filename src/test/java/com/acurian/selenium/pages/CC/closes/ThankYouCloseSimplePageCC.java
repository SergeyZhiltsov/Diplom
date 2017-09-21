package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouCloseSimplePageCC extends MainPageCC{

    //Thank You Close - AWR/SEN - 65_number

    public final String titleExpected = "Thank you again for contacting Acurian's Research Information Center. Goodbye.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    public ThankYouCloseSimplePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThankYouCloseSimplePageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
