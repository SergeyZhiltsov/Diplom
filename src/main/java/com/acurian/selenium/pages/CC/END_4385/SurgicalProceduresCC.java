package com.acurian.selenium.pages.CC.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class SurgicalProceduresCC extends MainPageCC{

    public final String titleExpected = "There are times when surgery is required to remove endometriosis tissue found outside of the uterus (implants), to remove scar tissue (adhesions), to cut nerves in the pelvis, etc.\n" +
            "How many of these types of surgical procedures have you had to treat your endometriosis?\n" +
    		"Please do not count any procedures you may have had to diagnose your endometriosis.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public SurgicalProceduresCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SurgicalProceduresCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SurgicalProceduresCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
