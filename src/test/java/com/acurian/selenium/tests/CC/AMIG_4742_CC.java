package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.CC.LMG_4686.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondCC;
import com.acurian.selenium.pages.CC.generalHealth.HeartrelatedMedicalProceduresPageCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.DoYouSufferFromMigPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HasDoctorDiagnosedYouWithClusterHeadache_CC;
import com.acurian.selenium.pages.CC.shared.HaveUeverDiagnosedByHealthcareProfesionalCC;
import com.acurian.selenium.pages.CC.shared.HowLongSufferingFromMigraineCC;
import com.acurian.selenium.pages.CC.shared.HowOldWereYouMigHeadachePageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.pages.CC.shared.WhenYouLastHaveBotoxMigCC;
import com.acurian.selenium.pages.CC.shared.ZipCodePageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.utils.DataProviderPool;

public class AMIG_4742_CC extends BaseTest {

    @Test(enabled = true, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    public void Amig4742cc(final String username, final String password) {
        String phoneNumber = "AUTAMS1MIG";
        Site site = Site.AUT_MIG4742_site;
        String studyName1 = "a migraine study";
        String protocol1 = "3101_301_002";
        String protocol2 = "3101_302_002";
        String studyName = "migraine";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("a migraine study", "400"), "Title is diff");


        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC.waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols);
        debugPageCC.back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad()
                .setYear("1942")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
//debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1);
        debugPageCC.back();
        dateOfBirthPageCC
                .waitForPageLoad()
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        DoYouSufferFromMigPageCC doYouSufferFromMigPageCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromMigPageCC());

        HasDoctorDiagnosedYouWithClusterHeadache_CC hasDoctorDiagnosedYouWithClusterHeadache_CC = doYouSufferFromMigPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HasDoctorDiagnosedYouWithClusterHeadache_CC());

        hasDoctorDiagnosedYouWithClusterHeadache_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005097-QS6002-STUDYQUES", site.activeProtocols)
                .back();

        HowOldWereYouMigHeadachePageCC howOldWereYouMigHeadachePageCC = doYouSufferFromMigPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowOldWereYouMigHeadachePageCC());

        HowLongSufferingFromMigraineCC howLongSufferingFromMigraineCC = howOldWereYouMigHeadachePageCC
                .typeAge("50")
                .clickNextButton(new HowLongSufferingFromMigraineCC());

        howLongSufferingFromMigraineCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005098-QS6003-STUDYQUES", site.activeProtocols)
                .back();

        howOldWereYouMigHeadachePageCC
                .typeAge("40")
                .clickNextButton(howLongSufferingFromMigraineCC);


//---------------Q4: For approximately how long have you been suffering from migraine headaches?
        HowManyDaysYouSufferCC howManyDaysYouSufferCC = howLongSufferingFromMigraineCC
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowManyDaysYouSufferCC());

        howManyDaysYouSufferCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005099-QS6004-STUDYQUES", site.activeProtocols)
                .back();

        howLongSufferingFromMigraineCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 11 months")
                .clickNextButton(howManyDaysYouSufferCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005099-QS6004-STUDYQUES", site.activeProtocols)
                .back();

        howLongSufferingFromMigraineCC
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(howManyDaysYouSufferCC);

//---------------Q5: In a typical month, how many days do you suffer from migraines? 
        HowOftenDoYouTypicallyTakeMedicationCC howOftenDoYouTypicallyTakeMedicationCC = howManyDaysYouSufferCC
                .waitForPageLoad()
                .selectDay("3")
                .clickNextButton(new HowOftenDoYouTypicallyTakeMedicationCC());

        howOftenDoYouTypicallyTakeMedicationCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017149-QS6005-STUDYQUES", site.activeProtocols)
                .back();

        howManyDaysYouSufferCC
                .waitForPageLoad()
                .selectDay("15")
                .clickNextButton(howOftenDoYouTypicallyTakeMedicationCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0017149-QS6005-STUDYQUES", site.activeProtocols)
                .back();

        howManyDaysYouSufferCC
                .waitForPageLoad()
                .selectDay("4")
                .clickNextButton(howOftenDoYouTypicallyTakeMedicationCC);

//---------------Q6: How often do you typically take medication to stop an active migraine, either as it starts or while you are experiencing it?-------------
        AnyMedicationsToPreventMigrainesCC anyMedicationsToPreventMigrainesCC = howOftenDoYouTypicallyTakeMedicationCC
                .waitForPageLoad()
                .clickOnAnswer("Half the days in a month or more")
                .clickNextButton(new AnyMedicationsToPreventMigrainesCC());

//---------------Q7: HowManyDifferentMedicationsCC -----------
        HaveYouEverHadBotoxbotulinumtoxin_CC haveYouEverHadBotoxbotulinumtoxin_CC = anyMedicationsToPreventMigrainesCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadBotoxbotulinumtoxin_CC());

        haveYouEverHadBotoxbotulinumtoxin_CC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0019319-QS6030-STUDYQUES", site.activeProtocols)
                .back();

        anyMedicationsToPreventMigrainesCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverHadBotoxbotulinumtoxin_CC);

