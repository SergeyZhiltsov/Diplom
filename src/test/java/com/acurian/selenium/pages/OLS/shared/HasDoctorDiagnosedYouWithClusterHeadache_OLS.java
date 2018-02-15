package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HasDoctorDiagnosedYouWithClusterHeadache_OLS extends MainPageOLS {
	public final String titleExpected = "Cluster headache is a very rare condition that causes severe pain, usually around one eye, and occurs in periods of attacks and remissions. It is different from the more common headache types such as migraine or tension headache.\n" +
			"Has a doctor diagnosed you with cluster headache?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HasDoctorDiagnosedYouWithClusterHeadache_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasDoctorDiagnosedYouWithClusterHeadache_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HasDoctorDiagnosedYouWithClusterHeadache_OLS clickOnAnswer(String answerText) {
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
