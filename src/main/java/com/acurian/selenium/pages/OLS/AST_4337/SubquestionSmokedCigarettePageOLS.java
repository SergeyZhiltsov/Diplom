package com.acurian.selenium.pages.OLS.AST_4337;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionSmokedCigarettePageOLS extends MainPageOLS{

    public final String titleExpected1 = "How many years have you been smoking cigarettes?";
    public final String titleExpected2 = "How many years did you smoke cigarettes?";
    public final String titleExpected3 = "About how many cigarettes per day do you smoke?";
    public final String titleExpected4 = "About how many cigarettes per day did you smoke?";

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//input")
    WebElement firstField;

    @FindBy(xpath = "//div[contains(@class,'subquestion')][2]//input")
    WebElement secondField;

    public SubquestionSmokedCigarettePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionSmokedCigarettePageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionSmokedCigarettePageOLS setFirst(String number) {
        typeText(firstField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public SubquestionSmokedCigarettePageOLS setSecond(String number) {
        typeText(secondField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
