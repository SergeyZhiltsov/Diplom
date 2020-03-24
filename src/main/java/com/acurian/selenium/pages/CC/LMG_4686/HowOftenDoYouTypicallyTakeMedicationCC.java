package com.acurian.selenium.pages.CC.LMG_4686;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HowOftenDoYouTypicallyTakeMedicationCC extends MainPageCC{

    public final String titleExpected = "Some migraine medications are taken \"as needed\", as the migraine starts or while a migraine headache is occurring.\n" +
    		"How often do you typically take medication to stop an active migraine, either as it starts or while you are experiencing it?";
    

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HowOftenDoYouTypicallyTakeMedicationCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowOftenDoYouTypicallyTakeMedicationCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowOftenDoYouTypicallyTakeMedicationCC clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
