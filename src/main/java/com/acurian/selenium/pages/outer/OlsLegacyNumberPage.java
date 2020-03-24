package com.acurian.selenium.pages.outer;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class OlsLegacyNumberPage extends BasePage {

    @FindBy(xpath = "//h3[@id='welcome_acurian']")
    WebElement header;

    @FindBy(xpath = "//input[@id='phoneNumberareacode']")
    WebElement firstPhoneDigits;

    @FindBy(xpath = "//input[@id='phoneNumberexchange']")
    WebElement secondPhoneDigits;

    @FindBy(xpath = "//input[@id='phoneNumberlastdigits']")
    WebElement thirdPhoneDigits;

    @FindBy(xpath = "//input[@id='go_btn']")
    WebElement goButton;


    public OlsLegacyNumberPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OlsLegacyNumberPage waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(header);
        Assert.assertEquals(getTitleText(), "Welcome to the\n" +
                "Acurian Clinical Trial Center", "Title text is diff");
        return this;
    }

    @Step
    public OlsLegacyNumberPage typePhone(String phoneNumber){
        typeText(firstPhoneDigits,phoneNumber.substring(0,3));
        waitForAnimation();
        typeText(secondPhoneDigits,phoneNumber.substring(3,6));
        waitForAnimation();
        typeText(thirdPhoneDigits,phoneNumber.substring(6,10));
        waitForAnimation();
        return this;
    }

    @Step
    public OlsLegacyDateOfBirthPage clickGoButton(){
        goButton.click();
        return new OlsLegacyDateOfBirthPage();
    }

    @Step
    public String getTitleText(){
        return header.getText();
    }
}
