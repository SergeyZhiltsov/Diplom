package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedClose2PageOLS extends MainPageOLS{

    //Qualified Close 2: No Pediatric Study Switch - 35
    public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    public QualifiedClose2PageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
