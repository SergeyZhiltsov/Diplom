package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

abstract class IdentificationOpeningOptionsClosePageCC extends MainPageCC {

    @FindBy(xpath = "//form[@id='contact_info_form']/div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//input[contains(@class,'input-text-first-name')]")
    WebElement firstNameField;

    @FindBy(xpath = "//input[contains(@class,'input-text-last-name')]")
    WebElement lastNameField;

    IdentificationOpeningOptionsClosePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    IdentificationOpeningOptionsClosePageCC setFirstName(String name) {
        typeText(firstNameField, name);
        return this;
    }

    @Step
    IdentificationOpeningOptionsClosePageCC setLastName(String name) {
        typeText(lastNameField, name);
        return this;
    }
}
