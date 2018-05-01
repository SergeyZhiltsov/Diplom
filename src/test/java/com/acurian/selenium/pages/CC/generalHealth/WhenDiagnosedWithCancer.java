package com.acurian.selenium.pages.CC.generalHealth;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.IBD.MostRecentColonoscopyCC;

import ru.yandex.qatools.allure.annotations.Step;

public class WhenDiagnosedWithCancer extends MainPageCC{

    public final String titleExpected = "When were you diagnosed with cancer (other than skin cancer)?";
    

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public WhenDiagnosedWithCancer() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDiagnosedWithCancer waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenDiagnosedWithCancer clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
