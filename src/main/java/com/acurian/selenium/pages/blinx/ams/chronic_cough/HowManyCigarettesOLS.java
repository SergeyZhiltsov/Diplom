package com.acurian.selenium.pages.blinx.ams.chronic_cough;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyCigarettesOLS extends MainPageBlinx {

    public final String titleExpected = "About how many cigarettes per day do you smoke?";

    public final String titleExpected1 = "About how many cigarettes per day did you smoke?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = "//input[@id='QS6208B']")
    WebElement year;

    @FindBy(xpath = "//input[@id='QS6208D']")
    WebElement cigarettes;

    public HowManyCigarettesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyCigarettesOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyCigarettesOLS waitForPageLoad1() {
        waitForPageLoadMain(titleText, titleExpected1);
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
        typeText(cigarettes, number);
        waitForAnimation();
        return this;
    }

}
