package com.acurian.selenium.pages.CC.COPD_5042;

import com.acurian.selenium.constants.Locators;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class HasHealthcareProfessionalDiagnosedLungCondCC extends MainPageCC{

    
    public final String titleExpected = "COPD, or chronic obstructive pulmonary disease, is a common lung condition that makes it difficult to breathe. It is mainly caused by smoking. There are two forms of COPD:\n" +
            "• Chronic bronchitis, in which the lining of your airways becomes inflamed, causing a long-term cough with mucus or phlegm, and\n" +
            "• Emphysema, in which the air sacs in your lungs become damaged, causing shortness of breath.\n" +
            "Most people suffer from both forms, and symptoms often develop slowly over time.\n" +
            "\n" +
            "Has a healthcare professional ever diagnosed you with any of these lung conditions?\n" +
            "Agent Note: Select all that apply";
    		
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public HasHealthcareProfessionalDiagnosedLungCondCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasHealthcareProfessionalDiagnosedLungCondCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    

    @Step
    public HasHealthcareProfessionalDiagnosedLungCondCC clickOnAnswers(String ...answerText) {
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
