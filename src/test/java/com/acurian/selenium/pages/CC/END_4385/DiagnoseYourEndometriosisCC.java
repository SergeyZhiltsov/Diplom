package com.acurian.selenium.pages.CC.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.END_4385.DiagnoseYourEndometriosisOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class DiagnoseYourEndometriosisCC extends MainPageCC{

    public final String titleExpected = "When was your most recent surgery to treat or diagnose your endometriosis performed?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public DiagnoseYourEndometriosisCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnoseYourEndometriosisCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnoseYourEndometriosisCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
