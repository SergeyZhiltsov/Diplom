package com.acurian.selenium.pages.CC.PSO_456;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowMuchPsoriasisOnYourBodyCC extends MainPageCC {
    public final String titleExpected = "We need to understand how much psoriasis you have on your body.\n" +
            "\n" +
            "Use your hand to cover all of the psoriasis patches currently on your skin. About how many hand prints does it take to cover all the psoriasis on your body?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='ddlist_container']//select")
    WebElement dropDownList;

    public HowMuchPsoriasisOnYourBodyCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowMuchPsoriasisOnYourBodyCC waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowMuchPsoriasisOnYourBodyCC selectFromDropDown(String answerText) {
        selectDropDownListOptionByText(dropDownList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
