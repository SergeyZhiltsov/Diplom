package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverTakenAnyOtherPrescriptionMedicinesToTreatYourCrohns_OLS extends MainPageOLS {
	
	public final String titleExpected = "Have you ever taken any other prescription medicines to treat or manage your Crohn’s or colitis?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HaveYouEverTakenAnyOtherPrescriptionMedicinesToTreatYourCrohns_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverTakenAnyOtherPrescriptionMedicinesToTreatYourCrohns_OLS waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public HaveYouEverTakenAnyOtherPrescriptionMedicinesToTreatYourCrohns_OLS clickOnAnswer(String answerText) {
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
