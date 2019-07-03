package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SynexusHealthyMindsPageOLS extends MainPageOLS {

    public final String titleExpected = "The Synexus HealthyMinds Registry is an innovative study to help researchers understand how healthy brains age in order to identify potential methods of prevention, treatment, and cures for cognitive decline, Alzheimer’s Disease, and other forms of dementia.\n" +
            "\n" +
            "Participation in the study is easy, free, done entirely online, and includes brain-training games to exercise the mind and help maintain mental ability. Space is limited, and only United States residents 50 years old or older who have access to the Internet and have not been diagnosed with dementia will be able to participate.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public SynexusHealthyMindsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SynexusHealthyMindsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SynexusHealthyMindsPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
