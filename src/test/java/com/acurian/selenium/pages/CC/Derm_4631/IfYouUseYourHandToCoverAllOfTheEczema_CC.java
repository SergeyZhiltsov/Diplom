package com.acurian.selenium.pages.CC.Derm_4631;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class IfYouUseYourHandToCoverAllOfTheEczema_CC extends MainPageCC{

    public final String titleExpected = "If you use your hand to cover all of the eczema (atopic dermatitis) patches currently on your skin, approximately how many hand prints does it take to cover all the affected areas?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='ddlist_container']//select")
    WebElement dropDownList;

    public IfYouUseYourHandToCoverAllOfTheEczema_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public IfYouUseYourHandToCoverAllOfTheEczema_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public IfYouUseYourHandToCoverAllOfTheEczema_CC selectFromDropDown(String answerText) {
    	selectDropDownListOptionByText(dropDownList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
