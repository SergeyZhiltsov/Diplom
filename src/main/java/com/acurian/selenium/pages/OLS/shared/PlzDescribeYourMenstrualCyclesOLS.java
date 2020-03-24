package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;


public class PlzDescribeYourMenstrualCyclesOLS extends MainPageOLS{

    public final String titleExpected = "Please describe your menstrual cycles:";
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;
    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    
    public PlzDescribeYourMenstrualCyclesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step    
    public PlzDescribeYourMenstrualCyclesOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step    
    public PlzDescribeYourMenstrualCyclesOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step    
    public String getTitleText(){
        return getText(titleText);
    }
}
