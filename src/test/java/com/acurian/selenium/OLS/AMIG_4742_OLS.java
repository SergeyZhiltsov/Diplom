package com.acurian.selenium.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AMIG_4742.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.*;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AMIG_4742_OLS extends BaseTest {
//FULs were stopped on AMS1 R68.2
    @Test(enabled = false)
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
                .waitForPageLoad("a migraine study", "400");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle("a migraine study", "400"), "Title is diff");
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
                .setDate("09092003")  //DQ if <18 and Age Unqualified close
                .clickOnAnswer("Female")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols =
        genderPageOLS
                .setDate("09091938") //Disqualify ("Age") if >= 81
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());
        hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();

        HaveYouBeenDiagnosedWithMigrainesPageOLS haveYouBeenDiagnosedWithMigrainesOLS = genderPageOLS
                .setDate("09091982")
                .clickNextButton(new HaveYouBeenDiagnosedWithMigrainesPageOLS());

        haveYouBeenDiagnosedWithMigrainesOLS
                .waitForPageLoad();

//        will be needed if Cluster Headache is active
//        HasDoctorDiagnosedYouWithClusterHeadache_OLS hasDoctorDiagnosedYouWithClusterHeadache_OLS = haveYouBeenDiagnosedWithMigrainesOLS
//                .clickOnAnswer("No")
//                .clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_OLS());
//        hasDoctorDiagnosedYouWithClusterHeadache_OLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6002", site.activeProtocols)
//                .back();
//        AgeWhenDiagnosedWithMigOLS ageWhenDiagnosedWithMigOLS = haveYouBeenDiagnosedWithMigrainesOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new AgeWhenDiagnosedWithMigOLS());

        //QS2
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = haveYouBeenDiagnosedWithMigrainesOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6034", site.activeProtocols)
                .back();
        AgeWhenDiagnosedWithMigOLS ageWhenDiagnosedWithMigOLS = haveYouBeenDiagnosedWithMigrainesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AgeWhenDiagnosedWithMigOLS());


        //--------Q3:  Approximately how old were you when you were diagnosed with migraine headaches?
        ApproxHowLongSufferingFromMIGOLS approxHowLongSufferingFromMIGOLS = ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("51")
                .clickNextButton(new ApproxHowLongSufferingFromMIGOLS());
        approxHowLongSufferingFromMIGOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6003", site.activeProtocols)
                .back();
        ageWhenDiagnosedWithMigOLS
                .waitForPageLoad()
                .setAge("37")
                .clickNextButton(approxHowLongSufferingFromMIGOLS);


        //---------------Q4: For approximately how long have you been suffering from migraine headaches?
        HowManyDaysYouSufferOLS howManyDaysYouSufferOLS = approxHowLongSufferingFromMIGOLS
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowManyDaysYouSufferOLS());
        howManyDaysYouSufferOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6004", site.activeProtocols)
                .back();
        approxHowLongSufferingFromMIGOLS
                .waitForPageLoad()
                .clickOnAnswer("6 - 11 months")
                .clickNextButton(howManyDaysYouSufferOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6004", site.activeProtocols)
                .back();
        approxHowLongSufferingFromMIGOLS
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(howManyDaysYouSufferOLS);


        //---------------Q5: In a typical month, how many days do you suffer from migraines? - R75 changes - SKIP to NEW QS8
        HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS =
                howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("3")
                .clickNextButton(new HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS());
        haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6005", site.activeProtocols)
                .back();
        howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("15")
                .clickNextButton(haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6005", site.activeProtocols)
                .back();
        howManyDaysYouSufferOLS
                .waitForPageLoad()
                .selectDays("4")
                .clickNextButton(haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS);


        //---------------NEW Q8: Have you ever taken prescription medications daily to keep migraines from starting?
        //----------------------------------------- + GHOST QS11----------------------------------------------------
                haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No, never any daily medications that my doctor prescribed")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6033", site.activeProtocols)
                .back();

        //        Q8	Have you ever taken prescription medications daily to prevent migraines from starting?
        haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No, never any daily medications that my doctor prescribed") //Skip to Q11 - Ghost for Preventive Medication Logic
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6033", site.activeProtocols)
                .back();
        AreYouCurrentlyTakingPrescriptionMedicationsDailyPageOLS areYouCurrentlyTakingPrescriptionMedicationsDailyPageOLS =
        haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, daily medications that my doctor prescribed")
                .clickNextButton(new AreYouCurrentlyTakingPrescriptionMedicationsDailyPageOLS());

        //        Q9	Are you currently taking prescription medications daily to prevent migraines from starting?
        areYouCurrentlyTakingPrescriptionMedicationsDailyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No, I used to take daily medications that my doctor prescribed, but I stopped taking them") //Skip to Q11 - Ghost for Preventive Medication Logic
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
//                .getPage(debugPageOLS)
                //-----------STATUS SET validation:  PATIENT_PRIORITY_YES = 8 14 -------------
//                .checkStudyStatusContainsForQNumber(env.equals("PRD") ? "13-20" : "9-16")
                .back();
        PrescriptionMedicationsDailyToPreventMigrainesPageOLS prescriptionMedicationsDailyToPreventMigrainesPageOLS =
        areYouCurrentlyTakingPrescriptionMedicationsDailyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, I still take daily medications that my doctor prescribed") //Continue to Q10
                .clickNextButton(new PrescriptionMedicationsDailyToPreventMigrainesPageOLS());

        //        Q10	How satisfied are you with the prescription medications that you take daily to prevent migraines from starting?
        List<String> disqualifyQ10 = Arrays.asList("Satisfied", "Somewhat Satisfied");
        for (String answer: disqualifyQ10) {
            System.out.println("Select answer for Q10: " + answer);
            prescriptionMedicationsDailyToPreventMigrainesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS6033", site.activeProtocols)
                    .back();
        }
        prescriptionMedicationsDailyToPreventMigrainesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Dissatisfied")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

//        //        Q20	Have you ever had a Botox (botulinum toxin) injection to your face, head, or neck?
//        HaveYouEverDiagnosedByHealthcareProfOLS haveYouEverDiagnosedByHealthcareProfOLS = haveYouEverHadBotoxbotulinumtoxin_OLS
//                .waitForPageLoad()
//                .clickOnAnswers("Yes, to treat migraines", "Yes, as a cosmetic treatment for lines on the face")
//                .clickOnAnswers("No") //Skip to Q22
//                .clickNextButton(new HaveYouEverDiagnosedByHealthcareProfOLS());
//        haveYouEverDiagnosedByHealthcareProfOLS
//                .waitForPageLoad()
//                .back();
//        WhenDidYouLastHaveBotoxInjectionOLS whenDidYouLastHaveBotoxInjectionOLS = haveYouEverHadBotoxbotulinumtoxin_OLS
//                .waitForPageLoad()
//                .clickOnAnswers("Yes, to treat migraines")
//                .clickNextButton(new WhenDidYouLastHaveBotoxInjectionOLS());
//
//
//        //      Q21	When did you last have a Botox (botulinum toxin) injection?
//        List<String> disqualifyQ21 = Arrays.asList("3 months ago or less", "4 - 6 months ago");
//        for (String answer: disqualifyQ21) {
//            System.out.println("Select answer for Q21: " + answer);
//            whenDidYouLastHaveBotoxInjectionOLS
//                    .waitForPageLoad()
//                    .clickOnAnswer(answer)
//                    .clickNextButton(haveYouEverDiagnosedByHealthcareProfOLS)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS6026", site.activeProtocols)
//                    .back();
//        }
//        whenDidYouLastHaveBotoxInjectionOLS
//                .waitForPageLoad()
//                .clickOnAnswer("7 months - 1 year ago")
//                .clickNextButton(haveYouEverDiagnosedByHealthcareProfOLS);
//
//
//        //      Q22	Have you ever been diagnosed by a healthcare professional with any of the following pain conditions?
//        DoYouCurrentlyUseMarijuanaOLS doYouCurrentlyUseMarijuanaOLS = new DoYouCurrentlyUseMarijuanaOLS();
//        List<String> disqualifyQ22 = Arrays.asList("Trigeminal Neuralgia - severe pain in the nerves of the face",
//                "Temporomandibular Joint Disorders also known as TMD or TMJ");
//        for (String answer: disqualifyQ22) {
//            System.out.println("Select answer for Q22: " + answer);
//            haveYouEverDiagnosedByHealthcareProfOLS
//                    .waitForPageLoad()
//                    .clickOnAnswers("None 4742of the above")
//                    .clickOnAnswers(answer)
//                    .clickNextButton(doYouCurrentlyUseMarijuanaOLS)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS6027", site.activeProtocols)
//                    .back();
//        }
//        haveYouEverDiagnosedByHealthcareProfOLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(doYouCurrentlyUseMarijuanaOLS);
//
//
//        //      Q23	 Do you currently use marijuana (cannabis) or any products that contain it, including CBD oil? 
//        doYouCurrentlyUseMarijuanaOLS
//                .waitForPageLoad()
//                .clickOnAnswer("No") //Continue to Q24
//                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .back();
//        IfYouQualifyForStudyWillingtoStopOLS ifYouQualifyForStudyWillingtoStopOLS = doYouCurrentlyUseMarijuanaOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new IfYouQualifyForStudyWillingtoStopOLS());
//
//        //      Q24	If you qualify for a study, are you willing to stop using marijuana (cannabis) during your participation?
//        ifYouQualifyForStudyWillingtoStopOLS
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS6029", site.activeProtocols)
//                .back(ifYouQualifyForStudyWillingtoStopOLS)
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

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
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPageOLS());
        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .back();
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());


        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago");
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS =
                haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS =
                new HeartrelatedMedicalProceduresPageOLS();
        for (String answer: disqualifyQ12GH) {
            System.out.println("Select answer for Q12.1:QS47A: " + answer);
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                    .clickOnAnswers(answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageOLS.back();


        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionExperiencedHeartPageOLS);
        for (String answer: disqualifyQ12GH) {
            System.out.println("Select answer for Q12.2:QS47B: " + answer);
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                    .clickOnAnswers(answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageOLS.back();


        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionExperiencedHeartPageOLS);
        for (String answer: disqualifyQ12GH) {
            System.out.println("Select answer for Q12.3:QS47C: " + answer);
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                    .clickOnAnswers(answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageOLS.back();


        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionExperiencedHeartPageOLS);
        for (String answer: disqualifyQ12GH) {
            System.out.println("Select answer for Q12.4:QS47D: " + answer);
            subquestionExperiencedHeartPageOLS
                    .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                    .clickOnAnswers(answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionExperiencedHeartPageOLS.back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back();

        FollowingMentalEmotionalHealthPageOLS following_MentalEmotionalHealthPageOLS =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());


        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        List<String> disqualifyQ18GH = Arrays.asList("Bipolar disorder", "Schizophrenia");
        following_MentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Generalized anxiety disorder (GAD)",
                        "Major depressive disorder (MDD) or depression");
        for (String answer: disqualifyQ18GH) {
            System.out.println("Select answer for Q18:QS53: " + answer);
            following_MentalEmotionalHealthPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back();
        }
        following_MentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back();
        WomenHealthConditionsOLS womenHealthConditionsOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WomenHealthConditionsOLS());

        womenHealthConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("Uterine fibroids", "Endometriosis", "Overactive bladder",
                        "Urinary leakage or urinary incontinence")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);


        //  Q24: QS59	Do any of the following additional diagnoses apply to you?
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQ24GH = Arrays.asList("Bipolar disorder",
                "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS");
        for (String answer: disqualifyQ24GH) {
            System.out.println("Select answer for Q24GH: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQ24GHPart2 = Arrays.asList("Kidney disease requiring dialysis", "Multiple sclerosis (MS)",
                "Seizure disorder such as epilepsy",  "Schizophrenia");
        for (String answer: disqualifyQ24GHPart2) {
            System.out.println("Select answer for Q24GHp2: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }
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
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
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
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                //.clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "4742")
                .assertGeneratedFul(env, site)
 //               .assertRmgOrderPriority(env, "4742")
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}