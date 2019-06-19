package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ScreenBuilderApp extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//table[@id='mytable']//span/a")
    List<WebElement> screeners;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu-right')]/li/a")
    List<WebElement> screenerActions;

    @FindBy(id = "comment")
    WebElement commentfield;

    @FindBy(id = "publishProd")
    WebElement prodEnvButton;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    public WebElement cacheClearedSuccessAlert;

    @FindBy(css = "div.alert.alert-warning.alert-dismissable")
    WebElement alertDismissableMessage;


    public ScreenBuilderApp() {
        PageFactory.initElements(getDriver(), this);
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Step
    public ScreenBuilderApp clickOnScreener(String screenerName) {
        waitForAnimation();
        screeners.stream().filter(element -> element.getText().equals(screenerName))
                .findFirst()
                .get()
                .click();
        return this;
    }

    @Step
    public ScreenBuilderApp openSubActionsOf(String actionMenu) {
        getActions().moveToElement(screenerActions.stream().filter(element -> element.getText().equals(actionMenu))
                .findFirst()
                .get());
        return this;
    }

    @Step("Enter comment before PublishStudySetup")
    public ScreenBuilderApp entercomment() {
        typeText(commentfield, "No changes, testing publish feature for Healthcheck");
        return null;
    }
}
