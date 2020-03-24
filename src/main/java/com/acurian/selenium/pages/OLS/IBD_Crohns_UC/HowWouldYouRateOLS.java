package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowWouldYouRateOLS extends MainPageOLS {

    public final String titleExpected = "In general, how would you rate your health, living with Crohn's or colitis?";

    public final String titleCompared = "Compared to the past few months, how would you rate your health now?";

    public final String titleSymptoms = "Which of the following symptoms are you currently experiencing?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    WebElement titleTextIBD;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public HowWouldYouRateOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowWouldYouRateOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowWouldYouRateOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public HowWouldYouRateOLS waitForPageLoadSymptoms() {
        waitForPageLoadMain(titleTextIBD, titleSymptoms);
        return this;
    }
    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
