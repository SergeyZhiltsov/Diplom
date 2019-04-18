package com.acurian.selenium.pages.OLS.OA_3138;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionCurrentlyTakingPainMedicationPageOLS extends MainPageOLS {

    private final String titleExpected = "Are you currently taking the following pain medication(s)?";
    public final String titleExpected1 = "Oxycodone (Oxaydo, Oxycontin, Roxicodone)";
    public final String titleExpected2 = "Oxycodone and acetaminophen (Endocet, Percocet, Primlev, Roxicet, Xartemis)";
    public final String titleExpected3 = "Hydrocodone (Hysingla, Zohydro)";
    public final String titleExpected4 = "Hydrocodone and acetaminophen (Hycet, Lortab, Norco, Verdrocet, Vicodin, Xodol, Zamicet)";
    public final String titleExpected5 = "Tramadol (ConZip, Synapryn FusePaq, Ultram)";
    public final String titleExpected6 = "Morphine (Astramorph, Duramorph, Infumorph, Kadian, MS Contin)";
    public final String titleExpected7 = "Morphine and naltrexone (Embeda)";
    public final String titleExpected8 = "Meperidine (Demerol, Meperitab)";
    public final String titleExpected9 = "Fentanyl (Abstral, Actiq, Fentora, Lazanda, Subsys)";
    public final String titleExpected10 = "Fentanyl patch (Duragesic, Ionsys)";
    public final String titleExpected11 = "Codeine";
    public final String titleExpected12 = "Tylenol #3 or Tylenol #4 (acetaminophen with codeine)";
    public final String titleExpected13 = "Capital with codeine";
    public final String titleExpected14 = "Oxymorphone (Opana)";
    public final String titleExpected15 = "Hydromorphone (Dilaudid, Exalgo)";
    public final String titleExpected16 = "Methadone (Dolophine, Intensol, Methadose)";
    public final String titleExpected17 = "Buprenorphine (Belbuca, Buprenex, Butrans)";
    public final String titleExpected18 = "Buprenorphine and naloxone (Suboxone)";
    public final String titleExpected19 = "Oxycodone and naloxone";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;

    public SubquestionCurrentlyTakingPainMedicationPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionCurrentlyTakingPainMedicationPageOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex - 1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionCurrentlyTakingPainMedicationPageOLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber - 1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionCurrentlyTakingPainMedicationPageOLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionCurrentlyTakingPainMedicationPageOLS clickOnAnswerForAllSubQuestion(String answerText) {
        titlesText.forEach(el -> {
            List<WebElement> checkBoxListFromTitle = el.findElements(
                    By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
            clickOnRadioButton(checkBoxListFromTitle, answerText);
        });
        return this;
    }

    @Step
    public String getTitleText(int titleIndex) {
        return getText(titlesText.get(titleIndex - 1));
    }

}
