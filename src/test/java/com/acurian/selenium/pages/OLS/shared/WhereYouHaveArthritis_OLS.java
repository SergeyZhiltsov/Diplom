package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WhereYouHaveArthritis_OLS extends MainPageOLS {
	public final String titleExpected = "Where do you have arthritis?\n" + 
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public WhereYouHaveArthritis_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhereYouHaveArthritis_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhereYouHaveArthritis_OLS clickOnAnswer(String answerText) {
    	clickOnCheckBoxes(checkBoxList, answerText);
        return this;   
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
    

}
