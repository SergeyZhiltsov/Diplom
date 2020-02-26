package com.acurian.selenium.pages.CC.Vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class DirectSheduleVaccCC extends MainPageCC {


    public final String titleExpected = "The next step is to schedule an appointment with the study doctor’s team.\n" +
            "\n" +
            "Agent Note: Click the link below to schedule an appointment for the patient—this will open a new window with available timeslots at the patient’s preferred site. Please choose the date and time that is most convenient for the patient, then return to the current screen to complete the screening process.\n" +
            "\n" +
            "Agent Note: Later, you may be prompted to warm transfer the patient to the site or schedule the patient in Clinical Conductor (even if you have successfully scheduled an appointment here).\n" +
            "\n" +
            "If an appointment has already been scheduled, please do NOT complete the warm transfer or schedule the patient in Clinical Conductor.";

    public final String titleExpectedSTG = "Click below to schedule your appointment. After the appointment confirmation, please return to this window and click \"next\" to complete the process.\n" +
            "If you are not able to schedule now, you will be contacted by the study doctor's office to schedule your appointment.\n" +
            "\n" +
            "\n" +
            "SCHEDULE APPOINTMENT NOW";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
//    @FindBy(xpath = "//*[@id='command']/div[1]/div[1]/a")
//    WebElement sheduleBtn;
    @FindBy(xpath = "//span[@class='show-in-cc']/a")
    WebElement sheduleBtn;

    @Step
    public DirectSheduleVaccCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DirectSheduleVaccCC waitForPageLoadSTG() {
        waitForPageLoadMain(titleText, titleExpectedSTG);
        return this;
    }

    @Step
    public <T extends MainPageCC> T clickSheduleBtn(T page) {
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
