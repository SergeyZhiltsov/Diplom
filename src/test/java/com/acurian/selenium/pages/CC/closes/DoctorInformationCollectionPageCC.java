package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DoctorInformationCollectionPageCC extends MainPageCC{

    public final String titleExpected = "You will need to provide us with some information on the doctors who are treating or have treated your condition. We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    public final String titleExpectedGmega = "We now need some information on the doctors who are treating or who have treated your condition.\n" +
            "We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public DoctorInformationCollectionPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoctorInformationCollectionPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoctorInformationCollectionPageCC waitForPageLoadGmega() {
        waitForPageLoadMain(titleText, titleExpectedGmega);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
