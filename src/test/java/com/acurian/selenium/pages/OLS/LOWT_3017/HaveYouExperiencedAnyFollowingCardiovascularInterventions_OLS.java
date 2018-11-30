package com.acurian.selenium.pages.OLS.LOWT_3017;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS extends MainPageOLS{

    public final String titleExpected = "Have you experienced any of the following cardiovascular interventions or surgeries? \n" +
    		"Please select all that apply:";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
