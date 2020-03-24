package com.acurian.selenium.pages.CC.ChronicCough;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyCigarettesCC extends MainPageCC{

    public final String titleExpected = "About how many cigarettes per day do you smoke?";
    
    public final String titleExpected1 = "About how many cigarettes per day did you smoke?";

    @FindBy(xpath = "//div[@class='subquestion'][2]/span[1]")
    WebElement titleText;    

    @FindBy(xpath = "//input[@id='answersQS6208B.rawAnswer']")
    WebElement howManyYears;
    
    @FindBy(xpath = "//input[@id='answersQS6208D.rawAnswer']")
    WebElement howManyCigarettes;
    
    
    public HowManyCigarettesCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyCigarettesCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    
    @Step
    public HowManyCigarettesCC waitForPageLoad1() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected1));
        return this;
    }

    @Step
    public HowManyCigarettesCC enterYears(String manyYears) {
        typeText(howManyYears, manyYears);
        return this;
    }
    
    @Step
    public HowManyCigarettesCC enterCigrettes(String manyYears) {
        typeText(howManyCigarettes, manyYears);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
