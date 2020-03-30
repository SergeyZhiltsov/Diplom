package com.acurian.selenium.pages.CC.LMG_4686;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DoYouCurrentlyUseMarijuanaCC extends MainPageCC{

    public final String titleExpected = "Do you currently use marijuana (cannabis) or any products that contain it, including CBD oil?";
    

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public DoYouCurrentlyUseMarijuanaCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouCurrentlyUseMarijuanaCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DoYouCurrentlyUseMarijuanaCC clickOnAnswer(String answerText) {
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
