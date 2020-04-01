package com.acurian.selenium.pages.blinx.ams.vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class DirectSheduleVaccOLS extends MainPageBlinx {

    public final String titleExpected = "Click the link below to schedule an appointment:\n" +
            "\n" +
            "Once your appointment has been confirmed, please return to this window and click \"Next\" to complete the screening process.\n" +
            "If you are unable to schedule an appointment now, the study doctor's office will contact you with additional scheduling options.\n" +
            "\n" +
            "\n" +
            "SCHEDULE AN APPOINTMENT";

    public final String titleExpectedSTG = "Click below to schedule your appointment. After the appointment confirmation, please return to this window and click \"next\" to complete the process.\n" +
            "If you are not able to schedule now, you will be contacted by the study doctor's office to schedule your appointment.\n" +
            "\n" +
            "\n" +
            "SCHEDULE APPOINTMENT NOW";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = "(//*[contains(@class, 'btn')])[1]")
    WebElement sheduleBtn;

    @Step
    public DirectSheduleVaccOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DirectSheduleVaccOLS waitForPageLoadSTG() {
        waitForPageLoadMain(titleText, titleExpectedSTG);
        return this;
    }

    @Step
    public <T extends MainPageBlinx> T clickSheduleBtn(T page) {
        sheduleBtn.click();
        return (T) page;
    }

    @Step
    public <T extends MainPageBlinx> T clickSheduleBtnBlinx(T page) {
        sheduleBtn.click();
        return (T) page;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
