package com.acurian.selenium.pages.OLS.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class PelvicPainOtherTimesOLS extends MainPageOLS {
	public final String titleExpected = "Do you ever experience pelvic pain at other times, when you do NOT have your period?\n" +
            "This is sometimes called non-menstrual pelvic pain.";
			
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public PelvicPainOtherTimesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PelvicPainOtherTimesOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public PelvicPainOtherTimesOLS clickOnAnswer(String answerText) {
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
