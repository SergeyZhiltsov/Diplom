package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionLastReceivedPageCC extends MainPageCC{

    public final String titleExpected1 = "Which of the following best describes when you last received Actemra? You….";
    public final String titleExpected2 = "Which of the following best describes when you last received Benlysta? You….";
    public final String titleExpected3 = "Which of the following best describes when you last received Cimzia? You….";
    public final String titleExpected4 = "Which of the following best describes when you last received Enbrel? You….";
    public final String titleExpected5 = "Which of the following best describes when you last received Entyvio? You….";
    public final String titleExpected6 = "Which of the following best describes when you last received Humira? You….";
    public final String titleExpected7 = "Which of the following best describes when you last received Kineret? You….";
    public final String titleExpected8 = "Which of the following best describes when you last received Orencia? You….";
    public final String titleExpected9 = "Which of the following best describes when you last received Raptiva? You….";
    public final String titleExpected10 = "Which of the following best describes when you last received Remicade? You….";
    public final String titleExpected11 = "Which of the following best describes when you last received Rituxan? You….";
    public final String titleExpected12 = "Which of the following best describes when you last received Simponi? You….";
    public final String titleExpected13 = "Which of the following best describes when you last received Stelara? You….";
    public final String titleExpected14 = "Which of the following best describes when you last received Taltz? You….";
    public final String titleExpected15 = "Which of the following best describes when you last received Tysabri? You….";
    public final String titleExpected16 = "Which of the following best describes when you last received Rituxan?";

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;

    @FindBy(xpath = "")
    List<WebElement> checkBoxList;

    public SubquestionLastReceivedPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionLastReceivedPageCC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionLastReceivedPageCC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionLastReceivedPageCC clickOnAnswerForSubQuestion(String questionText, String answerText) {
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
