package com.acurian.selenium.pages.OLS.LMG_4686;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HowOftenDoYouTypicallyTakeMedicationOLS extends MainPageOLS{

    public final String titleExpected = "Some migraine medications are taken \"as needed\", as the migraine starts or while a migraine headache is occurring.\n" +
    		"How often do you typically take medication to stop an active migraine, either as it starts or while you are experiencing it?";
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HowOftenDoYouTypicallyTakeMedicationOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowOftenDoYouTypicallyTakeMedicationOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowOftenDoYouTypicallyTakeMedicationOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
