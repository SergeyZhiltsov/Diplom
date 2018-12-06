package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.OA_3138.AreYouCurrentlyTakingCC;
import com.acurian.selenium.pages.CC.OA_3138.HowManyTotalDaysCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.Regular_WarmTransfer1;
import com.acurian.selenium.pages.CC.closes.Regular_WarmTransfer4;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OA_4831_CC_NonSynexus extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    public void OA_4831_CC_NonSynexus_Script(final String username, final String password) {
        String phoneNumber = "AUTAMS1OA1";
        String zipCode = "19901";
        String studyName = "osteoarthritis";
        String studyName1 = "an osteoarthritis study";
        String siteName = "AUT_OA_4831_site"; //Synexus Site - AUT_OA_4831_Syn
        String protocol1 = "R475_PN_1523_B";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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
                .clickOnAnswer("Call Back")
                .clickNextButton(new DateOfBirthPageCC());
        

        dateOfBirthPageCC
                .waitForPageLoad();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());
        

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());
        

        DoYouSufferFromArthritisCC doYouSufferFromArthritisCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritisCC());
        

        WhatKindOfArthritisCC whatKindOfArthritisPage = doYouSufferFromArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisCC());
        

        WhereYouHaveArthritisCC whereYouHaveArthritis = whatKindOfArthritisPage
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereYouHaveArthritisCC());
        

        TransitionStatementCC transitionStatementCC  = whereYouHaveArthritis
                .waitForPageLoad()
                .clickOnAnswers("Spine or shoulders")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
        		.waitForPageLoad(studyName);
		DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004964-QS4504-STUDYQUES", protocol1);
        debugPageCC.back();
        AnyTypeOfMedicationForYourArthritisCC anyTypeOfMedicationForYourArthritisCC = whereYouHaveArthritis
                .waitForPageLoad()
                .clickOnAnswers("Spine or shoulders")
                .clickOnAnswers("Left Hip")
                .clickOnAnswers("Right Hip")
                .clickNextButton(new AnyTypeOfMedicationForYourArthritisCC());

        
        NSAIDMedicationsForArthritisPainCC nSAIDMedicationsForArthritisPainCC = anyTypeOfMedicationForYourArthritisCC
        		.waitForPageLoad()
                .clickOnAnswer("I do not take any medication for arthritis pain") 
                .clickOnAnswer("1 - 2 days per week or less")
                .clickNextButton(new NSAIDMedicationsForArthritisPainCC());
        nSAIDMedicationsForArthritisPainCC
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0007717-QS4520-STUDYQUES", protocol1);
        debugPageCC.back();
        anyTypeOfMedicationForYourArthritisCC
        		.waitForPageLoad()
                .clickOnAnswer("3 days per week")
                .clickNextButton(new NSAIDMedicationsForArthritisPainCC());
        

        AreYouCurrentlyTakingCC areYouCurrentlyTakingCC = nSAIDMedicationsForArthritisPainCC
                .waitForPageLoad()
                .clickOnAnswers("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
                .clickNextButton(new AreYouCurrentlyTakingCC());
        
        

        HowManyTotalDaysCC howManyTotalDaysCC = areYouCurrentlyTakingCC
                .waitForPageLoad()
                .clickOnAnswers("Yes")
                .clickNextButton(new HowManyTotalDaysCC());
        

        MedicationsContainingAcetaminophenCC medicationsContainingAcetaminophenCC = howManyTotalDaysCC
                .waitForPageLoad()
                .clickOnAnswers("2 days")
                .clickNextButton(new MedicationsContainingAcetaminophenCC());
        

        HaveYouEverTakenPrescriptionPainCC haveYouEverTakenPrescriptionPainCC = medicationsContainingAcetaminophenCC
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new HaveYouEverTakenPrescriptionPainCC());
        

        HasYourDoctorEverPrescribedOpioidNarcotic_CC hasYourDoctorEverPrescribedOpioidNarcotic_CC = haveYouEverTakenPrescriptionPainCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcotic_CC());
        
        
        
        hasYourDoctorEverPrescribedOpioidNarcotic_CC
        		.waitForPageLoad()
        		.clickOnAnswer("No, my doctor never offered me a prescription for opioids or narcotics for pain")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        transitionStatementCC
        		.waitForPageLoad(studyName);
        debugPageCC.checkProtocolsContainsForQNumber("Q0005279-QS4511-STUDYQUES", protocol1);
        debugPageCC.back();
        AreYouCurrentlyOnPageCC areYouCurrentlyOnPageCC = hasYourDoctorEverPrescribedOpioidNarcotic_CC
        		.waitForPageLoad()
        		.clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
        		.clickNextButton(new AreYouCurrentlyOnPageCC());
        

        areYouCurrentlyOnPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, for arthritis")
                .clickOnAnswer("Yes, for another chronic condition")
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoad(studyName);
        		debugPageCC.checkProtocolsContainsForQNumber("Q0005281-QS4513-STUDYQUES", protocol1);
        		debugPageCC.back();
        areYouCurrentlyOnPageCC
                .waitForPageLoad();
        HaveYouEverHadKneeReplacementSurgery_CC haveYouEverHadKneeReplacementSurgery_CC = areYouCurrentlyOnPageCC
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgery_CC());
        
        
        
        //-----------HaveYouEverHadKneeReplacementSurgery_CC--------------------
        haveYouEverHadKneeReplacementSurgery_CC
        		.waitForPageLoad();
        HaveYouEverReceivedInjectionIntoYourKnee_CC haveYouEverReceivedInjectionIntoYourKnee_CC = haveYouEverHadKneeReplacementSurgery_CC
        		.clickOnAnswer("Yes, both knees have been replaced")
        		.clickOnAnswer("Yes, one knee has been replaced")
        		.clickOnAnswer("No")
        		.clickNextButton(new HaveYouEverReceivedInjectionIntoYourKnee_CC());
                
              
        //-----------HaveYouEverReceivedInjectionIntoYourKnee_CC--------------------
        haveYouEverReceivedInjectionIntoYourKnee_CC
        		.waitForPageLoad();
        HaveYouReceivedKneeInjection_CC haveYouReceivedKneeInjection_CC = haveYouEverReceivedInjectionIntoYourKnee_CC
        		.clickOnAnswers("Yes, a corticosteroid or \"steroid\" injection")
        		.clickOnAnswers("Yes, a joint fluid supplement injection such as Synvisc or Hyalgan")
        		.clickNextButton(new HaveYouReceivedKneeInjection_CC());        
                
                
        //-------------------------HaveYouReceivedKneeInjection_CC---------------
        haveYouReceivedKneeInjection_CC
				.waitForPageLoad();
        DevicesInYourBodyCC followingDevicesInYourBody = haveYouReceivedKneeInjection_CC
        		.clickOnAnswer("No")
        		.clickNextButton(new DevicesInYourBodyCC());  

        
        //---------------------------FollowingDevicesInYourBody--------------------
        followingDevicesInYourBody
                .waitForPageLoad();
        CarpalTunnelSyndromeCC carpalTunnelSyndromeCC  = followingDevicesInYourBody
                .clickOnAnswers("None of the above")
                .clickNextButton(new CarpalTunnelSyndromeCC());
        
        
        //---------------------DiagnosedwithCarpalTunnelSyndrome--------------
        carpalTunnelSyndromeCC
                .waitForPageLoad();
        AreYouCurrentlyReceivingWorkersPageCC areYouCurrentlyReceivingWorkersPageCC = carpalTunnelSyndromeCC
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPageCC());
        
        
        //------------------AreYouCurrentlyReceivingWorkersPage_CC-------------
        areYouCurrentlyReceivingWorkersPageCC
                .waitForPageLoad()        
                .clickOnAnswer("Yes")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        


        
