package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class AboutHealthPageOLS extends MainPageOLS{

    public final String titleExpected = "Join Our Community";

    @FindBy(xpath = "//*[@id='menu-primary_menu']//span[contains(.,'Join Our Community')]")    //"//img[contains(@src,'//alotabouthealth.com')]")
    WebElement titleText;

    @FindBy(xpath = "//div[@id='top']")
    WebElement titleText2;


    public AboutHealthPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AboutHealthPageOLS waitForPageLoad() {
        if (Locators.isEnvWeb){
            waitForPageLoadMain(titleText, titleExpected);
        }
        else {
            driverWait.waitforVisibility(titleText2);
        }
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
