package com.acurian.selenium.pages.OLS.SUI_3923;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DoYouExperienceUrinaryIncontinenceOLS extends MainPageOLS{

    public final String titleExpected = "Do you experience either of the following types of urinary leakage, sometimes called urinary incontinence?\n" + 
"Please select all that apply.";
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public DoYouExperienceUrinaryIncontinenceOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouExperienceUrinaryIncontinenceOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouExperienceUrinaryIncontinenceOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
