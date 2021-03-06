package com.acurian.selenium.CC;

import com.acurian.selenium.blinx.Crohns_4818_OLSBlinx;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns.EverDiagnosedWithFollowingConditionsСС;
import com.acurian.selenium.pages.CC.Fibromyalgia.AnyFollowingPainfulConditionsCC;
import com.acurian.selenium.pages.CC.Fibromyalgia.DiagnosedWithFibromyalgiaCC;
import com.acurian.selenium.pages.CC.Fibromyalgia.HowLongBeenHavingSymptomsFibromyalgiaCC;
import com.acurian.selenium.pages.CC.Fibromyalgia.TypeOfDoctorDiagnosedWithFibromyalgiaCC;
import com.acurian.selenium.pages.CC.GERD.CurrentlySufferOfAnyOfFollowingCC;
import com.acurian.selenium.pages.CC.GERD.DuringPastThreeMonthsCC;
import com.acurian.selenium.pages.CC.GERD.UseMarijuanaOrCannabisCC;
import com.acurian.selenium.pages.CC.GERD.WhatTypeOfSurgeryDidYouHave_CC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.SubquestionHeartPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.OLS.AF_4958_OLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AF_4958_CC extends BaseTest {

    private static Logger Log = LogManager.getLogger(AF_4958_CC.class.getName());


    @Test(dataProviderClass = AF_4958_OLS.class, dataProvider = "sites")
    @Description("4958 NYX-2925-2005 Aptinyx Fibromyalgia CC")
    public void af4958CCTest(Site site) {
        final String phoneNumber = "AUTAMS1FIB";
        final String studyName = "a fibromyalgia study";
        final String transitionStudyName = "fibromyalgia";
        final String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        DebugPageCC debugPageCC = new DebugPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:",
                "Title text is diff");
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

        //-------Date of Birth Page--------
        dateOfBirthPageCC
                .waitForPageLoad(studyName, "350");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                .getExpectedModifiedTitle(studyName, "350"), "Title is diff");
        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .back(dateOfBirthPageCC)
                .waitForPageLoad(studyName, "350")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad(studyName, "350")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());


        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());


        genderPageCC
                .waitForPageLoad()
                .setMonth("Jan")
                .setDay("1")
                .setYear("2003") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                genderPageCC
                        .waitForPageLoad()
                        .setYear("1944") //Disqualify ("Age") if >= 76
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        DiagnosedWithFibromyalgiaCC diagnosedWithFibromyalgiaCC = genderPageCC
                .waitForPageLoad()
                .setYear("1960")
                .clickNextButton(new DiagnosedWithFibromyalgiaCC());

        //Q2
        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedWithFibromyalgiaCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7802", site.activeProtocols)
                .back();
        HowLongBeenHavingSymptomsFibromyalgiaCC howLongBeenHavingSymptomsFibromyalgiaCC = diagnosedWithFibromyalgiaCC.waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongBeenHavingSymptomsFibromyalgiaCC());


        AnyFollowingPainfulConditionsCC anyFollowingPainfulConditionsCC = new AnyFollowingPainfulConditionsCC();

        //Q3
        TypeOfDoctorDiagnosedWithFibromyalgiaCC typeOfDoctorDiagnosedWithFibromyalgiaCC =
                new TypeOfDoctorDiagnosedWithFibromyalgiaCC();
        List<String> disqualifyQ3 = Arrays.asList("Less than 3 months", "3 - 6 months", "7 - 11 months");
        for (String answer : disqualifyQ3) {
            Log.info("Select answer for Q3: " + answer);
            howLongBeenHavingSymptomsFibromyalgiaCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(anyFollowingPainfulConditionsCC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7811", site.activeProtocols)
                    .back();
        }

        howLongBeenHavingSymptomsFibromyalgiaCC
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(anyFollowingPainfulConditionsCC);


//        AnyFollowingPainfulConditionsCC anyFollowingPainfulConditionsCC = typeOfDoctorDiagnosedWithFibromyalgiaCC
//                .waitForPageLoad()
//                .clickOnAnswer("Primary care or family doctor")
//                .clickOnAnswer("Rheumatologist")
//                .clickOnAnswer("Psychiatrist")
//                .clickOnAnswer("Pain specialist")
//                .clickOnAnswer("Physiatrist (physical medicine and rehabilitation specialist)")
//                .clickOnAnswer("Neurologist")
//                .clickOnAnswer("Other")
//                .clickNextButton(new AnyFollowingPainfulConditionsCC());


        AreYouCurrentlyReceivingWorkersPageCC areYouCurrentlyReceivingWorkersPageCC =
                new AreYouCurrentlyReceivingWorkersPageCC();
//        List<String> disqualifyQ5 = Arrays.asList("Nerve damage, numbness, or pain in legs, feet, or hands caused by diabetes (diabetic peripheral neuropathy)",
//                "Ongoing shingles pain (post-herpetic neuralgia)", "Ongoing pain related to a traumatic injury or prior surgery");
//        for (String answer : disqualifyQ5) {
//            Log.info("Select answer for Q5: " + answer);
//            anyFollowingPainfulConditionsCC
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickOnAnswers(answer)
//                    .clickNextButton(areYouCurrentlyReceivingWorkersPageCC)
//                    .getPage(debugPageCC)
//                    .checkProtocolsContainsForQNumber("QS7805", site.activeProtocols)
//                    .back();
//        }
        anyFollowingPainfulConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(areYouCurrentlyReceivingWorkersPageCC);


        TransitionStatementCC transitionStatementCC = areYouCurrentlyReceivingWorkersPageCC
                .waitForPageLoad2()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoad(transitionStudyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7806", site.activeProtocols)
                .back(areYouCurrentlyReceivingWorkersPageCC)
                .waitForPageLoad2()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC);


        transitionStatementCC
                .waitForPageLoad(transitionStudyName)
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);


        //#############General_Health ###########################
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                                "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                                "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                                "Women's health issues (endometriosis, uterine fibroids)")
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Lupus")
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());


        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        WhatKindOfArthritisPageCC whatKindOfArthritisPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickNextButton(new WhatKindOfArthritisPageCC());


        whatKindOfArthritisPageCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickOnAnswers("Psoriatic Arthritis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisPageCC)
                .waitForPageLoad()
                .clickOnAnswers("Psoriatic Arthritis") //deselect
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .back();
        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                        .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC());


        List<String> disqualifyQ4QS40 = Arrays.asList("Ankylosing spondylitis or axial spondyloarthritis", "Gout");
        for (String answer : disqualifyQ4QS40) {
            Log.info("Select answer for Q4QS40: " + answer);
            whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS40", site.activeProtocols)
                    .back();
        }
        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                .waitForPageLoad()
                .clickOnAnswers("Low back pain", "Osteoporosis")
                .back();
        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Cancer")
                        .clickNextButton(new WhenDiagnosedWithCancerCC());


        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerCC)
                .clickOnAnswer("6 - 10 years ago")
                .clickOnAnswer("11 or more years ago")
                .clickOnAnswer("Diagnosed with skin cancer only")
                .back();
        WhichOfFollowingDigestiveConditionPageCC whichOfFollowingDigestiveConditionPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)")
                        .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC());


        List<String> disqualifyQ8QS44 = Arrays.asList("Crohn's disease", "Ulcerative colitis");
        for (String answer : disqualifyQ8QS44) {
            Log.info("Select answer for Q8:QS44: " + answer);
            whichOfFollowingDigestiveConditionPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back();
        }
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .back();
        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());


        SubquestionHeartPageCC subquestionHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionHeartPageCC());
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected2)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS46", site.activeProtocols)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionHeartPageCC);


        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC =
                new HeartRelatedSurgeriesProceduresPageCC();
        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago",
                "7 - 12 months ago");
        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.1GH: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected1)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionHeartPageCC);


        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.3GH: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected3)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected3)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageCC);

        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.4GH: " + answer);
            subquestionHeartPageCC
                    .waitForPageLoad(1, subquestionHeartPageCC.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageCC
                .waitForPageLoad(1, subquestionHeartPageCC.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC)
                .waitForPageLoad()
                .back();
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());


        List<String> disqualifyQ6QS51 = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQ6QS51) {
            Log.info("Select answer for Q6:QS51: " + answer);
            whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back();
        }
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();
        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());


        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Fatty liver disease", "NASH (non-alcoholic steatohepatitis)",
                        "NAFLD (non-alcoholic fatty liver disease)")
                .clickOnAnswers("Unsure which type of liver disease")
                .back();
        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageCC());


        //Q18: QS53
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQ18) {
            Log.info("Select answer for Q18:QS53: " + answer);
            followingMentalEmotionalHealthPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back();
        }
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back();
        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC());


        //Q19: QS54
        List<String> disqualifyQ19 = Arrays.asList("Alzheimer's disease", "Parkinson's disease",
                "Multiple sclerosis (MS)", "Seizure disorder, such as epilepsy");
        for (String answer : disqualifyQ19) {
            Log.info("Select answer for Q19:QS54: " + answer);
            whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                    .back();
        }
        whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);


        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ24 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
