package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.GERD.HaveYouEverHadSurgeryOnStomach_OLS;
import com.acurian.selenium.pages.OLS.GERD.HowDoYouBuyFollowingMedications_OLS;
import com.acurian.selenium.pages.OLS.GERD.HowLongHaveYouBeenTaking_OLS;
import com.acurian.selenium.pages.OLS.GERD.WhichoOfFollowingMedicationsCurrentlyGERD_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HasDoctorEverDiagnosedYouMedicalCond_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HasDoctorEverDiagnosedYouWithLowTestosterone_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveDoctorEverDiagnosedYou_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveYouEverSmokedCigarettes_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveYouExperienceAnyOftheFollowing_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HaveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.LowT_TransitionalStatement_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.PersonalQuestionsOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.WhenWasTheLastTimeThatYouReceivedHeartProc_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.WhichOfTheFollowingMensHealthConditions_OLS;
import com.acurian.selenium.pages.OLS.MDD_3159.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfArthritisPage;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.util.Arrays;
import java.util.List;

public class GERD_4301_OLS extends BaseTest{

    @Test
    @TestCaseId("00023")
    @Description("GERD_4301_OLS")
    public void Gerd_4301_OLS() {
        String phoneNumber = "AUTAMSGERD";
        String protocol1 = "C3718_301";
        String protocol2 = "C3718_302";
        String studyName = "heartburn, reflux, or GERD history";
        String site_Indication = "Hypogonadism";
        String siteName = "AUT_LOWT_3017_Site";
        String zipCode = "19901";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";
        
        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleGERD_4301_Expected, "Title is diff");
        

        AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
                .setDate("08082005")
                .clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_OLS
        		.waitForPageLoad();
				DebugPageOLS debugPageOLS = new DebugPageOLS();
				ageUnqualifiedClose_OLS.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QSI8004", protocol1, protocol2)
				.back();
				dateOfBirthPageOLS.waitForPageLoad();
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
				.setDate("09091980")
				.clickNextButton(new ZipCodePageOLS());
			
			
        //---------------ZIP-CODE Question-------------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_OLS = genderPageOLS
                .clickOnAnswer("Female")
		        .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS());
        
	        
        //---------------Q2 DoYouExperienceAnyOfFollowingSymptoms_OLS page-------------------
        doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad();
        Assert.assertEquals(doYouExperienceAnyOfFollowingSymptoms_OLS.getTitleText(),doYouExperienceAnyOfFollowingSymptoms_OLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouExperienceAnyOfFollowingSymptoms_OLS
        		.clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS6302", protocol1, protocol2);
        		debugPageOLS.back();
        doYouExperienceAnyOfFollowingSymptoms_OLS
        		.waitForPageLoad();
        		WhichoOfFollowingMedicationsCurrentlyGERD_OLS whichoOfFollowingMedicationsCurrentlyGERD_OLS = doYouExperienceAnyOfFollowingSymptoms_OLS
                .clickOnAnswers("GERD which has been diagnosed by a medical professional",
                		"Heartburn, which can be felt as pain or a burning sensation behind the breastbone",
                		"Acid reflux or frequent regurgitation, which is a sensation of liquid or food coming back up into your throat without vomiting")
                .clickNextButton(new WhichoOfFollowingMedicationsCurrentlyGERD_OLS());
        		

        //---------------Q3 WhichoOfFollowingMedicationsCurrentlyGEwhichoOfFollowingMedicationsCurrentlyGERD_OLSRD_OLS-------------------
        whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .waitForPageLoad();
        Assert.assertEquals(whichoOfFollowingMedicationsCurrentlyGERD_OLS.getTitleText(),whichoOfFollowingMedicationsCurrentlyGERD_OLS.titleExpected, "Title is diff");
        HaveYouEverHadSurgeryOnStomach_OLS haveYouEverHadSurgeryOnStomach_OLS = whichoOfFollowingMedicationsCurrentlyGERD_OLS
        //----SKIP to Q9 if selected any of these options in Q3:  None of the above
        		.clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS());
        haveYouEverHadSurgeryOnStomach_OLS
        		.waitForPageLoad();
        		debugPageOLS.checkProtocolsContainsForQNumber("QS6303", protocol1, protocol2);
        		debugPageOLS.back();
        whichoOfFollowingMedicationsCurrentlyGERD_OLS
        		.waitForPageLoad(); 		
        //----SKIP to Q5 if selected any of these options in Q3:  Aciphex (rabeprazole), Dexilant (dexlansoprazole), Protonix (pantoprazole), None of the above
        HowLongHaveYouBeenTaking_OLS howLongHaveYouBeenTaking_OLS = whichoOfFollowingMedicationsCurrentlyGERD_OLS		
        		.clickOnAnswers("Aciphex (rabeprazole)",
                		"Dexilant (dexlansoprazole)",
                		"Protonix (pantoprazole)")
                .clickNextButton(new HowLongHaveYouBeenTaking_OLS());
        howLongHaveYouBeenTaking_OLS
				.waitForPageLoad();
				debugPageOLS.back();
		whichoOfFollowingMedicationsCurrentlyGERD_OLS
				.waitForPageLoad();
		HowDoYouBuyFollowingMedications_OLS howDoYouBuyFollowingMedications_OLS = whichoOfFollowingMedicationsCurrentlyGERD_OLS
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Nexium (esomeprazole)",
								"Prevacid (lansoprazole)",
								"Prilosec (omeprazole)",
								"Zegerid (omeprazole and sodium bicarbonate)")
				.clickNextButton(new HowDoYouBuyFollowingMedications_OLS());
		
        
        //*******########*********Q4 HowDoYouBuyFollowingMedications_OLS --##########------------
		howDoYouBuyFollowingMedications_OLS
        	.waitForPageLoad();
		Assert.assertEquals(howDoYouBuyFollowingMedications_OLS.getTitleText(),howDoYouBuyFollowingMedications_OLS.titleExpected, "Title is diff");
		AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS = howDoYouBuyFollowingMedications_OLS
		        .clickOnAnswer("With a prescription from my doctor that I get filled at the pharmacy counter")
		        .clickOnAnswer("I get this medication off the shelf, or \"over-the-counter\"")
		        .clickNextButton(new AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS());
		areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
        		.waitForPageLoad();
				debugPageOLS.back();
		howDoYouBuyFollowingMedications_OLS.waitForPageLoad()
				.clickOnAnswer("None of the above")
				.clickNextButton(new AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS());
        

        //---------------Q6 AreYouCurrentlyTakingAnyOfTheFollowingMedications_OLS-------------------
        areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
        	.waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS.getTitleText(),areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS.titleExpected, "Title is diff");
        //HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
        HaveYouEverSmokedCigarettes_OLS haveYouEverSmokedCigarettes_OLS = areYouCurrentlyTakingAnyOfTheFollowingMedications_OLS
                .clickOnAnswers("AndroGel",
                		"Endoderm patch",
                		"Axiron gel",
                		"Fortesta gel",
                		"Striant (testosterone buccal system)",
                		"Testim gel",
                		"Testosterone injection (Depo-Testosterone, Testosterone enanthate, Testosterone Cypionate, Delatestryl)",
                		"Clomiphene (brand name Serophene) or another anti-estrogen therapy",
                		"Other testosterone medication not on this list",
                		"Unsure")  
                .clickNextButton(new HaveYouEverSmokedCigarettes_OLS());
        
        
        //---------------Q7 HaveYouEverSmokedCigarettes_OLS-------------------
        haveYouEverSmokedCigarettes_OLS
        	.waitForPageLoad();
        Assert.assertEquals(haveYouEverSmokedCigarettes_OLS.getTitleText(),haveYouEverSmokedCigarettes_OLS.titleExpected, "Title is diff");
        HaveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS = haveYouEverSmokedCigarettes_OLS
               .clickOnAnswer("Yes, I currently smoke")
               .clickOnAnswer("I used to smoke, but have since quit")
               .clickOnAnswer("No, I never smoked")
        .clickNextButton(new HaveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS());
        
        
        
        //---------------Q8 HaveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS-------------------
        haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS
        	.waitForPageLoad();
        Assert.assertEquals(haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS.getTitleText(),haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS.titleExpected, "Title is diff");
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS = haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS
        //---------SKIP to Q10 if selected "None of the above"  or go to Q9--------
        	   .clickOnAnswers("None of the above")
        	   .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS())
               .waitForPageLoad();
        		HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS.back();
        haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS
            	.waitForPageLoad();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouExperiencedAnyOfFollowingHeartBloodVessel_OLS
        		.clickOnAnswers("Heart attack",
        						"Stroke",
        						"TIA or \"Mini-Stroke\"")
        		.clickNextButton(new SubquestionExperiencedHeartPageOLS());
        
        
        //---------------Q9 SubquestionExperiencedHeartPageOLS-------------------
        subquestionExperiencedHeartPageOLS
        		.waitForPageLoadHeartAttack();
        HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS = subquestionExperiencedHeartPageOLS
        		.clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
        		.clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
        		.clickOnAnswerForSubQuestion(3, "Less than 30 days ago")
        	   .clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());
        haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
        		.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5622", protocol1, protocol2);
		debugPageOLS.back();
		subquestionExperiencedHeartPageOLS.waitForPageLoad()
				.clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
				.clickOnAnswerForSubQuestion(2, "More than 6 months ago")
				.clickOnAnswerForSubQuestion(3, "More than 6 months ago")
				.clickNextButton(new HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS());
        	   
        	   
		
        //---------------Q10 HaveYouExperiencedAnyFollowingCardiovascularInterventions_OLS-------------------
		haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
        		.waitForPageLoad();
        Assert.assertEquals(haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS.getTitleText(),haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS.titleExpected, "Title is diff");
        HasDoctorEverDiagnosedYouMedicalCond_OLS hasDoctorEverDiagnosedYouMedicalCond_OLS = haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
        //---------SKIP to Q12 if selected "None of the above"  or go to Q11--------
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS())
        		.waitForPageLoad();
        hasDoctorEverDiagnosedYouMedicalCond_OLS.back();
        haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
            	.waitForPageLoad();
        WhenWasTheLastTimeThatYouReceivedHeartProc_OLS whenWasTheLastTimeThatYouReceivedHeartProc_OLS = haveYouExperiencedAnyFollowingCardiovascularInterventions_OLS
        		.clickOnAnswers("Percutaneous Coronary Intervention, or Stent placement (a procedure or surgery to open up blockages in the arteries in your heart)", 
        						"Coronary Artery Bypass Graft, also known as CABG, \"cabbage,\" or heart bypass surgery",
        						"Cerebrovascular Revascularization (a procedure or surgery to open up blockages in the arteries in your neck or head), which is a blood vessel graft to restore blood flow to the brain or parts of the brain", 
        						"Peripheral Arterial Revascularization (a procedure or surgery to open up blockages in the arteries in your arms or legs)")
        		.clickNextButton(new WhenWasTheLastTimeThatYouReceivedHeartProc_OLS());
        
        
        
        //---------------Q11 WhenWasTheLastTimeThatYouReceivedHeartProc_OLS-------------------
        whenWasTheLastTimeThatYouReceivedHeartProc_OLS
        		.waitForPageLoad();
        Assert.assertEquals(whenWasTheLastTimeThatYouReceivedHeartProc_OLS.getTitleText(),whenWasTheLastTimeThatYouReceivedHeartProc_OLS.titleExpected, "Title is diff");
        whenWasTheLastTimeThatYouReceivedHeartProc_OLS
        		.clickOnAnswer("Less than 30 days ago")
        		.clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
        hasDoctorEverDiagnosedYouMedicalCond_OLS
        		.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5624", protocol1, protocol2);
		debugPageOLS.back();
		whenWasTheLastTimeThatYouReceivedHeartProc_OLS.waitForPageLoad()
				.clickOnAnswer("1 - 3 months ago")
        		.clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
		hasDoctorEverDiagnosedYouMedicalCond_OLS
        		.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5624", protocol1, protocol2);
		debugPageOLS.back();
		whenWasTheLastTimeThatYouReceivedHeartProc_OLS.waitForPageLoad()
				.clickOnAnswer("4 - 6 months ago")
				.clickOnAnswer("More than 6 months ago")
				.clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS());
		
		
        //---------------Q13 HasDoctorEverDiagnosedYouMedicalCond_OLS-------------------
		hasDoctorEverDiagnosedYouMedicalCond_OLS
        		.waitForPageLoad();
        Assert.assertEquals(hasDoctorEverDiagnosedYouMedicalCond_OLS.getTitleText(),hasDoctorEverDiagnosedYouMedicalCond_OLS.titleExpected, "Title is diff");
        ApproximateHeightPageOLS approximateHeightPageOLS = hasDoctorEverDiagnosedYouMedicalCond_OLS
        				.clickOnAnswers("History of Prostate or Breast Cancer",
        				"Other cancer within the past 2 years (except skin cancer)",
        				"Sleep apnea that is not currently being treated", 
        				"Drug, alcohol or steroid abuse in the past 12 months")
        		.clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
        		.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS5626", protocol1, protocol2);
		debugPageOLS.back();
		hasDoctorEverDiagnosedYouMedicalCond_OLS.waitForPageLoad()
				.clickOnAnswers("None of the above")
        		.clickNextButton(new ApproximateHeightPageOLS());
		
		
        //----------****************NEW GENERAL HEALTH Questions************************----------  
		//------------Q14 What is your approximate height?  What is your approximate weight?------
        approximateHeightPageOLS
        		.waitForPageLoad();
        //------Disqualify ("High BMI") if > 50  ---  Calculate BMI as (X lbs/2.2)/[(X inches/39.37) x (X inches/39.37)]----
        LowT_TransitionalStatement_OLS lowT_TransitionalStatement_OLS = approximateHeightPageOLS
        		.setAll("5", "0", "256")
        //.clickNextButton(new ChildrenUnderPageOLS())
        		.clickNextButton(new LowT_TransitionalStatement_OLS())
        		.waitForPageLoad();
         debugPageOLS.checkProtocolsContainsForQNumber("QS5627", protocol1, protocol2);
        lowT_TransitionalStatement_OLS.back();
        approximateHeightPageOLS.waitForPageLoad()
        //----------Change inches to maje BMI to <50--------------------
        .waitForPageLoad()
        .setIncheswithClear("5")
        .clickNextButton(new ChildrenUnderPageOLS())
        
        
		//----------ChildrenUnderTheAge Page--------------------
        .waitForPageLoad()
        .clickOnAnswer("Yes")
        .clickNextButton(new HouseholdHavePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("None of the above")
        .clickNextButton(new TheStudySitePageOLS())
        .waitForPageLoad()
        
		//-------------------PEDIATRIC QUESTIONS-----------------------------   
        .clickOnAnswer("Public transportation")
        .clickNextButton(new WhatMedicalCoveragePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("No, I have no coverage")
        .clickNextButton(new EthnicBackgroundPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("Prefer not to answer")
        .clickNextButton(new IdentificationPageOLS())
		//----------PII (IdentificationPageOLS) Page--------------------
		.waitForPageLoad()
        .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
        .clickNextButton(new SiteSelectionPageOLS())
        
		//----------SiteSelection Page--------------------
        .waitForPageLoad(studyName)
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new HSGeneralPageOLS())
        .waitForPageLoad(site_Indication)
        .clickNextButton(new DoctorInformationCollectionPageOLS())
        .waitForPageLoad()
        .clickNextButton(new HS1PageOLS())
        .waitForPageLoad()
        .clickOkInPopUp()
        .setSignature()
        
        //------------HUMAN API Interface in HelloSign----------------
        /*.getPage(new HumanAPIOLS())
        .waitForPageLoad()		        
        .connectBTN()
        .switchToAPI()
        .waitForProvider()
        .clickANY()
        .waitSearchAll()
        .search("cleveland clinic")
        .waitProvider()
        .clickProvider()
        .typeUserName("democlinical@gmail.com")
        .typePWD("password")
        .clickConnect()*/
        
        .waitToClickNext()
       // .threadSleep(2000);
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);
    }
}