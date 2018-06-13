package com.acurian.selenium.pages.OLS.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyTimesDidYouGetYourPeriodInThreeMons_OLS extends MainPageOLS {
    public final String titleExpected = "Please think about your most recent menstrual cycles.\n" +
    		"How many times did you get your period in the past three months?";
			
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HowManyTimesDidYouGetYourPeriodInThreeMons_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyTimesDidYouGetYourPeriodInThreeMons_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HowManyTimesDidYouGetYourPeriodInThreeMons_OLS clickOnAnswer(String answerText) {
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
