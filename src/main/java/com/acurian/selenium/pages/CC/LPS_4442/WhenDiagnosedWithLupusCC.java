package com.acurian.selenium.pages.CC.LPS_4442;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class WhenDiagnosedWithLupusCC extends MainPageCC{

    public final String titleExpected = "When were you diagnosed with lupus?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;    

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;
    
    public WhenDiagnosedWithLupusCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDiagnosedWithLupusCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WhenDiagnosedWithLupusCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
