package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.chronic_cough.EverDiagnosedWithFollowingConditionsOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.cv_study.SubquestionHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.derm.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.blinx.ams.fibromyalgia.AnyFollowingPainfulConditionsOLS;
import com.acurian.selenium.pages.blinx.ams.fibromyalgia.DiagnosedWithFibromyalgiaOLS;
import com.acurian.selenium.pages.blinx.ams.fibromyalgia.HowLongBeenHavingSymptomsFibromyalgiaOLS;
import com.acurian.selenium.pages.blinx.ams.fibromyalgia.TypeOfDoctorDiagnosedWithFibromyalgiaOLS;
import com.acurian.selenium.pages.blinx.ams.gerd.CurrentlySufferOfAnyOfFollowingOLS;
import com.acurian.selenium.pages.blinx.ams.gerd.DuringPastThreeMonthsOLS;
import com.acurian.selenium.pages.blinx.ams.gerd.UseMarijuanaOrCannabisOLS;
import com.acurian.selenium.pages.blinx.ams.gerd.WhatTypeOfSurgeryDidYouHave_OLS;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AF_4958_OLSBlinx extends BaseTest {

    private static Logger Log = LogManager.getLogger(AF_4958_OLSBlinx.class.getName());

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_AMS1_4958_site},
                // {Site.AUT_AMS1_4958S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("4958 NYX-2925-2005 Aptinyx Fibromyalgia OLS")
    public void af4958BlinxTest(Site site) {
        final String phoneNumber = "AUTAMS1FIB";
        final String studyName = "a fibromyalgia study";
        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad(studyName, "350");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle(studyName, "350"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS);


        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad(studyName, "350")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());


        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());


        genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("01012003")
                .clickNextButton(lessThan18YearsOldPageOLS);
        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                        .waitForPageLoad()
                        .setDate("01011944") //Disqualify ("Age") if >= 76
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);
        DiagnosedWithFibromyalgiaOLS diagnosedWithFibromyalgiaOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("01011960")
                .clickNextButton(new DiagnosedWithFibromyalgiaOLS());

        //Q2
        diagnosedWithFibromyalgiaOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7802", site.activeProtocols)
                .back(diagnosedWithFibromyalgiaOLS);
        HowLongBeenHavingSymptomsFibromyalgiaOLS howLongBeenHavingSymptomsFibromyalgiaOLS = diagnosedWithFibromyalgiaOLS.waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongBeenHavingSymptomsFibromyalgiaOLS());

        AnyFollowingPainfulConditionsOLS anyFollowingPainfulConditionsOLS = new AnyFollowingPainfulConditionsOLS();

        //Q3
        TypeOfDoctorDiagnosedWithFibromyalgiaOLS typeOfDoctorDiagnosedWithFibromyalgiaOLS =
                new TypeOfDoctorDiagnosedWithFibromyalgiaOLS();
        List<String> disqualifyQ3 = Arrays.asList("Less than 3 months", "3 - 6 months", "7 - 11 months");
        for (String answer : disqualifyQ3) {
            Log.info("Select answer for Q3: " + answer);
            howLongBeenHavingSymptomsFibromyalgiaOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(anyFollowingPainfulConditionsOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7811", site.activeProtocols)
                    .back(howLongBeenHavingSymptomsFibromyalgiaOLS);
        }
        howLongBeenHavingSymptomsFibromyalgiaOLS
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(anyFollowingPainfulConditionsOLS);

        AreYouCurrentlyReceivingWorkersPageOLS areYouCurrentlyReceivingWorkersPageOLS =
                new AreYouCurrentlyReceivingWorkersPageOLS();

        anyFollowingPainfulConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(areYouCurrentlyReceivingWorkersPageOLS);


        areYouCurrentlyReceivingWorkersPageOLS
                .waitForPageLoad2()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7806", site.activeProtocols)
                .back(areYouCurrentlyReceivingWorkersPageOLS)
                .waitForPageLoad2()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        //#############General_Health ###########################
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Lupus")
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickNextButton(new WhatKindOfArthritisPageOLS());


        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickOnAnswers("Psoriatic Arthritis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Psoriatic Arthritis") //deselect
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                        .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());


        List<String> disqualifyQ4QS40 = Arrays.asList("Ankylosing spondylitis or axial spondyloarthritis", "Gout");
        for (String answer : disqualifyQ4QS40) {
            Log.info("Select answer for Q4QS40: " + answer);
            whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS40", site.activeProtocols)
                    .back(whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS);
        }
        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .waitForPageLoad()
                .clickOnAnswers("Low back pain", "Osteoporosis")
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Cancer")
                        .clickNextButton(new WhenDiagnosedWithCancerOLS());


        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)")
                        .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());


        List<String> disqualifyQ8QS44 = Arrays.asList("Crohn's disease", "Ulcerative colitis");
        for (String answer : disqualifyQ8QS44) {
            Log.info("Select answer for Q8:QS44: " + answer);
            whichOfFollowingDigestiveConditionPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back(whichOfFollowingDigestiveConditionPageOLS);
        }
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());


        SubquestionHeartPageOLS subquestionHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionHeartPageOLS());
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected2())
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS46", site.activeProtocols)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionHeartPageOLS);


        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS =
                new HeartrelatedMedicalProceduresPageOLS();
        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago",
                "7 - 12 months ago");
        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.1GH: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionHeartPageOLS);


        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.3GH: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected3())
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected3())
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageOLS);

        for (String answer : disqualifyQ12GH) {
            Log.info("Select answer for Q12.4GH: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected4())
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected4())
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Kidney disease")
                        .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());


        List<String> disqualifyQ6QS51 = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQ6QS51) {
            Log.info("Select answer for Q6:QS51: " + answer);
            whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        }
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());


        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswers("Fatty liver disease", "NASH (non-alcoholic steatohepatitis)",
                        "NAFLD (non-alcoholic fatty liver disease)")
                .clickOnAnswers("Unsure which type of liver disease")
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());


        //Q18: QS53
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQ18) {
            Log.info("Select answer for Q18:QS53: " + answer);
            followingMentalEmotionalHealthPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back(followingMentalEmotionalHealthPageOLS);
        }
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());


        //Q19: QS54
        List<String> disqualifyQ19 = Arrays.asList("Alzheimer's disease", "Parkinson's disease",
                "Multiple sclerosis (MS)", "Seizure disorder, such as epilepsy");
        for (String answer : disqualifyQ19) {
            Log.info("Select answer for Q19:QS54: " + answer);
            whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                    .back(whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS);
        }
        whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);


        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQ24 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
