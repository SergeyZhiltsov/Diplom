package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.LMG_4686.*;
import com.acurian.selenium.pages.CC.Migraine.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AMIG_4742_CC extends BaseTest {
    //FULs were stopped on AMS1 R68.2
    @Test(enabled = true)
    public void Amig4742cc() {
        String phoneNumber = "AUTAMS1MIG";
        Site site = Site.AUT_MIG4742_site;
        String studyName1 = "a migraine study";
        String studyName = "migraine";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),
                "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a migraine study", "400");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle
//                ("a migraine study", "400"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();


        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = genderPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("2003")
                .clickOnAnswer("Female")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc = genderPageCC
                        .setYear("1938") //Disqualify ("Age") if >= 81
                        .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());
        hasHealthcareProfessionalEverDiagnosedYouWithEczema_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();

        HaveYouBeenDiagnosedWithMigrainesPageCC haveYouBeenDiagnosedWithMigrainesPageCC = genderPageCC
                .setYear("1982")
                .clickNextButton(new HaveYouBeenDiagnosedWithMigrainesPageCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = haveYouBeenDiagnosedWithMigrainesPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6034", site.activeProtocols)
                .back();

        AgeWhenDiagnosedWithMigСС ageWhenDiagnosedWithMigСС = haveYouBeenDiagnosedWithMigrainesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AgeWhenDiagnosedWithMigСС());

        ApproxHowLongSufferingFromMIGСС approxHowLongSufferingFromMIGСС = ageWhenDiagnosedWithMigСС
                .typeAge("50")
                .clickNextButton(new ApproxHowLongSufferingFromMIGСС());
        approxHowLongSufferingFromMIGСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6003", site.activeProtocols)
                .back(ageWhenDiagnosedWithMigСС)
                .typeAge("40")
                .clickNextButton(approxHowLongSufferingFromMIGСС);


//---------------Q4: For approximately how long have you been suffering from migraine headaches?
        HowManyDaysYouSufferCC howManyDaysYouSufferCC = new HowManyDaysYouSufferCC();
        List<String> disqualifyQ4 = Arrays.asList("5 months or less", "6 - 11 months");
        for (String answer : disqualifyQ4) {
            System.out.println("Select answer for Q4: " + answer);
            approxHowLongSufferingFromMIGСС
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howManyDaysYouSufferCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6004", site.activeProtocols)
                    .back();
        }
        approxHowLongSufferingFromMIGСС
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(howManyDaysYouSufferCC);

