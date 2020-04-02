package com.acurian.selenium.pages.blinx.ams.ra;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
//TODO complete
public class WhichContainAcetaminophenPageOLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever treated your arthritis pain with any of the following medications which contain acetaminophen?";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public WhichContainAcetaminophenPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichContainAcetaminophenPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichContainAcetaminophenPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
