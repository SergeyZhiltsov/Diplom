package com.acurian.selenium.pages.OLS.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class LaparoscopyAndLaparotomyOLS extends MainPageOLS{

    public final String titleExpected = "Laparoscopy and laparotomy are the surgical procedures used to confirm a diagnosis of endometriosis.\n" +
            "When was the surgical procedure which confirmed your endometriosis performed?";
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    
    public LaparoscopyAndLaparotomyOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step    
    public LaparoscopyAndLaparotomyOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step    
    public LaparoscopyAndLaparotomyOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step    
    public String getTitleText(){
        return getText(titleText);
    }

}
