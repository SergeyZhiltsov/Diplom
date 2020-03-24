package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSCrohnsPageOLS extends MainPageOLS{

    //3638UC and 3638C
    public final String titleExpected = "Your medical records related to your Crohn's Disease are required for this study. The study doctor will not be able to contact you until they have reviewed these records.\n" +
            "\n" +
            "On the next page please provide:\n" +
            "\n" +
            "- The name of the doctor who has the medical records/evaluation of your most recent colonoscopy.\n" +
            "\n" +
            "We realize that gathering all of this information may take time, so if you complete the authorization form today, Acurian will send you a $25 Amazon electronic gift card after the information has been verified. The Amazon gift card is not related to the study or your choice to participate in the study – just our way of saying thanks for your time and for helping expedite the record release process.\n" +
            "\n" +
            "Please be assured your records will be kept confidential and only be used to evaluate you for participation.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    public HSCrohnsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSCrohnsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
