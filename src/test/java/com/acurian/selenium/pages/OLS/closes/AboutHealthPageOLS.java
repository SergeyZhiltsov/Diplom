package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class AboutHealthPageOLS extends MainPageOLS{

    public final String titleExpected = "Health Topics";

    @FindBy(xpath = "(//img[contains(@src,'//alotabouthealth.com')])[1]") //"(//article//h3)[1]")
    WebElement titleText;

    public AboutHealthPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AboutHealthPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
