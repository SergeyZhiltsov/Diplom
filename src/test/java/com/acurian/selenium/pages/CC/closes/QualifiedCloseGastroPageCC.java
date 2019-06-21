package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedCloseGastroPageCC extends MainPageCC{

    //Show for 4357 Gastroparesis - NOT IN FLARE patients with Status: INITIAL_INACTIVE

    public final String titleExpected = "This research study requires you to meet specific study requirements associated with your Diabetic Gastroparesis. Based on the information you have provided, you have not met the study requirements at this time.\n" +
            "\n" +
            "There is a helpful online symptom tracker you can access at www.mygutchecktracker.com and record your symptoms on a weekly basis (especially when your symptoms are worsening). Your information will be sent to the study site once your tracking indicates you have met the study requirements.\n" +
            "\n" +
            "There is also a number you can call to provide your symptom update: XXX.XXX.XXXX, and you will also receive an email reminding you to use the online tracker and to call us when your symptoms are worsening.";

    public final String titleExpected2 ="Once you access the online tracker www.mygutchecktracker.com, please take the time to answer the 3 questions weekly (and especially when your symptoms are worsening). The questions assess your symptom severity and determine if you are ready to see the study doctor.";


    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']/span[@class='sub_question_text']")
    WebElement titleText2;

    public QualifiedCloseGastroPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedCloseGastroPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        waitForPageLoadMain(titleText2, titleExpected2);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
