package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowManyLiquidPageOLS extends MainPageOLS{

    public final String titleExpected = "How many liquid or very soft bowel movements (episodes of diarrhea) do you have in an average day?";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//input")
    WebElement dayField;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//input")
    WebElement hoursField;

    public HowManyLiquidPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyLiquidPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyLiquidPageOLS setDayRating(String number) {
        typeText(dayField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public HowManyLiquidPageOLS setHoursRating(String number) {
        typeText(hoursField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
