package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SynexusHealthyMindsPageCC extends MainPageCC {

    public final String titleExpected = "I also wanted to let you know about the Synexus HealthyMinds Registry, an innovative study to help researchers understand how healthy brains age in order to identify potential methods of prevention, treatment, and cures for cognitive decline, Alzheimer’s Disease, and other forms of dementia.\n" +
            "\n" +
            "Participation in the study is easy, free, done entirely online, and includes brain-training games to exercise the mind and help maintain mental ability. Space is limited, and only United States residents 50 years old or older who have access to the Internet and have not been diagnosed with dementia will be able to participate.\n" +
            "\n" +
            "Do you agree to be contacted by Acurian or an Acurian affiliate by phone, including using automated technology or pre-recorded voicemail, or other means to receive more information when the study launches?";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public SynexusHealthyMindsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SynexusHealthyMindsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SynexusHealthyMindsPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
