package com.acurian.selenium.pages.OLS.RA;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class FollowingJointSymptoms  extends MainPageOLS {
	public final String titleExpected = "Are you currently experiencing any of the following joint symptoms associated with your RA?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS508_')]/span[@class='copy']")
    List<WebElement> checkBoxList;

    public FollowingJointSymptoms() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingJointSymptoms waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public FollowingJointSymptoms clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
