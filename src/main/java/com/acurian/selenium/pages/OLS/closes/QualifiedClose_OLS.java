package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedClose_OLS extends MainPageOLS{

    //%s = Qualified_indication variable
    public final String titleExpected = "We’re glad the location is convenient for you.\n" +
    		"\n" +
    		"We will forward your contact information to the doctor’s office that you selected so they may contact you about %s study.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    public QualifiedClose_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedClose_OLS waitForPageLoad(String indication) {
        String titleExpectedMod = String.format(titleExpected, indication);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
