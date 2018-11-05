package com.acurian.selenium.tests.OLS;

import java.time.Instant;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ChronicCough.ACEInhibitorsLS;
import com.acurian.selenium.pages.OLS.ChronicCough.CurrentlySufferFromChronicCoughOLS;
import com.acurian.selenium.pages.OLS.ChronicCough.DiagnosedWithFollowingConditionsOLS;
import com.acurian.selenium.pages.OLS.ChronicCough.DoYouStillHaveCoughOLS;
import com.acurian.selenium.pages.OLS.ChronicCough.ExperienceWithYourChronicCoughOLS;
import com.acurian.selenium.pages.OLS.ChronicCough.HowLongYouHadChronicCoughOLS;
import com.acurian.selenium.pages.OLS.ChronicCough.HowManyCigarettesOLS;
import com.acurian.selenium.pages.OLS.ChronicCough.QuitSmokingOLS;
import com.acurian.selenium.pages.OLS.ChronicCough.SymptomsGetBetterOLS;
import com.acurian.selenium.pages.OLS.ChronicCough.TreatingYourChronicCoughOLS;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.SubquestionsIBD_OLS;
import com.acurian.selenium.pages.OLS.OAB_4867.DoYouSufferFromOAB_OLS;
import com.acurian.selenium.pages.OLS.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_OLS;
import com.acurian.selenium.pages.OLS.OAB_4867.HaveYouEverHadBotoxInjectionbladder_OLS;
import com.acurian.selenium.pages.OLS.OAB_4867.SubquestionOABandBPH_OLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.AgeUnqualifiedClose_OLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.HSGeneralPageOLS;
import com.acurian.selenium.pages.OLS.closes.HumanAPIOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouSmokedCigarettes;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class OAB_BPH_4867_OLS extends BaseTest{

    @Test(enabled = false)
    @TestCaseId("0029")
    @Description("OAB_BPH_4867_OLS")
    public void OAB_BPH_4867_OLS_Script() {
        String phoneNumber = "AUTAMS1OAB";
        String protocol1 = "URO_901_1001";
        String studyName =  "an overactive bladder study";  //---an overactive bladder study
        String siteName = "AUT_OAB_4867";
        String zipCode = "08204";        
        String env = System.getProperty("acurian.env", "STG");

        String time = String.valueOf(Instant.now().getEpochSecond());
        time = time.substring(time.length()-4);
        String eMailId = "qa.acurian@gmail.com";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                	.openPage(env, phoneNumber)
                	.waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleOAB_Expected, "Title is diff");
        AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
                	.setDate("09092005")
                	.clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_OLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", protocol1);
		debugPageOLS.back();		
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
		           .setDate("09/09/1978")
		           .clickNextButton(new ZipCodePageOLS());
		
		GenderPageOLS genderPageOLS = zipCodePageOLS
				.waitForPageLoad()
				.typeZipCode(zipCode)
				.clickNextButton(new GenderPageOLS());
		
		
		//-------------If 'Female' AND selected "No" in Q2.1, Disqualify OAB
	    DoYouSufferFromOAB_OLS doYouSufferFromOAB_OLS = genderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("Female")
				.clickNextButton(new DoYouSufferFromOAB_OLS());
	   //-------------Display Q2.1		
	    HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouSufferFromOAB_OLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6502", protocol1);
		debugPageOLS.back();
		HaveYouEverHadBotoxInjectionbladder_OLS haveYouEverHadBotoxInjectionbladder_OLS = doYouSufferFromOAB_OLS
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new HaveYouEverHadBotoxInjectionbladder_OLS())
				.waitForPageLoad();
				haveYouEverHadBotoxInjectionbladder_OLS.back();
				haveYouEverHadBotoxInjectionbladder_OLS.waitForPageLoad();
				doYouSufferFromOAB_OLS.back();
				doYouSufferFromOAB_OLS.waitForPageLoad();
				
				
		//-------------Display Q2.2 for MALEs only ------------------
		genderPageOLS
				.waitForPageLoad();
		SubquestionOABandBPH_OLS subquestionOABandBPH_OLS = genderPageOLS
				.clickOnAnswer("Male")
				.clickNextButton(new SubquestionOABandBPH_OLS());
	   //-------------Display Q2.1
		subquestionOABandBPH_OLS
				.waitForPageLoad(1,subquestionOABandBPH_OLS.titleExpected1)
				.waitForPageLoad(2,subquestionOABandBPH_OLS.titleExpected2)
    //----------Select options for Q2.2 sub-question---------
				.clickOnAnswerForSubQuestion(1, "No")
				.clickOnAnswerForSubQuestion(2, "No")
				.clickNextButton(new HaveYouEverHadBotoxInjectionbladder_OLS())
				.waitForPageLoad();
				debugPageOLS.checkProtocolsContainsForQNumber("QS6502", protocol1);
				debugPageOLS.back();
		subquestionOABandBPH_OLS
				.waitForPageLoad(1,subquestionOABandBPH_OLS.titleExpected1)
				.waitForPageLoad(2,subquestionOABandBPH_OLS.titleExpected2)
				.clickOnAnswerForSubQuestion(1, "Yes")
				.clickOnAnswerForSubQuestion(2, "Yes")
				.clickNextButton(new HaveYouEverHadBotoxInjectionbladder_OLS());
		
		
		//-------------Q3:  Have you ever had a Botox injection into your bladder muscle?---
		haveYouEverHadBotoxInjectionbladder_OLS
				.waitForPageLoad();
		DoYouTakeAnyMedicationsControlHypertension_OLS doYouTakeAnyMedicationsControlHypertension_OLS = haveYouEverHadBotoxInjectionbladder_OLS
				.clickOnAnswer("Yes, within the past 6 weeks")
				.clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_OLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6503", protocol1);
		debugPageOLS.back();
		haveYouEverHadBotoxInjectionbladder_OLS
				.waitForPageLoad()
				.clickOnAnswer("Yes, more than 6 weeks ago")
				.clickOnAnswer("No, never")
				.clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_OLS());
				

		//-------------Q4:  Do you take any medications to control high blood pressure or hypertension?---
		doYouTakeAnyMedicationsControlHypertension_OLS
				.waitForPageLoad()
		//DoYouTakeAnyMedicationsControlHypertension_OLS doYouTakeAnyMedicationsControlHypertension_OLS = doYouTakeAnyMedicationsControlHypertension_OLS
				.clickOnAnswer("Yes")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6504", protocol1);
		debugPageOLS.back();
		haveYouEverHadBotoxInjectionbladder_OLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickOnAnswer("Unsure")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		
		//---------------------GENERAL HELATH--------------------------
		WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
				.waitForPageLoad()
				.clickOnAnswers("Kidney disease")
				.clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
		
		DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
				.waitForPageLoad()
				.clickOnAnswers("Dialysis")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS51", protocol1);
		debugPageOLS.back();
		whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
				.waitForPageLoad()
				.clickOnAnswers("Kidney transplant")
				.clickOnAnswers("Dialysis")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS51", protocol1);
		debugPageOLS.back();
		whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
				.waitForPageLoad()
				.clickOnAnswers("Neither")		
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
		
		ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Cirrhosis")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Drug or alcohol abuse within the past year")
				.clickOnAnswers("Cirrhosis")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Hepatitis B")
				.clickOnAnswers("Drug or alcohol abuse within the past year")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Hepatitis C")
				.clickOnAnswers("Hepatitis B")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("HIV or AIDS")
				.clickOnAnswers("Hepatitis C")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();		
				
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Schizophrenia")
				.clickOnAnswers("HIV or AIDS")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS61", protocol1);
		debugPageOLS.back();
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Cancer in the past 5 years, except skin cancer")
				.clickOnAnswers("Schizophrenia")
				.clickNextButton(new ApproximateHeightPageOLS());
		debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
		debugPageOLS.back();
		
		doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ApproximateHeightPageOLS());
		
		ChildrenUnderPageOLS childrenUnderPageOLS = approximateHeightPageOLS
				.waitForPageLoad()
				.setAll("5", "7", "166")
				.clickNextButton(new ChildrenUnderPageOLS());		
		 
		childrenUnderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
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
				.setAllFields("Acurian", "Trial", eMailId, "9999999999", zipCode)
				.clickNextButton(new SiteSelectionPageOLS())
	        
			//----------SiteSelection Page--------------------
				.waitForPageLoad(studyName)
				.getPID()
				.clickOnFacilityName(siteName)
				.clickNextButton(new HSGeneralPageOLS())
				.waitForPageLoad("Chronic Cough")
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
