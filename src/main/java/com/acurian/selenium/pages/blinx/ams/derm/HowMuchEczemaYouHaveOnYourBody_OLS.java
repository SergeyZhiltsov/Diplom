package com.acurian.selenium.pages.blinx.ams.derm;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HowMuchEczemaYouHaveOnYourBody_OLS extends MainPageBlinx {

    public final String titleExpected = "We need to understand how much eczema you have on your body.\n" +
            "\n" +
            "Use your hand to cover all of the eczema patches currently on your skin. About how many hand prints does it take to cover all the eczema on your body?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'dropdown')]/select")
    WebElement dropDownList;

    public HowMuchEczemaYouHaveOnYourBody_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowMuchEczemaYouHaveOnYourBody_OLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowMuchEczemaYouHaveOnYourBody_OLS selectFromDropDown(String answerText) {
        selectDropDownListOptionByText(dropDownList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
