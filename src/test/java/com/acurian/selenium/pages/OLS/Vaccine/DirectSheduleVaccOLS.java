package com.acurian.selenium.pages.OLS.Vaccine;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DirectSheduleVaccOLS extends MainPageOLS {


    public final String titleExpected = "You can schedule an appointment now, or click \"next\" to complete next steps and have the study doctor's team reach back out to you.\n" +
            "\n" +
            "Click below to schedule your appointment. This will open a new window with available dates and times at the site you have selected.\n" +
            "After you select an appointment date and time, please return to this window and click \"next\" to complete the next steps.";

    public final String titleExpectedSTG = "Click below to schedule your appointment. After the appointment confirmation, please return to this window and click \"next\" to complete the process.\n" +
            "If you are not able schedule now, you will be contacted by the study doctor's office to schedule your appointment.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
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
    public <T extends MainPageOLS> T clickSheduleBtn(T page) {
        sheduleBtn.click();
        return (T) page;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
