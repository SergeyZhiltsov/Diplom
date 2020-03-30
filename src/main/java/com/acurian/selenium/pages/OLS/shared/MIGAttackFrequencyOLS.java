package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.shared.StudyQuestionMigPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.MetforminMedicationsPageOLS;

import ru.yandex.qatools.allure.annotations.Step;


public class MIGAttackFrequencyOLS extends MainPageOLS {

   public final String titleExpected ="A migraine attack could last from a few hours to a few days. If you have a migraine that starts on Monday and ends on Tuesday, that is one migraine attack but two migraine days.\n" +
           "If you don't remember the exact numbers, please take your best guess.";

/*   public final String titleExpected1 ="In a typical month, how many separate migraine attacks do you have?\n"+
    		"Remember, a migraine attack could last from a few hours to a few days.";*/

    
    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    
/*    @FindBy(xpath = "(//div[@class='subquestion']//div[@class='show-in-cc'])[1]")
    WebElement questionText1;
    
    @FindBy(xpath = "(//div[@class='subquestion']//div[@class='show-in-cc'])[2]")
    WebElement questionText2;
    
    @FindBy(xpath ="(//div[@class='subquestion']//div[@class='show-in-cc'])[3]")
    WebElement questionText3;*/



    @FindBy(xpath = "//select[@id='QS4105A']")
    WebElement attacksselect;

    @FindBy(xpath = "//select[@id='QS4105B']")
    WebElement daysSelect;

    @FindBy(xpath = "//select[@id='QS4105C']")
    WebElement headachesSelect;



    public MIGAttackFrequencyOLS() {
        PageFactory.initElements(getDriver(), this);
    }

/*    @Step
    public MIGAttackFrequencyOLS waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }*/
    
    @Step
    public MIGAttackFrequencyOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

/*    @Step
    public String getQuestionText1() {
        return getText(questionText1);
    }
    @Step
    public String getQuestionText2() {
        return getText(questionText2);
    }
    @Step
    public String getQuestionText3() {
        return getText(questionText3);
    }
    */
    
    @Step
    public String getTitleText() {
        return getText(titleText);
    }

    @Step
    public MIGAttackFrequencyOLS selectAttacks(String attacks) {
        selectDropDownListOptionByText(attacksselect, attacks);
        return this;
    }

    @Step
    public MIGAttackFrequencyOLS selectDays(String days) {
        selectDropDownListOptionByText(daysSelect, days);
        return this;
    }

    @Step
    public MIGAttackFrequencyOLS selectHeadaches(String headache) {
    	selectDropDownListOptionByText(headachesSelect,headache);
        return this;
    }
	
	
	
    
    
	
}
