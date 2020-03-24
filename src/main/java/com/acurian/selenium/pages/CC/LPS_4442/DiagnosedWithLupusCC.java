package com.acurian.selenium.pages.CC.LPS_4442;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class DiagnosedWithLupusCC extends MainPageCC{

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with lupus? (Agent Note: LOOP-us)";
    public final String titleExpected2 = "Has a healthcare professional diagnosed you with lupus? (Agent Note: LOOP-us)";

    @FindBy(xpath = "//div[@class='question_text']/span[@class='show-in-cc']")
    WebElement titleText;    

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;
    
    public DiagnosedWithLupusCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithLupusCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DiagnosedWithLupusCC waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public DiagnosedWithLupusCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
