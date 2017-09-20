package com.acurian.selenium.pages.OLS.RA_2821;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

public class AgeWhenDiagnosedWithRA extends BasePage {
	public final String titleExpected = "When were you diagnosed with RA? ";

    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;
    
    @FindBy(xpath = "//div[contains(@class,'center-block')]//input")
    WebElement enterAge;		
    
    public AgeWhenDiagnosedWithRA() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AgeWhenDiagnosedWithRA waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public AgeWhenDiagnosedWithRA setAge(String age) {
       typeText(enterAge,age);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}
