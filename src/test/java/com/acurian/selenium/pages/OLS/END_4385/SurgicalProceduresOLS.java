package com.acurian.selenium.pages.OLS.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class SurgicalProceduresOLS extends MainPageOLS {
	public final String titleExpected = "There are times when surgery is required to remove endometriosis tissue found outside of the uterus (implants), to remove scar tissue (adhesions), to cut nerves in the pelvis, etc.\n" +
            "How many of these types of surgical procedures have you had to treat your endometriosis?\n" +
			"Please do not count any procedures you may have had to diagnose your endometriosis.";
			
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public SurgicalProceduresOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SurgicalProceduresOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public SurgicalProceduresOLS clickOnAnswer(String answerText) {
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
