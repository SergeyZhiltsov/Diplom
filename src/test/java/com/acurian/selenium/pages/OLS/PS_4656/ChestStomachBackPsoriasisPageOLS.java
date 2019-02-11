package com.acurian.selenium.pages.OLS.PS_4656;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ChestStomachBackPsoriasisPageOLS extends MainPageOLS {

    public final String titleExpected = "Which of these pictures looks most similar to the amount of psoriasis currently on your chest, stomach, and back?\n" +
            "Please focus on the amount of skin covered by psoriasis, rather than the pattern in the pictures. Answer choices appear below the pictures.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public ChestStomachBackPsoriasisPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ChestStomachBackPsoriasisPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForImagesToLoad();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public ChestStomachBackPsoriasisPageOLS clickOnAnswer(String answerText) {
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
