package com.acurian.selenium.pages.CC.AST_4337;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionSmokedCigarettePageCC extends MainPageCC{

    public final String titleExpected1 = "How many years have you been smoking cigarettes?";
    public final String titleExpected2 = "How many years did you smoke cigarettes?";
    public final String titleExpected3 = "About how many cigarettes per day do you smoke?";
    public final String titleExpected4 = "About how many cigarettes per day did you smoke?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;

    @FindBy(xpath = "//div[@class='subquestion'][1]//input[contains(@class,'input-text')]")
    WebElement firstField;

    @FindBy(xpath = "//div[@class='subquestion'][2]//input[contains(@class,'input-text')]")
    WebElement secondField;

    public SubquestionSmokedCigarettePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionSmokedCigarettePageCC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionSmokedCigarettePageCC setFirst(String number) {
        typeText(firstField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public SubquestionSmokedCigarettePageCC setSecond(String number) {
        typeText(secondField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
