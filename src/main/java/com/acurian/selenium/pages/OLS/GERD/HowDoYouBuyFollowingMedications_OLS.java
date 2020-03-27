package com.acurian.selenium.pages.OLS.GERD;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;


public class HowDoYouBuyFollowingMedications_OLS extends MainPageOLS{

	public final String titleExpected = "Some medications for heartburn, reflux, or GERD are available with or without a prescription from a doctor.\n" +
	"How do you buy the following medication(s)?";
	
    public final String titleExpected1 = "Nexium (esomeprazole)";
    public final String titleExpected2 = "Prevacid (lansoprazole)";
    public final String titleExpected3 = "Prilosec (omeprazole)";
    public final String titleExpected4 = "Zegerid (omeprazole and sodium bicarbonate)";

    
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;
    
    @FindBy(xpath = "(//div[contains(@class,'visible-md-block')])[1]")
    WebElement maintitleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;
    

    public HowDoYouBuyFollowingMedications_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    
    @Step
    public HowDoYouBuyFollowingMedications_OLS waitForMainPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }
    
    @Step
    public HowDoYouBuyFollowingMedications_OLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public HowDoYouBuyFollowingMedications_OLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public HowDoYouBuyFollowingMedications_OLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public HowDoYouBuyFollowingMedications_OLS clickOnAnswersForSubQuestion(int questionNumber, String ...answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("//ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public HowDoYouBuyFollowingMedications_OLS clickOnAnswersForSubQuestion(String questionText, String ...answerText) {
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