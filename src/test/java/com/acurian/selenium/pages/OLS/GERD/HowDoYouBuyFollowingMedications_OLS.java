package com.acurian.selenium.pages.OLS.GERD;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HowDoYouBuyFollowingMedications_OLS extends MainPageOLS {
	
	public final String titleExpected = "Some medications for heartburn, reflux, or GERD are available with or without a prescription from a doctor.\n" +
			"How do you buy the following medication(s)?";

    @FindBy(xpath = "(//div[@class='ng-scope']//div[contains(@class,'visible-md-block')])[1]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HowDoYouBuyFollowingMedications_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowDoYouBuyFollowingMedications_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HowDoYouBuyFollowingMedications_OLS clickOnAnswer(String answerText) {
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
