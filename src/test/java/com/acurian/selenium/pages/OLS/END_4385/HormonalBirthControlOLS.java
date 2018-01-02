package com.acurian.selenium.pages.OLS.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HormonalBirthControlOLS extends MainPageOLS {
	public final String titleExpected = "Are you currently taking a hormonal form of birth control?\n" +
            "This could include the Pill, patch, vaginal ring (such as NuvaRing), shot (such as Depo-Provera), implant (such as Implanon or Nexplanon), or certain IUDs (Liletta, Mirena, Skyla, Kyleena).";
			
    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HormonalBirthControlOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HormonalBirthControlOLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HormonalBirthControlOLS clickOnAnswer(String answerText) {
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
