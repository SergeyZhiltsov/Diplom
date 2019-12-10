package com.acurian.selenium.pages.CC.Vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class DirectSheduleVaccCC extends MainPageCC {


    public final String titleExpected = "The next step is to get you scheduled for an appointment with the study doctor's team. During this visit, the study doctor's team will further discuss the study requirements and answer any questions you may have.\n" +
            "\n" +
            "Agent note: Click the link below to schedule the patient's appointment. This will open a new window with available dates and times at the site that has been selected. Select an appointment date and time that is convenient for the patient. Then return to this screen to complete next steps.\n" +
            "\n" +
            "Agent note: you may be prompted later to attempt to warm transfer the patient to the site, or to schedule the patient in Clinical Conductor, even if you successfully scheduled the patient's appointment here. If the appointment was successfully scheduled, please do NOT complete the warm transfer or the scheduling in Clinical Conductor.\n" +
            "\n" +
            "Click here to book an appointment with the site you picked";

    public final String titleExpectedSTG = "Click below to schedule your appointment. After the appointment confirmation, please return to this window and click \"next\" to complete the process.\n" +
            "If you are not able to schedule now, you will be contacted by the study doctor's office to schedule your appointment.\n" +
            "\n" +
            "\n" +
            "SCHEDULE APPOINTMENT NOW";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = "//*[@id='command']/div[1]/div[1]/a")
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
