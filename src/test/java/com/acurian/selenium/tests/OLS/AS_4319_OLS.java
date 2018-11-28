package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AS_4319.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AS_4319_OLS extends BaseTest {

    @Test(enabled = false)
    public void as_4319_OLS() {
        String phoneNumber = "AUTAMS1AS1";
        String protocol1 = "M16_098";
        List<String> protocols = Arrays.asList(protocol1);
        String studyName = "an ankylosing spondylitis (AS)";
        String siteName = "AUT_AS_4319";
        String zipCode = "19044";
        String Siteindicator = "Ankylosing Spondylitis";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleAS_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("10/10/1980")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageOLS());

        DiagnosedWithAnkylosingSpondylitisOLS diagnosedWithAnkylosingSpondylitisOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithAnkylosingSpondylitisOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedWithAnkylosingSpondylitisOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4715", protocol1)
                .back();
        DoYouSufferFromLbpPageOLS doYouSufferFromLbpPageOLS = diagnosedWithAnkylosingSpondylitisOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DoYouSufferFromLbpPageOLS());

        HowLongHaveLbpPageOLS howLongHaveLbpPageOLS = doYouSufferFromLbpPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveLbpPageOLS());

        HaveYouEverHadXrayOrMRIOLS haveYouEverHadXrayOrMRIOLS = howLongHaveLbpPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 months to 1 year")
                .clickNextButton(new HaveYouEverHadXrayOrMRIOLS());

        FollowingSymptomsMoreThanOnceWeekOLS followingSymptomsMoreThanOnceWeekOLS = haveYouEverHadXrayOrMRIOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new FollowingSymptomsMoreThanOnceWeekOLS());
        followingSymptomsMoreThanOnceWeekOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Have you ever had an x-ray or MRI of your back or pelvis, to look for signs of ankylosing spondyliti", protocol1)
                .back();
        SacroiliitisPageOLS sacroiliitisPageOLS = haveYouEverHadXrayOrMRIOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SacroiliitisPageOLS());

        FollowingSymptomsMoreThanOnceWeekOLS followingSymptomsMoreThanOnceWeekOLS1 = sacroiliitisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Doctor did not explain the x-ray or MRI at all")
                .clickNextButton(new FollowingSymptomsMoreThanOnceWeekOLS());

        BiologicMedications biologicMedications = followingSymptomsMoreThanOnceWeekOLS1
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BiologicMedications());

        TakenXeljanz takenXeljanz = biologicMedications
                .waitForPageLoad()
                .clickOnAnswers("Actemra", "Benlysta", "Cimzia", "Cosentyx")
                .clickNextButton(new TakenXeljanz());
        takenXeljanz
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4708", protocol1)
                .back();
        biologicMedications
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(takenXeljanz);

        AreYouWheelchairBoundOLS areYouWheelchairBoundOLS = takenXeljanz
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am currently taking it")
                .clickNextButton(new AreYouWheelchairBoundOLS());
        takenXeljanz
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4709", protocol1)
                .back();
        takenXeljanz
                .waitForPageLoad()
                .clickOnAnswer("I took it in the past, but not now")
                .clickNextButton(areYouWheelchairBoundOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4709", protocol1)
                .back();
        takenXeljanz
                .waitForPageLoad()
                .clickOnAnswer("No, I have never taken it")
                .clickNextButton(areYouWheelchairBoundOLS);

        FollowingDevicesInYourBody_OLS followingDevicesInYourBodyOLS = areYouWheelchairBoundOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new FollowingDevicesInYourBody_OLS());
        followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4710", protocol1)
                .back();
        areYouWheelchairBoundOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(followingDevicesInYourBodyOLS);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 = followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


        //----------*******NEW GENERAL HEALTH Questions********----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                //----------Q23 - Do any of the following additional diagnoses apply to you?--------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                //------------ New for AMS1 Rel.51, when Gender = Female --------
                .clickNextButton(new ApproximateHeightPageOLS())
                //----------ProvideHeight-Weight Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
//        	.clickNextButton(new ChildrenUnderPageOLS())
//		//----------ChildrenUnderTheAge Page--------------------
//	        .waitForPageLoad()
//	        .clickOnAnswer("Yes")
//	        .clickNextButton(new HouseholdHavePageOLS())
//	        .waitForPageLoad()
//	        .clickOnAnswers("None of the above")
//	        .clickNextButton(new TheStudySitePageOLS())
//	        .waitForPageLoad()
//		//-------------------PEDIATRIC QUESTIONS----------------------
//	        .clickOnAnswer("Public transportation")
//	        .clickNextButton(new WhatMedicalCoveragePageOLS())
//	        .waitForPageLoad()
//	        .clickOnAnswers("No, I have no coverage")
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