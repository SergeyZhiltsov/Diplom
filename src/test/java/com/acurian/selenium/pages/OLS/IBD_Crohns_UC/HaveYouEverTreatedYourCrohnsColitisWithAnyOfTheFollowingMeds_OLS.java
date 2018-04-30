package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS extends MainPageOLS{

    public final String titleExpected = "Have you ever treated your Crohn's or colitis with any of the following medications that suppress your immune system?\n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public HaveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverTreatedYourCrohnsColitisWithAnyOfTheFollowingMeds_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
