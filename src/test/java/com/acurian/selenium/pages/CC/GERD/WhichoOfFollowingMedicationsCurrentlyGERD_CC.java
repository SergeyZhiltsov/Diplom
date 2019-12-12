package com.acurian.selenium.pages.CC.GERD;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class WhichoOfFollowingMedicationsCurrentlyGERD_CC extends MainPageCC{

    public final String titleExpected = "Which of the following medications do you currently take, every day, to treat your heartburn, reflux, or GERD?\n" +
    		"These medications may be prescribed by your doctor and filled at a pharmacy counter, or you may purchase them yourself as \"over-the-counter\" or non-prescription medications.\n" +
    		"Agent Note: Select all that apply";

    public final String titleExpected2 = "Do you currently take any of the following \"over-the-counter\", or non-prescription, medications to treat your heartburn, reflux, or GERD?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public WhichoOfFollowingMedicationsCurrentlyGERD_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichoOfFollowingMedicationsCurrentlyGERD_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WhichoOfFollowingMedicationsCurrentlyGERD_CC waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }


    @Step
    public WhichoOfFollowingMedicationsCurrentlyGERD_CC clickOnAnswers(String ...answerText) {
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
