package com.acurian.selenium.pages.CC;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageCC extends BasePage{

    @FindBy(xpath = "//button[text()='Next']")
    WebElement nextButton;


    public MainPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public <T extends MainPageCC> T clickNextButton(T page) {
        nextButton.click();
        return (T)page;
    }
}
