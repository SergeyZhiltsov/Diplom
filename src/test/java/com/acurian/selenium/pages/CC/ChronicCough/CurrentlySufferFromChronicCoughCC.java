package com.acurian.selenium.pages.CC.ChronicCough;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class CurrentlySufferFromChronicCoughCC extends MainPageCC{

    public final String titleExpected = "A chronic cough is a persistent cough that lasts more than 2 months. It can ruin your sleep and leave you feeling exhausted. Severe cases can cause you to vomit, feel lightheaded and even cause you to fracture your ribs.\n" +
    		"Do you currently suffer from chronic cough?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;    

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;
    
    public CurrentlySufferFromChronicCoughCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlySufferFromChronicCoughCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public CurrentlySufferFromChronicCoughCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
