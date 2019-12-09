package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BiologicMedications extends MainPageBlinx {

    public final String titleExpected = "\"Biologics\" are medications that affect the body's immune system. They are usually given as an infusion (into a vein) or a shot (injection).\n" +
            "Have you ever received any of the following \"biologic\" medications?\n"  +
            "Please select all that apply";

    public final String titleExpectedKAD = "Are you currently receiving regular doses of any of the following \"biologic\" medications?\n" +
            "\"Biologics\" are medications that affect the body's immune system. They are given as an infusion (into a vein) or an injection (a shot under the skin).\n" +
            "Please select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public BiologicMedications() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public BiologicMedications waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public BiologicMedications waitForPageLoadKAD() {
        waitForPageLoadMain(titleText, titleExpectedKAD);
        return this;
    }

    @Step
    public BiologicMedications clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
