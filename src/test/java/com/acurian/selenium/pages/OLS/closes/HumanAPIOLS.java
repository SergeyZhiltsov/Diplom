package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HumanAPIOLS extends MainPageOLS{

    //Qualified Close 2: No Pediatric Study Switch - 35
    public final String titleExpected = "The final step is to connect your health data";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/h3")
    WebElement titleText;
    
    @FindBy(xpath = "//button[@type='button']")
    WebElement connectButton;
    
    @FindBy(xpath = "//button[@id='filter-none']")
    WebElement selectAny;

    public HumanAPIOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HumanAPIOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
