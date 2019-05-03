package com.acurian.selenium.pages.CC.IBD;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class SteroidMedicationsForCrohnsCC extends MainPageCC{

    public final String titleExpected = "Have you ever taken steroid medications for your Crohn's or colitis?\n" +
             "These include medications like prednisone (Agent Note: PRED-nis-own) or hydrocortisone (Agent Note: hi-dro-CORT-i-sone), usually taken by mouth or sometimes as an enema or injection.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public SteroidMedicationsForCrohnsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SteroidMedicationsForCrohnsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SteroidMedicationsForCrohnsCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