//                "Hepatitis B",
//                "Hepatitis C",
                "HIV or AIDS");
        for (String answer : disqualifyQ24) {
            Log.info("Select answer for Q24QS59: " + answer);
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
        List<String> disqualifyQ24pt2 = Arrays.asList("Kidney disease requiring dialysis", "Multiple sclerosis (MS)",
                "Seizure disorder such as epilepsy", "Schizophrenia");
        for (String answer : disqualifyQ24pt2) {
            Log.info("Select answer for Q24QS59: " + answer);
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
                .setAll("5", "5", "280") //Disqualify ("High BMI") if > 40
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("3", "3","30")
                .clickNextButton(new LetMeSeePageCC());

        CurrentlyParticipatingInStudy currentlyParticipatingInStudy = new CurrentlyParticipatingInStudy();

        if (env.equals("STG")){
            letMeSeePageCC
                    .waitForPageLoad()
                    .clickNextButton(new CurrentlySufferOfAnyOfFollowingCC())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new DuringPastThreeMonthsCC())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new EverDiagnosedWithFollowingConditionsСС())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new WhatTypeOfSurgeryDidYouHave_CC())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new WeightLossSurgeryPageCC())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new UseMarijuanaOrCannabisCC())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
//                    .clickNextButton(new NonQRtransitionPageCC())
//                    .waitForPageLoad()
                    .clickNextButton(currentlyParticipatingInStudy);

        }else{
            letMeSeePageCC
                    .waitForPageLoad()
                    .clickNextButton(currentlyParticipatingInStudy);
        }

        RequirePassDrugTest requirePassDrugTest = currentlyParticipatingInStudy
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest());
        IdentificationPageCC identificationPageCC = requirePassDrugTest
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC());


        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());
        siteSelectionPageCC
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name);

        switch (site) {
            case AUT_AMS1_4958_site:
                QualifiedClose1PageCC qualifiedClose1PageCC = siteSelectionPageCC
                        .clickNextButton(new QualifiedClose1PageCC());

                ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = qualifiedClose1PageCC
                        .waitForPageLoad()
                        //.clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC());


//                ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = synexusHealthyMindsPageCC
//                        .waitForPageLoad()
//                        .clickOnAnswer("No")
//                        .clickNextButton(new ThankYouCloseSimplePageCC());


                thankYouCloseSimplePageCC
                        .waitForPageLoad3()
                        .clickNextButton(new AlzheimerClosePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad();
                if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
                    selectActionPageCC
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env)
                            .dispoShouldMatch(site.dispo, site.dispo)
                            .assertGeneratedFul(env, site);
                }
                    break;
            case AUT_AMS1_4958S_site:
                SynexusRadiantDirectScheduleCC synexusRadiantDirectScheduleCC = siteSelectionPageCC
                        .clickNextButton(new SynexusRadiantDirectScheduleCC());

                synexusRadiantDirectScheduleCC
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "01/01/1960", "US",
                                "Cape May, NJ", site.zipCode, "qa.acurian@gmail.com",
                                "999-999-9999", "aut4958s", site.name,
                                "APTXXXFIB005")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad();
                if (selectActionPageCC.getHostName().equals(Properties.getHostName())) {
                    selectActionPageCC
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env)
                            .dispoShouldMatch(site.dispo, site.dispo)
                            .assertGeneratedFul(env, site)
                            .getRadiantDbToLog(env);
                }
                break;
        }
    }
}
