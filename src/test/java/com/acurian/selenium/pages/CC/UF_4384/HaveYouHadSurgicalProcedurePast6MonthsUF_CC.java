package com.acurian.selenium.pages.CC.UF_4384;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class HaveYouHadSurgicalProcedurePast6MonthsUF_CC extends MainPageCC{

    public final String titleExpected = "Have you had a surgical procedure to treat your uterine fibroids in the past 6 months?\n" +
    		"This surgery may have included removing fibroids (myomectomy Agent Note: my-oh-MECK-toe-me), destroying the uterine lining to reduce menstrual flow (endometrial ablation Agent Note: end-oh-ME-tree-ul uh-BLAE-shun), cutting off blood supply to fibroids (uterine artery embolization Agent Note: em-boh-li-ZAE-shun), etc.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    public HaveYouHadSurgicalProcedurePast6MonthsUF_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouHadSurgicalProcedurePast6MonthsUF_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HaveYouHadSurgicalProcedurePast6MonthsUF_CC clickOnAnswer(String answerText) {
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
