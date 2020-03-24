package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class WhenYouAreInClusterPeriodHowOften_OLS extends MainPageOLS {
	public final String titleExpected = "A cluster headache attack is when you are actually experiencing severe headache pain.\n" +
			"When you are in a cluster period, how often do you have cluster headache attacks?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public WhenYouAreInClusterPeriodHowOften_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenYouAreInClusterPeriodHowOften_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhenYouAreInClusterPeriodHowOften_OLS clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
