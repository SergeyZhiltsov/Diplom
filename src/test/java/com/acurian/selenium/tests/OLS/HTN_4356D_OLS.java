package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class HTN_4356D_OLS extends BaseTest{

    @Test
    @TestCaseId("00031")
    @Description("HTN_4356D_Synexus test OLS")
    public void htn4356DolsTest() {
        String phoneNumberLBP = "AUTAMS1HTN";
        String protocol1 = "THR_1442_C_603";
        String protocol2 = "";
        List<String> protocols = Arrays.asList(protocol1,protocol2);
        String studyName = "a high blood pressure";
        String siteName = "AUT_HTN_4356D_Site";
        String debugSiteName = "";
        String env = "STG";
        String zipCode = "19044";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleHTNExpected, "Title is diff");
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
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = hasHealthcareProfessionalPageOLS
                .waitForPageLoad()
                .getPage(new DebugPageOLS())
                .checkIsNoProtocolsForQuestion("Ghost Question - HTN_4356D_Synexus End of Module Logic")
                .getPage(hasHealthcareProfessionalPageOLS)
                .clickOnAnswers("Heart Attack","Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(1),subquestionExperiencedHeartPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageOLS.getTitleText(2),subquestionExperiencedHeartPageOLS.titleExpected2, "Title is diff");
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS29", protocol1)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 5 years ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS29", protocol1)
                .back();
        AffectingYourMetabolismPageOLS affectingYourMetabolismPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1,"More than 5 years ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2,"More than 5 years ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CongestiveHeartFailurePageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageOLS());
        affectingYourMetabolismPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or high blood sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4",protocol1)
                .back();
        FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsPageOLS = affectingYourMetabolismPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or high blood sugar","High cholesterol or high triglycerides")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS());
        followingNeurologicalConditionsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4",protocol1)
                .back();
        SubquestionMetabolismPageOLS subquestionMetabolismPageOLS = affectingYourMetabolismPageOLS
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol or high triglycerides","High blood pressure or hypertension","Cirrhosis of the liver")
                .clickNextButton(new SubquestionMetabolismPageOLS());
        subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4",protocol1)
                .back();
        affectingYourMetabolismPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis of the liver","Kidney disease or currently on dialysis")
                .clickNextButton(subquestionMetabolismPageOLS);

        subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"No")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"Medications")
                .clickNextButton(followingNeurologicalConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7",protocol1)
                .back();
        subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"Yes")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"Medications","Dialysis")
                .clickNextButton(followingNeurologicalConditionsPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7",protocol1)
                .back();

        ViralConditionsPageOLS viralConditionsPageOLS = subquestionMetabolismPageOLS
                .waitForPageLoad(1,subquestionMetabolismPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionMetabolismPageOLS.titleExpected1,"Yes")
                .clickOnAnswersForSubQuestion(subquestionMetabolismPageOLS.titleExpected3,"None of the above")
                .clickNextButton(followingNeurologicalConditionsPageOLS)
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
                .clickNextButton(new ViralConditionsPageOLS());

        viralConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B or C")
                .clickNextButton(new InfectionClearedPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS15",protocol1)
                .back();
        MentalHealthPageOLS mentalHealthPageOLS = viralConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B or C","HIV or AIDS")
                .clickNextButton(new MentalHealthPageOLS());
        mentalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS15",protocol1)
                .back();
        viralConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(mentalHealthPageOLS);

        WomensHealthPageOLS womensHealthPageOLS = mentalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new WomensHealthPageOLS());
        womensHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS17",protocol1)
                .back();
        mentalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder","Schizophrenia")
                .clickNextButton(womensHealthPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS17",protocol1)
                .back();

        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = mentalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(womensHealthPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        SmokedCigarettesPageOLS smokedCigarettesPageOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, in the past 5 years")
                .clickNextButton(new SmokedCigarettesPageOLS());
        smokedCigarettesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS20",protocol1)
                .back();

        HistoryOfDrugPageOLS historyOfDrugPageOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(smokedCigarettesPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HistoryOfDrugPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, in the last 6 months")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS22",protocol1)
                .back();
        historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, 7 - 11 months ago")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS22",protocol1)
                .back();
        historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, 1 - 2 years ago")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS22",protocol1)
                .back();

        historyOfDrugPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new ChildrenUnderPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HouseholdHavePageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TheStudySitePageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WouldYouUsePageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Neither")
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
                .clickNextButton(new SynexusQualifiedClose4356PageOLS())
                .waitForPageLoad("625301")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForSENRPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();

    }
}
