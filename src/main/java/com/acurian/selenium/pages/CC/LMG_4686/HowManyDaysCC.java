package com.acurian.selenium.pages.CC.LMG_4686;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyDaysCC extends MainPageCC{

    public final String titleExpected = "In the past month, how many days did you take any of the medications you just mentioned in the previous question?";

    @FindBy(xpath = "//div[@class='question_text']/div[@class='show-in-cc']")
    WebElement titleText;    

    @FindBy(xpath = "//div[@class='ddlist_container']//select")
    WebElement chooseDays;
    
    public HowManyDaysCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyDaysCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowManyDaysCC selectDay(String text) {        
    	selectDropDownListOptionByText(chooseDays, text);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
