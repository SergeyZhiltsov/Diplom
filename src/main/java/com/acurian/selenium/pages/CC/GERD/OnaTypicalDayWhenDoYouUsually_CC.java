package com.acurian.selenium.pages.CC.GERD;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OnaTypicalDayWhenDoYouUsually_CC extends MainPageCC{

    public final String titleExpected1 = "On a typical day, when do you usually take Nexium (esomeprazole)? (Agent Note: NEX-ee-um, eh-so-MEP-ruh-zole)\n"+
            "Agent Note: Select all that apply";
    public final String titleExpected2 = "On a typical day, when do you usually take Prevacid (lansoprazole)? (Agent Note: PREV-uh-sid, lan-SOP-ruh-zole)\n"+
            "Agent Note: Select all that apply";
    public final String titleExpected3 = "On a typical day, when do you usually take Prilosec (omeprazole)? (Agent Note: PRY-lo-sec, oh-MEP-ruh-zole)\n"+
            "Agent Note: Select all that apply";
    public final String titleExpected4 = "On a typical day, when do you usually take Zegerid (omeprazole and sodium bicarbonate)? (Agent Note: ZEGG-er-rid, oh-MEP-ruh-zole, SO-dee-um bi-CAR-bo-nate)\n"+
            "Agent Note: Select all that apply";
    public final String titleExpected5 = "On a typical day, when do you usually take Aciphex (rabeprazole)? (Agent Note: AH-si-fex, ruh-BEP-ruh-zole)\n"+
            "Agent Note: Select all that apply";
    public final String titleExpected6 = "On a typical day, when do you usually take Dexilant (dexlansoprazole)? (Agent Note: DEX-ih-lant, dex-lan-SOP-ruh-zole)\n"+
            "Agent Note: Select all that apply";
    public final String titleExpected7 = "On a typical day, when do you usually take Protonix (pantoprazole)? (Agent Note: pro-TAHN-ix, pan-TOP-ruh-zole)\n"+
            "Agent Note: Select all that apply";


    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;
////div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']

    public OnaTypicalDayWhenDoYouUsually_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OnaTypicalDayWhenDoYouUsually_CC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public OnaTypicalDayWhenDoYouUsually_CC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("//div[@class='checkboxes_container']//span[@class='show-in-cc']"));
        clickOnCheckBoxes(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public OnaTypicalDayWhenDoYouUsually_CC clickOnAnswerForSubQuestion(String questionText, String answerText) {
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