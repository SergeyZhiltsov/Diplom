package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class NonQRtransitionPageCC extends BasePage{

    public final String titleExpected = "Do you suffer from low back pain?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;


    public NonQRtransitionPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NonQRtransitionPageCC waitForPageLoad() {
        waitForAnimation();
//        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
}