//---------------Q5: In a typical month, how many days do you suffer from migraines? 
        HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС =
                new HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС();
        List<String> disqualifyQ5 = Arrays.asList("3", "15");
        for (String answer : disqualifyQ5) {
            System.out.println("Select answer for Q5: " + answer);
            howManyDaysYouSufferCC
                    .waitForPageLoad()
                    .selectDay(answer)
                    .clickNextButton(haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6005", site.activeProtocols)
                    .back();
        }
        howManyDaysYouSufferCC
                .waitForPageLoad()
                .selectDay("4")
                .clickNextButton(haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС);


//---------------NEW Q8: Have you ever taken any medications to treat your migraine headaches? -----------
        TransitionStatementCC transitionStatementCC =
                haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС
                        .waitForPageLoad()
                        .clickOnAnswer("No, never any daily medications that my doctor prescribed") //skip to QS20
                        .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoad("migraine")
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6033", site.activeProtocols) //QS10 Ghost QS - DISQUALIFY
                .back();
        AreYouCurrentlyTakingPrescriptionMedicationsDailyPageСС areYouCurrentlyTakingPrescriptionMedicationsDailyPageСС =
                haveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageСС
                        .waitForPageLoad()
                        .clickOnAnswer("Yes, daily medications that my doctor prescribed")
                        .clickNextButton(new AreYouCurrentlyTakingPrescriptionMedicationsDailyPageСС());


        //--------------Q9 Are you currently taking prescription medications daily to prevent migraines from starting?
        areYouCurrentlyTakingPrescriptionMedicationsDailyPageСС
                .waitForPageLoad()
                .clickOnAnswer("No, I used to take daily medications that my doctor prescribed, but I stopped taking them")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoad("migraine")
                //-----------STATUS SET validation:  PATIENT_PRIORITY_YES = 8 14 -------------
               // .getPage(debugPageCC)
               // .checkStudyStatusContainsForQNumber("QS6036", env.equals("PRD") ? "13-20" : "9-16")
                .back();

        PrescriptionMedicationsDailyToPreventMigrainesPageCC prescriptionMedicationsDailyToPreventMigrainesPageCC =
                areYouCurrentlyTakingPrescriptionMedicationsDailyPageСС
                        .waitForPageLoad()
                        .clickOnAnswer("Yes, I still take daily medications that my doctor prescribed")
                        .clickNextButton(new PrescriptionMedicationsDailyToPreventMigrainesPageCC());


        //        Q10	How satisfied are you with the prescription medications that you take daily to prevent migraines from starting?
        List<String> disqualifyQ10 = Arrays.asList("Satisfied", "Somewhat Satisfied");
        for (String answer : disqualifyQ10) {
            System.out.println("Select answer for Q10: " + answer);
            prescriptionMedicationsDailyToPreventMigrainesPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(transitionStatementCC)
                    .waitForPageLoad("migraine")
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6033", site.activeProtocols)
                    .back();
        }
        prescriptionMedicationsDailyToPreventMigrainesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Dissatisfied")
                .clickNextButton(transitionStatementCC);


//        //-------------20: Have you ever had a Botox (botulinum toxin) injection to your face, head, or neck? -----------
//        HaveUeverDiagnosedByHealthcareProfesionalCC haveUeverDiagnosedByHealthcareProfesionalCC =
//                transitionStatementCC
//                        .waitForPageLoad()
//                        .clickOnAnswers("No") //Skip to Q22
//                        .clickNextButton(new HaveUeverDiagnosedByHealthcareProfesionalCC());
//
//        haveUeverDiagnosedByHealthcareProfesionalCC
//                .waitForPageLoad()
//                .back();
//
//        WhenYouLastHaveBotoxMigCC whenYouLastHaveBotoxMigCC = haveYouEverHadBotoxbotulinumtoxin_CC
//                .waitForPageLoad()
//                .clickOnAnswers("Yes, to treat migraines", "Yes, as a cosmetic treatment for lines on the face")
//                .clickNextButton(new WhenYouLastHaveBotoxMigCC());
//
////---------------Q21	When did you last have a Botox (botulinum toxin) injection?
//        List<String> disqualifyQ21 = Arrays.asList("3 months ago or less", "4 - 6 months ago");
//        for (String answer : disqualifyQ21) {
//            System.out.println("Select answer for Q21: " + answer);
//            whenYouLastHaveBotoxMigCC
//                    .waitForPageLoad()
//                    .clickOnAnswer(answer)
//                    .clickNextButton(haveUeverDiagnosedByHealthcareProfesionalCC)
//                    .waitForPageLoad()
//                    .getPage(debugPageCC)
//                    .checkProtocolsContainsForQNumber("QS6026", site.activeProtocols)
//                    .back();
//        }
//        whenYouLastHaveBotoxMigCC
//                .waitForPageLoad()
//                .clickOnAnswer("7 months - 1 year ago")
//                .clickNextButton(haveUeverDiagnosedByHealthcareProfesionalCC);
//
////---------------Q22: HaveYouEverDiagnosedByHealthcareProfCC-----
//        DoYouCurrentlyUseMarijuanaCC doYouCurrentlyUseMarijuanaCC = new DoYouCurrentlyUseMarijuanaCC();
//        List<String> disqualifyQ22 = Arrays.asList("Trigeminal Neuralgia - severe pain in the nerves of the face",
//                "Temporomandibular Joint Disorders also known as TMD or TMJ");
//        for (String answer : disqualifyQ22) {
//            System.out.println("Select answer for Q22: " + answer);
//            haveUeverDiagnosedByHealthcareProfesionalCC
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickOnAnswers(answer)
//                    .clickNextButton(doYouCurrentlyUseMarijuanaCC)
//                    .waitForPageLoad()
//                    .getPage(debugPageCC)
//                    .checkProtocolsContainsForQNumber("QS6027", site.activeProtocols)
//                    .back();
//        }
//        haveUeverDiagnosedByHealthcareProfesionalCC
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(doYouCurrentlyUseMarijuanaCC);
//
////---------------Q23: DoYouCurrentlyUseMarijuanaCC-----
//        TransitionStatementCC transitionStatementCC = doYouCurrentlyUseMarijuanaCC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new TransitionStatementCC());
//
//        transitionStatementCC
//                .waitForPageLoad(studyName)
//                .back();
//
//        IfYouQualifyForStudyWillingtoStopCC ifYouQualifyForStudyWillingtoStopCC = doYouCurrentlyUseMarijuanaCC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(new IfYouQualifyForStudyWillingtoStopCC());
//
////---------------Q24: IfYouQualifyForStudyWillingtoStopCC-----
//        ifYouQualifyForStudyWillingtoStopCC
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(transitionStatementCC)
//                .waitForPageLoad(studyName)
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS6029", site.activeProtocols)
//                .back();
//
//        ifYouQualifyForStudyWillingtoStopCC
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(transitionStatementCC);
//
//---------------Q24: Transition Statement - Display for Call Center onl-----
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

//-----------------GENERAL HEALTH questions-------------------
        WhatKindOfArthritisPageCC whatKindOfArthritisPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Headaches (migraine, cluster, tension)",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPageCC());
        whatKindOfArthritisPage.waitForPageLoad();
        whatKindOfArthritisPage.back();
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());
        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = heartRelatedSurgeriesProceduresPageCC
