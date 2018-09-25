package com.acurian.selenium.pages.OLS.GERD;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HowLongHaveYouBeenTaking_OLS extends MainPageOLS {
	public final String titleExpected = "Which of these pictures looks most similar to the amount of eczema (atopic dermatitis) currently on your legs and feet?\n" +
			"Please focus on the amount of skin covered by eczema (atopic dermatitis), rather than the pattern in the pictures. Answer choices appear below the pictures.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HowLongHaveYouBeenTaking_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongHaveYouBeenTaking_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HowLongHaveYouBeenTaking_OLS clickOnAnswer(String answerText) {
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
