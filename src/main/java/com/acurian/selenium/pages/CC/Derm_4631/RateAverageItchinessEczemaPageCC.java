package com.acurian.selenium.pages.CC.Derm_4631;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class RateAverageItchinessEczemaPageCC extends MainPageCC {

    public final String titleExpected = "On a scale from 0 (no itch) to 10 (severe itch), how would you rate your average itchiness due to eczema?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='ddlist_container']//select")
    WebElement dropDownList;

    public RateAverageItchinessEczemaPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public RateAverageItchinessEczemaPageCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public RateAverageItchinessEczemaPageCC selectFromDropDown(String answerText) {
        selectDropDownListOptionByText(dropDownList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}