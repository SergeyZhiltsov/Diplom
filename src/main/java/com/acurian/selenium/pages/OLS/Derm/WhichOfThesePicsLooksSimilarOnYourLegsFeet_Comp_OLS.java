package com.acurian.selenium.pages.OLS.Derm;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS extends MainPageOLS {
    public final String titleExpected = "Which of these pictures looks most similar to the amount of eczema currently on your legs and feet?\n" +
            "Please focus on the amount of skin covered by eczema, rather than the pattern in the pictures. Answer choices appear below the pictures.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS waitForPageLoad() {
        waitForAnimation();
        waitForImagesToLoad();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhichOfThesePicsLooksSimilarOnYourLegsFeet_Comp_OLS clickOnAnswer(String answerText) {
        for (int i = 0; i < 2; i++) {
            getActions().moveToElement(radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                    .findFirst()
                    .get())
                    .click()
                    .build()
                    .perform();
        }
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
