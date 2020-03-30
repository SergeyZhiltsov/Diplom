package com.acurian.selenium.pages.OLS.UF_4384;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouHadSurgicalProcedurePast6MonthsUF_OLS extends MainPageOLS {
	public final String titleExpected = "Have you had a surgical procedure to treat your uterine fibroids in the past 6 months?\n" +
			"This surgery may have included removing fibroids (myomectomy), destroying the uterine lining to reduce menstrual flow (endometrial ablation), cutting off blood supply to fibroids (uterine artery embolization), etc.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HaveYouHadSurgicalProcedurePast6MonthsUF_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouHadSurgicalProcedurePast6MonthsUF_OLS waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public HaveYouHadSurgicalProcedurePast6MonthsUF_OLS clickOnAnswer(String answerText) {
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
