package com.acurian.selenium.pages.CC.SUI_3923;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SUI_SubQuestionsCC extends MainPageCC{

    public final String titleExpected1 = "Have you had pelvic floor physical therapy (meaning that you worked with a physical therapist to improve functioning of the pelvic floor muscles) within the past 30 days?";
    public final String titleExpected2 = "Have you had a urethral bulking injection within the past 6 months?";
    public final String titleExpected3 = "Have you had a vaginal rejuvenation or MonaLisa Touch procedure within the past 6 months?";


    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;

    @FindBy(xpath = "")
    List<WebElement> checkBoxList;

    public SUI_SubQuestionsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SUI_SubQuestionsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public SUI_SubQuestionsCC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SUI_SubQuestionsCC clickOnAnswerForSubQuestion(String questionText, String answerText) {
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
