package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AST_4337.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class AST_4337_OLS extends BaseTest{

    @Test
    @TestCaseId("00008")
    @Description("Asthma_4337_OLS")
    public void ast4337olsTest() {
        String phoneNumberLBP = "AUTAMS1AST";
        List<String> protocols = Arrays.asList("205715");
        String protocol1 = "205715";
        String studyName = "an asthma";
        String siteName = "AUT_AST_4337_Site";
        String debugSiteName = "";
        String env = "STG";
        String zipCode = "19044";
        String Siteindicator = "Asthma";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleAsthma_4337_Expected, "Title is diff");
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
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = everDiagnosedAsthmaPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());
        hasHealthcareProfessionalPageOLS
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

        SubquestionHospitalizedOvernightPageOLS subquestionHospitalizedOvernightPageOLS = respiratorySymptomsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Xolair (omalizumab)")
                .clickNextButton(new SubquestionHospitalizedOvernightPageOLS());

        subquestionHospitalizedOvernightPageOLS
                .waitForPageLoad(1,subquestionHospitalizedOvernightPageOLS.titleExpected1);
        Assert.assertEquals(subquestionHospitalizedOvernightPageOLS.getTitleText(1),subquestionHospitalizedOvernightPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionHospitalizedOvernightPageOLS.getTitleText(2),subquestionHospitalizedOvernightPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionHospitalizedOvernightPageOLS.getTitleText(3),subquestionHospitalizedOvernightPageOLS.titleExpected3, "Title is diff");
        TheseSymptomsPageOLS theseSymptomsPageOLS = subquestionHospitalizedOvernightPageOLS
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageOLS.titleExpected1,"No")
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageOLS.titleExpected2,"No")
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageOLS.titleExpected3,"No")
                .clickNextButton(new TheseSymptomsPageOLS());
        theseSymptomsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Asthma Exacerbation Logic", protocol1)
                .back();
        SubquestionTheHospitalPageOLS subquestionTheHospitalPageOLS = subquestionHospitalizedOvernightPageOLS
                .waitForPageLoad(1,subquestionHospitalizedOvernightPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageOLS.titleExpected1,"Yes")
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageOLS.titleExpected2,"Yes")
                .clickOnAnswerForSubQuestion(subquestionHospitalizedOvernightPageOLS.titleExpected3,"Yes")
                .clickNextButton(new SubquestionTheHospitalPageOLS());

        subquestionTheHospitalPageOLS
                .waitForPageLoad(1,subquestionTheHospitalPageOLS.titleExpected1);
        Assert.assertEquals(subquestionTheHospitalPageOLS.getTitleText(1),subquestionTheHospitalPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionTheHospitalPageOLS.getTitleText(2),subquestionTheHospitalPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionTheHospitalPageOLS.getTitleText(3),subquestionTheHospitalPageOLS.titleExpected3, "Title is diff");
        SeekMedicalPageOLS seekMedicalPageOLS = subquestionTheHospitalPageOLS
                .clickOnAnswersForSubQuestion(subquestionTheHospitalPageOLS.titleExpected1,"Inhaled nebulizer treatment")
                .clickOnAnswersForSubQuestion(subquestionTheHospitalPageOLS.titleExpected2,"Injection or shot")
                .clickOnAnswersForSubQuestion(subquestionTheHospitalPageOLS.titleExpected3,"Unsure")
                .clickNextButton(new SeekMedicalPageOLS());

        seekMedicalPageOLS
                .waitForPageLoad();
        Assert.assertEquals(seekMedicalPageOLS.getTitleText(),seekMedicalPageOLS.titleExpected, "Title is diff");
        seekMedicalPageOLS
                .clickOnAnswer("Once")
                .clickNextButton(theseSymptomsPageOLS);

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
                .clickNextButton(hasHealthcareProfessionalPageOLS)
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
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Asthma Smoking History Logic", protocol1)
                .back();
        subquestionSmokedCigarettePageOLS
                .waitForPageLoad(1,subquestionSmokedCigarettePageOLS.titleExpected2)
                .setFirst("9")
                .clickNextButton(hasHealthcareProfessionalPageOLS);


        hasHealthcareProfessionalPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CongestiveHeartFailurePageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SkinConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ViralConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new MentalHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WomensHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HistoryOfDrugPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new ChildrenUnderPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Public transportation")
//                .clickNextButton(new WouldYouUsePageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Neither")
                .clickNextButton(new WhatMedicalCoveragePageOLS())
                .waitForPageLoad()
                .clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
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
                .getPage(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
