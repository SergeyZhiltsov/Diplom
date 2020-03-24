package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowManyLiquidPageCC extends MainPageCC{

    public final String titleExpected = "How many liquid or very soft bowel movements (episodes of diarrhea) do you have in an average day?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;

    @FindBy(xpath = "//div[@class='subquestion'][1]//input[contains(@class,'input-text')]")
    WebElement dayField;

    @FindBy(xpath = "//div[@class='subquestion'][2]//input[contains(@class,'input-text')]")
    WebElement hoursField;

    public HowManyLiquidPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyLiquidPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyLiquidPageCC setDayRating(String number) {
        typeText(dayField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public HowManyLiquidPageCC setHoursRating(String number) {
        typeText(hoursField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
