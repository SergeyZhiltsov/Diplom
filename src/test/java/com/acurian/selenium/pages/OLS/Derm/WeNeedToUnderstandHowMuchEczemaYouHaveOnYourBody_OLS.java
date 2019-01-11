package com.acurian.selenium.pages.OLS.Derm;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.Derm_4631.WeNeedToUnderstandHowMuchEczemaYouHaveOnYOurBody_CC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class WeNeedToUnderstandHowMuchEczemaYouHaveOnYourBody_OLS extends MainPageOLS {

    public final String titleExpected = "We need to understand how much eczema you have on your body. Use your hand to cover all of the eczema patches currently on your skin. " +
            "About how many hand prints does it take to cover all the eczema on your body?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[contains(@class,'dropdown')]/select")
    WebElement dropDownList;

    public WeNeedToUnderstandHowMuchEczemaYouHaveOnYourBody_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WeNeedToUnderstandHowMuchEczemaYouHaveOnYourBody_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WeNeedToUnderstandHowMuchEczemaYouHaveOnYourBody_OLS selectFromDropDown(String answerText) {
        selectDropDownListOptionByText(dropDownList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
