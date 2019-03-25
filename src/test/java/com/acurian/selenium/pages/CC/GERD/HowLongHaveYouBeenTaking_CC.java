package com.acurian.selenium.pages.CC.GERD;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowLongHaveYouBeenTaking_CC extends MainPageCC{

    public final String titleExpected1 = "How long have you been taking Aciphex (rabeprazole)? (Agent Note: AH-si-fex, ruh-BEP-ruh-zole)";
    public final String titleExpected2 = "How long have you been taking Dexilant (dexlansoprazole)? (Agent Note: DEX-ih-lant, dex-lan-SOP-ruh-zole)";
    public final String titleExpected3 = "How long have you been taking Protonix (pantoprazole)? (Agent Note: pro-TAHN-ix, pan-TOP-ruh-zole)";
    public final String titleExpected4 = "How long have you been taking Nexium (esomeprazole)? (Agent Note: NEX-ee-um, eh-so-MEP-ruh-zole)";
    public final String titleExpected5 = "How long have you been taking Prevacid (lansoprazole)? (Agent Note: PREV-uh-sid, lan-SOP-ruh-zole)";
    public final String titleExpected6 = "How long have you been taking Prilosec (omeprazole)? (Agent Note: PRY-lo-sec, oh-MEP-ruh-zole)";
    public final String titleExpected7 = "How long have you been taking Zegerid (omeprazole and sodium bicarbonate)? (Agent Note: ZEGG-er-rid, oh-MEP-ruh-zole, SO-dee-um bi-CAR-bo-nate)";
    public final String titleExpected8 = "How long have you been taking Aralen (chloroquine)?";
    public final String titleExpected9 = "How long have you been taking Arava (leflunomide)?";
    public final String titleExpected10 = "How long have you been taking Azulfidine or Sulfazine (sulfasalazine)?";
    public final String titleExpected11 = "How long have you been taking Plaquenil (hydroxychloroquine)?";
    

    @FindBy(xpath = "//div[@class='subquestion'][1]//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    List<WebElement> titlesText;


    public HowLongHaveYouBeenTaking_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongHaveYouBeenTaking_CC waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public HowLongHaveYouBeenTaking_CC clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public HowLongHaveYouBeenTaking_CC clickOnAnswerForSubQuestion(String questionText, String answerText) {
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