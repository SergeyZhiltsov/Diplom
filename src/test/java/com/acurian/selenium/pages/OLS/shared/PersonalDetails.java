package com.acurian.selenium.pages.OLS.shared;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class PersonalDetails extends MainPageOLS{

    public final String titleExpected = "Personal details (*required fields)";

    @FindBy(xpath = "//h2[@id='patient-title']")
    
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@name,'QI3')]")
    WebElement firstName;
    
    @FindBy(xpath = "//input[contains(@name,'QI5')]")
    WebElement lastName;
    
    @FindBy(xpath = "//input[contains(@name,'QI7')]")
    WebElement phone;
    
    @FindBy(xpath = "//input[contains(@name,'QI16')]")
    WebElement zipCode;
    
    @FindBy(xpath = "//button[contains(.,'Confirm')]")
    WebElement confirmButton;

    public PersonalDetails() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PersonalDetails waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public PersonalDetails setFirstName(String firstN) {
        typeText(firstName, firstN);
        return this;
    }
    
    @Step
    public PersonalDetails setLastName(String lastN) {
        typeText(lastName, lastN);
        return this;
    }
    
    @Step
    public PersonalDetails setPhone(String ph) {
        typeText(phone, ph);
        return this;
    }
    
    @Step
    public PersonalDetails setZip(String zip) {
        typeText(zipCode, zip);
        return this;
    }
   
    @Step
    public String getTitleText(){
        return getText(titleText);
    } 
    
    @Step
    public PersonalDetails clickConfirm(){
    	confirmButton.click();
        return this;
    }  
    

}
