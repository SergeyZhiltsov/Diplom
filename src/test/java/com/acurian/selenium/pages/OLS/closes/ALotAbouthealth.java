package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class ALotAbouthealth extends MainPageOLS{
	public final String titleExpected = "Health Topics";
            

    @FindBy(xpath = "//h3[contains(.,'Health Topics')")
    WebElement titleText;
    

    public ALotAbouthealth() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ALotAbouthealth waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
