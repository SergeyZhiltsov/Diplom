package com.acurian.selenium.pages.CC.shared;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;


public class StudyQuestionMigPageCC<Just> extends MainPageCC {

    public final String titleExpectedParagraphs = "The next few questions are about migraines, regular headaches, and how often you have them. If you d";

    public final String titleExpected ="In a typical month, how many separate migraine attacks do you have?\n"+
    		"Remember, a migraine attack could last from a few hours to a few days.";

    
    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;
    
    @FindBy(xpath = "(//div[@class='subquestion']//div[@class='show-in-cc'])[1]")
    WebElement questionText1;
    
    @FindBy(xpath = "(//div[@class='subquestion']//div[@class='show-in-cc'])[2]")
    WebElement questionText2;
    
    @FindBy(xpath ="(//div[@class='subquestion']//div[@class='show-in-cc'])[3]")
    WebElement questionText3;



    @FindBy(xpath = "//select[@id='QS4105A']")
    WebElement attacksselect;

    @FindBy(xpath = "//select[@id='QS4105B']")
    WebElement daysSelect;

    @FindBy(xpath = "//select[@id='QS4105C']")
    WebElement headachesSelect;



    public StudyQuestionMigPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StudyQuestionMigPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> questionText1.getText().contains(titleExpected));
        return this;
    }

    @Step
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
    
    
    @Step
    public String getTitleText() {
        return getText(questionText1);
    }

    @Step
    public StudyQuestionMigPageCC selectAttacks(String attacks) {
        selectDropDownListOptionByText(attacksselect, attacks);
        return this;
    }

    @Step
    public StudyQuestionMigPageCC selectDays(String days) {
        selectDropDownListOptionByText(daysSelect, days);
        return this;
    }

    @Step
    public StudyQuestionMigPageCC selectHeadaches(String headache) {
    	selectDropDownListOptionByText(headachesSelect,headache);
        return this;
    }
	
	
	
}
