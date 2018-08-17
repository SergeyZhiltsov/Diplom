package com.acurian.selenium.pages.CC.Derm_4631;

import com.acurian.selenium.constants.Locators;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC extends MainPageCC{

    public final String titleExpectedKAD = "Are you currently receiving regular doses of any of the following \"biologic\" medications?\n" +
    		"\"Biologics\" are medications that affect the body's immune system. They are given as an infusion (into a vein) or an injection (a shot under the skin).\n" +
    		"Agent Notes:\n" +
    		"Please read the full list of medications to the respondent\n" +
    		"Select all that apply";
    
    public final String titleExpected = "Are you currently receiving regular doses of any of the following \"biologic\" medications?\n" +
    		"\"Biologics\" are medications that affect the body’s immune system.  They are given as an infusion (into a vein) or injection (a shot under the skin).\n" +
    		"Please select all that apply.\n" +    		
    		"·  Please read the full list of medications to the respondent\n" +
    		"·  Select all that apply";
    		
    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    
    @Step
    public AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC waitForPageLoadKAD() {
    	waitForPageLoadMain(titleText, titleExpectedKAD);
        return this;
    }

    @Step
    public AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC clickOnAnswers(String ...answerText) {
        List<String> answerTextList = Arrays.asList(answerText);
        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
                .forEach(el -> el.click());
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

	
}
