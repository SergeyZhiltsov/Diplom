package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class Regular_WarmTransfer3 extends MainPageCC{

    public final String titleExpected ="The site is available to speak with you now. I am going to transfer you over to %s. Thank you again for contacting Acurian's Research Information Center. Goodbye.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public Regular_WarmTransfer3() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public Regular_WarmTransfer3 waitForPageLoad(String siteCoordinatorName) {
        String titleExpectedMod = String.format(titleExpected, siteCoordinatorName);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public Regular_WarmTransfer3 clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}

