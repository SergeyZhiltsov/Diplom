package com.acurian.selenium.pages.OLS.MDD_3159;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class CurrentEpisodeOfDepressionOLS extends MainPageOLS {
	public final String titleExpected = "We'd like to make a distinction between the beginning of your depression overall versus the beginning of your current episode of depression.\n" +
			"When did your current episode of depression start?\n" +
			"If you are unsure, please take your best guess.";			
    
    
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public CurrentEpisodeOfDepressionOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentEpisodeOfDepressionOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public CurrentEpisodeOfDepressionOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
