package com.acurian.selenium.pages.OLS.RA;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class MedicationsToTreatYourRA extends MainPageOLS {
	public final String titleExpected = "Are you currently taking any of the following medications to treat your RA?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    
    @FindBy(xpath = "//label[contains(@for,'QS7109')]/span[@class='copy']")
    List<WebElement> checkBoxList;

    public MedicationsToTreatYourRA() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MedicationsToTreatYourRA waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public MedicationsToTreatYourRA clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
