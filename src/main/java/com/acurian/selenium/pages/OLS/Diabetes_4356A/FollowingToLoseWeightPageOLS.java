package com.acurian.selenium.pages.OLS.Diabetes_4356A;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FollowingToLoseWeightPageOLS extends MainPageOLS{

    public final String titleExpected = "Are you currently using any of the following to lose weight?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    public FollowingToLoseWeightPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingToLoseWeightPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FollowingToLoseWeightPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
