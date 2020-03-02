package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ApproximateHeightPageCC extends MainPageCC{

    public final String titleExpected = "May I have your approximate height?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//select[@class='select-height-feet'] | //*[@class='feet_display']")
    WebElement featSelect;

    @FindBy(xpath = "//select[@class='select-height-inches'] | //*[@class='inches_display']")
    WebElement inchesSelect;

//    @FindBy(css = "#command > div:nth-child(7) > div > div.weight_input_container > input")
//    WebElement lbsField;

    @FindAll({
            @FindBy(css = "#command > div:nth-child(7) > div > div.weight_input_container > input"),
            @FindBy(xpath = "//*[@class='input-text']")
    })
    private List<WebElement> lbsField;

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
        waitForAnimation();
        selectDropDownListOptionByText(featSelect, number);
        return this;
    }

    @Step
    public ApproximateHeightPageCC setInches(String number) {
        waitForAnimation();
        selectDropDownListOptionByText(inchesSelect, number);
        return this;
    }

    @Step
    public ApproximateHeightPageCC setLbs(String number) {
        waitForAnimation();
        typeText(lbsField.get(0), number);
        return this;
    }
}
