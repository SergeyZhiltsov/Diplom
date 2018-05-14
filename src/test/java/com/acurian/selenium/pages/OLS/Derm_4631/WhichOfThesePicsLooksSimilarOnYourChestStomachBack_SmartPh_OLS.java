package com.acurian.selenium.pages.OLS.Derm_4631;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class WhichOfThesePicsLooksSimilarOnYourChestStomachBack_SmartPh_OLS extends MainPageOLS {
	public final String titleExpected = "Which of these pictures looks most similar to the amount of eczema (atopic dermatitis) currently on your chest, stomach, and back?\n" +
			"Please focus on the amount of skin covered by eczema (atopic dermatitis), rather than the pattern in the pictures. Answer choices appear below the pictures.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public WhichOfThesePicsLooksSimilarOnYourChestStomachBack_SmartPh_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfThesePicsLooksSimilarOnYourChestStomachBack_SmartPh_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhichOfThesePicsLooksSimilarOnYourChestStomachBack_SmartPh_OLS clickOnAnswer(String answerText) {
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
