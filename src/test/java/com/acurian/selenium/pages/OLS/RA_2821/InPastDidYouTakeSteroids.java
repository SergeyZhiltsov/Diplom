package com.acurian.selenium.pages.OLS.RA_2821;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class InPastDidYouTakeSteroids extends MainPageOLS {
	public final String titleExpected = "In the past, did you have to take any steroids for your RA?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS513_')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public InPastDidYouTakeSteroids() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InPastDidYouTakeSteroids waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public InPastDidYouTakeSteroids clickOnAnswer(String answerText) {
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
