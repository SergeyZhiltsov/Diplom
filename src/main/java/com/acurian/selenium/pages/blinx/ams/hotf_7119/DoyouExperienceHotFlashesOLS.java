package com.acurian.selenium.pages.blinx.ams.hotf_7119;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoyouExperienceHotFlashesOLS extends MainPageBlinx {

    public final String titleExpected = "A hot flash is a common symptom of menopause, which may cause:\n" +
            "• A sudden feeling of warmth spreading through your face, neck, and chest\n" +
            "• A flushed appearance, with red, blotchy skin\n" +
            "• Sweating, often at night\n" +
            "• Rapid heartbeat\n" +
            "• A chilled feeling as the hot flash lets up\n" +
            "Do you experience hot flashes?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public DoyouExperienceHotFlashesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoyouExperienceHotFlashesOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoyouExperienceHotFlashesOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
