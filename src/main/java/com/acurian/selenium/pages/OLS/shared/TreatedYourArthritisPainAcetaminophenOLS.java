package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class TreatedYourArthritisPainAcetaminophenOLS extends MainPageOLS{

    public final String titleExpected = "Have you ever treated your arthritis pain with medications containing acetaminophen, also known as Tylenol?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public TreatedYourArthritisPainAcetaminophenOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TreatedYourArthritisPainAcetaminophenOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TreatedYourArthritisPainAcetaminophenOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
