package com.acurian.selenium.pages.CC.GERD;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowDoYouBuyFollowingMedications_CC extends MainPageCC{

    public final String titleExpected1 = "Nexium (esomeprazole) (Agent Note: NEX-ee-um, eh-so-MEP-ruh-zole)";
    public final String titleExpected2 = "Prevacid (lansoprazole) (Agent Note: PREV-uh-sid, lan-SOP-ruh-zole)";
    public final String titleExpected3 = "Prilosec (omeprazole) (Agent Note: PRY-lo-sec, oh-MEP-ruh-zole)";
    public final String titleExpected4 = "Zegerid (omeprazole and sodium bicarbonate) (Agent Note: ZEGG-er-rid, oh-MEP-ruh-zole, SO-dee-um bi-CAR-bo-nate)";


    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;


    public HowDoYouBuyFollowingMedications_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowDoYouBuyFollowingMedications_CC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public HowDoYouBuyFollowingMedications_CC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public HowDoYouBuyFollowingMedications_CC clickOnAnswerForSubQuestion(String questionText, String answerText) {
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
