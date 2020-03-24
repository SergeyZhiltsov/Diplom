package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class UlcerativeColitisDoctorOrNursePageOLS extends MainPageOLS {

	public final String titleExpected = "Was your diagnosis of ulcerative colitis made by a doctor or nurse?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public UlcerativeColitisDoctorOrNursePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public UlcerativeColitisDoctorOrNursePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public UlcerativeColitisDoctorOrNursePageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
