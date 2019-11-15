package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

//29 Qualified Close 1: Pediatric Study Switch
public class QualifiedClose1PageOLS extends MainPageOLS {

    public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor's office that you selected so they can contact you.";

    public final String titleExpected1 = "We are also enrolling children and teens between the ages of 12-17 in eczema studies going on around the world.\n" +
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


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-sm-block')][1]")
    WebElement titleTextFirstPart;

    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]")
    WebElement titleTextSecondPart;

    public QualifiedClose1PageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedClose1PageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        Assert.assertEquals(getText(titleTextSecondPart), titleExpected1, "Second title is diff");
        return this;
    }

    @Step
    public QualifiedClose1PageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}