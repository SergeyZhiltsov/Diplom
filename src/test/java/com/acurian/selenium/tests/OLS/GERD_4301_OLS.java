package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.GERD.AreYouCurrentlyAbleToSwallowTablets_OLS;
import com.acurian.selenium.pages.OLS.GERD.DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.GERD.HaveYouEverHadSurgeryOnStomach_OLS;
import com.acurian.selenium.pages.OLS.GERD.HowDoYouBuyFollowingMedications_OLS;
import com.acurian.selenium.pages.OLS.GERD.HowLongHaveYouBeenTaking_OLS;
import com.acurian.selenium.pages.OLS.GERD.ThinkingAboutThePast2Months_OLS;
import com.acurian.selenium.pages.OLS.GERD.WhatTypeOfSurgeryDidYouHave_OLS;
import com.acurian.selenium.pages.OLS.GERD.WhenDidYouHaveAppendixRemoved_OLS;
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
import com.acurian.selenium.pages.OLS.shared.WeightLossSurgeryPageOLS;
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
        String studyName = "a heartburn or reflux";
        String site_Indication = "Gastroesophageal Reflux Disease (GERD)";
        String siteName = "AUT_GER_4301_Site";
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
        //----DQ if selected any of these options in Q3:  None of the above
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
				.waitForMainPageLoad();
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
		
        
        //****************Q4 HowDoYouBuyFollowingMedications_OLS --------------
		howDoYouBuyFollowingMedications_OLS
			.waitForMainPageLoad()
			.waitForPageLoad(1,howDoYouBuyFollowingMedications_OLS.titleExpected1)
			.waitForPageLoad(2,howDoYouBuyFollowingMedications_OLS.titleExpected2)
			.waitForPageLoad(3,howDoYouBuyFollowingMedications_OLS.titleExpected3)
			.waitForPageLoad(4,howDoYouBuyFollowingMedications_OLS.titleExpected4);
	    Assert.assertEquals(howDoYouBuyFollowingMedications_OLS.getTitleText(1),howDoYouBuyFollowingMedications_OLS.titleExpected1, "Title is diff");
	    howDoYouBuyFollowingMedications_OLS
	    		.clickOnAnswerForSubQuestion(1, "With a prescription from my doctor that I get filled at the pharmacy counter")
		        .clickOnAnswerForSubQuestion(2,"I get this medication off the shelf, or \"over-the-counter\"")
		        .clickOnAnswerForSubQuestion(3, "With a prescription from my doctor that I get filled at the pharmacy counter")
		        .clickOnAnswerForSubQuestion(4,"I get this medication off the shelf, or \"over-the-counter\"")
		        .clickNextButton(new HowLongHaveYouBeenTaking_OLS());
	    
        

        //---------------Q5 HowLongHaveYouBeenTaking_OLS-------------------
		howLongHaveYouBeenTaking_OLS
				.waitForPageLoad(1,howDoYouBuyFollowingMedications_OLS.titleExpected1)
				.waitForPageLoad(2,howDoYouBuyFollowingMedications_OLS.titleExpected2)
				.waitForPageLoad(3,howDoYouBuyFollowingMedications_OLS.titleExpected3)
				.waitForPageLoad(4,howDoYouBuyFollowingMedications_OLS.titleExpected4);
        Assert.assertEquals(howLongHaveYouBeenTaking_OLS.getTitleText(1),howLongHaveYouBeenTaking_OLS.titleExpected1, "Title is diff");
        DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS despiteTakingMedicationDoYouStillExperienceSymptoms_OLS = howLongHaveYouBeenTaking_OLS
        		.clickOnAnswerForSubQuestion(1, "Less than 1 month")
		        .clickOnAnswerForSubQuestion(2, "1 month")
		        .clickOnAnswerForSubQuestion(3, "Less than 1 month")
		        .clickOnAnswerForSubQuestion(4, "1 month")
		        .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS());
        despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6306", protocol1, protocol2);
		debugPageOLS.back();
		howLongHaveYouBeenTaking_OLS
				.waitForPageLoad(1,howDoYouBuyFollowingMedications_OLS.titleExpected1)
        		.clickOnAnswerForSubQuestion(1, "2 months")
		        .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS());
		
				
		
        //---------------Q7 DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS-------------------
		despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
        		.waitForPageLoad();
        Assert.assertEquals(despiteTakingMedicationDoYouStillExperienceSymptoms_OLS.getTitleText(),despiteTakingMedicationDoYouStillExperienceSymptoms_OLS.titleExpected, "Title is diff");
        despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
				.clickOnAnswer("No, my symptoms are well-controlled")
				.clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS())
				.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6307", protocol1, protocol2);
		debugPageOLS.back();
		despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
				.waitForPageLoad();
		ThinkingAboutThePast2Months_OLS thinkingAboutThePast2Months_OLS = despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
				.clickOnAnswer("Yes, I still have symptoms")
				.clickNextButton(new ThinkingAboutThePast2Months_OLS());
        
        
        
		//--------------Q8 ThinkingAboutThePast2Months_OLS ---------------------
		thinkingAboutThePast2Months_OLS
				.waitForPageLoad();
        Assert.assertEquals(thinkingAboutThePast2Months_OLS.getTitleText(),thinkingAboutThePast2Months_OLS.titleExpected, "Title is diff");
        thinkingAboutThePast2Months_OLS
        		.clickOnAnswer("1 day per week or less")
				.clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS())
        		.waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6308", protocol1, protocol2);
		debugPageOLS.back();
		thinkingAboutThePast2Months_OLS
				.waitForPageLoad()
				.clickOnAnswer("2 - 3 days per week")
				.clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6308", protocol1, protocol2);
		debugPageOLS.back();
		thinkingAboutThePast2Months_OLS
				.waitForPageLoad()
				.clickOnAnswer("4 - 5 days per week")
				.clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS());        
        
		
		
        //---------------Q9 HaveYouEverHadSurgeryOnStomach_OLS-------------------
        haveYouEverHadSurgeryOnStomach_OLS
        		.waitForPageLoad();
        Assert.assertEquals(haveYouEverHadSurgeryOnStomach_OLS.getTitleText(),haveYouEverHadSurgeryOnStomach_OLS.titleExpected, "Title is diff");
        AreYouCurrentlyAbleToSwallowTablets_OLS areYouCurrentlyAbleToSwallowTablets_OLS = haveYouEverHadSurgeryOnStomach_OLS
               .clickOnAnswer("No")
               .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_OLS())
               .waitForPageLoad();
        areYouCurrentlyAbleToSwallowTablets_OLS
        		.back();
        haveYouEverHadSurgeryOnStomach_OLS
				.waitForPageLoad();
        WhatTypeOfSurgeryDidYouHave_OLS whatTypeOfSurgeryDidYouHave_OLS = haveYouEverHadSurgeryOnStomach_OLS
				.clickOnAnswer("Yes")
				.clickNextButton(new WhatTypeOfSurgeryDidYouHave_OLS());
        
        
        
        //---------------Q10 WhatTypeOfSurgeryDidYouHave_OLS-------------------
        whatTypeOfSurgeryDidYouHave_OLS
        	.waitForPageLoad();
        Assert.assertEquals(whatTypeOfSurgeryDidYouHave_OLS.getTitleText(),whatTypeOfSurgeryDidYouHave_OLS.titleExpected, "Title is diff");
        //---------SKIP to Q12 if selected "Other surgery on my stomach, intestines, colon, or esophagus"  or go to Q11--------
        whatTypeOfSurgeryDidYouHave_OLS
        	   .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
        	   .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_OLS())
               .waitForPageLoad()
               .back();
        whatTypeOfSurgeryDidYouHave_OLS
    			.waitForPageLoad();
        WhenDidYouHaveAppendixRemoved_OLS whenDidYouHaveAppendixRemoved_OLS = whatTypeOfSurgeryDidYouHave_OLS
         	    .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
        		.clickOnAnswers("Appendix removed - Appendectomy",
        						"Gallbladder removed - Cholecystectomy",
        						"Biopsy – removal of a small piece of tissue for analysis",
        						"Tonsils removed - Tonsillectomy",
        						"Hemorrhoids removed - Hemorrhoidectomy")
        		.clickNextButton(new WhenDidYouHaveAppendixRemoved_OLS());
        
        
        
        //---------------Q11 WhenDidYouHaveAppendixRemoved_OLS-------------------
        whenDidYouHaveAppendixRemoved_OLS
				.waitForPageLoad(1,whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
				.waitForPageLoad(2,whenDidYouHaveAppendixRemoved_OLS.titleExpected2);
				Assert.assertEquals(whenDidYouHaveAppendixRemoved_OLS.getTitleText(1),whenDidYouHaveAppendixRemoved_OLS.titleExpected1, "Title is diff");
        whenDidYouHaveAppendixRemoved_OLS
				.clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
        		.clickOnAnswerForSubQuestion(2, "4 - 6 months ago")
        		.clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_OLS())
        		.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6311", protocol1, protocol2);
		debugPageOLS.back();
		whenDidYouHaveAppendixRemoved_OLS
				.waitForPageLoad(1,whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
				.clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
				.clickOnAnswerForSubQuestion(2, "More than 6 months ago")
				.clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_OLS());
        
        
        //---------------Q12 AreYouCurrentlyAbleToSwallowTablets_OLS-------------------
		areYouCurrentlyAbleToSwallowTablets_OLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        	   .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
        		.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6312", protocol1, protocol2);
		debugPageOLS.back();
		areYouCurrentlyAbleToSwallowTablets_OLS
				.waitForPageLoad()
        		.clickOnAnswer("Yes")
         	    .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        	   
		
        //----------------------GENERAL HEALTH Questions -----------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Alzheimer's disease", "Lupus")
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        //----Do any of the following additional diagnoses apply to you? ------------
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad();
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Alzheimer's disease",
                        "Bipolar disorder",
                        "Cancer in the past 5 years, except skin cancer",
                        "Cirrhosis",
                        "Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS",
                        "Neuropathy (nerve damage due to diabetes or another condition)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());


        //----HEIGHT and WEIGHT Question ------------
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
//				.clickNextButton(new ChildrenUnderPageOLS());
//
//
//		//----Do you have any children under the age of 18 in your household? ------------
//		childrenUnderPageOLS
//				.waitForPageLoad()
//				.clickOnAnswer("No")
//				.clickNextButton(new TheStudySitePageOLS())
//				.waitForPageLoad()
//				.clickOnAnswer("Public transportation")
//				.clickNextButton(new WhatMedicalCoveragePageOLS())
//				.waitForPageLoad()
//				.clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                // ----------PII (IdentificationPageOLS)
                // Page--------------------
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
                .getPage(new HumanAPIOLS())
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
                .clickConnect()
                
                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}