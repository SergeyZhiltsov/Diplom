package com.acurian.selenium.pages.OLS.Insomnia_3792;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class AreYouCurrentlyTakingAnyPrescriptionNedications_OLS extends MainPageOLS{

    public final String titleExpected = "Are you currently taking any of the following prescription medications to help you sleep?\n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public AreYouCurrentlyTakingAnyPrescriptionNedications_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyTakingAnyPrescriptionNedications_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyTakingAnyPrescriptionNedications_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
