package com.acurian.selenium.pages.blinx.ams.diabetes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class NoOfAlcoholicDrinkOLS extends MainPageBlinx {

    public final String titleExpected = "Alcohol consumption can affect your liver health over time.\n" +
            "About how many alcoholic drinks do you have in a typical week?\n" +
            "One standard drink is equivalent to a can of beer, a glass of wine, or a shot of hard liquor.\n" +
            "\n" +
            "Number of alcoholic drinks in a week:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = "//input[@type='text']")
    WebElement enterDrinks;

    public NoOfAlcoholicDrinkOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NoOfAlcoholicDrinkOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public NoOfAlcoholicDrinkOLS setDrinks(String drinks) {
        typeText(enterDrinks, drinks);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
