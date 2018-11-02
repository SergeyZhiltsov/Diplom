package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.*;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LMG_4686_OLS extends BaseTest {

    @Test(enabled = true)
    @TestCaseId("00056")
    @Description("MIG_4356B_Synexus_OLS module")
    public void lmg_4686_ols() {
        String phoneNumberMIG = "AUTAMS1MIG";
        String protocol1 = "I5Q_MC_CGAW";
        String studyName = "a migraine";
        String siteName = "AUT_LMG";
        String zip_Code = "19341";
        String site_Indication = "Migraines";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleLMGExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091982")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zip_Code)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DoYouSufferFromMigHeadachesOLS doYouSufferFromMigHeadachesOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromMigHeadachesOLS());

        doYouSufferFromMigHeadachesOLS
                .waitForPageLoad();
        Assert.assertEquals(doYouSufferFromMigHeadachesOLS.getTitleText(), doYouSufferFromMigHeadachesOLS.titleExpected, "Title is diff");
        HasDoctorDiagnosedYouWithClusterHeadache_OLS hasDoctorDiagnosedYouWithClusterHeadache_OLS = doYouSufferFromMigHeadachesOLS
                .clickOnAnswer("No")
                .clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_OLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6002", protocol1);
        debugPageOLS.back();

        AgeWhenDiagnosedWithMigOLS ageWhenDiagnosedWithMigOLS = doYouSufferFromMigHeadachesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AgeWhenDiagnosedWithMigOLS());

        ApproxHowLongSufferingFromMIG approxHowLongSufferingFromMIG = ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("51")
                .clickNextButton(new ApproxHowLongSufferingFromMIG());
        debugPageOLS.checkProtocolsContainsForQNumber("QS6003", protocol1);
        debugPageOLS.back();
        ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("37")
                .clickNextButton(new ApproxHowLongSufferingFromMIG());

        HowManyDaysYouSufferOLS howManyDaysYouSufferOLS = approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowManyDaysYouSufferOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS6004", protocol1);
        debugPageOLS.back();

        approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("6 - 11 months")
                .clickNextButton(new HowManyDaysYouSufferOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS6004", protocol1);
        debugPageOLS.back();
        approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(new HowManyDaysYouSufferOLS());

        WhichOfTheFollowingSymptomsOLS whichOfTheFollowingSymptomsOLS = howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("5")
                .clickNextButton(new WhichOfTheFollowingSymptomsOLS());

        HowManyDifferentMedicationsOLS howManyDifferentMedicationsOLS = whichOfTheFollowingSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswers("Eye pain / blurred vision", "Constipation", "Hearing problems", "Lightheadedness and/or fainting")
                .clickOnAnswers("Nausea and/or vomiting", "Throbbing or pulsating pain on sides of head", "Problems with your speech")
                .clickNextButton(new HowManyDifferentMedicationsOLS());

        FollowingMedicationsToPreventOLS followingMedicationsToPreventOLS = howManyDifferentMedicationsOLS
                .waitForPageLoad()
                .noOfMedications("4")
                .clickNextButton(new FollowingMedicationsToPreventOLS());

        CurrentlyTakeFollowingMedicationsOLS CurrentlyTakeFollowingMedicationsOLS = followingMedicationsToPreventOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CurrentlyTakeFollowingMedicationsOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS6008", protocol1);
        debugPageOLS.back();

        followingMedicationsToPreventOLS
                .waitForPageLoad()
                //.clickOnAnswers("Topamax, Qudexy, Trokendi, or topiramate")
                //.clickNextButton(new CurrentlyTakeFollowingMedicationsOLS());
                //debugPageOLS.checkProtocolsContainsForQNumber("QS6008", protocol1);
                //debugPageOLS.back();
                //followingMedicationsToPreventOLS
                //.waitForPageLoad()
                //.clickOnAnswers("Depacon or valproate, Depakote or divalproex", "Elavil or amitriptyline", "Sibelium or Flunarizine", "Timolol")
                //.clickNextButton(new CurrentlyTakeFollowingMedicationsOLS());
                //debugPageOLS.checkProtocolsContainsForQNumber("QS6008", protocol1);
                //debugPageOLS.back();
                //followingMedicationsToPreventOLS
                //.waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Sibelium or Flunarizine", "Timolol")
                .clickNextButton(new CurrentlyTakeFollowingMedicationsOLS());

        HowManyDaysYouTakeMedicationsOLS howManyDaysYouTakeMedicationsOLS = CurrentlyTakeFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("Alagesic", "Ascomp", "Bupap", "Dolgic", "Esgic", "Fioricet", "Fiorinal", "Margesic", "Orviban", "Phrenilin", "Promacet", "Repan")
                .clickOnAnswers("Butalbital", "Zebutal")
                .clickNextButton(new HowManyDaysYouTakeMedicationsOLS());

        TreatYourMigraineHeadachesOLS treatYourMigraineHeadachesOLS = howManyDaysYouTakeMedicationsOLS
                .waitForPageLoad()
                .selectDays("4")
                .clickNextButton(new TreatYourMigraineHeadachesOLS());

        treatYourMigraineHeadachesOLS
                .waitForPageLoad()
                .clickOnAnswers("Percocet, Oxycontin, or oxycodone", "Vicodin, Lortab, or hydrocodone", "Ultram or tramadol", "Tylenol #3, Tylenol #4, or codeine")
                .clickNextButton(new HowManyDaysYouTakeMedicationsOLS());

        MigraineAffectedYourAbilityOLS migraineAffectedYourAbilityOLS = howManyDaysYouTakeMedicationsOLS
                .waitForPageLoad()
                .selectDays("1")
                .clickNextButton(new MigraineAffectedYourAbilityOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS6022", protocol1);
        debugPageOLS.back();

        howManyDaysYouTakeMedicationsOLS
                .waitForPageLoad()
                .selectDays("0")
                .clickNextButton(new MigraineAffectedYourAbilityOLS());

        AbilityToAttendSchoolOrWorkOLS abilityToAttendSchoolOrWorkOLS = migraineAffectedYourAbilityOLS
                .waitForPageLoad()
                .clickOnAnswers("Attend school or work - including completing assignments", "Attend social events or activities")
                .clickOnAnswers("Perform regular household chores such as cleaning, doing yardwork or running errands")
                .clickNextButton(new AbilityToAttendSchoolOrWorkOLS());

        PerformHouseholdChoresOLS performHouseholdChoresOLS = abilityToAttendSchoolOrWorkOLS
                .waitForPageLoad()
                .clickOnAnswer("You have not missed any school or work but you have been significantly less productive due to your migraines")
                .clickNextButton(new PerformHouseholdChoresOLS());

        ImpactHaveYourMigraineHeadachesOLS impactHaveYourMigraineHeadachesOLS = performHouseholdChoresOLS
                .waitForPageLoad()
                .clickOnAnswer("You are able to perform your household chores such as cleaning and running errands, but you are significantly less productive due to your migraines")
                .clickNextButton(new ImpactHaveYourMigraineHeadachesOLS());

        ExperiencingAMigraineOLS experiencingAMigraineOLS = impactHaveYourMigraineHeadachesOLS
                .waitForPageLoad()
                .clickOnAnswer("Moderate impact")
                .clickNextButton(new ExperiencingAMigraineOLS());

        MostRecentMigraineEndOLS mostRecentMigraineEndOLS = experiencingAMigraineOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new MostRecentMigraineEndOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = mostRecentMigraineEndOLS
                .waitForPageLoad()
                .clickOnAnswer("1 to 2 weeks ago")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        WhatKindOfArthritisPage whatKindOfArthritisPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",

                        "Headaches (migraine, cluster, tension)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",

                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",

                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPage());
        whatKindOfArthritisPage.waitForPageLoad();
        whatKindOfArthritisPage.back();
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",

                        "Headaches (migraine, cluster, tension)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",

                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",

                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack()
                .clickOnAnswers("Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack()
                .clickOnAnswers("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack()
                .clickOnAnswers("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS.back();

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadStroke()
                .clickOnAnswers("Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadStroke()
                .clickOnAnswers("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadStroke()
                .clickOnAnswers("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", protocol1);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS.back();

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoadTIA()
                .clickOnAnswers("More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        MostRecentHeartProcedurePageOLS mostRecentHeartProcedurePageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Angioplasty")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS49", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS49", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS49", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .back();

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS49", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .back();

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Atherectomy")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS49", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .back();

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Procedure to clear plaque from blood vessels in the neck such as carotid endarterectomy")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS49", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .back();

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Coronary artery bypass graft, also known as CABG, \"cabbage,\" or heart bypass surgery")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS49", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .back();

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Revascularization")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS49", protocol1)
                .back();
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "7", "166")
//				.clickNextButton(new ChildrenUnderPageOLS());

//		childrenUnderPageOLS
//				.waitForPageLoad()
//				.clickOnAnswer("No")
//				.clickNextButton(new TheStudySitePageOLS())
//				.waitForPageLoad()
//			//-------------------PEDIATRIC QUESTIONS-----------------------------
//				.clickOnAnswer("Public transportation")
//				.clickNextButton(new WhatMedicalCoveragePageOLS())
//				.waitForPageLoad()
//				.clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zip_Code)
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