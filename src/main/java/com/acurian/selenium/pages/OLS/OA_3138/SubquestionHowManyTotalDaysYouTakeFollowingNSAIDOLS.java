package com.acurian.selenium.pages.OLS.OA_3138;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS extends MainPageOLS {

    private final String titleExpected = "During a typical week, how many total days do you take the following NSAID medication(s)?";
    public final String titleExpected1 = "Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)";
    public final String titleExpected2 = "Naproxen (Aleve, Naprosyn, Naprelan, Anaprox)";
    public final String titleExpected3 = "Ibuprofen (Motrin, Advil, Nuprin)";
    public final String titleExpected4 = "Indomethacin (Indocin)";
    public final String titleExpected5 = "Celebrex (celecoxib)";
    public final String titleExpected6 = "Meloxicam (Mobic)";
    public final String titleExpected7 = "Ketoprofen (Orudis, Oruvail)";
    public final String titleExpected8 = "Fenoprofen (Nalfon)";
    public final String titleExpected9 = "Diclofenac (Cataflam, Voltaren, Arthrotec)";
    public final String titleExpected10 = "Ketorolac (Sprix, Toradol)";
    public final String titleExpected11 = "Piroxicam (Feldene)";
    public final String titleExpected12 = "Flurbiprofen (Ansaid)";
    public final String titleExpected13 = "Magnesium salicylate (Arthritab, Bayer Select, Magan, Mobidin, Mobogesic)";
    public final String titleExpected14 = "Nabumetone (Relafen)";
    public final String titleExpected15 = "Oxaprozin (Daypro)";
    public final String titleExpected16 = "Sulindac";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    List<WebElement> titlesText;

    public SubquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS waitForPageLoad(int actualTitleIndex, String expectedTitle) {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        waitForPageLoadMain(titlesText.get(actualTitleIndex-1), expectedTitle);
        return this;
    }

    @Step
    public SubquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS clickOnAnswerForSubQuestion(int questionNumber, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.get(questionNumber-1)
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = titlesText.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public SubquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS clickOnAnswerForAllSubQuestion(String answerText) {
        titlesText.forEach(el -> {
            List<WebElement> checkBoxListFromTitle = el.findElements(
                    By.xpath("ancestor::div[contains(@class,'subquestion')]//span[contains(@class,'visible-md-inline')]"));
            clickOnRadioButton(checkBoxListFromTitle, answerText);
        });
        return this;
    }

    @Step
    public String getTitleText(int titleIndex){
        return getText(titlesText.get(titleIndex-1));
    }

}
