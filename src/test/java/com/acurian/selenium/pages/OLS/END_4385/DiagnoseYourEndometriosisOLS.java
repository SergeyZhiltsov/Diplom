package com.acurian.selenium.pages.OLS.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DiagnoseYourEndometriosisOLS extends MainPageOLS{

    
    public final String titleExpected = "Did your doctor perform any of the following procedures to help diagnose your endometriosis?\n" +
            "Please do not report any procedures you may have had to treat your endometriosis.\n" +
            "Please select all that apply.";
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

   
    public DiagnoseYourEndometriosisOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step    
    public DiagnoseYourEndometriosisOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
        public DiagnoseYourEndometriosisOLS clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
