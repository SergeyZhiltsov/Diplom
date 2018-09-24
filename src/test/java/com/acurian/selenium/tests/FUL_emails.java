package com.acurian.selenium.tests;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import com.acurian.selenium.pages.OLS.RA_2821.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.UnqualifiedCloseOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.gmega1.BasedOnYourAnswersPageOLS;
import com.acurian.selenium.pages.OLS.gmega1.ReachTheSchedulingCenterPageOLS;
import com.acurian.selenium.pages.OLS.gmega1.TakingAcetaminophenTylenolPageOLS;
import com.acurian.selenium.pages.OLS.gmega1.TransferPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.WhereDoYouHaveArthritisPageOLS;
import com.acurian.selenium.utils.DBConnection;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class FUL_emails extends BaseTest{

    @Test
    @TestCaseId("00026")
    @Description("Stress Urinary Incontinence (SUI) - 3923 OLS")
    public void fUL_emails() {
        String phoneNumber = "AUTGMEGA01";
        String protocol1 = "RA01_Generic";
        String protocol2 = "Radiant_Generic";
        String protocol3 = "GOA_3";
        String studyName = "an arthritis";
        String siteName = "AUT_GMEGA_01";
        String zipCode = "19044";
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGH(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleGmegaExpected, "Title is diff");
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        boneOrJointConditionsPageOLS
                .waitForPageLoad();
//        Assert.assertEquals(boneOrJointConditionsPageOLS.getTitleText(), boneOrJointConditionsPageOLS.titleExpected, "Title is diff");
        UnqualifiedCloseOLS unqualifiedCloseOLS = boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new UnqualifiedCloseOLS());
        unqualifiedCloseOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEqualsForQNumber("QS3", protocol1, protocol2, protocol3);
        debugPageOLS.clickOnQNumber("QS3");//because after clicking back is same page loading
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhereDoYouHaveArthritisPageOLS whereDoYouHaveArthritisPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereDoYouHaveArthritisPageOLS());

        TakingAcetaminophenTylenolPageOLS takingAcetaminophenTylenolPageOLS = whereDoYouHaveArthritisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("What kind of arthritis do you have?Agent Note: Select all that applyWhat kind of arthritis do you ha", protocol1)
                .getPage(whereDoYouHaveArthritisPageOLS)
                .clickOnAnswers("Left Knee", "Right Knee")
                .clickNextButton(new TakingAcetaminophenTylenolPageOLS());

        IdentificationPageOLS identificationPageOLS = takingAcetaminophenTylenolPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Where do you have arthritis?Agent Note: Select all that applyWhere do you have arthritis?Please sele", protocol2)
                .getPage(takingAcetaminophenTylenolPageOLS)
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());

        identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName);
        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();
        		siteSelectionPageOLS.getPID();
        		siteSelectionPageOLS.clickOnFacilityName(siteName)
                .clickNextButton(new BasedOnYourAnswersPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ReachTheSchedulingCenterPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Ok, I will pass your information on to the scheduling center and they will call you back. Thank you again for contacting Acurian's Research Information Center. Goodbye.")
                .clickNextButton(new TransferPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Successful transfer made to site")
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();
        
        
        //TheStudySitePageOLS theStudySitePageOLS = new TheStudySitePageOLS();
				//String pidAfterScreening = theStudySitePageOLS.waitForPageLoad()
        				
				
		    	
//=====================================================================================
		//--------------Validate FL letter for PARENT_PID (AMS1)------------- -----
		//FollowupLetter followupLetter = new FollowupLetter();
		//followupLetter.Gmail_FUL_Validate(pidAfterScreening);
		
        		//--------------Validate FL letter for CHILD_PID-(GMEGA)------------
        		String pidAfterScreening = siteSelectionPageOLS.getPidNumber();
        		FollowupLetter followupLetter = new FollowupLetter();
        		String childPID = new DBConnection().dbReadChilPID(env, pidAfterScreening);
                
        		followupLetter.Gmail_FUL_Validate(childPID);
//=====================================================================================
        		
        		
        		
		
		//------Validate FUL emails in Gmail -----
		/*SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();
		siteSelectionPageOLS.threadSleep(50000);
		String PID = siteSelectionPageOLS.pidNumber;
				//String PID = "63275790";
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
    	
    	//-----------Enter URL---------------
        driver.manage().window().maximize();
        driver.get("https://mail.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        
    	//-----------Enter EmailID and Password---------------        
        WebElement email_id = driver.findElement(By.xpath("//input[@id='identifierId']"));
        email_id.sendKeys("qa.acurian@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("automation");
        driver.findElement(By.id("passwordNext")).click();
				
        //-------Search for email using PID------------
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gbqfq']"));
        searchBox.sendKeys(PID);
        
        //-------Open the email to view the contents--------------
        WebElement email = driver.findElement(By.xpath("//table[@class='F cf zt']/tbody/tr[1]/td[@class='xY a4W']"));
        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.click();
        
        WebElement actual = driver.findElement(By.xpath("//div[contains(@class,'a3s')]/descendant::table[2]//tr[2]/td[1]/div"));
        String email_content_Actual = actual.getText();
        //System.out.println(email_content_Actual);
        //System.out.println(email_content_expected_1R);
        Assert.assertTrue(email_content_Actual.contains(email_content_expected_1R));*/
}

}