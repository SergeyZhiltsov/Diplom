package com.acurian.selenium.pages.OLS.SUI_3923;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HowLongYouBeenExperiencingUrinaryLeakageOLS extends MainPageOLS {
	public final String titleExpected = "How long have you been experiencing urinary leakage?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> radioButtonsList;

    public HowLongYouBeenExperiencingUrinaryLeakageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongYouBeenExperiencingUrinaryLeakageOLS waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public HowLongYouBeenExperiencingUrinaryLeakageOLS clickOnAnswer(String answerText) {
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
