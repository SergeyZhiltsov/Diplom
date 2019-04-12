package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.BiologicMedicationsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.DiagnosedWithCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.ManageYourCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.WhenDiagnosedCrohnsPageCC;
import com.acurian.selenium.pages.CC.IBD.CurrentlyExperiencingFlareUpCC;
import com.acurian.selenium.pages.CC.IBD.OtherPrescriptionMedicinesIBDShort;
import com.acurian.selenium.pages.CC.IBD.SteroidMedicationsForCrohnsCC;
import com.acurian.selenium.pages.CC.closes.IncongruentSiteSelectionCloseCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class IBD_Short extends BaseTest{

    @Test()
    @Description("IBD Short for CC")
    public void IBD3264ccTest_Short() {
        String phoneNumber = "AUTAMSCRSH";
        String protocol1 = "M14_234";
        String protocol3 = "M16_006";
        String protocol2 = "SHP647_301";        
        List<String> protocols = Arrays.asList(protocol1,protocol2);
        String ibdStudy = "Ulcerative Colitis";
        String siteName = "AUT_IBD_3839_Site";
        String studyIndication = "Ulcerative Colitis";
        String zipCode = "19901";
        
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("a Crohn's study", "700"), "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC());
        DebugPageCC debugPageCC = new DebugPageCC();       
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol2);
        debugPageCC.back();
        
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC                
             /*   .setYear("1942")
                .clickNextButton(new IdentificationPageCC());              
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1);
        debugPageCC.back();
        dateOfBirthPageCC      */  		
        		.setYear("1937")
        		.clickNextButton(new IdentificationPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol2);
        debugPageCC.back();        
        dateOfBirthPageCC		   		
		   		.setYear("1980")
		   		.clickNextButton(new IdentificationPageCC()); 
        
       
        GenderPageCC genderPageCC = identificationPageCC
     		   .waitForPageLoad1()
     		   .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
     		   .clickNextButton(new GenderPageCC());
        
        DiagnosedWithCrohnsPageCC  diagnosedWithCrohnsPageCC = genderPageCC
     		   .waitForPageLoad()
     		   .clickOnAnswer("Female")
     		   .clickNextButton(new DiagnosedWithCrohnsPageCC());
        
        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = diagnosedWithCrohnsPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("Crohn's disease")
        		.clickNextButton(new WhenDiagnosedCrohnsPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", protocol2);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", protocol2);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
				.waitForPageLoad()
				.clickOnAnswers("Ulcerative colitis")
				.clickNextButton(new WhenDiagnosedCrohnsPageCC());
        
        whenDiagnosedCrohnsPageCC
        		.waitForPageLoadULC()
        		.clickOnAnswer("Less than 3 months ago")
        		.clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015881-QS5704-STUDYQUES", protocol2);
        debugPageCC.back();
        whenDiagnosedCrohnsPageCC
				.waitForPageLoadULC()
				.clickOnAnswer("Not officially diagnosed with ulcerative colitis by a doctor")
				.clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015881-QS5704-STUDYQUES", protocol2);
        debugPageCC.back();
        ManageYourCrohnsPageCC manageYourCrohnsPageCC = whenDiagnosedCrohnsPageCC
				.waitForPageLoadULC()
				.clickOnAnswer("More than 6 months ago")
				.clickNextButton(new ManageYourCrohnsPageCC());      
                
        CurrentlyExperiencingFlareUpCC currentlyExperiencingFlareUpCC = manageYourCrohnsPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015883-QS5706-STUDYQUES", protocol2);
        debugPageCC.back();
        SteroidMedicationsForCrohnsCC steroidMedicationsForCrohnsCC = manageYourCrohnsPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		.clickNextButton(new SteroidMedicationsForCrohnsCC());        
                
        BiologicMedicationsPageCC biologicMedicationsPageCC = steroidMedicationsForCrohnsCC
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new BiologicMedicationsPageCC());      
        
        OtherPrescriptionMedicinesIBDShort otherPrescriptionMedicinesIBDShort = biologicMedicationsPageCC        		
        		.clickOnAnswers("Kineret (Agent Note: KIN-er-et)")
        		.clickNextButton(new OtherPrescriptionMedicinesIBDShort());
        
      /*  debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS5710-STUDYQUES", protocol2);
        debugPageCC.back();
        biologicMedicationsPageCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Raptiva (Agent Note: rap-TEE-vuh)", "Tysabri (Agent Note: tie-SAB-ree)")
				.clickNextButton(new OtherPrescriptionMedicinesIBDShort());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS5710-STUDYQUES", protocol2);
        debugPageCC.back();
        biologicMedicationsPageCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new OtherPrescriptionMedicinesIBDShort()); */
        
        otherPrescriptionMedicinesIBDShort
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015901-QS5713-STUDYQUES", protocol3);
        debugPageCC.back();
        otherPrescriptionMedicinesIBDShort.back();
        
        biologicMedicationsPageCC				
				.clickOnAnswers("None of the above")
				.clickNextButton(new OtherPrescriptionMedicinesIBDShort());

        otherPrescriptionMedicinesIBDShort
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new CurrentlyExperiencingFlareUpCC());
        
        currentlyExperiencingFlareUpCC
        		.waitForPageLoad()
        		.clickOnAnswer("No, I am not currently in a flare with my Crohn's or colitis")
//        		.clickNextButton(new ChildrenUnderPageCC());
//
//
//        childrenUnderPageCC
//        		.waitForPageLoad()
//        		.clickOnAnswer("No")
        		.clickNextButton(new IdentificationPageCC())
        		.waitForPageLoad()        		              
        		.clickNextButton(new IncongruentSiteSelectionCloseCC())
        		.waitForPageLoadIBD("a colitis")
        		.getPID()
        		.clickOnAnswer(siteName)
        		.clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoadIBD()
                .clickNextButton(new ThankYouCloseSimplePageCC())  
        		.waitForPageLoad()
        		.clickNextButton(selectActionPageCC)
        		.waitForPageLoad()
        		.pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch("1R", "1R");
    }

}
