package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DiagnosedwithCarpalTunnelSyndrome extends MainPageOLS {
	
	public final String titleExpected = "Has a doctor ever diagnosed you with carpal tunnel syndrome?";
      

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS4515_')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public DiagnosedwithCarpalTunnelSyndrome() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedwithCarpalTunnelSyndrome waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public DiagnosedwithCarpalTunnelSyndrome clickOnAnswer(String answerText) {
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
