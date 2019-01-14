package com.acurian.selenium.pages.OLS.Derm;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS extends MainPageOLS{

    public final String titleExpected = "Are you currently receiving regular doses of any of the following \"biologic\" medications?\n" +
    		"\"Biologics\" are medications that affect the body's immune system. They are given as an infusion (into a vein) or an injection (a shot under the skin).\n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
