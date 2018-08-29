package com.acurian.selenium.pages.OLS.ChronicCough;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyCigarettesOLS extends MainPageOLS{

    public final String titleExpected = "About how many cigarettes per day do you smoke?";
    
    public final String titleExpected1 = "About how many cigarettes per day did you smoke?";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//input[@id='QS6208B']")
    WebElement year;

    @FindBy(xpath = "//input[@id='QS6208D']")
    WebElement cigarettes;
    

    public HowManyCigarettesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyCigarettesOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public HowManyCigarettesOLS waitForPageLoad1() {
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }   

    @Step
    public HowManyCigarettesOLS enterYears(String number) {
        typeText(year, number);
        waitForAnimation();
        return this;
    }
    
    @Step
    public HowManyCigarettesOLS howManyCigarettes(String number) {
        typeText(cigarettes, number);
        waitForAnimation();
        return this;
    }    

}
