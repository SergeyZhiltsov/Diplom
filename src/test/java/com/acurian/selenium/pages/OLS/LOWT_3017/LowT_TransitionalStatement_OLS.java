package com.acurian.selenium.pages.OLS.LOWT_3017;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class LowT_TransitionalStatement_OLS extends MainPageOLS{

    public final String titleExpected = "Thank you for answering these initial questions.\n" +
    		"We would like to ask you a few more questions about your health to better match you with a research study in your area.\n" +
    		"You may be asked similar information in this next set of questions. We appreciate your patience.";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public LowT_TransitionalStatement_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LowT_TransitionalStatement_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public LowT_TransitionalStatement_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
