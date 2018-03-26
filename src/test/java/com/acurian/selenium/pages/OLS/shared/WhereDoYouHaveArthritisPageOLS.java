package com.acurian.selenium.pages.OLS.shared;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WhereDoYouHaveArthritisPageOLS extends MainPageOLS {

	public final String titleExpected = "Where do you have arthritis?\n" + 
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhereDoYouHaveArthritisPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhereDoYouHaveArthritisPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhereDoYouHaveArthritisPageOLS clickOnAnswers(String ...answerText) {
    	clickOnCheckBoxes(checkBoxList, answerText);
        return this;   
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
    

}
