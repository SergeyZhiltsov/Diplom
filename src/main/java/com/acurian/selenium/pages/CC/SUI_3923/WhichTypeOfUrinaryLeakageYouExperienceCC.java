package com.acurian.selenium.pages.CC.SUI_3923;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class WhichTypeOfUrinaryLeakageYouExperienceCC extends MainPageCC{

    public final String titleExpected = "To review, stress urinary leakage is associated with physical activities such as coughing, sneezing, and laughing, while urge urinary leakage is associated with sudden, intense urges to urinate.\n" +
"Which type of urinary leakage do you experience most often?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public WhichTypeOfUrinaryLeakageYouExperienceCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichTypeOfUrinaryLeakageYouExperienceCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WhichTypeOfUrinaryLeakageYouExperienceCC clickOnAnswer(String answerText) {
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
