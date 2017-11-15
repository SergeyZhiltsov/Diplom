package com.acurian.selenium.pages.OLS.Insomnia_3792;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HasAHealthcareProfessionalEverDiagnosedYou_OLS extends MainPageOLS{

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following sleep related conditions?\n" + 
"Please select all that apply.";
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public HasAHealthcareProfessionalEverDiagnosedYou_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasAHealthcareProfessionalEverDiagnosedYou_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasAHealthcareProfessionalEverDiagnosedYou_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
