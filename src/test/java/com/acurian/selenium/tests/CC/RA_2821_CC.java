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
import com.acurian.selenium.pages.CC.RA_2821.WhenWereYouDiagnosedWithRACC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectYourLungsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.AffectingYourMetabolismPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.BoneOrJointConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingDigestiveConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingMentalHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingNeurologicalConditions;
import com.acurian.selenium.pages.CC.generalHealth.FollowingSkinConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingViralConditionsPageCC;
import com.acurian.selenium.pages.CC.generalHealth.FollowingWomensHealthPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HasHealthcareProfessionalPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouUndergoneAnyPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartFailureIsAlsoPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HistoryOfDrugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.OtherThanSkinCancerPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.SleepRelatedConditionsPageCC;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.pediatric.EthnicBackgroundPageCC;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.pediatric.WhatSortPageCC;
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
import com.acurian.selenium.pages.CC.shared.WhenLastReceivedTysabriCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class RA_2821_CC extends BaseTest{
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
	
	public void tc001Test(final String username, final String password) {
        String phoneNumberOA = "AUTAMS1OA1";
        List<String> protocols = Arrays.asList("M15_925","M13_545");
        String protocol1 = "M15_925";
        String protocol2 = "M13_545";
        String studyName = "arthritis";        
        String env = "PRD";
        String siteName = "AUT_RA2821_Site";
        String zipCode  = "19044";
        
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
       
       WhenWereYouDiagnosedWithRACC whenWereYouDiagnosedWithRACC = whatKindOfArthritisCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Rheumatoid arthritis")
    		   .clickNextButton(new WhenWereYouDiagnosedWithRACC());
       
       HowOldWereUWhenDiagnosedWithRACC howOldWereUWhenDiagnosedWithRACC = whenWereYouDiagnosedWithRACC
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
    		   .clickOnAnswers("Pain or swelling in at least 3 separate joints ")
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
       
       WhenLastReceivedTysabriCC whenLastReceivedTysabriCC = biologicMedicationsCC
    		   .waitForPageLoad()
    		   .clickOnAnswers("Tysabri")
    		   .clickNextButton(new WhenLastReceivedTysabriCC());
       
       EverTakenXeljanzCC EverTakenXeljanzCC = whenLastReceivedTysabriCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("Last received 7 to 11 months ago")
    		   .clickNextButton(new EverTakenXeljanzCC());
       
       TransitionStatementCC transitionStatementCC = EverTakenXeljanzCC
    		   .waitForPageLoad()
    		   .clickOnAnswer("No, I have never taken it")
    		   .clickNextButton(new TransitionStatementCC());
       
       HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC = transitionStatementCC
               .waitForPageLoad("RA")
               .clickNextButton(new HasHealthcareProfessionalPageCC());


       hasHealthcareProfessionalPageCC
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
               .clickNextButton(new TheStudySitePageCC())
               .waitForPageLoad()
               .clickOnAnswer("No")
               .clickNextButton(new WhatSortPageCC())
               .waitForPageLoad()
               .clickOnAnswers("No, I have no coverage")
               .clickNextButton(new EthnicBackgroundPageCC())
               .waitForPageLoad()
               .clickOnAnswers("Other")
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
               .waitForPageLoad();
       
       
	}

}
