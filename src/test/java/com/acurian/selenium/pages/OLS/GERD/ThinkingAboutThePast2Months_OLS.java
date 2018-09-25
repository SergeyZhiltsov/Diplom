package com.acurian.selenium.pages.OLS.GERD;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class ThinkingAboutThePast2Months_OLS extends MainPageOLS {
	public final String titleExpected = "Thinking about the past 2 months, about how many days per week have you experienced symptoms of heartburn, reflux, or GERD?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public ThinkingAboutThePast2Months_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThinkingAboutThePast2Months_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public ThinkingAboutThePast2Months_OLS clickOnAnswer(String answerText) {
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