//---------------SKIP to Q18: Have you ever had a Botox (botulinum toxin) injection to your face, head, or neck? -----------
        WhenYouLastHaveBotoxMigCC whenYouLastHaveBotoxMigCC = haveYouEverHadBotoxbotulinumtoxin_CC
                .waitForPageLoad()
                .clickOnAnswers("Yes, to treat migraines")
                .clickNextButton(new WhenYouLastHaveBotoxMigCC());

//---------------Q19: When did you last have a Botox (botulinum toxin) injection?-----------
        HaveUeverDiagnosedByHealthcareProfesionalCC haveUeverDiagnosedByHealthcareProfesionalCC = whenYouLastHaveBotoxMigCC
                .waitForPageLoad()
                .clickOnAnswer("3 months ago or less")
                .clickNextButton(new HaveUeverDiagnosedByHealthcareProfesionalCC());

        haveUeverDiagnosedByHealthcareProfesionalCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018421-QS6026-STUDYQUES", site.activeProtocols)
                .back();

        whenYouLastHaveBotoxMigCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(haveUeverDiagnosedByHealthcareProfesionalCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018421-QS6026-STUDYQUES", site.activeProtocols)
                .back();

        whenYouLastHaveBotoxMigCC
                .waitForPageLoad()
                .clickOnAnswer("7 months - 1 year ago")
                .clickNextButton(haveUeverDiagnosedByHealthcareProfesionalCC);

//---------------Q20: HaveYouEverDiagnosedByHealthcareProfCC-----
        DoYouCurrentlyUseMarijuanaCC doYouCurrentlyUseMarijuanaCC = haveUeverDiagnosedByHealthcareProfesionalCC
                .waitForPageLoad()
                .clickOnAnswers("Trigeminal Neuralgia - severe pain in the nerves of the face")
                .clickNextButton(new DoYouCurrentlyUseMarijuanaCC());

        doYouCurrentlyUseMarijuanaCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005117-QS6027-STUDYQUES", site.activeProtocols)
                .back();

        haveUeverDiagnosedByHealthcareProfesionalCC
                .waitForPageLoad()
                .clickOnAnswers("Temporomandibular Joint Disorders also known as TMD or TMJ")
                .clickNextButton(doYouCurrentlyUseMarijuanaCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0005117-QS6027-STUDYQUES", site.activeProtocols)
                .back();

        haveUeverDiagnosedByHealthcareProfesionalCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doYouCurrentlyUseMarijuanaCC);

//---------------Q21: DoYouCurrentlyUseMarijuanaCC-----
        TransitionStatementCC transitionStatementCC = doYouCurrentlyUseMarijuanaCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());

        transitionStatementCC
                .waitForPageLoad(studyName)
                .back();

        IfYouQualifyForStudyWillingtoStopCC ifYouQualifyForStudyWillingtoStopCC = doYouCurrentlyUseMarijuanaCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IfYouQualifyForStudyWillingtoStopCC());

//---------------Q22: IfYouQualifyForStudyWillingtoStopCC-----
        ifYouQualifyForStudyWillingtoStopCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoad(studyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018426-QS6029-STUDYQUES", site.activeProtocols)
                .back();

        ifYouQualifyForStudyWillingtoStopCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(transitionStatementCC);

//---------------Q24: Transition Statement - Display for Call Center onl-----
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

//-----------------GENERAL HEALTH questions-------------------
        WhatKindOfArthritisCC whatKindOfArthritisPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
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
                .clickNextButton(new WhatKindOfArthritisCC());
        whatKindOfArthritisPage.waitForPageLoad();
        whatKindOfArthritisPage.back();
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
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
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols);
        debugPageCC.back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());
        subquestionExperiencedHeartPageCC
                .waitForPageLoadStroke()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoadStroke()
                .clickOnAnswer("1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoadStroke()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);
        debugPageCC.checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        subquestionExperiencedHeartPageCC.back();

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("TIA or \"mini-stroke\"")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoadTIA()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = heartrelatedMedicalProceduresPageCC
//WomenHealthConditionsCC womenHealthConditionsCC = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                /*  .clickNextButton(new WomenHealthConditionsCC());


           DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = womenHealthConditionsCC
                  .waitForPageLoad()
                  .clickOnAnswers("None of the above") */
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());


        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad();
        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setFirstName("Acurian")
                .setLastName("Trial")
                .setPhone("9999999999")
                .setZipCode(site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                //----------SITE Selection Page--------------------
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
                .dispoShouldMatch(site.dispo);
    }
}