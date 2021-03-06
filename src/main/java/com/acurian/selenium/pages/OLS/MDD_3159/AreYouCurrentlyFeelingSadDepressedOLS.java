package com.acurian.selenium.pages.OLS.MDD_3159;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class AreYouCurrentlyFeelingSadDepressedOLS extends MainPageOLS {
	public final String titleExpected = "Are you currently feeling depressed, or experiencing any of the following symptoms?\n" +
    		"Lacking interest in activities you previously enjoyed\n" +
    		"Feeling guilty or worthless\n" +
    		"Having difficulty concentrating or making decisions\n" +
    		"Having trouble sleeping\n" +
    		"Significant weight gain or loss\n" +
    		"Fatigue or loss of energy";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyFeelingSadDepressedOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyFeelingSadDepressedOLS waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public AreYouCurrentlyFeelingSadDepressedOLS clickOnAnswer(String answerText) {
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
