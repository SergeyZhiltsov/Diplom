package com.acurian.selenium.pages.OLS.RA;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HowLongTakingMethotrexate extends MainPageOLS{
	public final String titleExpected = "How long have you been taking methotrexate?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    
    @FindBy(xpath = "//label[contains(@for,'QS7108_')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HowLongTakingMethotrexate() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongTakingMethotrexate waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public HowLongTakingMethotrexate clickOnAnswer(String answerText) {
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
