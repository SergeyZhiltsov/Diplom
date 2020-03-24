package com.acurian.selenium.pages.CC.MDD_3159;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HasHealthcareProfDiagnosedMDDCC extends MainPageCC{

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with major depressive disorder (MDD) or depression?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HasHealthcareProfDiagnosedMDDCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasHealthcareProfDiagnosedMDDCC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HasHealthcareProfDiagnosedMDDCC clickOnAnswer(String answerText) {
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
