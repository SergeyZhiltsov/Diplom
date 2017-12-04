package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;


public class HaveRegularMenstrualCyclesOLS extends MainPageOLS{

    public final String titleExpected = "Do you have regular menstrual cycles, meaning that you get your period each month on a predictable schedule?";   
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;
    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    
    public HaveRegularMenstrualCyclesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step    
    public HaveRegularMenstrualCyclesOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step    
    public HaveRegularMenstrualCyclesOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step    
    public String getTitleText(){
        return getText(titleText);
    }
}
