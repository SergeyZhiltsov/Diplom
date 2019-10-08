package com.acurian.selenium.pages.CC.GERD;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasYourDoctorToldYouThatYouHaveErosion_CC extends MainPageCC {

    public final String titleExpected = "Acid irritation and inflammation can damage the esophagus (the tube that connects the throat to the stomach).  This can create a condition known as erosive esophagitis, which can be seen by a doctor during an endoscopy.\n" +
            "Has your doctor diagnosed you with erosive esophagitis or esophageal erosions, or told you there are sores or breaks in the lining of your esophagus?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public HasYourDoctorToldYouThatYouHaveErosion_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasYourDoctorToldYouThatYouHaveErosion_CC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
