package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.*;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AMIG_4742_OLS extends BaseTest {

    @Test(enabled = true)
    public void amig4742ols() {
        String phoneNumberMIG = "AUTAMS1MIG";
        Site site = Site.AUT_MIG4742_site;
        String studyName = "a migraine";
        String site_Indication = "Migraines";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a migraine study", "400"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091982")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
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
        debugPageOLS.checkProtocolsContainsForQNumber("QS6002", site.activeProtocols);
        debugPageOLS.back();
        AgeWhenDiagnosedWithMigOLS ageWhenDiagnosedWithMigOLS = doYouSufferFromMigHeadachesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AgeWhenDiagnosedWithMigOLS());


        //--------Q3:  Approximately how old were you when you were diagnosed with migraine headaches?
        ApproxHowLongSufferingFromMIG approxHowLongSufferingFromMIG = ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("51")
                .clickNextButton(new ApproxHowLongSufferingFromMIG());
        debugPageOLS.checkProtocolsContainsForQNumber("QS6003", site.activeProtocols);
        debugPageOLS.back();
        ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("37")
                .clickNextButton(new ApproxHowLongSufferingFromMIG());


        //---------------Q4: For approximately how long have you been suffering from migraine headaches?
        HowManyDaysYouSufferOLS howManyDaysYouSufferOLS = approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowManyDaysYouSufferOLS());
        howManyDaysYouSufferOLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6004", site.activeProtocols);
        debugPageOLS.back();
        approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("6 - 11 months")
                .clickNextButton(howManyDaysYouSufferOLS)
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6004", site.activeProtocols);
        debugPageOLS.back();
        approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(new HowManyDaysYouSufferOLS());


        //---------------Q5: In a typical month, how many days do you suffer from migraines?
        HowOftenDoYouTypicallyTakeMedicationOLS howOftenDoYouTypicallyTakeMedicationOLS = howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("3")
                .clickNextButton(new HowOftenDoYouTypicallyTakeMedicationOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6005", site.activeProtocols);
        debugPageOLS.back();
        howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("15")
                .clickNextButton(new HowOftenDoYouTypicallyTakeMedicationOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6005", site.activeProtocols);
        debugPageOLS.back();
        howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("4")
                .clickNextButton(new HowOftenDoYouTypicallyTakeMedicationOLS());


        //---------------Q6: How often do you typically take medication to stop an active migraine, either as it starts or while you are experiencing it?-------------
        AnyMedicationsToPreventMigrainesOLS anyMedicationsToPreventMigrainesOLS = howOftenDoYouTypicallyTakeMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Half the days in a month or more")
                .clickNextButton(new AnyMedicationsToPreventMigrainesOLS());


        //---------------Q7: HowManyDifferentMedicationsOLS -----------
        HaveYouEverHadBotoxbotulinumtoxin_OLS haveYouEverHadBotoxbotulinumtoxin_OLS = anyMedicationsToPreventMigrainesOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadBotoxbotulinumtoxin_OLS());

        haveYouEverHadBotoxbotulinumtoxin_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6030", site.activeProtocols)
                .back();

        anyMedicationsToPreventMigrainesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverHadBotoxbotulinumtoxin_OLS);

        //---------------SKIP to Q18: Have you ever had a Botox (botulinum toxin) injection to your face, head, or neck? -----------
        WhenDidYouLastHaveBotoxInjectionOLS whenDidYouLastHaveBotoxInjectionOLS = haveYouEverHadBotoxbotulinumtoxin_OLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, to treat migraines")
                .clickNextButton(new WhenDidYouLastHaveBotoxInjectionOLS());

        //---------------Q19: When did you last have a Botox (botulinum toxin) injection?-----------
        HaveYouEverDiagnosedByHealthcareProfOLS haveYouEverDiagnosedByHealthcareProfOLS = whenDidYouLastHaveBotoxInjectionOLS
                .waitForPageLoad()
                .clickOnAnswer("3 months ago or less")
                .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS());

        haveYouEverDiagnosedByHealthcareProfOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6026", site.activeProtocols)
                .back();

        whenDidYouLastHaveBotoxInjectionOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(haveYouEverDiagnosedByHealthcareProfOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6026", site.activeProtocols)
                .back();

        whenDidYouLastHaveBotoxInjectionOLS
                .waitForPageLoad()
                .clickOnAnswer("7 months - 1 year ago")
                .clickNextButton(haveYouEverDiagnosedByHealthcareProfOLS);

        //---------------Q20: HaveYouEverDiagnosedByHealthcareProfOLS-----
        DoYouCurrentlyUseMarijuanaOLS doYouCurrentlyUseMarijuanaOLS = haveYouEverDiagnosedByHealthcareProfOLS
                .waitForPageLoad()
                .clickOnAnswers("Trigeminal Neuralgia - severe pain in the nerves of the face")
                .clickNextButton(new DoYouCurrentlyUseMarijuanaOLS());

        doYouCurrentlyUseMarijuanaOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6027", site.activeProtocols)
                .back();

        haveYouEverDiagnosedByHealthcareProfOLS
                .clickOnAnswers("Temporomandibular Joint Disorders also known as TMD or TMJ")
                .clickNextButton(doYouCurrentlyUseMarijuanaOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6027", site.activeProtocols)
                .back();

        haveYouEverDiagnosedByHealthcareProfOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doYouCurrentlyUseMarijuanaOLS);


        //---------------Q21: DoYouCurrentlyUseMarijuanaOLS-----
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouCurrentlyUseMarijuanaOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .back();

        IfYouQualifyForStudyWillingtoStopOLS ifYouQualifyForStudyWillingtoStopOLS = doYouCurrentlyUseMarijuanaOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IfYouQualifyForStudyWillingtoStopOLS());

        //---------------Q22: IfYouQualifyForStudyWillingtoStopOLS-----
        ifYouQualifyForStudyWillingtoStopOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6029", site.activeProtocols)
                .back();

        ifYouQualifyForStudyWillingtoStopOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //-----------------GENERAL HEALTH questions-------------------
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
                        "Headaches (migraine, cluster, tension)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)",
                        "Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPageOLS());
        whatKindOfArthritisPageOLS.waitForPageLoad();
        whatKindOfArthritisPageOLS.back();
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
                        "Headaches (migraine, cluster, tension)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids, PCOS, dense breasts)")
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
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", site.activeProtocols);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack()
                .clickOnAnswers("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", site.activeProtocols);
        debugPageOLS.back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoadHeartAttack()
                .clickOnAnswers("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", site.activeProtocols);
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
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", site.activeProtocols);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadStroke()
                .clickOnAnswers("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", site.activeProtocols);
        debugPageOLS.back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoadStroke()
                .clickOnAnswers("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);
        debugPageOLS.checkProtocolsContainsForQNumber("QS47", site.activeProtocols);
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

        FollowingMentalEmotionalHealthPageOLS following_MentalEmotionalHealthPageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());


        following_MentalEmotionalHealthPageOLS
                .waitForPageLoad();
        WomenHealthConditions womenHealthConditions = following_MentalEmotionalHealthPageOLS
                .clickOnAnswers("Generalized anxiety disorder (GAD)",
                        "Major depressive disorder (MDD) or depression",
                        "None of the above")
                .clickOnAnswers("Bipolar disorder", "Schizophrenia")
                .clickNextButton(new WomenHealthConditions());
        womenHealthConditions
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS53", site.activeProtocols);
        debugPageOLS.back();
        following_MentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WomenHealthConditions());


        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = womenHealthConditions
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad();
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "7", "166")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())

                //----------SiteSelection Page--------------------
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad();
        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();
        aboutHealthPageOLS
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .threadSleep(2000);
        aboutHealthPageOLS
                .pidFromDbToLog(env);
    }
}