package com.acurian.selenium.pages.blinx.ams.chronic_cough;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyCigarettesOLS extends MainPageBlinx {

    public final String titleExpected = "How many years have you been smoking cigarettes?";

    public final String titleExpected1 = "How many years did you smoke cigarettes?";

    @FindBy(xpath = "(//div[@class='question-text'])[2]")
    WebElement titleText;

    @FindBy(xpath = "(//input[@class='noTelephone'])[1]")
    WebElement year;

    @FindBy(xpath = "//input[@class='noTelephone'] | //input[@class='noTelephone error']")
    WebElement cigarettes;

    @FindBy(xpath = "(//input[@class='noTelephone valid'])[1]")
    WebElement yearNotForFirstTime;

    public HowManyCigarettesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyCigarettesOLS waitForPageLoad() {
        waitForAnimation();
        try {
            waitForPageLoadMain(titleText, titleExpected);
        } catch (AssertionError e) {
            waitForPageLoadMain(titleText, titleExpected1);
        }
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    @Step
    public HowManyCigarettesOLS enterYears(String number) {
        typeText(year, number);
        waitForAnimation();
        return this;
    }

    @Step
    public HowManyCigarettesOLS howManyCigarettes(String number) {
        try {
            typeText(cigarettes, number);
        } catch (NoSuchElementException e) {
            typeText(cigarettes, number);
        }
        waitForAnimation();
        return this;
    }
}
