package com.acurian.selenium.pages.CC.LMG_4686;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyDifferentMedicationsCC extends MainPageCC{

    public final String titleExpected = "Medications to prevent migraine headaches are taken daily or regularly, not just when a migraine headache is occurring.\n" + 
    		"Over the past 10 years, how many different medications to prevent migraines have you tried?\n" +
    		"Please include any medications you are currently taking to prevent migraines.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;
    
    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement noOfMedication;
    
    public HowManyDifferentMedicationsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyDifferentMedicationsCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowManyDifferentMedicationsCC diffMedication(String text) {
        typeText(noOfMedication, text);
        return this;
    }
    

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
