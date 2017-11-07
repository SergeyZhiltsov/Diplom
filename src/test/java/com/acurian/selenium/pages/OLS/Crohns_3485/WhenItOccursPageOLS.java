package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class WhenItOccursPageOLS extends MainPageOLS{

    // Q21
    public final String titleExpected = "Many people with Crohn’s disease get used to their abdominal (stomach) pain or cramping over time.\n" +
            "Please think about the way you feel when you have abdominal pain and cramping from Crohn’s compared to when you are completely pain-free.\n" +
            "\n" +
            "Please use a 0 to 10 scale where 0 means it has mild to virtually no impact on your life and 10 means your Crohn’s severely impacts your life (you miss work/cancel plans).\n" +
            "\n" +
            "Please note that you can pick any number from 0 to 10.\n" +
            "\n" +
            "\n" +
            "\n" +
            "How would you rate the impact your cramping from Crohn’s has on your life when it occurs?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[@class='question']//input")
    WebElement ratingField;

    public WhenItOccursPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenItOccursPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenItOccursPageOLS setRating(String number) {
        typeText(ratingField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}
