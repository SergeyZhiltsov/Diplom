package com.acurian.selenium.pages.OLS.MDD_3159;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HowManyDifferentPrescriptionAntidepresMedsOLS extends MainPageOLS {
	public final String titleExpected = "How many different prescription antidepressant medications have you taken during your current episode of depression?\n" +
			"Please include all antidepressant medications. Include those which you are currently taking and those you previously took for this current episode but are no longer taking.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HowManyDifferentPrescriptionAntidepresMedsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyDifferentPrescriptionAntidepresMedsOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HowManyDifferentPrescriptionAntidepresMedsOLS clickOnAnswer(String answerText) {
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
