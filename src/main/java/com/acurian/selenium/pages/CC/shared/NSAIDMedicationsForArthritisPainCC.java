package com.acurian.selenium.pages.CC.shared;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class NSAIDMedicationsForArthritisPainCC extends MainPageCC {

    public final String titleExpected = "The following medications are called NSAIDs. They may be available over-the-counter or with a prescription.\n" +
            "Have you ever taken any of the following NSAID medications for your arthritis pain?\n" +
    		"Agent Note: Read medications in the following way: \"Aspirin, also known as Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, or Excedrin\" etc.\n" +
            "Select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public NSAIDMedicationsForArthritisPainCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public NSAIDMedicationsForArthritisPainCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public NSAIDMedicationsForArthritisPainCC clickOnAnswers(String ...answerText) {
        List<String> answerTextList = Arrays.asList(answerText);
        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
                .forEach(el -> el.click());
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
