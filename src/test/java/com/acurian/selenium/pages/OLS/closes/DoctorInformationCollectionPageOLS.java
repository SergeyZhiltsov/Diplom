package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DoctorInformationCollectionPageOLS extends MainPageOLS{

    public final String titleExpected = "We now need some information on the doctors who are treating or who have treated your condition.";

    public final String titleGmegaExpected = "We now need some information on the doctors who are treating or who have treated your condition.  \n" +
            "We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    public DoctorInformationCollectionPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoctorInformationCollectionPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoctorInformationCollectionPageOLS waitForPageLoadGmega() {
        waitForPageLoadMain(titleText, titleGmegaExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
