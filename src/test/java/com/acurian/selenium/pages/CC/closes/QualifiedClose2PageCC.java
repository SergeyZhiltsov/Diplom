package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedClose2PageCC extends MainPageCC{

    //Qualified Close 2: No Pediatric Study Switch - 35_number

    public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you.";
    
    public final String titleExpectedIBD = "We’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you about %s study.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    public QualifiedClose2PageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedClose2PageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public QualifiedClose2PageCC waitForPageLoadIBD(String StudyIndication) {
        waitForPageLoadMain(titleText, titleExpectedIBD);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}
