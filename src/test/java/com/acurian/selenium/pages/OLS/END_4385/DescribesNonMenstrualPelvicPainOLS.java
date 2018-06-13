package com.acurian.selenium.pages.OLS.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DescribesNonMenstrualPelvicPainOLS extends MainPageOLS {
	public final String titleExpected = "Which of the following most accurately describes your worst pelvic pain when you do NOT have your period, and how it affects your life?";
			
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public DescribesNonMenstrualPelvicPainOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DescribesNonMenstrualPelvicPainOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public DescribesNonMenstrualPelvicPainOLS clickOnAnswer(String answerText) {
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
