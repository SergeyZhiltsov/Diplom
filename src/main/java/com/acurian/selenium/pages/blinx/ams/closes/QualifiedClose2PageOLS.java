package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QualifiedClose2PageOLS extends MainPageBlinx {

    private final String titleExpectedPart1 = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you.";

    private final String titleExpectedPart3 = "We're glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor's office that you selected so they can contact you.";
//    private final String titleExpectedPart2 = "We are also enrolling children and teens between the ages of 12-17 in eczema studies going on around the world.\n" +
//            "\n" +
//            "If your child has eczema, you know it can make your child feel physically uncomfortable and self-conscious. Plus, your child’s current lotions, creams or medications may not be helping.\n" +
//            "\n" +
//            "Eczema researchers around the world are studying medications that are not available from your child’s current doctors.\n" +
//            "These research studies:\n" +
//            "• May offer payment up to $400, varies by study\n" +
//            "• Provide your teen with close attention from the study doctor who is focused on eczema care\n" +
//            "• Ensure your teen’s health is carefully monitored and his or her safety is protected throughout the study\n" +
//            "• May help you and your teen learn more about his or her eczema\n" +
//            "\n" +
//            "Remember, if you join a clinical study, your child will still be able to see his/her normal healthcare provider.\n" +
//            "\n" +
//            "Your teen’s participation can make a difference. Would you like to see if there is study that's right for your child?";

    @FindBy(xpath = "//*[@class='question_text']")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text'])[2]")
    WebElement titleTextPart2;
    @FindBy(xpath = "//div[@class='single-choice-answers-container']/button")
    List<WebElement> singleChoiceButtonsList;
    @FindBy(xpath = "//div[@class='question-text']")
    WebElement titleTextPart3;

    @Step
    public QualifiedClose2PageOLS waitForPageLoad3() {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart3, titleExpectedPart3);
        return this;
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoad1() {
        waitForPageLoadMain(titleTextPart3, titleExpectedPart1);
        return this;
    }


//    @Step
//    public QualifiedClosePageOLS waitForPageLoad() {
//        waitForPageLoadMain(titleTextPart1, titleExpectedPart1);
//        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
//        return this;
//    }

    @Step
    public QualifiedClose2PageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }
}
