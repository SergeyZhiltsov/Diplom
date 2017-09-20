package com.acurian.selenium.pages.OLS.RA_2821;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

public class WhenYouDiagnosedWithRA extends BasePage {
	public final String titleExpected = "When were you diagnosed with RA? ";

    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public WhenYouDiagnosedWithRA() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenYouDiagnosedWithRA waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhenYouDiagnosedWithRA clickOnAnswer(String answerText) {
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
