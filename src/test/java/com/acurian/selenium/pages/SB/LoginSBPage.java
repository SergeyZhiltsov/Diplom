package com.acurian.selenium.pages.SB;

import com.acurian.selenium.constants.URLs;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;


public class LoginSBPage extends MainPageSB {

    @FindBy(id = "username")
    WebElement loginUsername;
    @FindBy(id = "password")
    WebElement loginPassword;
    @FindBy(css = "img.customimg")
    WebElement logoImage;

    public LoginSBPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LoginSBPage openPage(String env) {
        switch (env) {
            case "STG":
                logTextToAllureAndConsole("The SB available only on QA or PRD env, will be opened PRD page for selected STG env");
            case "PRD":
                openURL(URLs.SB_PRD);
                break;
            case "QA":
            default:
                openURL(URLs.SB_QA);
                break;
        }
        return this;
    }

    @Step
    public StudyProjectsListPage loginAs(String username, String password) {
        waitForAnimation();
        waitForVisibility(loginUsername);
        waitForVisibility(loginPassword);
        loginUsername.sendKeys(username);
        loginPassword.sendKeys(password);
        loginPassword.sendKeys(Keys.ENTER);
        return new StudyProjectsListPage();
    }

    @Step("Getting actual image logo")
    public Screenshot getActualLogoImage() {
        String src = logoImage.getAttribute("src");
        try {
            return new Screenshot(ImageIO.read(new URL(src)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Step("Getting expected image logo")
    public Screenshot getExpectedLogoImage() {
        try {
            return new Screenshot(ImageIO.read((ScreenBuilderApp.class.getResource("/AcurianSB_wtint.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Step("Checking logo image")
    public ImageDiff checkLogoImage() {
        ImageDiff diff = getDiff(getExpectedLogoImage(), getActualLogoImage());
    return diff;
    }
}