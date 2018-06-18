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
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

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
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpected4356D, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
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
        		.clickOnAnswers("None of the above","Alzheimer's disease")
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
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env);
                //.getAnomalyDbToLog(env);
        
        
        
        
       /* SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(new DebugPageCC())
                .checkIsNoProtocolsForQuestion("Ghost Question - HTN_4356D_Synexus End of Module Logic")
                .getPage(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .clickOnAnswers("Heart Attack","Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad();
        Assert.assertEquals(subquestionExperiencedHeartPageCC.getTitleText(1),subquestionExperiencedHeartPageCC.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageCC.getTitleText(2),subquestionExperiencedHeartPageCC.titleExpected2, "Title is diff");
        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005123-QS29-STUDYQUES", protocol1)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"More than 5 years ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005123-QS29-STUDYQUES", protocol1)
                .back();
        AffectingYourMetabolismPageCC affectingYourMetabolismPageCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1,"More than 5 years ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2,"More than 5 years ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartFailureIsAlsoPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageCC());
        affectingYourMetabolismPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or high blood sugar")
                .clickNextButton(new WhatKindOfDiabetesPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004941-QS4-STUDYQUES",protocol1)
                .back();
        FollowingNeurologicalConditions followingNeurologicalConditions = affectingYourMetabolismPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or high blood sugar","High cholesterol or high triglycerides")
                .clickNextButton(new FollowingNeurologicalConditions());
        followingNeurologicalConditions
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004941-QS4-STUDYQUES",protocol1)
                .back();
        SubquestionMetabolismPageCC subquestionMetabolismPageCC = affectingYourMetabolismPageCC
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol or high triglycerides","High blood pressure or hypertension","Cirrhosis of the liver")
                .clickNextButton(new SubquestionMetabolismPageCC());
        subquestionMetabolismPageCC
                .waitForPageLoad(1,subquestionMetabolismPageCC.titleExpected1)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004941-QS4-STUDYQUES",protocol1)
                .back();
        affectingYourMetabolismPageCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis of the liver","Kidney disease or currently on dialysis")
                .clickNextButton(subquestionMetabolismPageCC);

        subquestionMetabolismPageCC
                .waitForPageLoad(1,subquestionMetabolismPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageCC.titleExpected1,"No")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageCC.titleExpected3,"Medications")
                .clickNextButton(followingNeurologicalConditions)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004946-QS7-STUDYQUES",protocol1)
                .back();
        subquestionMetabolismPageCC
                .waitForPageLoad(1,subquestionMetabolismPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageCC.titleExpected1,"Yes")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageCC.titleExpected3,"Medications","Dialysis")
                .clickNextButton(followingNeurologicalConditions)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004946-QS7-STUDYQUES",protocol1)
                .back();

        FollowingViralConditionsPageCC followingViralConditionsPageCC = subquestionMetabolismPageCC
                .waitForPageLoad(1,subquestionMetabolismPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageCC.titleExpected1,"Yes")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageCC.titleExpected3,"None of the above")
                .clickNextButton(followingNeurologicalConditions)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingDigestiveConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingSkinConditionsPageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingViralConditionsPageCC());

        followingViralConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B or C")
                .clickNextButton(new InfectionClearedPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004968-QS15-STUDYQUES",protocol1)
                .back();
        FollowingMentalHealthPageCC followingMentalHealthPageCC = followingViralConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B or C","HIV or AIDS")
                .clickNextButton(new FollowingMentalHealthPageCC());
        followingMentalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004968-QS15-STUDYQUES",protocol1)
                .back();
        followingViralConditionsPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(followingMentalHealthPageCC);

        FollowingWomensHealthPageCC followingWomensHealthPageCC = followingMentalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new FollowingWomensHealthPageCC());
        followingWomensHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004971-QS17-STUDYQUES",protocol1)
                .back();
        followingMentalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder","Schizophrenia")
                .clickNextButton(followingWomensHealthPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004971-QS17-STUDYQUES",protocol1)
                .back();

        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = followingMentalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(followingWomensHealthPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageCC());

        SmokedCigarettesPageCC smokedCigarettesPageCC = otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, in the past 5 years")
                .clickNextButton(new SmokedCigarettesPageCC());
        smokedCigarettesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004977-QS20-STUDYQUES",protocol1)
                .back();

        HistoryOfDrugPageCC historyOfDrugPageCC = otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(smokedCigarettesPageCC)
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HistoryOfDrugPageCC());

        ApproximateHeightPageCC approximateHeightPageCC = historyOfDrugPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, in the last 6 months")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004979-QS22-STUDYQUES",protocol1)
                .back();
        historyOfDrugPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, 7 - 11 months ago")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004979-QS22-STUDYQUES",protocol1)
                .back();
        historyOfDrugPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, 1 - 2 years ago")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004979-QS22-STUDYQUES",protocol1)
                .back();

        historyOfDrugPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                //----------PEDIATRIC HEALTH Questions----------
                .clickNextButton(new HouseholdHavePageCC())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                //.clickNextButton(new TheStudySitePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Public transportation")
                //.clickNextButton(new WhatMedicalCoveragePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("No, I have no coverage")
                //.clickNextButton(new EthnicBackgroundPageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Prefer not to answer")
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("a high blood pressure study")
                .getPID()
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
                .pidFromDbToLog(env); */
    }
}
