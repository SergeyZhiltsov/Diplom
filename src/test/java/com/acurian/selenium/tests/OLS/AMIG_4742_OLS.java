package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AMIG_4742.HaveYourEverTakenAnyMedicationToTreatMigrainePageOLS;
import com.acurian.selenium.pages.OLS.AMIG_4742.WhenDidYouTakeYourMigraineMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.*;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AMIG_4742_OLS extends BaseTest {

    @Test()
    public void amig4742ols() {
        String phoneNumberMIG = "AUTAMS1MIG";
        Site site = Site.AUT_MIG4742_site;
        String studyName = "a migraine";
        String site_Indication = "Migraines";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a migraine study", "400"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
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
        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = genderPageOLS
                .setDate("09092002")  //DQ if <18 and Age Unqualified close
                .clickOnAnswer("Female")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();

        DoYouSufferFromMigHeadachesOLS doYouSufferFromMigHeadachesOLS = genderPageOLS
                .setDate("09091982")
                .clickNextButton(new DoYouSufferFromMigHeadachesOLS());

        doYouSufferFromMigHeadachesOLS
                .waitForPageLoad();
        Assert.assertEquals(doYouSufferFromMigHeadachesOLS.getTitleText(), doYouSufferFromMigHeadachesOLS.titleExpected, "Title is diff");

        HasDoctorDiagnosedYouWithClusterHeadache_OLS hasDoctorDiagnosedYouWithClusterHeadache_OLS = doYouSufferFromMigHeadachesOLS
                .clickOnAnswer("No")
                .clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_OLS());
        hasDoctorDiagnosedYouWithClusterHeadache_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6002", site.activeProtocols)
                .back();
        AgeWhenDiagnosedWithMigOLS ageWhenDiagnosedWithMigOLS = doYouSufferFromMigHeadachesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AgeWhenDiagnosedWithMigOLS());


        //--------Q3:  Approximately how old were you when you were diagnosed with migraine headaches?
        ApproxHowLongSufferingFromMIG approxHowLongSufferingFromMIG = ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("51")
                .clickNextButton(new ApproxHowLongSufferingFromMIG());
        approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6003", site.activeProtocols)
                .back();
        ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("37")
                .clickNextButton(approxHowLongSufferingFromMIG);


        //---------------Q4: For approximately how long have you been suffering from migraine headaches?
        HowManyDaysYouSufferOLS howManyDaysYouSufferOLS = approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowManyDaysYouSufferOLS());
        howManyDaysYouSufferOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6004", site.activeProtocols)
                .back();
        approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("6 - 11 months")
                .clickNextButton(howManyDaysYouSufferOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6004", site.activeProtocols)
                .back();
        approxHowLongSufferingFromMIG
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(howManyDaysYouSufferOLS);


        //---------------Q5: In a typical month, how many days do you suffer from migraines? - R75 changes - SKIP to NEW QS8
        HaveYourEverTakenAnyMedicationToTreatMigrainePageOLS haveYourEverTakenAnyMedicationToTreatMigrainePageOLS = howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("3")
                .clickNextButton(new HaveYourEverTakenAnyMedicationToTreatMigrainePageOLS());
        haveYourEverTakenAnyMedicationToTreatMigrainePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6005", site.activeProtocols)
                .back();
        howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("15")
                .clickNextButton(haveYourEverTakenAnyMedicationToTreatMigrainePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6005", site.activeProtocols)
                .back();
        howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("4")
                .clickNextButton(haveYourEverTakenAnyMedicationToTreatMigrainePageOLS);


        //---------------NEW Q8: Have you ever taken any medications to treat your migraine headaches? -----------
        HaveYouEverHadBotoxbotulinumtoxin_OLS haveYouEverHadBotoxbotulinumtoxin_OLS = haveYourEverTakenAnyMedicationToTreatMigrainePageOLS
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickNextButton(new HaveYouEverHadBotoxbotulinumtoxin_OLS());

        haveYouEverHadBotoxbotulinumtoxin_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6033", site.activeProtocols)
                .back();

        WhenDidYouTakeYourMigraineMedicationsPageOLS whenDidYouTakeYourMigraineMedicationsPageOLS =
                haveYourEverTakenAnyMedicationToTreatMigrainePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, prescription medication")
                .clickNextButton(new WhenDidYouTakeYourMigraineMedicationsPageOLS());

        whenDidYouTakeYourMigraineMedicationsPageOLS
                .waitForPageLoad()
                .back();

        haveYourEverTakenAnyMedicationToTreatMigrainePageOLS
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickOnAnswers("Yes, over-the-counter medication")
                .clickNextButton(whenDidYouTakeYourMigraineMedicationsPageOLS);

        whenDidYouTakeYourMigraineMedicationsPageOLS
                .waitForPageLoad()
                .back();

         haveYourEverTakenAnyMedicationToTreatMigrainePageOLS
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickOnAnswers("Yes, vitamins or herbal supplements")
                .clickNextButton(whenDidYouTakeYourMigraineMedicationsPageOLS);


        //---------------NEW Q9: When did you take your migraine medication(s)?  + GHOST -----------
        whenDidYouTakeYourMigraineMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("\"As needed\" – as my migraine started or while I had it")
                .clickNextButton(haveYouEverHadBotoxbotulinumtoxin_OLS);

        haveYouEverHadBotoxbotulinumtoxin_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6033", site.activeProtocols) //QS10 Ghost QS - DISQUALIFY
                .back();

        whenDidYouTakeYourMigraineMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("\"As needed\" – as my migraine started or while I had it")
                .clickOnAnswers("Every day, to prevent migraine headaches")
                .clickNextButton(haveYouEverHadBotoxbotulinumtoxin_OLS);

        haveYouEverHadBotoxbotulinumtoxin_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6033", site.activeProtocols)//QS10 Ghost QS - DISQUALIFY
                .back();

        whenDidYouTakeYourMigraineMedicationsPageOLS
                .waitForPageLoad()
                .back();

        haveYourEverTakenAnyMedicationToTreatMigrainePageOLS
                .waitForPageLoad()
                .clickOnAnswers("No")
                .clickOnAnswers("Yes, prescription medication")
                .clickNextButton(whenDidYouTakeYourMigraineMedicationsPageOLS);

        whenDidYouTakeYourMigraineMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Every day, to prevent migraine headaches")
                .clickOnAnswers("\"As needed\" – as my migraine started or while I had it")
                .clickNextButton(haveYouEverHadBotoxbotulinumtoxin_OLS);

        haveYouEverHadBotoxbotulinumtoxin_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6033", site.activeProtocols)//QS10 Ghost QS - DISQUALIFY
                .back();

        whenDidYouTakeYourMigraineMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("\"As needed\" – as my migraine started or while I had it")
                .clickOnAnswers("Every day, to prevent migraine headaches")
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
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                doYouCurrentlyUseMarijuanaOLS
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
                        "Headaches (migraine, cluster, tension)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)",
                        "Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        //"Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPageOLS());
        whatKindOfArthritisPageOLS.waitForPageLoad();
        whatKindOfArthritisPageOLS.back();
        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
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
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
                whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS =
                haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswers("Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswers("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswers("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS.back();

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswers("Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswers("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswers("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS.back();

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                .clickOnAnswers("More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        FollowingMentalEmotionalHealthPageOLS following_MentalEmotionalHealthPageOLS =
                heartrelatedMedicalProceduresPageOLS
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
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();
        following_MentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(womenHealthConditions);


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
                /*.clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")*/
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())

                //----------SiteSelection Page--------------------
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4742")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}