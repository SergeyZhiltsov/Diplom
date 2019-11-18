package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AST_4337.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.InThePastYearHowManyTimesDidYouSeekMedicalOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class AST_4337_OLS extends BaseTest{

    @Test(enabled = false)
    @TestCaseId("00008")
    @Description("Asthma_4337_OLS")
    public void Asthma_4337_OLS() {
        String phoneNumberLBP = "AUTAMS1AST";
        List<String> protocols = Arrays.asList("205715");
        String protocol1 = "205715";
        String studyName = "an asthma";
        String siteName = "AUT_AST_4337_Site";
        String debugSiteName = "";       
        String zipCode = "19044";
        String Siteindicator = "Asthma";
        
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP);
        //        .waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleAsthma_4337_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        EverDiagnosedAsthmaPageOLS everDiagnosedAsthmaPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new EverDiagnosedAsthmaPageOLS());

        everDiagnosedAsthmaPageOLS
                .waitForPageLoad();
        Assert.assertEquals(everDiagnosedAsthmaPageOLS.getTitleText(),everDiagnosedAsthmaPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = everDiagnosedAsthmaPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(everDiagnosedAsthmaPageOLS.titleExpected, protocol1);
        debugPageOLS.back();
        WhenDiagnosedAsthmaPageOLS whenDiagnosedAsthmaPageOLS = everDiagnosedAsthmaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDiagnosedAsthmaPageOLS());

        whenDiagnosedAsthmaPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whenDiagnosedAsthmaPageOLS.getTitleText(),whenDiagnosedAsthmaPageOLS.titleExpected, "Title is diff");
        RescueInhalersPageOLS rescueInhalersPageOLS = whenDiagnosedAsthmaPageOLS
                .clickOnAnswer("Less than 1 year ago")
                .clickNextButton(new RescueInhalersPageOLS());
        rescueInhalersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whenDiagnosedAsthmaPageOLS.titleExpected, protocol1)
                .back();
        whenDiagnosedAsthmaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(rescueInhalersPageOLS);

        rescueInhalersPageOLS
                .waitForPageLoad();
        Assert.assertEquals(rescueInhalersPageOLS.getTitleText(),rescueInhalersPageOLS.titleExpected, "Title is diff");
        InhalersOrNebulizersPageOLS inhalersOrNebulizersPageOLS = rescueInhalersPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new InhalersOrNebulizersPageOLS());
        inhalersOrNebulizersPageOLS
                .waitForPageLoad()
                .back();
        RescueOrShortactingPageOLS rescueOrShortactingPageOLS = rescueInhalersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Metaproterenol")
                .clickNextButton(new RescueOrShortactingPageOLS());

        rescueOrShortactingPageOLS
                .waitForPageLoad();
        Assert.assertEquals(rescueOrShortactingPageOLS.getTitleText(),rescueOrShortactingPageOLS.titleExpected, "Title is diff");
        rescueOrShortactingPageOLS
                .clickOnAnswer("Every day")
                .clickNextButton(inhalersOrNebulizersPageOLS);

        inhalersOrNebulizersPageOLS
                .waitForPageLoad();
        Assert.assertEquals(inhalersOrNebulizersPageOLS.getTitleText(),inhalersOrNebulizersPageOLS.titleExpected, "Title is diff");
        CurrentlyTakingPillPageOLS currentlyTakingPillPageOLS = inhalersOrNebulizersPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyTakingPillPageOLS());
        currentlyTakingPillPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(inhalersOrNebulizersPageOLS.titleExpected, protocol1)
                .back();
        HowLongUsingInhalerPageOLS howLongUsingInhalerPageOLS = inhalersOrNebulizersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Aerospan (flunisolide)")
                .clickNextButton(new HowLongUsingInhalerPageOLS());
        howLongUsingInhalerPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(inhalersOrNebulizersPageOLS.titleExpected, protocol1)
                .back();
        inhalersOrNebulizersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Tudorza Pressair (aclidinium)")
                .clickNextButton(howLongUsingInhalerPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(inhalersOrNebulizersPageOLS.titleExpected, protocol1)
                .back();
        inhalersOrNebulizersPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Advair Diskus or Advair HFA (fluticasone and salmeterol)")
                .clickNextButton(howLongUsingInhalerPageOLS);

        howLongUsingInhalerPageOLS
                .waitForPageLoad();
        Assert.assertEquals(howLongUsingInhalerPageOLS.getTitleText(), howLongUsingInhalerPageOLS.titleExpected, "Title is diff");
        howLongUsingInhalerPageOLS
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(currentlyTakingPillPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(howLongUsingInhalerPageOLS.titleExpected, protocol1)
                .back();
        howLongUsingInhalerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 months")
                .clickNextButton(currentlyTakingPillPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(howLongUsingInhalerPageOLS.titleExpected, protocol1)
                .back();
        howLongUsingInhalerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(currentlyTakingPillPageOLS);

        currentlyTakingPillPageOLS
                .waitForPageLoad();
        Assert.assertEquals(currentlyTakingPillPageOLS.getTitleText(),currentlyTakingPillPageOLS.titleExpected, "Title is diff");
        RespiratorySymptomsPageOLS respiratorySymptomsPageOLS = currentlyTakingPillPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new RespiratorySymptomsPageOLS());
        respiratorySymptomsPageOLS
                .waitForPageLoad()
                .back();
        HowLongTakingPillPageOLS howLongTakingPillPageOLS = currentlyTakingPillPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Singulair (montelukast)")
                .clickNextButton(new HowLongTakingPillPageOLS());

        howLongTakingPillPageOLS
                .waitForPageLoad();
        Assert.assertEquals(howLongTakingPillPageOLS.getTitleText(),howLongTakingPillPageOLS.titleExpected, "Title is diff");
        howLongTakingPillPageOLS
                .clickOnAnswer("Less than 1 month")
                .clickNextButton(respiratorySymptomsPageOLS);

        //SubquestionHospitalizedOvernightPageOLS subquestionHospitalizedOvernightPageOLS = respiratorySymptomsPageOLS
        InThePastYearHowManyTimesDidYouSeekMedicalOLS inThePastYearHowManyTimesDidYouSeekMedicalOLS = respiratorySymptomsPageOLS
        		.waitForPageLoad()
                .clickOnAnswers("Xolair (omalizumab)")
                .clickNextButton(new InThePastYearHowManyTimesDidYouSeekMedicalOLS());

        inThePastYearHowManyTimesDidYouSeekMedicalOLS
                .waitForPageLoad();
        Assert.assertEquals(inThePastYearHowManyTimesDidYouSeekMedicalOLS.getTitleText(),inThePastYearHowManyTimesDidYouSeekMedicalOLS.titleExpected, "Title is diff");
        TheseSymptomsPageOLS theseSymptomsPageOLS = inThePastYearHowManyTimesDidYouSeekMedicalOLS
                .clickOnAnswer("None")
                .clickNextButton(new TheseSymptomsPageOLS());
        theseSymptomsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("In the past year, how many times did you have to seek any medical attention (at a hospital, ER, urge...", protocol1)
                .back();
        inThePastYearHowManyTimesDidYouSeekMedicalOLS
        .waitForPageLoad()
        .clickOnAnswer("Once")
        .clickNextButton(new TheseSymptomsPageOLS());

        theseSymptomsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(theseSymptomsPageOLS.getTitleText(),theseSymptomsPageOLS.titleExpected, "Title is diff");
        SmokedCigarettesPageOLS smokedCigarettesPageOLS = theseSymptomsPageOLS
                .clickOnAnswer("Less than once a week")
                .clickNextButton(new SmokedCigarettesPageOLS());
        smokedCigarettesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(theseSymptomsPageOLS.titleExpected, protocol1)
                .back();
        theseSymptomsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Every day")
                .clickNextButton(smokedCigarettesPageOLS);

        smokedCigarettesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(smokedCigarettesPageOLS.getTitleText(),smokedCigarettesPageOLS.titleExpected, "Title is diff");
        smokedCigarettesPageOLS
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .back();
        SubquestionSmokedCigarettePageOLS subquestionSmokedCigarettePageOLS = smokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(new SubquestionSmokedCigarettePageOLS());
        subquestionSmokedCigarettePageOLS
                .waitForPageLoad(1,subquestionSmokedCigarettePageOLS.titleExpected1)
                .getPage(debugPageOLS)
                .checkProtocolsEquals(smokedCigarettesPageOLS.titleExpected, protocol1)
                .back();
        smokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(subquestionSmokedCigarettePageOLS);

        subquestionSmokedCigarettePageOLS
                .waitForPageLoad(1,subquestionSmokedCigarettePageOLS.titleExpected2);
        Assert.assertEquals(subquestionSmokedCigarettePageOLS.getTitleText(1),subquestionSmokedCigarettePageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionSmokedCigarettePageOLS.getTitleText(2),subquestionSmokedCigarettePageOLS.titleExpected4, "Title is diff");
        subquestionSmokedCigarettePageOLS
                .setFirst("10")
                .setSecond("20")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Asthma Smoking History Logic", protocol1)
                .back();
        subquestionSmokedCigarettePageOLS
                .waitForPageLoad(1,subquestionSmokedCigarettePageOLS.titleExpected2)
                .setFirst("9")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        
        
        //----------*******NEW GENERAL HEALTH Questions********----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        	.waitForPageLoad()
        	.clickOnAnswers("None of the above")
        	.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        	.waitForPageLoad()
        	.clickOnAnswers("None of the above")   
        	.clickNextButton(new ApproximateHeightPageOLS())
		//----------ProvideHeight-Weight Page--------------------
        	.waitForPageLoad()
        	.setAll("5", "5", "160")
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
	        .waitForPageLoad(studyName)
	        .getPID()
	        .clickOnFacilityName(siteName)
	        .clickNextButton(new HSGeneralPageOLS())
	        .waitForPageLoad(Siteindicator)
	        .clickNextButton(new DoctorInformationCollectionPageOLS())        
	        .waitForPageLoad()
	        .clickNextButton(new HS1PageOLS())
	        .waitForPageLoad()        
	        .clickOkInPopUp()
	        .setSignature();
	        
/*	        //------------HUMAN API Interface in HelloSign----------------
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
	        .clickNextButton(new ThankYouCloseSimplePageOLS())*/

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        thankYouCloseSimplePageOLS
            .waitForPageLoad()
	        .clickNextButton(new AboutHealthPageOLS())
	        .waitForPageLoad()
	        .pidFromDbToLog(env);
    }
}
