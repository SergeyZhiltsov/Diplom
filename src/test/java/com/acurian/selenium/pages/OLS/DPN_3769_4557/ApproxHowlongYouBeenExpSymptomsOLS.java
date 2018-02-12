package com.acurian.selenium.pages.OLS.DPN_3769_4557;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class ApproxHowlongYouBeenExpSymptomsOLS extends MainPageOLS {
	public final String titleExpected = "Approximately how long have you been experiencing symptoms or sensations of diabetic nerve pain?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public ApproxHowlongYouBeenExpSymptomsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ApproxHowlongYouBeenExpSymptomsOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public ApproxHowlongYouBeenExpSymptomsOLS clickOnAnswer(String answerText) {
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