//WomenHealthConditionsCC womenHealthConditionsCC = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                /*  .clickNextButton(new WomenHealthConditionsCC());


           DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = womenHealthConditionsCC
                  .waitForPageLoad()
                  .clickOnAnswers("None of the above") */
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());


        List<String> disqualifyQ24 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis", "Drug or alcohol abuse within the past year", "Hepatitis B", "Hepatitis C", "HIV or AIDS");
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        for (String answer : disqualifyQ24) {
            System.out.println("Select answer for Q24: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQ24p2 = Arrays.asList("Seizure disorder such as epilepsy",
                "Kidney disease requiring dialysis", "Multiple sclerosis (MS)", "Schizophrenia");
        for (String answer : disqualifyQ24p2) {
            System.out.println("Select answer for Q24: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());

        //Not Sinexus Close about drugs
        CurrentlyParticipatingInStudy currentlyParticipatingInStudy = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy());

        RequirePassDrugTest requirePassDrugTest = currentlyParticipatingInStudy
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new RequirePassDrugTest());
        requirePassDrugTest
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS912", site.activeProtocols)
                .back(currentlyParticipatingInStudy)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(requirePassDrugTest);
        IdentificationPageCC identificationPageCC = requirePassDrugTest
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC());
        identificationPageCC
                .waitForPageLoadNotQ()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS913", site.activeProtocols)
                .back(requirePassDrugTest);
        requirePassDrugTest
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(identificationPageCC);
        //end
        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setFirstName("Acurian")
                .setLastName("Trial")
                .setPhone("9999999999")
                .setEmailAddress("qa.acurian@gmail.com")
                .setZipCode(site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());
                //----------SITE Selection Page--------------------
        siteSelectionPageCC
                .waitForPageLoad(studyName1)
                .getPID()

                //----------SITE Selection Page--------------------
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .assertRmgOrderPriority(env, "4742")
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}