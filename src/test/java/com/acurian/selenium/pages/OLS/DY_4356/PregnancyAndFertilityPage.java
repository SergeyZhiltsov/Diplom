package com.acurian.selenium.pages.OLS.DY_4356;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class PregnancyAndFertilityPage extends MainPageOLS{

    public final String titleExpected = "Clinical trials often have requirements related to pregnancy and fertility.\n" +
            "Please select the option which most closely applies to you:";
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'radio-question')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    public PregnancyAndFertilityPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PregnancyAndFertilityPage waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PregnancyAndFertilityPage clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
