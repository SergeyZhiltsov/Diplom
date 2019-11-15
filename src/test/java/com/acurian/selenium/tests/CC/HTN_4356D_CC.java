package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransferClose1PageCC;
import com.acurian.selenium.pages.CC.closes.SRDirectScheduleWTTCPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusDirectScheduleWTC2PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusDirectScheduleWTC3PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;


public class HTN_4356D_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)
    @TestCaseId("00045")
    @Description("HTN_4356D_Synexus test CC")
    public void htn_4356D_Synexus_CC(final String username, final String password) {
        String phoneNumber = "AUTAMS1HTN";
        String protocol1 = "THR_1442_C_603";
        String protocol2 = "";
        List<String> protocols = Arrays.asList(protocol1,protocol2);
        String studyName = "a high blood pressure study";
        String siteName = "AUT_HTN_4356D_Site";
        String debugSiteName = "";
        String zipCode = "19044";
        String facility_Code_STG = "625301";
        String facility_Code_PRD = "625869";
        
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpected4356D, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        
        
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(new DebugPageCC())
                .checkIsNoProtocolsForQuestion("Ghost Question - HTN_4356D_Synexus End of Module Logic")
                .getPage(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .clickOnAnswers("Alzheimer's disease")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad();
        Assert.assertEquals(doAnyOftheFollowingAdditionalDiagnosesCC.getTitleText(),doAnyOftheFollowingAdditionalDiagnosesCC.titleExpected, "Title is diff");
        DebugPageCC debugPageCC = new DebugPageCC();
        		doAnyOftheFollowingAdditionalDiagnosesCC.getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES", protocol1)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad();
        		DoYouTakeAnyMedicationsToControlHighBloodPressureCC doYouTakeAnyMedicationsToControlHighBloodPressureCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        		.clickOnAnswers("Alzheimer's disease","High blood pressure or hypertension")
        		.clickNextButton(new DoYouTakeAnyMedicationsToControlHighBloodPressureCC());

        
        doYouTakeAnyMedicationsToControlHighBloodPressureCC
        		.waitForPageLoad();
        		doYouTakeAnyMedicationsToControlHighBloodPressureCC.clickOnAnswer("No")
        		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        		doAnyOftheFollowingAdditionalDiagnosesCC
        			.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015141-QS50-STUDYQUES",protocol1)
                .back();
        		doYouTakeAnyMedicationsToControlHighBloodPressureCC.waitForPageLoad()
                .clickOnAnswer("Yes")
        		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

                
        doAnyOftheFollowingAdditionalDiagnosesCC
        		.waitForPageLoad()
                .clickOnAnswers("Bipolar disorder","Cancer in the past 5 years, except skin cancer","Cirrhosis","Drug or alcohol abuse within the past year", 
                		"Hepatitis B","Hepatitis C","HIV or AIDS")
                .clickNextButton(new HormonalBirthControlCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES",protocol1)
                .back();
        		doAnyOftheFollowingAdditionalDiagnosesCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new HormonalBirthControlCC())
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new ApproximateHeightPageCC())
    
		//----------ProvideHeight-Weight Page--------------------
				.waitForPageLoad()
				.setFeat("5")
				.setInches("5")
				.setLbs("155")
				.clickNextButton(new LetMeSeePageCC())
		
		//----------ChildrenUnderTheAge Page--------------------
				.clickNextButton(new ChildrenUnderPageCC())	
				.waitForPageLoad()
				.clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
			
		/*//-------------------PEDIATRIC QUESTIONS-----------------------------                            
		//----"theStudySitePageCC" page --  If you qualify for a study, how would you plan to travel to and from the study site?
                .clickNextButton(new TheStudySitePageCC())
                .waitForPageLoad()
		        .clickOnAnswers("Public transportation")
		        .clickNextButton(new WhatMedicalCoveragePageCC())
		                
		//-----"WhatMedicalCoveragePageCC" -  What sort of medical coverage do you have for your doctor visits, medication, surgery, and/or testing?-
		         .waitForPageLoad()
		         .clickOnAnswers("No, I have no coverage")
		         .clickNextButton(new EthnicBackgroundPageCC())
		                
		//----"EthnicBackgroundPageCC" page --  Which of the following describes your ethnic background?
		         .waitForPageLoad()
		         .clickOnAnswers("Prefer not to answer")
		         .clickNextButton(new IdentificationPageCC())	*/
						
		//----------PII (IdentificationPageCC) Page--------------------
				.waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
        		//----------SITE Selection Page--------------------
                .clickOnAnswer(siteName)
                .clickNextButton(new RadiantWarmTransferClose1PageCC())
                .waitForPageLoad()
                .clickOnAnswer("[patient agrees to be transferred]")
                .clickNextButton(new SynexusDirectScheduleWTC2PageCC())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SynexusDirectScheduleWTC3PageCC())
                .waitForPageLoad()
                .clickNextButton(new SRDirectScheduleWTTCPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Transferred for Scheduling")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
        		//.getRadiantDbToLog(env); //Radiant warm transfer and Radiant processing has been replaced with Direct Scheduling
                //.getAnomalyDbToLog(env); //Not applicable for Call center
    }
}
