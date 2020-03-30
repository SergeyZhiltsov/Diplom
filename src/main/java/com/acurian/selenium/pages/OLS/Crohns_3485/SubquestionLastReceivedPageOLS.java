package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionLastReceivedPageOLS extends MainPageOLS{

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


    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;

//    @FindBy(xpath = "//div[contains(@class,'subquestion')][1]//span[contains(@class,'visible-md-inline')]")
//    List<WebElement> checkBoxList;

    public SubquestionLastReceivedPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionLastReceivedPageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionLastReceivedPageOLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }
    // can be an issue with ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]
    // because clickOnRadioButton method use label at the end, so need add ancestor::label

    @Step
    public SubquestionLastReceivedPageOLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}
