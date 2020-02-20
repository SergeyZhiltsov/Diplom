package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.END_4385.*;
import com.acurian.selenium.pages.OLS.MDD_3159.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class END_4385_OLS extends BaseTest {

    @Test(enabled = false)
    @Description("a cluster headache study 3237 - OLS")
    public void end4385ols() {
        Site site = Site.AUT_END_4385;
        String phoneNumber = "AUTAMS1END";
        String studyName = "an endometriosis";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad("an endometriosis study", "1775");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("an endometriosis study", "1775"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        FollowingGynecologicalConditionOLS followingGynecologicalConditionOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new FollowingGynecologicalConditionOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4902", site.activeProtocols)
                .back();
        TreatYourEndometriosisPageOLS treatYourEndometriosisPageOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Endometriosis")
                .clickNextButton(new TreatYourEndometriosisPageOLS());

        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .back();
        DiagnoseYourEndometriosisOLS diagnoseYourEndometriosisOLS = treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Ultrasound")
                .clickNextButton(new DiagnoseYourEndometriosisOLS());
        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4928", site.activeProtocols)
                .back();
        treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickOnAnswers("CT scan")
                .clickNextButton(diagnoseYourEndometriosisOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4928", site.activeProtocols)
                .back();
        treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickOnAnswers("MRI")
                .clickNextButton(diagnoseYourEndometriosisOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4928", site.activeProtocols)
                .back();
        treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Surgery, but unsure what type",
                        "Laparoscopy, which is a surgical procedure in which a scope is inserted through a small cut in the abdomen",
                        "Laparotomy, which is a surgical procedure in which a large cut is made into the abdomen",
                        "Seen or biopsied during an examination of the vagina, cervix, or other location (such as a cesarean section scar)")
                .clickNextButton(diagnoseYourEndometriosisOLS);

        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(haveYouGoneThroughMenopauseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4921", site.activeProtocols)
                .back();
        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(haveYouGoneThroughMenopauseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4921", site.activeProtocols)
                .back();
        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(haveYouGoneThroughMenopauseOLS);

        HaveYouHadHysterectomyOLS haveYouHadHysterectomyOLS = haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4905", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                .clickNextButton(haveYouHadHysterectomyOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4905", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(haveYouHadHysterectomyOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4905", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouHadHysterectomyOLS);

        haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4906", site.activeProtocols)
                .back();
        PlzDescribeYourMenstrualCyclesOLS plzDescribeYourMenstrualCyclesOLS = haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PlzDescribeYourMenstrualCyclesOLS());

        ApproxHowManyDaysInYourMenstrualCycle_OLS approxHowManyDaysInYourMenstrualCycle_OLS = plzDescribeYourMenstrualCyclesOLS
                .waitForPageLoad()
                .clickOnAnswer("Never regular")
                .clickNextButton(new ApproxHowManyDaysInYourMenstrualCycle_OLS());

        HowManyTimesDidYouGetYourPeriodInThreeMons_OLS howManyTimesDidYouGetYourPeriodInThreeMons_OLS = approxHowManyDaysInYourMenstrualCycle_OLS
                .waitForPageLoad()
                .setDays("15")
                .clickNextButton(new HowManyTimesDidYouGetYourPeriodInThreeMons_OLS());

        PelvicPainOLS pelvicPainOLS = howManyTimesDidYouGetYourPeriodInThreeMons_OLS
                .waitForPageLoad()
                .clickOnAnswer("Did not get period at all in the past 3 months")
                .clickNextButton(new PelvicPainOLS());

        PelvicPainOtherTimesOLS pelvicPainOtherTimesOLS = pelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PelvicPainOtherTimesOLS());
        pelvicPainOtherTimesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4908", site.activeProtocols)
                .back();
        DescribesPelvicPainOLS describesPelvicPainOLS = pelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesPelvicPainOLS());

        describesPelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(new PelvicPainOtherTimesOLS());

        HormonalBirthControlOLS hormonalBirthControlOLS = pelvicPainOtherTimesOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HormonalBirthControlOLS());
        hormonalBirthControlOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4923", site.activeProtocols)
                .back();
        DescribesNonMenstrualPelvicPainOLS describesNonMenstrualPelvicPainOLS = pelvicPainOtherTimesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesNonMenstrualPelvicPainOLS());

        describesNonMenstrualPelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(new HormonalBirthControlOLS());

        DiagnosedWithGynecologicalConditionOLS diagnosedWithGynecologicalConditionOLS = hormonalBirthControlOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithGynecologicalConditionOLS());
        diagnosedWithGynecologicalConditionOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4925", site.activeProtocols)
                .back();
        BirthControlMethodPageOLS birthControlMethodPageOLS = hormonalBirthControlOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BirthControlMethodPageOLS());

        birthControlMethodPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(diagnosedWithGynecologicalConditionOLS);

        AreYouCurrentlyPregnantOLS areYouCurrentlyPregnantOLS = diagnosedWithGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Vaginismus, also known as vaginal muscle spasm")
                .clickNextButton(new AreYouCurrentlyPregnantOLS());

        areYouCurrentlyPregnantOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4916", site.activeProtocols)
                .back();
        areYouCurrentlyPregnantOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Cancer",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_ols = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());
        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back();
        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickOnAnswers("Psoriatic Arthritis")
                .clickNextButton(whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_ols)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back();
        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Psoriatic Arthritis")
                .clickOnAnswers("Unsure")
                .clickNextButton(whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_ols);

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_ols
                .waitForPageLoad()
                .clickOnAnswers("Osteoporosis")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS40", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_ols
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whenDiagnosedWithCancerOLS);

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS46", site.activeProtocols)
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "Less than 30 days ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        MostRecentHeartProcedurePageOLS mostRecentHeartProcedurePageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 30 days ago")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
                .back();
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        FollowingMentalEmotionalHealthPageOLS following_mentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(following_mentalEmotionalHealthPageOLS);

        WomenHealthConditionsOLS womenHealthConditionsOLS = following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new WomenHealthConditionsOLS());
        womenHealthConditionsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(womenHealthConditionsOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(womenHealthConditionsOLS);

        womenHealthConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();

/*                //------------HUMAN API Interface in HelloSign----------------
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
                .clickNextButton(new ThankYouCloseSimplePageOLS())*/

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}