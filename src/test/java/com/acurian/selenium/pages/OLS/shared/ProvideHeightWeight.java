package com.acurian.selenium.pages.OLS.shared;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class ProvideHeightWeight extends MainPageOLS{

    public final String titleExpected = "What is your approximate height?";

    @FindBy(xpath = "//div[contains(@class,'text-height-question')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@name,'feet')]")
    WebElement heightField;
    
    @FindBy(xpath = "//input[contains(@name,'inches')]")
    WebElement heightINCH;
    
    @FindBy(xpath = "//input[contains(@name,'QS23B')]")
    WebElement weightField;

    public ProvideHeightWeight() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ProvideHeightWeight waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public ProvideHeightWeight setFT(String heightFT) {
        typeText(heightField, heightFT);
        return this;
    }
    
    @Step
    public ProvideHeightWeight setIN(String heightIN) {
        typeText(heightINCH, heightIN);
        return this;
    }
    
    @Step
    public ProvideHeightWeight setWeight(String weightFT) {
        typeText(weightField, weightFT);
        return this;
    }

   
    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
