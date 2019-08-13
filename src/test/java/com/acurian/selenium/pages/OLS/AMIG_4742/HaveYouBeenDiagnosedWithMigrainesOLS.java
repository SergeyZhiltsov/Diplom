package com.acurian.selenium.pages.OLS.AMIG_4742;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouBeenDiagnosedWithMigrainesOLS extends MainPageOLS {
	public final String titleExpected =
      "Migraines are intense headaches that last for hours to days and:\n" +
            "Cause pulsing or throbbing pain\n"+
            "Interfere with work, family, or social activities\n"+
            "Can trigger nausea or sensitivity to light and/or sound\n\n"+
            "Have you been diagnosed with migraines?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HaveYouBeenDiagnosedWithMigrainesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouBeenDiagnosedWithMigrainesOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HaveYouBeenDiagnosedWithMigrainesOLS clickOnAnswer(String answerText) {
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
