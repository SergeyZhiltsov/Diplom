package com.acurian.selenium.pages.OLS;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageOLS extends BasePage{

    @FindBy(xpath = "//button[@id='submit']")
    WebElement nextButton;


    public MainPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    protected void waitForPageLoadMain(WebElement titleText, String titleExpected) {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
    }

    @Step
    public <T extends BasePage> T clickNextButton(T page) {
        nextButton.click();
        return (T)page;
    }


//MainPageOLS<Z> and DateOfBirthPageOLS extends MainPageOLS<DateOfBirthPageOLS>
//    public Z assertSome(){
//        return (Z)this;
//    }


}
