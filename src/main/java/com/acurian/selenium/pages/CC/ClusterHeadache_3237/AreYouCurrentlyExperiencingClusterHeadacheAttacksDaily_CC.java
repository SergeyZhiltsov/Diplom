package com.acurian.selenium.pages.CC.ClusterHeadache_3237;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC extends MainPageCC{

    public final String titleExpected = "Are you currently experiencing cluster headache attacks daily or frequently?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public AreYouCurrentlyExperiencingClusterHeadacheAttacksDaily_CC clickOnAnswer(String answerText) {
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
