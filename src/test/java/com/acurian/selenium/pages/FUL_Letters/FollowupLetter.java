package com.acurian.selenium.pages.FUL_Letters;

import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.utils.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;
//------Validate FUL emails in Gmail -----
public class FollowupLetter extends MainPageOLS{

    public final String titleExpected = "What is your date of birth?";
       
    @FindBy(xpath = "//div[contains(@class,'subquestion')]//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement questionText;
    
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;
  
    @FindBy(xpath = "//input[@id='identifierId']")
    WebElement email_id;
    
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    
    @FindBy(xpath = "//input[@id='gbqfq']")
    WebElement searchBox;
    
    @FindBy(xpath = "//table[@class='F cf zt']/tbody/tr[1]/td[@class='xY a4W']")
    WebElement email;
    
    @FindBy(xpath = "//div[contains(@class,'a3s')]/descendant::table[2]//tr[2]/td[1]/div")
    WebElement actual;
    

	String email_content_expected_1R = "Dear Acurian,\n" +
			"Thank you for your recent interest in participating in one of our Stress Urinary Incontinence clinical research studies.\n" +
			"We have forwarded your information to the study doctor’s office that you selected. If the study doctor’s office has not already contacted you, they should be contacting you within the next few days to further discuss the study and to set up an in-person evaluation.\n" +
			"If you are not contacted within the next 5 business days, please contact them directly.\n" +
			"The study doctor’s office that you selected is:\n" +
			"Dr. Test PI, MD\n" +
			"AUT_SUI_3923\n" +
			"32 Walnut Grove Dr\n" +
			"Horsham, PA 19044\n" +
			"(123) 456-7899\n" +
			"Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.\n" + 
			"\n" +
			"The AcurianHealth Team";
	
	String email_content_expected_Med1R = "Acurian Trial\n" +
	"Horsham, PA 19044\r\n" +
	"Dear Acurian,\n" +
	"Thank you for your recent interest in participating in one of our Crohn's Disease clinical research studies.\n" +
	"We have forwarded your information to the study doctor’s office that you selected. If the study doctor’s office has not already contacted you, they should be contacting you within the next few days to further discuss the study and to set up an in-person evaluation.\n" +
	"If you are not contacted within the next 5 business days, please contact them directly.\n" +
	"The study doctor’s office that you selected is:\r\n" + 
	"Dr. Test PI, MD\n" +
	"AUT_CRN_3889_HS\n" +
	"71 Walnut Grove Dr\n" +
	"Horsham, PA 19044\n" +
	"(123) 456-7899\n" +
	"To allow us to send your medical records to the study doctor, please provide information on the doctors who are treating, or have treated, your Crohn's Disease. Please complete all details required by clicking on the link below. Please click here to learn more.\n" +
	"Please click here to learn more.\n" +
	"Please be assured that your records will be kept confidential and only shared with the study research facility.\r\n" + 
	"Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.\n" +
	"The AcurianHealth Team";
	
	
	
	//========================1R FL validation =============================================================
    @Step
    public FollowupLetter Gmail_FUL_Validate(String pidAfterScreening) {
		driver.get("https://mail.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();
		siteSelectionPageOLS.threadSleep(35000);
		//String PID = "63276144";
    	//-----------Enter EmailID and Password---------------        
        email_id.sendKeys("qa.acurian@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("automation");
        driver.findElement(By.id("passwordNext")).click();
				
        //-------Search for email using PID------------
        searchBox.sendKeys(pidAfterScreening);
        
        //-------Open the email to view the contents--------------
        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.click();
        
        String email_content_Actual = actual.getText();
        System.out.println(email_content_Actual);
        System.out.println(email_content_expected_1R);
        Assert.assertTrue(email_content_Actual.contains(email_content_expected_1R));  
        return this;
    }
	
	//========================1R_MED FL validation =============================================================
    @Step
    public FollowupLetter Gmail_MedFUL_Validate(String pidAfterScreening) {
		driver.get("https://mail.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();
		siteSelectionPageOLS.threadSleep(35000);
		//String PID = "63276144";
    	//-----------Enter EmailID and Password---------------        
        email_id.sendKeys("qa.acurian@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("automation");
        driver.findElement(By.id("passwordNext")).click();
				
        //-------Search for email using PID------------
        searchBox.sendKeys(pidAfterScreening);
        
        //-------Open the email to view the contents--------------
        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.click();
        
        String email_content_Actual = actual.getText();
        System.out.println(email_content_Actual);
        System.out.println(email_content_expected_Med1R);
        Assert.assertTrue(email_content_Actual.contains(email_content_expected_Med1R));  
        return this;
    }

    

    
    @Step
    public FollowupLetter waitForPageLoad() {
        waitForPageLoadMain(questionText,titleExpected);
        return this;
    }

  
    @Step
    public String getQuestionText() {
        return getText(questionText);
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

    }
