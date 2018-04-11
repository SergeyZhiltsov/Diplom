package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.RA_2821.AnySteroidsForYourRACC;
import com.acurian.selenium.pages.CC.RA_2821.AreYouCurrentlyTakingMethotrexateCC;
import com.acurian.selenium.pages.CC.RA_2821.CurrentlyExperiencingJointSymptomsYourRACC;
import com.acurian.selenium.pages.CC.RA_2821.DoYouUseAnyOralSteroidCC;
import com.acurian.selenium.pages.CC.RA_2821.FollowingDescribesYourRASymptomsStartedCC;
import com.acurian.selenium.pages.CC.RA_2821.FollowingMedicationsToTreatYourRACC;
import com.acurian.selenium.pages.CC.RA_2821.HowLongTakingMethotrexateCC;
import com.acurian.selenium.pages.CC.RA_2821.HowLongTakingPlaquenilCC;
import com.acurian.selenium.pages.CC.RA_2821.HowOldWereUWhenDiagnosedWithRACC;
import com.acurian.selenium.pages.CC.RA_2821.TenderPainfulOrSwollenJointsCC;
import com.acurian.selenium.pages.CC.RA_2821.WhatTestsDoctorLedToDiagnosingRACC;
import com.acurian.selenium.pages.CC.RA_2821.WhenWereYouDiagnosedWithRACC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.IncongruentSiteSelectionCloseCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransferClose1PageCC;
import com.acurian.selenium.pages.CC.closes.SRDirectScheduleWTTCPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusDirectScheduleWTC2PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusDirectScheduleWTC3PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingDigestiveConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMentalHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingNeurologicalConditions;
import com.acurian.selenium.pages.CC.generalHealth.FollowingSkinConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingViralConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingWomensHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouUndergoneAnyPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartFailureIsAlsoPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HistoryOfDrugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.OtherThanSkinCancerPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SleepRelatedConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SmokedCigarettesPageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.HouseholdHavePageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatSortPageCC;
import com.acurian.selenium.pages.CC.shared.BiologicMedicationsCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.DoYouSufferFromArthritisCC;
import com.acurian.selenium.pages.CC.shared.EverTakenXeljanzCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.pages.CC.shared.WhenLastReceivedTysabriCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class RA_2821_CC extends BaseTest{
	
	@Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void rA_2821_CC(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1RA1";
        List<String> protocols = Arrays.asList("M15_925","M13_545");
        String protocol1 = "M15_925";
   //     String protocol2 = "M13_545"; This protocol is disabled
        String studyName = "Rheumatoid Arthritis";
        String studyName1 = "a rheumatoid arthritis (RA) study";
   //     String env = "PRD";
        String siteName = "AUT_RA2821_HS_Site";
        String zipCode  = "19044";
        
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
                .typePhoneNumber(phoneNumberOA)
                .clickPopupPhoneNumber(phoneNumberOA)
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
       Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedRA2821, "Title is diff");

       ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
               .setMonth("Sep")
               .setDay("9")
               .setYear("1980")
               .clickNextButton(new ZipCodePageCC());
       
       GenderPageCC genderPageCC = zipCodePageCC
    		   .waitForPageLoad()
    		   .typeZipCode("19044")
    		   .clickNextButton(new GenderPageCC());
       
       DoYouSufferFromArthritisCC doYouSufferFromArthritisCC = genderPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Female")
    		   .clickNextButton(new DoYouSufferFromArthritisCC());
       
       doYouSufferFromArthritisCC
	   .waitForPageLoad()	   
	   .clickOnAnswer("No")
	   .clickNextButton(new NonQRtransitionPageCC());

DebugPageCC debugPageCC = new DebugPageCC();
debugPageCC.checkProtocolsEquals(doYouSufferFromArthritisCC.titleExpected, protocol1);
debugPageCC.back();

WhatKindOfArthritisCC whatKindOfArthritisCC = doYouSufferFromArthritisCC
			.waitForPageLoad()
			.clickOnAnswer("Yes")
			.clickNextButton(new WhatKindOfArthritisCC());

WhenWereYouDiagnosedWithRACC whenWereYouDiagnosedWithRACC = whatKindOfArthritisCC
	   .waitForPageLoad()
	   .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
	   .clickNextButton(new WhenWereYouDiagnosedWithRACC());

whenWereYouDiagnosedWithRACC
	   .waitForPageLoad()
	   .clickOnAnswer("Within the past 2 months")
	   .clickNextButton(new HowOldWereUWhenDiagnosedWithRACC());

debugPageCC.checkProtocolsEquals(whenWereYouDiagnosedWithRACC.titleExpected, protocol1);
debugPageCC.back();

HowOldWereUWhenDiagnosedWithRACC howOldWereUWhenDiagnosedWithRACC = whenWereYouDiagnosedWithRACC
	   .waitForPageLoad()
	   .clickOnAnswer("7 - 11 months ago")	   
	   .clickNextButton(new HowOldWereUWhenDiagnosedWithRACC());       

howOldWereUWhenDiagnosedWithRACC
	   .waitForPageLoad()
	   .typeAge("16")
	   .clickNextButton(new FollowingDescribesYourRASymptomsStartedCC());

debugPageCC.checkProtocolsEquals("Approximately how old were you when you were diagnosed with RA?Agent Note: If patient is unsure, say...", protocol1);
debugPageCC.back();

FollowingDescribesYourRASymptomsStartedCC followingDescribesYourRASymptomsStartedCC = howOldWereUWhenDiagnosedWithRACC
	   .waitForPageLoad()
	   .typeAge("28")
	   .clickNextButton(new FollowingDescribesYourRASymptomsStartedCC());

WhatTestsDoctorLedToDiagnosingRACC whatTestsDoctorLedToDiagnosingRACC = followingDescribesYourRASymptomsStartedCC
	   .waitForPageLoad()
	   .clickOnAnswer("Symptoms took several months to develop; the pain built gradually over a period of time")
	   .clickNextButton(new WhatTestsDoctorLedToDiagnosingRACC());

TenderPainfulOrSwollenJointsCC tenderPainfulOrSwollenJointsCC = whatTestsDoctorLedToDiagnosingRACC
	   .waitForPageLoad()
	   .clickOnAnswers("An x-ray of your affected joints, which included multiple joints such as your hands and feet")
	   .clickNextButton(new TenderPainfulOrSwollenJointsCC());

tenderPainfulOrSwollenJointsCC
	   .waitForPageLoad()
	   .clickOnAnswer("No")
	   .clickNextButton(new CurrentlyExperiencingJointSymptomsYourRACC());

debugPageCC.checkProtocolsEquals(tenderPainfulOrSwollenJointsCC.titleExpected, protocol1);
debugPageCC.back();

CurrentlyExperiencingJointSymptomsYourRACC currentlyExperiencingJointSymptomsYourRACC = tenderPainfulOrSwollenJointsCC
	   .waitForPageLoad()
	   .clickOnAnswer("Yes")
	   .clickNextButton(new CurrentlyExperiencingJointSymptomsYourRACC());


DoYouUseAnyOralSteroidCC doYouUseAnyOralSteroidCC = currentlyExperiencingJointSymptomsYourRACC
	   .waitForPageLoad()
	   .clickOnAnswers("Pain or swelling in at least 3 separate joints")
	   .clickNextButton(new DoYouUseAnyOralSteroidCC());

AnySteroidsForYourRACC anySteroidsForYourRACC = doYouUseAnyOralSteroidCC
	   .waitForPageLoad()
	   .clickOnAnswer("No")
	   .clickNextButton(new AnySteroidsForYourRACC());

AreYouCurrentlyTakingMethotrexateCC areYouCurrentlyTakingMethotrexateCC = anySteroidsForYourRACC
	   .waitForPageLoad()
	   .clickOnAnswer("Yes")
	   .clickNextButton(new AreYouCurrentlyTakingMethotrexateCC());

HowLongTakingMethotrexateCC howLongTakingMethotrexateCC = areYouCurrentlyTakingMethotrexateCC
	   .waitForPageLoad()
	   .clickOnAnswer("Yes, I am taking methotrexate tablets or pills")
	   .clickNextButton(new HowLongTakingMethotrexateCC());

howLongTakingMethotrexateCC
	   .waitForPageLoad()
	   .clickOnAnswer("Less than 1 month")
	   .clickNextButton(new FollowingMedicationsToTreatYourRACC());

debugPageCC.checkProtocolsEquals(howLongTakingMethotrexateCC.titleExpected, protocol1);
debugPageCC.back();

FollowingMedicationsToTreatYourRACC followingMedicationsToTreatYourRACC = howLongTakingMethotrexateCC
	   .waitForPageLoad()
	   .clickOnAnswer("4 - 6 months")	   
	   .clickNextButton(new FollowingMedicationsToTreatYourRACC());     
      
followingMedicationsToTreatYourRACC
	   .waitForPageLoad()
	   .clickOnAnswers("Leukeran (chlorambucil)")
	   .clickNextButton(new BiologicMedicationsCC());

debugPageCC.checkProtocolsEquals("Are you currently taking any of the following medications to treat your RA?Agent Note: Read medicati...", protocol1);
debugPageCC.back();

HowLongTakingPlaquenilCC howLongTakingPlaquenilCC = followingMedicationsToTreatYourRACC
	   .waitForPageLoad()
	   .clickOnAnswers("Leukeran (chlorambucil)")
	   .clickOnAnswers("Plaquenil (hydroxychloroquine)")	         
	   .clickNextButton(new HowLongTakingPlaquenilCC());       

howLongTakingPlaquenilCC
	   .waitForPageLoad()
	   .clickOnAnswer("Less than 1 month")
	   .clickNextButton(new BiologicMedicationsCC());

debugPageCC.checkProtocolsEqualsForQNumber("Q0005220-QS521-STUDYQUES", protocol1);
debugPageCC.back();

BiologicMedicationsCC biologicMedicationsCC = howLongTakingPlaquenilCC
	   .waitForPageLoad()
	   .clickOnAnswer("4 - 6 months")      
	   .clickNextButton(new BiologicMedicationsCC());


biologicMedicationsCC
	   .waitForPageLoad()
	   .clickOnAnswers("None of the above")
	   .clickNextButton(new EverTakenXeljanzCC());

debugPageCC.checkProtocolsEquals("Ghost Question - 2821 RA bDMARD protocol logic - (\"bDMARD Exposure\") for M14-465 and M13-5...", protocol1);
debugPageCC.back();

WhenLastReceivedTysabriCC whenLastReceivedTysabriCC = biologicMedicationsCC
	   .waitForPageLoad()
	   .clickOnAnswers("Tysabri")	          
	   .clickNextButton(new WhenLastReceivedTysabriCC());


EverTakenXeljanzCC EverTakenXeljanzCC = whenLastReceivedTysabriCC
	   .waitForPageLoad()
	   .clickOnAnswer("Last received 7 to 11 months ago")
	   .clickNextButton(new EverTakenXeljanzCC());

EverTakenXeljanzCC
	   .waitForPageLoad()
	   .clickOnAnswer("Yes, I am currently taking it")
	   .clickNextButton(new TransitionStatementCC());

debugPageCC.checkProtocolsEquals("Xeljanz is a pill that is taken for rheumatoid arthritis (RA). Xeljanz is also called tofacitinib.Ha...", protocol1);
debugPageCC.back();

TransitionStatementCC transitionStatementCC = EverTakenXeljanzCC
	   .waitForPageLoad()
	   .clickOnAnswer("No, I have never taken it")	   
	   .clickNextButton(new TransitionStatementCC()); 
       
HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
               .waitForPageLoad("RA")
               .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

//-------------------New GENERAL HEALTH---------------------------
haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
		.waitForPageLoad()
		.clickOnAnswers("None of the above")                	
		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
		.waitForPageLoad()
		.clickOnAnswers("None of the above")
		.clickNextButton(new HormonalBirthControlCC())
		.waitForPageLoad()
		.clickOnAnswer("No")
        .clickNextButton(new ApproximateHeightPageCC())
		//----------Height and Weight Question Page--------------------
        .waitForPageLoad()
        .setAll("5", "5", "160")
        .clickNextButton(new LetMeSeePageCC())
		//----------ChildrenUnderTheAge Page--------------------
        .waitForPageLoad()
        .clickNextButton(new ChildrenUnderPageCC())
        .waitForPageLoad()
        .clickOnAnswer("Yes")
        //----------PEDIATRIC HEALTH Questions----------
        .clickNextButton(new HouseholdHavePageCC())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
		//----------PII (IdentificationPageOLS) Page--------------------
        .clickNextButton(new IdentificationPageCC())
        .waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
        .clickNextButton(new SiteSelectionPageCC())
        .waitForPageLoad(studyName1)
        .getPID()
        .clickOnAnswer(siteName)
        .clickNextButton(new HSGeneralCC())
        .waitForPageLoad(studyName)
        .clickNextButton(new DoctorInformationCollectionPageCC())
        .waitForPageLoad()
        .clickNextButton(new HSMedicalRecordsPageCC())
        .waitForPageLoad()
        .clickNextButton(new ThankYouCloseSimplePageCC())
        .waitForPageLoad()
        .clickNextButton(selectActionPageCC)
        .waitForPageLoad()
        .pidFromDbToLog(env);


/*-------------------OLD General Health------------------
haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickNextButton(new HaveYouUndergoneAnyPageCC())
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickNextButton(new HeartFailureIsAlsoPageCC())
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickNextButton(new AffectingYourMetabolismPageCC())
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickNextButton(new FollowingNeurologicalConditions())
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
               .clickNextButton(new FollowingViralConditionsPageCC())
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickNextButton(new FollowingMentalHealthPageCC())
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickNextButton(new FollowingWomensHealthPageCC())
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickNextButton(new OtherThanSkinCancerPageCC())
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickNextButton(new SmokedCigarettesPageCC())
               .waitForPageLoad()
               .clickOnAnswer("No, I never smoked")
               .clickNextButton(new HistoryOfDrugPageCC())
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickNextButton(new ApproximateHeightPageCC())
               .waitForPageLoad()
               .setAll("5", "5", "160")
               .clickNextButton(new LetMeSeePageCC())
               .waitForPageLoad()
               .clickNextButton(new ChildrenUnderPageCC())
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickNextButton(new IdentificationPageCC())
               .waitForPageLoad()
               .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
               .clickNextButton(new SiteSelectionPageCC())
               .waitForPageLoad(studyName1)
               .getPID()
               .clickOnAnswer(siteName)
               .clickNextButton(new HSGeneralCC())
               .waitForPageLoad(studyName)
               .clickNextButton(new DoctorInformationCollectionPageCC())
               .waitForPageLoad()
               .clickNextButton(new HSMedicalRecordsPageCC())
               .waitForPageLoad()
               .clickNextButton(new ThankYouCloseSimplePageCC())
               .waitForPageLoad()
               .clickNextButton(selectActionPageCC)
               .waitForPageLoad()
               .pidFromDbToLog(env);       */
	}

}
