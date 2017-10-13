package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SiteSelectionPageCC extends MainPageCC {

    @Parameter("My PID")
    private String pidNumber;

    public final String titleExpected = "The closest doctor's office available for a low back pain study is located at [name of street and city]. Is that convenient for you?\n" +
            "\n" +
            "[Agent Note: The patient may have responded to outreach for a specific type of study within a broader indication, such as \"diabetics with foot ulcer\" or \"diabetics with stomach problems,\" and are referring for (for example) a different diabetes complication study or for a general diabetes study. If there is confusion about which study they are being referred for, the following type of clarification can be offered: \"You may have seen a letter or ad that mentioned a specific diabetes complication such as stomach problems due to diabetes or foot sores or ulcers due to diabetes. Based on your answers, you are not an exact match for that study; however, you have prequalified for another study for people with diabetes.\"]\n" +
            "\n" +
            "[Offer second closest site if necessary and if reasonable]\n" +
            "If respondent indicates that no site offered is convenient, read the following: \"I'm sorry that site isn't very convenient. We have a couple of options: we can make a note to contact you if a more convenient site becomes available. Or, I can send your information over to the site in (town), and you can talk to them about the study and see if they might be able to help arrange transportation for you. Which would you prefer?\"";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='site_selection_container']//span[@class='site_sel_radio_facilityName']")
    List<WebElement> radioButtonsList;
    
    @FindBy(xpath = "//div[@class='site_selection_container']//span[@class='question_helper']")
    List<WebElement> radioButtonsList1;

    @FindBy(xpath = "//em[@id='debug-pid']")
    WebElement pidNumberPath;

    public SiteSelectionPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SiteSelectionPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public SiteSelectionPageCC clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().equals(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }
    
    @Step
    public SiteSelectionPageCC selectAnswer(String answerText) {
        radioButtonsList1.stream().filter(el -> el.getText().equals(answerText))
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

    @Step
    public SiteSelectionPageCC getPID(){
        pidNumber = getText(pidNumberPath);
        logTextToAllure("PID="+pidNumber);
        return this;
    }

//    @Step("{0}")
//    private void logTextToAllure(String text) {
//        //empty method
//    }
}
