package com.acurian.selenium.pages.CC.HOTF_7119;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoyouExperienceHotFlashesCC extends MainPageCC {

    public final String titleExpected = "A hot flash is a common symptom of menopause, which may cause:\n" +
            "• A sudden feeling of warmth spreading through your face, neck, and chest\n" +
            "• A flushed appearance, with red, blotchy skin\n" +
            "• Sweating, often at night\n" +
            "• Rapid heartbeat\n" +
            "• A chilled feeling as the hot flash lets up\n" +
            "Do you experience hot flashes?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public DoyouExperienceHotFlashesCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoyouExperienceHotFlashesCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoyouExperienceHotFlashesCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
