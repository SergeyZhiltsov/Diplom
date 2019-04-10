package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class AnotherSuperScrPageOLS extends MainPageOLS{

    public final String titleExpected = "This is the first part of the process to match your child with a research study.\n" +
            "First, please complete this questionnaire to see if there is a study that's right for your child.\n" +
            "Then, if there is a study right for your child, you’ll schedule an in person visit at the study doctor’s office.\n" +
            "Finally, if the study doctor confirms your child is a match for the study, and you attend all required study visits, you may receive*:\n" +
            "Payment up to $400, which varies by study\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication\n" +
            "\n" +
            "Let's get started to see if there is a study that's right for your child!";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    public AnotherSuperScrPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AnotherSuperScrPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
