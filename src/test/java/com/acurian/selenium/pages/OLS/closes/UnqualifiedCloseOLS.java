package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class UnqualifiedCloseOLS extends MainPageOLS{

    //Pediatric module
    public final String titleExpected = "Unfortunately, from the information you have provided, you would not be a candidate at this time. We appreciate your interest in participating.";

    public final String titleExpected2 = "We are also enrolling children and teens between the ages of 12-17 in eczema studies going on around the world.\n" +
            "\n" +
            "If your child has eczema, you know it can make your child feel physically uncomfortable and self-conscious. Plus, your child’s current lotions, creams or medications may not be helping.\n" +
            "\n" +
            "Eczema researchers around the world are studying medications that are not available from your child’s current doctors.\n" +
            "These research studies:\n" +
            "• May offer payment up to $400, varies by study\n" +
            "• Provide your teen with close attention from the study doctor who is focused on eczema care\n" +
            "• Ensure your teen’s health is carefully monitored and his or her safety is protected throughout the study\n" +
            "• May help you and your teen learn more about his or her eczema\n" +
            "\n" +
            "Remember, if you join a clinical study, your child will still be able to see his/her normal healthcare provider.\n" +
            "\n" +
            "Your teen’s participation can make a difference. Would you like to see if there is study that's right for your child?";


    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleTextFirstPart1;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-sm-block')]")
    WebElement titleTextFirstPart2;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-xs-block')]")
    WebElement titleTextFirstPart3;

    WebElement titleTextFirstPart;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    WebElement titleTextSecondPart;


    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public UnqualifiedCloseOLS() {
        PageFactory.initElements(getDriver(), this);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                titleTextFirstPart = titleTextFirstPart1;
                break;
            case Platforms.TABLET:
                titleTextFirstPart = titleTextFirstPart2;
                break;
            case Platforms.MOBILE:
                titleTextFirstPart = titleTextFirstPart3;
                break;
        }
    }

    @Step
    public UnqualifiedCloseOLS waitForPageLoad() {
        waitForPageLoadMain(titleTextFirstPart, titleExpected);
        Assert.assertEquals(getText(titleTextSecondPart), titleExpected2, "Second title is diff");
        return this;
    }

    @Step
    public UnqualifiedCloseOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleTextFirstPart);
    }
}
