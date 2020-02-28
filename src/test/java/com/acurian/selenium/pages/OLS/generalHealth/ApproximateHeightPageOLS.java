package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ApproximateHeightPageOLS extends MainPageOLS{

    public final String titleExpected = "What is your approximate height?";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleTextGMEGA;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]/span[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'text-height-input-feet')] | //input[contains(@class, 'form-control text-dual-height-input-feet')]")
    WebElement featField;

    @FindBy(xpath = "//input[contains(@class,'text-height-input-inches')] | //input[contains(@class, 'form-control text-dual-height-input-inches')]")
    WebElement inchesField;

    @FindBy(xpath = "//input[contains(@class,'text-weight-input')] | //input[contains(@class, 'text-dual-weight')]")
    WebElement lbsField;

    public ApproximateHeightPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ApproximateHeightPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ApproximateHeightPageOLS waitForPageLoadGMEGA() {
        waitForPageLoadMain(titleTextGMEGA, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    @Step
    public ApproximateHeightPageOLS setAll(String feat, String inches, String lbs) {
//        setFeat(feat);
//        setInches(inches);
//        setLbs(lbs);
        setFeatwithClear(feat);
        setIncheswithClear(inches);
        setLbs(lbs);
        return this;
    }

    @Step
    public ApproximateHeightPageOLS setAllWithClear(String feat, String inches, String lbs) {
        setFeatwithClear(feat);
        setIncheswithClear(inches);
        setLbs(lbs);
        return this;
    }

    @Step
    public ApproximateHeightPageOLS setFeat(String number) {
        typeTextWithoutClear(featField, number);
        waitForAnimation();
        return this;
    }
    
    @Step
    public ApproximateHeightPageOLS setFeatwithClear(String number) {
        typeText(featField, number);
        waitForAnimation();
        return this;
    }


    @Step
    public ApproximateHeightPageOLS setInches(String number) {
        waitForAnimation();
        typeTextWithoutClear(inchesField, number);
        waitForAnimation();
        return this;
    }
    
    @Step
    public ApproximateHeightPageOLS setIncheswithClear(String number) {
        waitForAnimation();
        typeText(inchesField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public ApproximateHeightPageOLS setLbs(String number) {
        waitForAnimation();
        typeText(lbsField, number);
        waitForAnimation();
        return this;
    }
}
