package com.acurian.selenium.pages.CC.insomnia_5017;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouSufferFromInsomniaPageCC extends MainPageCC {

    public final String titleExpected = "Insomnia is a sleep disorder that may cause you to have difficulty:\n" +
                                        "Falling asleep\n" +
                                        "Staying asleep\n" +
                                        "Going back to sleep when you wake up during the night\n" +
                                        "Going back to sleep when you wake up earlier than you intend\n" +
                                        "\n" +
                                        "Do you suffer from insomnia, or any of these sleep problems?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public DoYouSufferFromInsomniaPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouSufferFromInsomniaPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouSufferFromInsomniaPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
