package com.acurian.selenium.pages.CC.IBD;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class UlcerativeColitisDoctorOrNursePageСС extends MainPageCC {

    public final String titleExpected = "Was your diagnosis of ulcerative colitis made by a doctor or nurse?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public UlcerativeColitisDoctorOrNursePageСС() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public UlcerativeColitisDoctorOrNursePageСС waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public UlcerativeColitisDoctorOrNursePageСС clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}