package com.acurian.selenium.pages.OLS.GERD;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.xml.sax.Locator;
import ru.yandex.qatools.allure.annotations.Step;

public class WhichoOfFollowingMedicationsCurrentlyGERD_OLS extends MainPageOLS{

    public final String titleExpected = "Which of the following medications do you currently take, every day, to treat your heartburn, reflux, or GERD? \n" +
    		"These medications may be prescribed by your doctor and filled at a pharmacy counter, or you may purchase them yourself as \"over-the-counter\" or non-prescription medications.\n" +
    		"Please select all that apply.";
    public final String titleExpected2 = "Do you currently take any of the following \"over-the-counter\", or non-prescription, medications to treat your heartburn, reflux, or GERD? \n" +
            "Please select all that apply.";

    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhichoOfFollowingMedicationsCurrentlyGERD_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichoOfFollowingMedicationsCurrentlyGERD_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichoOfFollowingMedicationsCurrentlyGERD_OLS waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public WhichoOfFollowingMedicationsCurrentlyGERD_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
