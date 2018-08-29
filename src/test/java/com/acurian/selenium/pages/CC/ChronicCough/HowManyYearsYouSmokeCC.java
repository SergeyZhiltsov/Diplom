package com.acurian.selenium.pages.CC.ChronicCough;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyYearsYouSmokeCC extends MainPageCC{

    public final String titleExpected = "About how many cigarettes per day do you smoke?";
    
    public final String titleExpected1 = "About how many cigarettes per day did you smoke?";

    @FindBy(xpath = "//div[@class='subquestion'][2]/span[1]")
    WebElement titleText;    

    @FindBy(xpath = "//input[@id='answersQS6208B.rawAnswer']")
    WebElement howManyYears;
    
    @FindBy(xpath = "//input[@id='answersQS6208D.rawAnswer']")
    WebElement howManyCigarettes;
    
    
    public HowManyYearsYouSmokeCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyYearsYouSmokeCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    
    @Step
    public HowManyYearsYouSmokeCC waitForPageLoad1() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected1));
        return this;
    }

    @Step
    public HowManyYearsYouSmokeCC enterYears(String manyYears) {
        typeText(howManyYears, manyYears);
        return this;
    }
    
    @Step
    public HowManyYearsYouSmokeCC enterCigrettes(String manyYears) {
        typeText(howManyCigarettes, manyYears);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
