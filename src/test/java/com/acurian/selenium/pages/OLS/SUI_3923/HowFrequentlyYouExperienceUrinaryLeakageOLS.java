package com.acurian.selenium.pages.OLS.SUI_3923;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HowFrequentlyYouExperienceUrinaryLeakageOLS extends MainPageOLS {
	public final String titleExpected = "During a typical day, how frequently do you experience urinary leakage?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HowFrequentlyYouExperienceUrinaryLeakageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowFrequentlyYouExperienceUrinaryLeakageOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HowFrequentlyYouExperienceUrinaryLeakageOLS clickOnAnswer(String answerText) {
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
