package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class BiologicMedications extends MainPageOLS {
	public final String titleExpected = "\"Biologics\" are medications that affect the body's immune system. They are usually given as an infusion (into a vein) or a shot (injection).\n" +
			"Have you ever received any of the following \"biologic\" medications?\n"  +
			"Please select all that apply";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public BiologicMedications() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public BiologicMedications waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public BiologicMedications clickOnAnswers(String answerText) {
    	checkBoxList.stream().filter(el -> el.getText().contains(answerText))
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
