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

public class Chronic_4471_OLS extends BaseTest{

    @Test(enabled = true)
    @TestCaseId("0019")
    @Description("4471 Chronic Cough")
    public void chronicCough_4471() {
        String phoneNumberMIG = "AUTAMS1MCC";
        String protocol1 = "MK_7264_027";
        String protocol2 = "MK_7264_030";
        String studyName =  "a chronic cough"; 
        String siteName = "AUT_MCC";
        String zipCode = "19341";        
        String env = System.getProperty("acurian.env", "STG");

        String time = String.valueOf(Instant.now().getEpochSecond());
        time = time.substring(time.length()-4);
        String eMailId = "qa.acurian@gmail.com";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                	.openPage(env, phoneNumberMIG)
                	.waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleMCCExpected, "Title is diff");
        AgeUnqualifiedClose_OLS ageUnqualifiedClose_OLS = dateOfBirthPageOLS
                	.setDate("09092003")
                	.clickNextButton(new AgeUnqualifiedClose_OLS());
        ageUnqualifiedClose_OLS.waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QSI8004", protocol1, protocol2);
		debugPageOLS.back();
		
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
		           .setDate("10/10/1980")
		           .clickNextButton(new ZipCodePageOLS());
		
		GenderPageOLS genderPageOLS = zipCodePageOLS
				.waitForPageLoad()
				.typeZipCode("19341")
				.clickNextButton(new GenderPageOLS());
		
		CurrentlySufferFromChronicCoughOLS currentlySufferFromChronicCoughOLS = genderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("Female")
				.clickNextButton(new CurrentlySufferFromChronicCoughOLS());
		
		HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = currentlySufferFromChronicCoughOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6202", protocol1, protocol2);
		debugPageOLS.back();
		
