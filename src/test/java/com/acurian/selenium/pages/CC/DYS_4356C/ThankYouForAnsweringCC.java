package com.acurian.selenium.pages.CC.DYS_4356C;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouForAnsweringCC extends MainPageCC {

    public final String titleExpected = "Thank you for answering these specific health questions.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
    		"Agent Note: If \"no\" to all items in a question, select \"None of the above\"";

    @FindBy(xpath = "//div[@class='question_container']//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//button[@id='nextButton']")
    WebElement nextButton;

    public ThankYouForAnsweringCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public  ThankYouForAnsweringCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;        
        
    }
    
    @Step
    public  ThankYouForAnsweringCC clickNext() {
       nextButton.click();
       return this;    
       
    }    
 }
