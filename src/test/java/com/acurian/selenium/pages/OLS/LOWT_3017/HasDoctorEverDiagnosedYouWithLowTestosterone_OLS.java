package com.acurian.selenium.pages.OLS.LOWT_3017;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HasDoctorEverDiagnosedYouWithLowTestosterone_OLS extends MainPageOLS {
	public final String titleExpected = "Testosterone is the male sex hormone, which regulates body functions such as sex drive, bone mass, fat distribution, and muscle size and strength. Levels may drop as men age.\n" +
			"Has a doctor ever diagnosed you with low testosterone?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HasDoctorEverDiagnosedYouWithLowTestosterone_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasDoctorEverDiagnosedYouWithLowTestosterone_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HasDoctorEverDiagnosedYouWithLowTestosterone_OLS clickOnAnswer(String answerText) {
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