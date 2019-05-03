package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class SteroidMedicationsForCrohnsOLS extends MainPageOLS {
	
	public final String titleExpected = "Have you ever taken steroid medications for your Crohn's or colitis?\n" +
			"These include medications like prednisone or hydrocortisone, usually taken by mouth or sometimes as an enema or injection.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public SteroidMedicationsForCrohnsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SteroidMedicationsForCrohnsOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SteroidMedicationsForCrohnsOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
