package com.acurian.selenium.pages.OLS.common_elements;

import com.acurian.selenium.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoreAboutPage extends BasePage {

    @FindBy(xpath = "//h1[@class='title']")
    WebElement header;

    public MoreAboutPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public String getHeaderText(){
        driverWait.waitforVisibility(header);
        return getText(header);
    }
}
