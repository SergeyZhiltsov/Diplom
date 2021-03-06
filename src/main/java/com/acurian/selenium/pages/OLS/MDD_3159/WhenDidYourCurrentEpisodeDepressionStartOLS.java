package com.acurian.selenium.pages.OLS.MDD_3159;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class WhenDidYourCurrentEpisodeDepressionStartOLS extends MainPageOLS {
	public final String titleExpected = "When did your current episode of depression start?\n" +
			"If you are unsure, please take your best guess.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public WhenDidYourCurrentEpisodeDepressionStartOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenDidYourCurrentEpisodeDepressionStartOLS waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhenDidYourCurrentEpisodeDepressionStartOLS clickOnAnswer(String answerText) {
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
