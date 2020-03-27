package com.acurian.selenium.pages.OLS.RA;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class CurrentlyTakingMethotrexate extends MainPageOLS {
	public final String titleExpected = "Methotrexate is a common RA medication. It is usually taken once a week. Methotrexate can come as a shot or as pills or tablets. The brand names include Otrexup, Rasuvo, Rheumatrex, or Trexall.\n" +
            "Are you currently taking methotrexate for your Rheumatoid Arthritis?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS7107_')]/span[@class='copy']")
    List<WebElement> radioButtonsList;
    
   

    public CurrentlyTakingMethotrexate() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlyTakingMethotrexate waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public CurrentlyTakingMethotrexate clickOnAnswer(String answerText) {
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
