package com.acurian.selenium.pages.OLS.AMIG_4742;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouBeenDiagnosedWithMigrainesPageOLS extends MainPageOLS {
	public final String titleExpected =
      "Migraines are intense headaches that last for hours to days and:\n" +
            "Cause pulsing or throbbing pain\n"+
            "Interfere with work, family, or social activities\n"+
            "Can trigger nausea or sensitivity to light and/or sound\n\n"+
            "Have you been diagnosed with migraines?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HaveYouBeenDiagnosedWithMigrainesPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouBeenDiagnosedWithMigrainesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouBeenDiagnosedWithMigrainesPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
