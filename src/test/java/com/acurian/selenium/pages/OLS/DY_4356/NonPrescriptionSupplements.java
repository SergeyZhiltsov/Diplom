package com.acurian.selenium.pages.OLS.DY_4356;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class NonPrescriptionSupplements extends MainPageOLS{

    public final String titleExpected = "Are you currently taking any of the following non-prescription supplements or food products on a daily basis?\n" +
            "Please select all that apply.";
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public NonPrescriptionSupplements() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NonPrescriptionSupplements waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public NonPrescriptionSupplements clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
