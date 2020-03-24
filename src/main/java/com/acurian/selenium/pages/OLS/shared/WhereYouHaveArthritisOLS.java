package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WhereYouHaveArthritisOLS extends MainPageOLS {
	public final String titleExpected = "Where do you have arthritis?\n" + 
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public WhereYouHaveArthritisOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhereYouHaveArthritisOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhereYouHaveArthritisOLS clickOnAnswer(String answerText) {
    	clickOnCheckBoxes(checkBoxList, answerText);
        return this;   
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
    

}
