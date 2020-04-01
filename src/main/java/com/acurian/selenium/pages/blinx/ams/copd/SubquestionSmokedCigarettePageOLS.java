package com.acurian.selenium.pages.blinx.ams.copd;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SubquestionSmokedCigarettePageOLS extends MainPageBlinx {

    public final String titleExpected1 = "How many years did you smoke cigarettes?";
    public final String titleExpected2 = "How many years have you been smoking cigarettes?";
    public final String titleExpected3 = "About how many cigarettes per day do you smoke?";
    public final String titleExpected4 = "About how many cigarettes per day did you smoke?";

    @FindBy(xpath = "//div[@class='question-text' and contains(text(),'How many ')]")
    WebElement titleText1;

    @FindBy(xpath = "//div[@id='QS7407C']/div[contains(@class,'question-text')]")
    WebElement titleText2;

    @FindBy(xpath = "(//input[@class='noTelephone'])[1] | (//input[@class='noTelephone error'])[1] | //input[@class='noTelephone valid']") // I'm sorry for this sh*t
    WebElement firstField;

    @FindBy(xpath = "(//input[@class='noTelephone'])[2] | (//input[@class='noTelephone error'])[2] | //input[@class='noTelephone']") // I'm sorry for this sh*t
    WebElement secondField;

    public SubquestionSmokedCigarettePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SubquestionSmokedCigarettePageOLS waitForPageLoadHaveYouBeenSmoking() {
        waitForAnimation();
        try {
            waitForPageLoadMain(titleText1, titleExpected2);
        } catch (AssertionError e){
            waitForPageLoadMain(titleText1, titleExpected1);
        }
        return this;
    }

//    @Step
//    public SubquestionSmokedCigarettePageOLS waitForPageLoadDidYouSmoke() {
//        waitForAnimation();
//        waitForPageLoadMain(titleText2, titleExpected2);
//        return this;
//    }

    @Step
    public SubquestionSmokedCigarettePageOLS setFirst(String number) {
        typeTextWithoutClear(firstField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public SubquestionSmokedCigarettePageOLS setSecond(String number) {
        typeTextWithoutClear(secondField, number);
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText1() {
        return getText(titleText1);
    }

    @Step
    public String getTitleText2() {
        return getText(titleText2);
    }

}
