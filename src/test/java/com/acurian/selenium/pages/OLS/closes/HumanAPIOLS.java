package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HumanAPIOLS extends MainPageOLS{
    
    public final String titleExpected = "Now connect your digital health data using your online patient portals\n" +
            "Connecting your digital health data from your patient portals helps ensure the study doctor has all the necessary information for your first office appointment.\n" +
            "To securely connect your data, you will need to:\n" +
            "Search for and select your healthcare provider\n" +
            "Enter your patient portal login credentials\n" +
            "\n" +
            "Connect Your Health Data >>\n" +
            "Note: If you don't have credentials or don't remember them, you can register or reset them as part of the process.\n" +
            "Please click 'Next' when you have finished connecting your digital health data";

    public final String titleGmegaExpected = "The final step is to connect your health data\n" +
            "Connecting your health data helps to ensure the study doctor has the necessary information for your first office appointment. Please provide as much information as possible.\n" +
            "Now Connect Your Health Data\n" +
            "Connect >>\n" +
            "Add additional providers\n" +
            "Please click 'Next' when you have added all your medical data providers.";
    
    public final String titleFind = "Find your provider";
    
    public final String titleSearchAll = "Search all providers";
    
    

    @FindBy(xpath = "//div[@class='question']//h4")//div[@class='question']//div[contains(@class,'visible-md-block')]/h3
    WebElement titleText;

    @FindBy(xpath = "(//div[@class='question']//h4)[1]")
    WebElement titleTextGmega;
    
    @FindBy(xpath = "//button[@type='button']")
    WebElement connectButton;
    
    @FindBy(xpath = "//button[@id='filter-none']")
    WebElement selectAny;
    
    @FindBy(xpath = "//input[@type='text']")
    WebElement searchProvider;
    
    @FindBy(xpath = "//div[@data-reactid='.0.0.1.0.2.1.0.1.$54dc427aaa6b4cb7d6203061.1']")
    WebElement selectProvider;
    
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userName;
    
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    
    @FindBy(xpath = "//button[@class='button-action']")
    WebElement clickConnectButton;
    
    @FindBy(xpath = "//h2[@data-reactid='.0.1.0.0']")
    WebElement titleFindProvider;
    
    @FindBy(xpath = "//h2[@data-reactid='.0.0.1.0.0']")
    WebElement searchAllProvider;

    public HumanAPIOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HumanAPIOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HumanAPIOLS waitForPageLoadGmega() {
        waitForPageLoadMain(titleTextGmega, titleGmegaExpected);
        return this;
    }
    
    @Step
    public HumanAPIOLS waitForProvider() {
        waitForPageLoadMain(titleFindProvider, titleFind);
        return this;
    }
    
    @Step
    public HumanAPIOLS waitSearchAll() {
        waitForPageLoadMain(searchAllProvider, titleSearchAll);
        return this;
    }
    
    @Step
    public HumanAPIOLS waitProvider() {
    	WebDriverWait wait = new WebDriverWait(getDriver(), 4000);
    	wait.until(ExpectedConditions.visibilityOf(selectProvider));
        return this;
    }
    
    @Step
    public HumanAPIOLS waitToClickNext() {
    	WebDriverWait wait = new WebDriverWait(getDriver(), 4000);
    	wait.until(ExpectedConditions.visibilityOf(titleText));
        return this;
    }
    
    @Step
    public HumanAPIOLS switchToAPI() {
    	WebDriverWait wait = new WebDriverWait(getDriver(), 4000);
    	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("human-connect"));    
        return this;
    }
    
    @Step
    public HumanAPIOLS connectBTN() {
        connectButton.click();
        return this;
    }
    
    @Step
    public HumanAPIOLS clickANY() {
        selectAny.click();
        return this;
    }
    
    @Step
    public HumanAPIOLS search(String search) {
        typeText(searchProvider, search);
        return this;
    }
    
    @Step
    public HumanAPIOLS clickProvider() {
        selectProvider.click();
        return this;
    }
    
    @Step
    public HumanAPIOLS typeUserName(String username) {
        typeText(userName, username);
        return this;
    }
    
    @Step
    public HumanAPIOLS typePWD(String pwd) {
        typeText(password, pwd);
        return this;
    }
    
    @Step
    public HumanAPIOLS clickConnect() {
    	clickConnectButton.click();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
