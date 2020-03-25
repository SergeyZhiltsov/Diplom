package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.END_4385.*;
import com.acurian.selenium.pages.CC.MDD_3159.MostRecentHeartProcedurePageСС;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_CC;
import com.acurian.selenium.pages.CC.SUI_3923.HaveYouGoneThroughMenopauseCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.MedicalRecordsOptionPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class End_4385_CC extends BaseTest {

    private static Logger Log = LogManager.getLogger(End_4385_CC.class.getName());

    @Test(enabled = false)
    public void end4385cc() {
        Site site = Site.AUT_END_4385;
        String phoneNumber = "AUTAMS1END";
        String studyName = "an endometriosis";
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("an endometriosis study", "1775");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("an endometriosis study", "1775"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
//                .setMonth("Sep")
//                .setDay("9")
//                .setYear("1980")
//                .clickOnAnswer("Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        FollowingGynecologicalConditionСС followingGynecologicalConditionСС = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Female")
                .clickNextButton(new FollowingGynecologicalConditionСС());

        DebugPageCC debugPageCC = new DebugPageCC();

        NonQRtransitionPageCC nonQRtransitionPageCC = followingGynecologicalConditionСС
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0014078-QS4902-STUDYQUES", site.activeProtocols)
                .back();
        TreatYourEndometriosisPageСС treatYourEndometriosisPageСС = followingGynecologicalConditionСС
                .waitForPageLoad()
                .clickOnAnswers("Endometriosis")
                .clickNextButton(new TreatYourEndometriosisPageСС());

        HaveYouGoneThroughMenopauseCC haveYouGoneThroughMenopauseCC = treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickNextButton(new HaveYouGoneThroughMenopauseCC());
        haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .back();
        DiagnoseYourEndometriosisCC diagnoseYourEndometriosisCC = treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("Ultrasound")
                .clickNextButton(new DiagnoseYourEndometriosisCC());
        diagnoseYourEndometriosisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020254-QS4928-STUDYQUES", site.activeProtocols)
                .back();
        treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickOnAnswers("CT scan")
                .clickNextButton(diagnoseYourEndometriosisCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020254-QS4928-STUDYQUES", site.activeProtocols)
                .back();
        treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickOnAnswers("MRI")
                .clickNextButton(diagnoseYourEndometriosisCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020254-QS4928-STUDYQUES", site.activeProtocols)
                .back();
        treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("Surgery, but unsure what type",
                        "Laparoscopy, which is a surgical procedure in which a scope is inserted through a small cut in the abdomen",
                        "Laparotomy, which is a surgical procedure in which a large cut is made into the abdomen",
                        "Seen or biopsied during an examination of the vagina, cervix, or other location (such as a cesarean section scar)")
                .clickNextButton(diagnoseYourEndometriosisCC);

        diagnoseYourEndometriosisCC
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(haveYouGoneThroughMenopauseCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015212-QS4921-STUDYQUES", site.activeProtocols)
                .back();
        diagnoseYourEndometriosisCC
                .waitForPageLoad()
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(haveYouGoneThroughMenopauseCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015212-QS4921-STUDYQUES", site.activeProtocols)
                .back();
        diagnoseYourEndometriosisCC
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(haveYouGoneThroughMenopauseCC);

        HaveYouHadHysterectomyСС haveYouHadHysterectomyСС = haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickNextButton(new HaveYouHadHysterectomyСС());
        haveYouHadHysterectomyСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0013713-QS4905-STUDYQUES", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                .clickNextButton(haveYouHadHysterectomyСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0013713-QS4905-STUDYQUES", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(haveYouHadHysterectomyСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0013713-QS4905-STUDYQUES", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouHadHysterectomyСС);

        haveYouHadHysterectomyСС
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0014084-QS4906-STUDYQUES", site.activeProtocols)
                .back();
        PlzDescribeYourMenstrualCyclesCC plzDescribeYourMenstrualCyclesCC = haveYouHadHysterectomyСС
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PlzDescribeYourMenstrualCyclesCC());

        ApproxHowManyDaysInYourMenstrualCycle_CC approxHowManyDaysInYourMenstrualCycle_cc = plzDescribeYourMenstrualCyclesCC
                .waitForPageLoad()
                .clickOnAnswer("Never regular")
                .clickNextButton(new ApproxHowManyDaysInYourMenstrualCycle_CC());

        HowManyTimesDidYouGetYourPeriodInThreeMons_CC howManyTimesDidYouGetYourPeriodInThreeMons_cc = approxHowManyDaysInYourMenstrualCycle_cc
                .waitForPageLoad()
                .setDays("15")
                .clickNextButton(new HowManyTimesDidYouGetYourPeriodInThreeMons_CC());

        PelvicPainCC pelvicPainCC = howManyTimesDidYouGetYourPeriodInThreeMons_cc
                .waitForPageLoad()
                .clickOnAnswer("Did not get period at all in the past 3 months")
                .clickNextButton(new PelvicPainCC());

        PelvicPainOtherTimesCC pelvicPainOtherTimesCC = pelvicPainCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PelvicPainOtherTimesCC());
        pelvicPainOtherTimesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0014086-QS4908-STUDYQUES", site.activeProtocols)
                .back();
        DescribesPelvicPainCC describesPelvicPainCC = pelvicPainCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesPelvicPainCC());

        describesPelvicPainCC
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(new PelvicPainOtherTimesCC());

        HormonalBirthControlCC hormonalBirthControlCC = pelvicPainOtherTimesCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HormonalBirthControlCC());
        hormonalBirthControlCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015214-QS4923-STUDYQUES", site.activeProtocols)
                .back();
        DescribesNonMenstrualPelvicPainCC describesNonMenstrualPelvicPainCC = pelvicPainOtherTimesCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesNonMenstrualPelvicPainCC());

        describesNonMenstrualPelvicPainCC
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(hormonalBirthControlCC);

        DiagnosedWithGynecologicalConditionCC diagnosedWithGynecologicalConditionCC = hormonalBirthControlCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithGynecologicalConditionCC());
        diagnosedWithGynecologicalConditionCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015753-QS4925-STUDYQUES", site.activeProtocols)
                .back();
        BirthControlMethodPageCC birthControlMethodPageCC = hormonalBirthControlCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BirthControlMethodPageCC());

        birthControlMethodPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(diagnosedWithGynecologicalConditionCC);

        AreYouCurrentlyPregnantCC areYouCurrentlyPregnantCC = diagnosedWithGynecologicalConditionCC
                .waitForPageLoad()
                .clickOnAnswers("Vaginismus, also known as vaginal muscle spasm")
                .clickNextButton(new AreYouCurrentlyPregnantCC());

        TransitionStatementCC transitionStatementCC = areYouCurrentlyPregnantCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadWithTitle(transitionStatementCC.titleExpectedEndo)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0008690-QS4916-STUDYQUES", site.activeProtocols)
                .back();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = areYouCurrentlyPregnantCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithTitle(transitionStatementCC.titleExpectedEndo)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        //-------------------New GENERAL HEALTH---------------------------
        WhatKindOfArthritisPageCC whatKindOfArthritisPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                                "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                        "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                                "Skin problems (eczema or atopic dermatitis, psoriasis)",
                                "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                                "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                                "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPageCC());

        whatKindOfArthritisPageCC
                .waitForPageLoad()
                .back();
        //Q2: QS38
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("ADHD or attention deficit hyperactivity disorder") //If exclusively selected, skip to Q24)
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        //Check flow logic for Q2
        //Q4: QS40
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickNextButton(whatKindOfArthritisPageCC);
        whatKindOfArthritisPageCC
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004962-QS39-STUDYQUES", site.activeProtocols)
                .back(whatKindOfArthritisPageCC)
                .clickOnAnswers("Psoriatic Arthritis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004962-QS39-STUDYQUES", site.activeProtocols)
                .back(whatKindOfArthritisPageCC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                        .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC());

        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                .waitForPageLoad()
                .clickOnAnswers("Osteoporosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015115-QS40-STUDYQUES", site.activeProtocols)
                .back(whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC); //Back to Q2: QS38

        WhichOfTheFollowingBreathingLungPageСС whichOfTheFollowingBreathingLungPageСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                        .clickNextButton(new WhichOfTheFollowingBreathingLungPageСС());
        //Q5: QS41
        whichOfTheFollowingBreathingLungPageСС
                .waitForPageLoad()
                .back();

        WhenDiagnosedWithCancerCC otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        //Q6: QS42
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", site.activeProtocols)
                .back(otherThanSkinCancerPageOLS);
        //Back to haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .back();

        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes (type 1 or type 2)")
                .clickNextButton(new WhatKindOfDiabetesPageCC());
        //Q6: QS42
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .back();

        WhichTypeOfHeadacheDoYouGetCC whichTypeOfHeadacheDoYouGetCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Headaches (migraine, cluster, tension)") //Select
                .clickNextButton(new WhichTypeOfHeadacheDoYouGetCC());
        //Q10: QS45
        whichTypeOfHeadacheDoYouGetCC
                .waitForPageLoad()
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)") //Select
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        //Q11: QS46
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageCC()); //Display Q12.1: QS47A
        //Q12.1: QS47A
        HashMap<String, List<String>> disqualifyQ121 = new HashMap<>();
        disqualifyQ121.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("History of MI")
        disqualifyQ121.put("1 - 3 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ121.put("4 - 6 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ121.put("7 - 12 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ121.put("More than 1 year ago", Arrays.asList(site.activeProtocols));
        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC =
                new HeartrelatedMedicalProceduresPageCC();
        for (Map.Entry<String, List<String>> entry : disqualifyQ121.entrySet()) {
            Log.info(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);
        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionExperiencedHeartPageCC); //Display Q12.2: QS47B
        //Q12.2: QS47B
        HashMap<String, List<String>> disqualifyQ122 = new HashMap<>();
        disqualifyQ122.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("History of stroke")
        disqualifyQ122.put("1 - 3 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ122.put("4 - 6 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ122.put("7 - 12 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ122.put("More than 1 year ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ122.entrySet()) {
            Log.info(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionExperiencedHeartPageCC); //Display Q12.3: QS47C
        //Q12.3: QS47C
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected3)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(heartrelatedMedicalProceduresPageCC) //Disqualify ("CHF") if selected "CHF" here, OR in Heart Failure Q2 selected "Yes"
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015128-QS46-STUDYQUES", site.activeProtocols)
                .back(heartrelatedMedicalProceduresPageCC);

        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionExperiencedHeartPageCC); //Display Q12.4: QS47D
        //Q12.4: QS47D
        HashMap<String, List<String>> disqualifyQ124 = new HashMap<>();
        disqualifyQ124.put("Less than 30 days ago", Arrays.asList(site.activeProtocols)); //Disqualify ("History of angina")
        disqualifyQ124.put("1 - 3 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ124.put("4 - 6 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ124.put("7 - 12 months ago", Arrays.asList(site.activeProtocols));
        disqualifyQ124.put("More than 1 year ago", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ124.entrySet()) {
            Log.info(entry.getKey());
            subquestionExperiencedHeartPageCC
                    .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(heartrelatedMedicalProceduresPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", site.activeProtocols)
                    .back(subquestionExperiencedHeartPageCC);
        }
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);
        //Q11: QS46
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageCC); //Skip to Q13
        //Q13: QS48
        MostRecentHeartProcedurePageСС mostRecentHeartProcedurePageСС = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageСС());
        //Q14: QS49
        mostRecentHeartProcedurePageСС
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015137-QS49-STUDYQUES", site.activeProtocols)
                .back(mostRecentHeartProcedurePageСС)
                .waitForPageLoad()
                .back(heartrelatedMedicalProceduresPageCC);
        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        DoYouTakeAnyMedicationsControlHypertension_CC doYouTakeAnyMedicationsControlHypertension_CC =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("High blood pressure or hypertension")
                .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_CC());
        //Q15: QS50
        doYouTakeAnyMedicationsControlHypertension_CC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        //Q16: QS51
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());
        //Q17: QS52
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Lupus") //Disqualify ("Lupus")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES", site.activeProtocols)
                .back();

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        //Q18: QS53
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC);
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", site.activeProtocols)
                .back(followingMentalEmotionalHealthPageCC);
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC());
        //Q19: QS54
        whichOfFollowingHaveYouDiagnosedWith_NeurologicalCC
                .waitForPageLoad()
                .back();
        WhichOfTheFollowingSkinConditionsDoYouSufferСС whichOfTheFollowingSkinConditionsDoYouSufferСС =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferСС());
        //Q20: QS55
        whichOfTheFollowingSkinConditionsDoYouSufferСС
                .waitForPageLoad()
                .clickOnAnswers("Psoriasis")
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        WomenHealthConditionsCC womenHealthConditionsCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WomenHealthConditionsCC());
        //Q22: QS57
        womenHealthConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("Overactive bladder (OAB)",
                                "Urinary leakage or urinary incontinence")
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(womenHealthConditionsCC);
        //Q22: QS57
        womenHealthConditionsCC
                .waitForPageLoad()
                .back();

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);
        //Flow for Q2: QS38 was checked

        //Q24: QS59
        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers( //Select all to check quantity
                        "Bipolar disorder",
                        "Cancer in the past 5 years, except skin cancer",
                        "Cirrhosis",
                        "Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis C",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS)",
                        "Neuropathy (nerve damage due to diabetes or another condition)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia",
                        "None of the above")
                .clickNextButton(new ApproximateHeightPageCC());
        //Q28: QS60
        approximateHeightPageCC
                .waitForPageLoad()
                .back();
        //Q24: QS59
        HashMap<String, List<String>> disqualifyQ24 = new HashMap<>();
        disqualifyQ24.put("Bipolar disorder", Arrays.asList(site.activeProtocols)); //Disqualify ("Bipolar disorder")
        disqualifyQ24.put("Cancer in the past 5 years, except skin cancer", Arrays.asList(site.activeProtocols)); //Cancer in the past 5 years, except skin cancer
        disqualifyQ24.put("Cirrhosis", Arrays.asList(site.activeProtocols)); //Disqualify ("Cirrhosis")
        disqualifyQ24.put("Drug or alcohol abuse within the past year", Arrays.asList(site.activeProtocols)); //Disqualify ("Substance abuse")
        disqualifyQ24.put("Hepatitis B", Arrays.asList(site.activeProtocols)); //Disqualify ("HBV")
        disqualifyQ24.put("Hepatitis C", Arrays.asList(site.activeProtocols)); //Disqualify ("HCV")
        disqualifyQ24.put("HIV or AIDS", Arrays.asList(site.activeProtocols)); //Disqualify ("HIV")
        for (Map.Entry<String, List<String>> entry : disqualifyQ24.entrySet()) {
            Log.info(entry.getKey());
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", site.activeProtocols)
                    .back();
        }

        //Q24: QS59
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC)
                //----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new TheStudySitePageCC())
                //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("an endometriosis study")
                .getPID()
                .clickOnAnswer(site.name)
//                .clickNextButton(new HSGeneralCC())
//                .waitForPageLoad(site_Indication)
                .clickNextButton(new MedicalRecordsOptionPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}