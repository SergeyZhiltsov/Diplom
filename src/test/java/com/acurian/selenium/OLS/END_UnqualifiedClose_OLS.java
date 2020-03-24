package com.acurian.selenium.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.closes.AnotherSuperScrPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.closes.UnqualifiedCloseOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;

public class END_UnqualifiedClose_OLS extends BaseTest {

    @Test(enabled = false)
    public void endUnqualifiedCloseOLS() {
        Site site = Site.AUT_END_4385;
        String phoneNumberRA = "AUTAMS1END";
        String studyName = "an endometriosis";
        String ExpStudySwich = "4733";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumberRA)
                .waitForPageLoad("an endometriosis study", "1775");

        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("an endometriosis study", "1775"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageOLS());

        FollowingGynecologicalConditionOLS followingGynecologicalConditionOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("10/10/1980")
                .clickOnAnswer("Female")
                .clickNextButton(new FollowingGynecologicalConditionOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


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
//		        .clickNextButton(new ChildrenUnderPageOLS())
//		//----------ChildrenUnderTheAge Page--------------------
//		        .waitForPageLoad()
//		        .clickOnAnswer("Yes")
//		        .clickNextButton(new HouseholdHavePageOLS())
//		        .waitForPageLoad()
//		        .clickOnAnswers("None of the above")
//		        .clickNextButton(new TheStudySitePageOLS())
//		        .waitForPageLoad()
//		//-------------------PEDIATRIC QUESTIONS-----------------------------
//		        .clickOnAnswer("Public transportation")
//		        .clickNextButton(new WhatMedicalCoveragePageOLS())
//		        .waitForPageLoad()
//		        .clickOnAnswers("No, I have no coverage")
//                .clickNextButton(new EthnicBackgroundPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")
//                .clickNextButton(new AreYouInterestedInPneumoniaVaccineStudyOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS())
                .clickOnAnswers("None of the above")
                .clickNextButton(new PersonalDetails())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new UnqualifiedCloseOLS())
                //.waitForPageLoad()
                .clickOnAnswer("No");
        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();
        siteSelectionPageOLS
                .getPID()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .back(new UnqualifiedCloseOLS())
                //.waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AnotherSuperScrPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);

//                .clickNextButton(new ConfigPageOLS())
//                .getPID()
//                .openDebugWindow();
//        Assert.assertEquals(configPageOLS.getTextfromStudySwitch(), ExpStudySwich, "studySwitch from AMS1 to Standalone 4733 failed");
    }
}