//----------*******NEW GENERAL HEALTH Questions**************************----------      
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC       
        		.waitForPageLoad();
        WhichFollowingBonesJoints_CC whichFollowingBonesJoints_CC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        		.clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Autism spectrum","Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)","Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)","Cancer","Diabetes (type 1 or type 2)","Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)","Headaches (migraine, cluster, tension)","Heart or circulation problems (heart attack, heart failure, stroke)","High blood pressure or hypertension","High cholesterol, triglycerides, or lipids","Kidney disease","Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)","Lupus","Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)","Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)","Skin problems (eczema or atopic dermatitis, psoriasis)","Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
        .clickNextButton(new WhichFollowingBonesJoints_CC());
whichFollowingBonesJoints_CC
        .waitForPageLoad()
        .back();
WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickOnAnswers("Cancer")
        .clickNextButton(new WhenDiagnosedWithCancerCC());


DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancerCC
        .waitForPageLoad()
        .clickOnAnswer("Within the past 5 years")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1);
debugPageCC.back();
whenDiagnosedWithCancerCC.back();
KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        .waitForPageLoad()
        .clickOnAnswers("Kidney disease")
        .clickOnAnswers("Cancer")
        .clickNextButton(new KidneyProblemsPage());


kidneyProblemsPage
        .waitForPageLoad()
        .clickOnAnswers("Dialysis")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1);
debugPageCC.back();
kidneyProblemsPage
        .waitForPageLoad()
        .clickOnAnswers("Kidney transplant")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1);
debugPageCC.back();
kidneyProblemsPage
        .waitForPageLoad()
        .clickOnAnswers("Neither")
        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());


ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
        .waitForPageLoad()
        .clickOnAnswers("Cirrhosis")
        .clickNextButton(new ApproximateHeightPageCC());
approximateHeightPageCC.waitForPageLoad();
//debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
debugPageCC.back();
doAnyOftheFollowingAdditionalDiagnosesCC
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickOnAnswers("Hepatitis B")
        .clickNextButton(new ApproximateHeightPageCC());
approximateHeightPageCC.waitForPageLoad();
//debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
debugPageCC.back();
doAnyOftheFollowingAdditionalDiagnosesCC
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickOnAnswers("Hepatitis C")
        .clickNextButton(new ApproximateHeightPageCC());
approximateHeightPageCC.waitForPageLoad();
//debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
debugPageCC.back();
doAnyOftheFollowingAdditionalDiagnosesCC
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickOnAnswers("HIV or AIDS")
        .clickNextButton(new ApproximateHeightPageCC());
approximateHeightPageCC.waitForPageLoad();
//debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
debugPageCC.back();
doAnyOftheFollowingAdditionalDiagnosesCC
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickOnAnswers("Schizophrenia")
        .clickNextButton(new ApproximateHeightPageCC());
approximateHeightPageCC.waitForPageLoad();
//debugPageCC.checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES");
debugPageCC.back();
doAnyOftheFollowingAdditionalDiagnosesCC
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new ApproximateHeightPageCC())
        
                //----------ProvideHeight-Weight Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                //----------ChildrenUnderTheAge Page--------------------
                .waitForPageLoad()
                //----------PII (IdentificationPageOLS) Page--------------------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                //----------SITE Selection Page--------------------
                .waitForPageLoad(studyName1)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                //*******************Regular WARM TRANSFER (non-synexus)*******************
                .clickNextButton(new Regular_WarmTransfer1())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new Regular_WarmTransfer4())
                .waitForPageLoad()
                .clickOnAnswer("Successful transfer made to site")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}