package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acurian.selenium.pages.BaseTest;
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
import com.acurian.selenium.pages.CC.RA_2821.WhenYouDiagnosedWithRaPageCC;
import com.acurian.selenium.pages.CC.closes.IncongruentSiteSelectionCloseCC;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransferClose1PageCC;
import com.acurian.selenium.pages.CC.closes.SRDirectScheduleWTTCPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusDirectScheduleWTC2PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusDirectScheduleWTC3PageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.HouseholdHavePageCC;
import com.acurian.selenium.pages.CC.shared.BiologicMedicationsCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.DoYouSufferFromArthritisCC;
import com.acurian.selenium.pages.CC.shared.EverTakenXeljanzCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.pages.CC.shared.WhenLastReceivedOrenciaCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class RA_4356F_CC extends BaseTest{
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)
	public void RA_4356F_CC(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1OA1";
        List<String> protocols = Arrays.asList("M15_925");//,"M13_545");
        String protocol1 = "M15_925";
        //String protocol2 = "M13_545";
        String protocol3 = "CL04041023";
        String studyName = "a rheumatoid arthritis (RA)";
        String indication = "an arthritis";
   //     String env = "PRD";
        String siteName = "AUT_RA_4356F_Site";
        String zipCode  = "19044";
        
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
      // Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedOA, "Title is diff");

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
       
       WhatKindOfArthritisCC whatKindOfArthritisCC = doYouSufferFromArthritisCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Yes")
    		   .clickNextButton(new WhatKindOfArthritisCC());
       
       WhenYouDiagnosedWithRaPageCC whenYouDiagnosedWithRaPageCC = whatKindOfArthritisCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
    		   .clickNextButton(new WhenYouDiagnosedWithRaPageCC());
       
       HowOldWereUWhenDiagnosedWithRACC howOldWereUWhenDiagnosedWithRACC = whenYouDiagnosedWithRaPageCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("7 - 11 months ago")
    		   .clickNextButton(new HowOldWereUWhenDiagnosedWithRACC());
       
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
    		   .clickOnAnswer("")
    		   .clickNextButton(new HowLongTakingMethotrexateCC());
       
       FollowingMedicationsToTreatYourRACC followingMedicationsToTreatYourRACC = howLongTakingMethotrexateCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("4 - 6 months")
    		   .clickNextButton(new FollowingMedicationsToTreatYourRACC());
       
       HowLongTakingPlaquenilCC howLongTakingPlaquenilCC = followingMedicationsToTreatYourRACC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Plaquenil (hydroxychloroquine)")
    		   .clickNextButton(new HowLongTakingPlaquenilCC());
       
       BiologicMedicationsCC biologicMedicationsCC = howLongTakingPlaquenilCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("4 - 6 months")
    		   .clickNextButton(new BiologicMedicationsCC());
       
       WhenLastReceivedOrenciaCC whenLastReceivedOrenciaCC = biologicMedicationsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Orencia (Agent Note: oh-REN-see-uh)")
    		   .clickNextButton(new WhenLastReceivedOrenciaCC());
       
       EverTakenXeljanzCC EverTakenXeljanzCC = whenLastReceivedOrenciaCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Last received 7 to 11 months ago")
    		   .clickNextButton(new EverTakenXeljanzCC());
       
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
               .clickNextButton(new IncongruentSiteSelectionCloseCC())
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

       //------------------OLD General Health--------------------
      /* haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickNextButton(new HaveYouUndergoneAnyPageCC())
               .waitForPageLoad()
               .clickOnAnswers("None of the above")
               .clickNextButton(new CongestiveHeartFailurePageCC())
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
               //----------PEDIATRIC HEALTH Questions----------
               //.clickNextButton(new HouseholdHavePageCC())
               //.waitForPageLoad()
               //.clickOnAnswers("None of the above")
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
               .waitForPageLoad(studyName)
               .getPID()
               .clickOnAnswer(siteName)
               .clickNextButton(new QualifiedClose2PageCC())
               .waitForPageLoad()
               .clickNextButton(new ThankYouCloseSimplePageCC())
               .waitForPageLoad()
               .clickNextButton(selectActionPageCC)
               .waitForPageLoad()
               .pidFromDbToLog(env);  */
	}
}
