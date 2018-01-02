package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class SynexusQualifiedCloseMIG4356Page extends MainPageOLS{

    //%s = ID variable
    public final String titleExpected = "We're glad the location is convenient for you. The next step is to schedule an appointment with the study doctor. You can schedule your appointment directly by calling 1-844-438-6150. Please provide the study doctor ID %s when you call. If we don’t hear from you, we will call you at the number provided to schedule your appointment.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    public SynexusQualifiedCloseMIG4356Page() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SynexusQualifiedCloseMIG4356Page waitForPageLoad() {
        //String titleExpectedMig4356 = String.format(titleExpected, "625252");
        String titleExpectedMig4356 = String.format(titleExpected, "625641");
        waitForPageLoadMain(titleText, titleExpectedMig4356);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}