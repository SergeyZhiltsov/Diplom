package com.acurian.selenium.pages.CC.MDD_3159;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionWhenDidYouTakeFollowingMeds_CC extends MainPageCC{

    public final String titleExpected1 = "Celexa (citalopram)";
    public final String titleExpected2 = "Cymbalta (duloxetine)";
    public final String titleExpected3 = "Effexor (venlafaxine)";
    public final String titleExpected4 = "Fetzima (levomilnacipran)";
    public final String titleExpected5 = "Other antidepressant not listed";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;

    @FindBy(xpath = "")
    List<WebElement> checkBoxList;

    public SubquestionWhenDidYouTakeFollowingMeds_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionWhenDidYouTakeFollowingMeds_CC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionWhenDidYouTakeFollowingMeds_CC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionWhenDidYouTakeFollowingMeds_CC clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }


}
