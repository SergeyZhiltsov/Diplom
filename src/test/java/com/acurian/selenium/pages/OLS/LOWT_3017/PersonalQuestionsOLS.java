package com.acurian.selenium.pages.OLS.LOWT_3017;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class PersonalQuestionsOLS extends MainPageOLS{

    public final String titleExpected = "These next few rather personal questions will help us assess your health status to better match you with a research study in your area. " +
            "We appreciate your participation.";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public PersonalQuestionsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PersonalQuestionsOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }   

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
