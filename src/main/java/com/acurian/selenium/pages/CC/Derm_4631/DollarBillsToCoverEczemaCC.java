package com.acurian.selenium.pages.CC.Derm_4631;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class DollarBillsToCoverEczemaCC extends MainPageCC {
    public final String titleExpected = "How many dollar bills would it take to cover all the eczema on your skin?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='ddlist_container']//select")
    WebElement dropDownList;

    public DollarBillsToCoverEczemaCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DollarBillsToCoverEczemaCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DollarBillsToCoverEczemaCC selectFromDropDown(String answerText) {
        selectDropDownListOptionByText(dropDownList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
