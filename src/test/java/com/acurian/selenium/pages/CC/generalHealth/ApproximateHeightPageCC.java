package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class ApproximateHeightPageCC extends MainPageCC{

    public final String titleExpected = "May I have your approximate height?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//select[@class='select-height-feet']")
    WebElement featSelect;

    @FindBy(xpath = "//select[@class='select-height-inches']")
    WebElement inchesSelect;

    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement lbsField;

    public ApproximateHeightPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ApproximateHeightPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    @Step
    public ApproximateHeightPageCC setAll(String feat, String inches, String lbs) {
        setFeat(feat);
        setInches(inches);
        setLbs(lbs);
        return this;
    }

    @Step
    public ApproximateHeightPageCC setFeat(String number) {
        selectDropDownListOptionByText(featSelect, number);
        return this;
    }

    @Step
    public ApproximateHeightPageCC setInches(String number) {
        selectDropDownListOptionByText(inchesSelect, number);
        return this;
    }

    @Step
    public ApproximateHeightPageCC setLbs(String number) {
        typeText(lbsField, number);
        return this;
    }
}
