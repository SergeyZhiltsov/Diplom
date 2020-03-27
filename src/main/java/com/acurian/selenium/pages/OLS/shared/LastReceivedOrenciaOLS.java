package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class LastReceivedOrenciaOLS extends MainPageOLS {
	public final String titleExpected = "Which of the following best describes when you last received Orencia? You….";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS545H_')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public LastReceivedOrenciaOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LastReceivedOrenciaOLS waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public LastReceivedOrenciaOLS clickOnAnswer(String answerText) {
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
