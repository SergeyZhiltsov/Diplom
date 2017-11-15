package com.acurian.selenium.pages.OLS.Insomnia_3792;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class DoYouSufferFromInsomnia_OLS extends MainPageOLS {
	public final String titleExpected = "Do you suffer from insomnia, or do you sometimes have difficulty falling or staying asleep?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public DoYouSufferFromInsomnia_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouSufferFromInsomnia_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public DoYouSufferFromInsomnia_OLS clickOnAnswer(String answerText) {
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
