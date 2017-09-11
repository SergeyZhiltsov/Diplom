package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CallCenterIntroductionPageCC extends BasePage{

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement questionText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

//    @FindBy(xpath = "//input[@class='next_btn']")
//    WebElement nextButton;

    public CallCenterIntroductionPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CallCenterIntroductionPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(questionText);
        return this;
    }

    @Step
    public CallCenterIntroductionPageCC clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

//    @Step
//    public <T extends BasePage> T clickNextButton(BasePage page) {
//        nextButton.click();
//        return (T)page;
//    }
}