		HowLongYouHadChronicCoughOLS howLongYouHadChronicCoughOLS = currentlySufferFromChronicCoughOLS
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new HowLongYouHadChronicCoughOLS());
		
		TreatingYourChronicCoughOLS treatingYourChronicCoughOLS = howLongYouHadChronicCoughOLS
				.waitForPageLoad()
				.clickOnAnswer("Less than 6 months")
				.clickNextButton(new TreatingYourChronicCoughOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6203", protocol1, protocol2);
		debugPageOLS.back();
		
		howLongYouHadChronicCoughOLS
				.waitForPageLoad()
				.clickOnAnswer("1 year or longer")
				.clickNextButton(new TreatingYourChronicCoughOLS());
		
		HaveYouSmokedCigarettes haveYouSmokedCigarettes = treatingYourChronicCoughOLS
				.waitForPageLoad()
				.clickOnAnswers("No, have not treated")
				.clickNextButton(new HaveYouSmokedCigarettes())
				.waitForPageLoadNew();
		haveYouSmokedCigarettes.back();
		
		DoYouStillHaveCoughOLS doYouStillHaveCoughOLS = treatingYourChronicCoughOLS
				.waitForPageLoad()
				.clickOnAnswers("Yes, with prescription", "Yes, with over the counter")
				.clickNextButton(new DoYouStillHaveCoughOLS());
		
		doYouStillHaveCoughOLS
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new HaveYouSmokedCigarettes());
		
		DiagnosedWithFollowingConditionsOLS diagnosedWithFollowingConditionsOLS = haveYouSmokedCigarettes
				.waitForPageLoadNew()
				.clickOnAnswers("No, I never smoked")
				.clickNextButton(new DiagnosedWithFollowingConditionsOLS())
				.waitForPageLoad();
		diagnosedWithFollowingConditionsOLS.back();
		
		HowManyCigarettesOLS howManyCigarettesOLS = haveYouSmokedCigarettes
				.waitForPageLoadNew()
				.clickOnAnswers("Yes, I currently smoke")
				.clickNextButton(new HowManyCigarettesOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6206", protocol1, protocol2);
		debugPageOLS.back();
		
		QuitSmokingOLS quitSmokingOLS = haveYouSmokedCigarettes
				.waitForPageLoadNew()
				.clickOnAnswers("I used to smoke, but have since quit")
				.clickNextButton(new QuitSmokingOLS());
		
		quitSmokingOLS
				.waitForPageLoad()
				.clickOnAnswer("I quit smoking within the past year")
				.clickNextButton(new HowManyCigarettesOLS())
				.waitForPageLoad1();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6207", protocol1, protocol2);
		debugPageOLS.back();
		quitSmokingOLS
				.waitForPageLoad()
				.clickOnAnswer("I quit smoking more than a year ago")
				.clickNextButton(new HowManyCigarettesOLS());
		
		howManyCigarettesOLS
				.waitForPageLoad1()
				.enterYears("20")
				.howManyCigarettes("21")
				.clickNextButton(new DiagnosedWithFollowingConditionsOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6209", protocol1, protocol2);
		debugPageOLS.back();
		howManyCigarettesOLS
				.waitForPageLoad1()
				.enterYears("15")		
				.clickNextButton(new DiagnosedWithFollowingConditionsOLS());
		
		ACEInhibitorsLS aCEInhibitorsLS = diagnosedWithFollowingConditionsOLS
				.waitForPageLoad()
				.clickOnAnswers("Post-Nasal Drip (Upper Airway Cough Syndrome)", "Lung Cancer", "Tuberculosis (TB)")
				.clickNextButton(new ACEInhibitorsLS())
				.waitForPageLoad();
		aCEInhibitorsLS.back();
		diagnosedWithFollowingConditionsOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new ACEInhibitorsLS());
		
		ExperienceWithYourChronicCoughOLS experienceWithYourChronicCoughOLS = aCEInhibitorsLS
				.waitForPageLoad()
				.clickOnAnswers("Benazepril (Brand name: Lotensin)", "Captopril (Brand name: Capoten)", "Cilazapril (Brand name: Inhibace)", "Enalapril (Brand names: Vasotec, Renitec, Berlipril, Enap, Enapren)")
				.clickOnAnswers("Fosinopril (Brand names: Fositen, Monopril)", "Imidapril (Brand name: Tanatril)", "Lisinopril (Brand names: Listril, Lopril, Novatec, Prinivil, Zestril, Lisidigal)")
				.clickOnAnswers("Perindopril (Brand names: Coversyl, Coversum, Aceon)", "Quinapril (Brand name: Accupril)", "Ramipril (Brand names: Altace, Prilace, Ramace, Ramiwin, Triatec, Tritace)")
				.clickOnAnswers("Trandolapril ( Brand names: Mavik, Odrik, Gopten)", "Zofenopril (Brand names: Zofenil, Bifril, Zopranol)")
				.clickNextButton(new ExperienceWithYourChronicCoughOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS6211", protocol1, protocol2);
		debugPageOLS.back();
		aCEInhibitorsLS
				.waitForPageLoad()		
				.clickOnAnswers("None of the above")
				.clickNextButton(new ExperienceWithYourChronicCoughOLS());
		
		SymptomsGetBetterOLS symptomsGetBetterOLS = experienceWithYourChronicCoughOLS
				.waitForPageLoad()
				.clickOnAnswers("A runny or stuffy nose", "Frequent throat clearing and sore throat", "Hoarseness", "Coughing up blood", "Heartburn or a sour taste in your mouth")
				.clickNextButton(new SymptomsGetBetterOLS());
		
		symptomsGetBetterOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
		
		WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
				.waitForPageLoad()
				.clickOnAnswers("Kidney disease")
				.clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
		
		DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
				.waitForPageLoad()
				.clickOnAnswers("Dialysis")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS51", protocol1, protocol2);
		debugPageOLS.back();
		whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
				.waitForPageLoad()
				.clickOnAnswers("Kidney transplant")
				.clickOnAnswers("Dialysis")
				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
				.waitForPageLoad();
		debugPageOLS.checkProtocolsContainsForQNumber("QS51", protocol1, protocol2);
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
		
		EthnicBackgroundPageOLS ethnicBackgroundPageOLS = approximateHeightPageOLS
				.waitForPageLoad()
				.setAll("5", "7", "166")
                .clickNextButton(new EthnicBackgroundPageOLS());
        ethnicBackgroundPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", eMailId, "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
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
