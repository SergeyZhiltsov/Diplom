package com.acurian.selenium.pages.OLS.GERD;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HowLongHaveYouBeenTaking_OLS extends MainPageOLS {
    public final String titleExpected1 = "How long have you been taking Nexium (esomeprazole)?";
    public final String titleExpected2 = "How long have you been taking Prevacid (lansoprazole)?";
    public final String titleExpected3 = "How long have you been taking Prilosec (omeprazole)?";
    public final String titleExpected4 = "How long have you been taking Zegerid (omeprazole and sodium bicarbonate)?";
    public final String titleExpected5 = "How long have you been taking Aralen (chloroquine)?";
    public final String titleExpected6 = "How long have you been taking Arava (leflunomide)?";
    public final String titleExpected7 = "How long have you been taking Azulfidine or Sulfazine (sulfasalazine)?";
    public final String titleExpected8 = "How long have you been taking Plaquenil (hydroxychloroquine)?";
    
    
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;
    
    @FindBy(xpath = "(//div[contains(@class,'visible-md-block')])[1]")
    WebElement maintitleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;
    
   
    public HowLongHaveYouBeenTaking_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    
    @Step
    public HowLongHaveYouBeenTaking_OLS waitForMainPageLoad() {
        waitForAnimation();
        waitforVisibility(maintitleText);
        return this;
    }
    
    @Step
    public HowLongHaveYouBeenTaking_OLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public HowLongHaveYouBeenTaking_OLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public HowLongHaveYouBeenTaking_OLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public HowLongHaveYouBeenTaking_OLS clickOnAnswersForSubQuestion(int questionNumber, String ...answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("//ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public HowLongHaveYouBeenTaking_OLS clickOnAnswersForSubQuestion(String questionText, String ...answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("//ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }
}