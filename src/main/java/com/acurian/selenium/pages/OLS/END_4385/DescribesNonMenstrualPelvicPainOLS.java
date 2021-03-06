package com.acurian.selenium.pages.OLS.END_4385;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DescribesNonMenstrualPelvicPainOLS extends MainPageOLS {

	public final String titleExpected = "Which of the following most accurately describes your worst pelvic pain when you do NOT have your period, and how it affects your life?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public DescribesNonMenstrualPelvicPainOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DescribesNonMenstrualPelvicPainOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DescribesNonMenstrualPelvicPainOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
