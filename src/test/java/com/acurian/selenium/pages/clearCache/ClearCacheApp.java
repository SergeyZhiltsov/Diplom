package com.acurian.selenium.pages.clearCache;

import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ClearCacheApp extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//select[@id='studyId']/option")
    List<WebElement> projectsList;

    @FindBy(xpath = "//select[@id='studyId']")
    WebElement projectDropdown;

    @FindBy(xpath = "//h4/following-sibling::table//tr")
    List<WebElement> projectCheatSheet;

    @FindBy(xpath = "//*[@id='rClearCacheProject']//input")
    WebElement submitClearCache;

    public ClearCacheApp() {
        PageFactory.initElements(getDriver(), this);
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Step
    public ClearCacheApp openSecuredPage(String env, String username, String password) {
        switch (env) {
            case "QA":
                openURL("https://" + username + ":" + password + "@" + URLs.QA_CLEAR_CACHE_OLS);
                driver.navigate().refresh();
                break;
            case "STG":
                openURL("https://" + username + ":" + password + "@" + URLs.STG_CLEAR_CACHE_OLS);
                driver.navigate().refresh();
                break;
            case "PRD":
                openURL("https://" + username + ":" + password + "@" + URLs.PRD_CLEAR_CACHE_OLS);
                driver.navigate().refresh();
                break;
            default:
                openURL("https://" + username + ":" + password + "@" + URLs.STG_CLEAR_CACHE_OLS);
                driver.navigate().refresh();
                break;
        }
        return this;
    }

    @Step
    public void selectProject(String projectName) {
        selectDropDownListOptionByText(projectDropdown, projectName);
    }

    @Step
    public void clearCacheFor(String projectName) {
        Optional<WebElement> projectWithCache = projectCheatSheet.stream().filter(element -> element.getText().contains(projectName)).findFirst();
        if(projectWithCache.isPresent()) {
            selectProject(projectName);
            submitClearCache.click();
            try {
                projectCheatSheet.stream().filter(element -> element.getText().contains(projectName)).findFirst().get();
            } catch (NoSuchElementException e) {
                return;
            }
            Assert.fail(projectName + " still present in sheet after clear cache");
        }
        else {
            throw new IllegalArgumentException("The " + projectName + " doesn't have any caches");
        }
    }
}
