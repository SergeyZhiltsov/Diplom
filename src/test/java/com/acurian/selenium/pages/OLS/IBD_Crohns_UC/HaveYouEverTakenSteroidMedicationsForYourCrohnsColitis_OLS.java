package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS extends MainPageOLS {
	
	public final String titleExpected = "Have you ever taken steroid medications for your Crohn's or colitis?\n" +
			"These include medications like prednisone or hydrocortisone, usually taken by mouth or sometimes as an enema or injection.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HaveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HaveYouEverTakenSteroidMedicationsForYourCrohnsColitis_OLS clickOnAnswer(String answerText) {
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