//                "Hepatitis B",
//                "Hepatitis C",
                "HIV or AIDS");
        for (String answer : disqualifyQ24) {
            Log.info("Select answer for Q24QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back(            doAnyOftheFollowingAdditionalDiagnosesOLS
                    );
        }
        List<String> disqualifyQ24pt2 = Arrays.asList("Kidney disease requiring dialysis", "Multiple sclerosis (MS)",
                "Seizure disorder such as epilepsy", "Schizophrenia");
        for (String answer : disqualifyQ24pt2) {
            Log.info("Select answer for Q24QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        }
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        CurrentlySufferOfAnyOfFollowingOLS currentlySufferOfAnyOfFollowingOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "280") //Disqualify ("High BMI") if > 40
                .clickNextButton(new CurrentlySufferOfAnyOfFollowingOLS());
        currentlySufferOfAnyOfFollowingOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageOLS);

        IdentificationPageOLS identificationPageOLS = new IdentificationPageOLS();

        if (env.equals("PRD")) {
            approximateHeightPageOLS
                    .waitForPageLoad()
                    .setPounds("150")
                    .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new RequirePassDrugTestOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(identificationPageOLS);
        }
        if (env.equals("STG")){
            approximateHeightPageOLS
                    .waitForPageLoad()
                    .setAll("3","3","30")
                    .clickNextButton(new CurrentlySufferOfAnyOfFollowingOLS())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new DuringPastThreeMonthsOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new EverDiagnosedWithFollowingConditionsOLS())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new WhatTypeOfSurgeryDidYouHave_OLS())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new WeightLossSurgeryPageOLS())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new UseMarijuanaOrCannabisOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new RequirePassDrugTestOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(identificationPageOLS);
        }

        SiteSelectionPageOLS siteSelectionPageCC = identificationPageOLS
                .waitForPageLoad2()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999")
                .clickNextButton(new SiteSelectionPageOLS());


        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageCC
                .waitForPageLoad("a fibromyalgia study!")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS());

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                .waitForPageLoad3()
                .clickNextButton(new ThankYouCloseSimplePageOLS());

        AlzheimerClosePageOLS alzheimerClosePageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AlzheimerClosePageOLS());

        AboutHealthPageOLS aboutHealthPageOLS = alzheimerClosePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        if(aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .dispoShouldMatch(site.dispo, site.dispo)
                    .assertGeneratedFul(env, site);

            if (site == Site.AUT_AMS1_4958S_site) {
                aboutHealthPageOLS
                        .getRadiantDbToLog(env)
                        .getAnomalyDbToLog(env);
            }
        }

    }
}
