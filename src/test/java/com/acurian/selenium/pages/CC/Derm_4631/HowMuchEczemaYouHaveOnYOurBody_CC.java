package com.acurian.selenium.pages.CC.Derm_4631;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HowMuchEczemaYouHaveOnYOurBody_CC extends MainPageCC{

    public final String titleExpected = "We need to understand how much eczema you have on your body.\n" +
            "\n" +
            "Use your hand to cover all of the eczema patches currently on your skin. About how many hand prints does it take to cover all the eczema on your body?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='ddlist_container']//select")
    WebElement dropDownList;

    public HowMuchEczemaYouHaveOnYOurBody_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowMuchEczemaYouHaveOnYOurBody_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowMuchEczemaYouHaveOnYOurBody_CC selectFromDropDown(String answerText) {
    	selectDropDownListOptionByText(dropDownList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
