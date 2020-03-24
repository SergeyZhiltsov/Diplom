package com.acurian.selenium.pages.OLS.MDD_3159;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverHadElectroconvulsiveTherapyOLS extends MainPageOLS {
	public final String titleExpected = "Electroconvulsive therapy (ECT), sometimes known as electroshock therapy or \"shock treatment,\" is a procedure done under general anesthesia in which small electric currents are passed through the brain, often helping to relieve symptoms of certain mental illnesses.\n" +
"Have you ever had electroconvulsive therapy or ECT?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HaveYouEverHadElectroconvulsiveTherapyOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverHadElectroconvulsiveTherapyOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HaveYouEverHadElectroconvulsiveTherapyOLS clickOnAnswer(String answerText) {
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
