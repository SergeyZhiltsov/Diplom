package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Vaccine.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.pages.blinx.ams.shared.DRSBlinx;
import com.acurian.selenium.utils.Properties;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VACC_JANRSV_CC extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.JANRSV_AUT_JANDS},
                {Site.AUT_AMS_JANRSV},
                {Site.AUT_AMS_JANRSV_Syn}
        };
    }
    @Test(dataProvider = "sites")
    @Description("VACC_4556_OLS")
    public void vaccJANRSVccTest(Site site) {
        String phoneNumber = "AUTAMS1VAC";
        String studyName = "a vaccine study";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();
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
                .waitForPageLoad(studyName, "650");
        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .back(dateOfBirthPageCC)
                .waitForPageLoad(studyName, "650")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        ZipCodePageCC zipCodePageCC = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad(studyName, "650")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        if (site == Site.JANRSV_AUT_JANDS) {
            HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                    new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC();
            ScedulerCC scedulerCC = new ScedulerCC();
            DirectSheduleVaccCC directSheduleVaccCC = new DirectSheduleVaccCC();
            DRSBlinx dRSBlinx = new DRSBlinx();
            zipCodePageCC
                    .waitForPageLoad()
                    .typeZipCode(site.zipCode)
                    .clickNextButton(dateOfBirthPageCC)
                    .waitForPageLoadGmega()
                    .clickOnAnswer("Female")
                    .setYear("1954")
                    .setDay("1")
                    .setMonth("Jan")
                    .clickNextButton(new AreYouInterestedVaccineResearchStudyCC())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new AreYouGenerallyInGoodHealthCC())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new AllergicToAnyVaccinesCC())
                    .waitForPageLoad()
                    .clickOnAnswer("Unsure")
                    .clickNextButton(new HaveYouGoneThroughMenopauseCC())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                    .clickNextButton(new TransitionStatementCC())
                    .waitForPageLoadVacc()
                    .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new ApproximateHeightPageCC())
                    .waitForPageLoad()
                    .setAll("5", "5", "150")
                    .clickNextButton(new LetMeSeePageCC())
                    .waitForPageLoad()
                    .clickNextButton(new IdentificationPageCC())
                    .waitForPageLoad()
                    .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                            "9999999999", site.zipCode)
                    .clickNextButton(new SiteSelectionPageCC())
                    .waitForPageLoad3("a vaccine study")
                    .getPID()
                    .clickOnAnswer(site.name)
                    .clickNextButton(directSheduleVaccCC);
            if(env.equals("PRD")){
                directSheduleVaccCC
                        .waitForPageLoad();
            }
            if(env.equals("STG")){
                directSheduleVaccCC
                        .waitForPageLoadSTG();
            }
            directSheduleVaccCC
                    .clickSheduleBtnBlinx(dRSBlinx);
            ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
            getDriver().switchTo().window(tabs.get(1));
            dRSBlinx
                    .waitForPageLoadBlinx()
                    .clickOnDay()
                    .clickOnTime()
                    .clickOnNext()
                    .waitForPageLoadClientDetails()
                    .dateCheck()
                    .startsAtCheck()
                    .serviceProviderCheck();
                    //.assertClientData("qa.acurian@gmail.com", "9999999999")
//                    .clickBook()
//                    .waitForPageLoadSuccess()
//                    .clickOnBtnNext()
//                    .waitForThankYou();
//            if(env.equals("PRD")){
//                directSheduleVaccOLS
//                        .waitForPageLoad();
//            }
//            if(env.equals("STG")){
//                directSheduleVaccOLS
//                        .waitForPageLoadSTG();
//            }
//            directSheduleVaccOLS
//                    .clickSheduleBtn(drsols);
            getDriver().switchTo().window(tabs.get(0));
            SynexusRadiantDirectScheduleCC synexusRadiantDirectScheduleCC = new SynexusRadiantDirectScheduleCC();
//            if (env.equals("PRD")) {
//                directSheduleVaccCC
//                        .waitForPageLoad();
//            }
//            if (env.equals("STG")) {
//                directSheduleVaccCC
//                        .waitForPageLoadSTG();
//            }
            directSheduleVaccCC
                    .waitForPageLoad()
                    .clickNextButton(synexusRadiantDirectScheduleCC);
//            SynexusHealthyMindsPageCC synexusHealthyMindsPageCC  = qualifiedClose1PageCC
//                    .waitForPageLoad()
//                    .clickNextButton(new SynexusHealthyMindsPageCC());

//            ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = synexusHealthyMindsPageCC
//                    .waitForPageLoad()
//                    .clickOnAnswer("No")
            synexusRadiantDirectScheduleCC
                    .waitForPageLoadSyn()
                    .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                    .clickNextButton(selectActionPageCC);

//            thankYouCloseSimplePageCC
//                    .waitForPageLoad()
//                    .clickNextButton(selectActionPageCC);

            selectActionPageCC
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .dispoShouldMatch(site.dispo, site.dispo);

        } else {
            GenderPageCC genderPageCC = zipCodePageCC
                    .waitForPageLoad()
                    .typeZipCode(site.zipCode)
                    .clickNextButton(new GenderPageCC());


            genderPageCC
                    .waitForPageLoad()
                    .setMonth("Jan")
                    .setDay("1")
                    .setYear("2002") //Disqualify (“Age < 18 years old”) if <18
                    .clickOnAnswer("Female")
                    .clickNextButton(lessThan18YearsOldPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                    .back();
            HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                    genderPageCC
                            .waitForPageLoad()
                            .setYear("1955")
                            .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
            haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                    .back();
            AreYouInterestedVaccineResearchStudyCC areYouInterestedVaccineResearchStudyCC = genderPageCC
                    .waitForPageLoad()
                    .setYear("1954")
                    .clickNextButton(new AreYouInterestedVaccineResearchStudyCC());


            NonQRtransitionPageCC nonQRtransitionPageCC = areYouInterestedVaccineResearchStudyCC
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new NonQRtransitionPageCC());
            nonQRtransitionPageCC
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6908", site.activeProtocols)
                    .back();
            AreYouGenerallyInGoodHealthCC areYouGenerallyInGoodHealthCC = areYouInterestedVaccineResearchStudyCC
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new AreYouGenerallyInGoodHealthCC());


            AllergicToAnyVaccinesCC allergicToAnyVaccinesCC = areYouGenerallyInGoodHealthCC
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new AllergicToAnyVaccinesCC());
            allergicToAnyVaccinesCC
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6909", site.activeProtocols)
                    .back(areYouGenerallyInGoodHealthCC)
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(allergicToAnyVaccinesCC);


            HaveYouGoneThroughMenopauseCC haveYouGoneThroughMenopauseCC = allergicToAnyVaccinesCC
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new HaveYouGoneThroughMenopauseCC());
            haveYouGoneThroughMenopauseCC
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6910", site.activeProtocols)
                    .back(allergicToAnyVaccinesCC)
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickOnAnswer("Unsure")
                    .clickNextButton(haveYouGoneThroughMenopauseCC);


            TransitionStatementCC transitionStatementCC = haveYouGoneThroughMenopauseCC
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new TransitionStatementCC());
            transitionStatementCC
                    .waitForPageLoadWithTitle(transitionStatementCC.titleInitialQuestionsExpected)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS6911", site.activeProtocols)
                    .back(haveYouGoneThroughMenopauseCC)
                    .waitForPageLoad()
                    .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                    .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                    .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                    .clickNextButton(transitionStatementCC);


            transitionStatementCC
                    .waitForPageLoadWithTitle(transitionStatementCC.titleInitialQuestionsExpected)
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
                    .back();

            whatKindOfArthritisPageCC
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


            whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                    .waitForPageLoad()
                    .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis")
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS40", site.activeProtocols)
                    .back(whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC)
                    .waitForPageLoad()
                    .clickOnAnswers("Gout", "Low back pain", "Osteoporosis") //deselect
                    .clickOnAnswers("None of the above")
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
                System.out.println("Select answer for Q8:QS44: " + answer);
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
            WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers("Kidney disease")
                    .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());


            List<String> disqualifyQ6QS51 = Arrays.asList("Dialysis", "Kidney transplant");
            for (String answer : disqualifyQ6QS51) {
                System.out.println("Select answer for Q6:QS51: " + answer);
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
                System.out.println("Select answer for Q18:QS53: " + answer);
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
            List<String> disqualifyQ19 = Arrays.asList("Alzheimer's disease", "Multiple sclerosis (MS)");
            for (String answer : disqualifyQ19) {
                System.out.println("Select answer for Q19:QS54: " + answer);
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
                    "Hepatitis B",
                    "Hepatitis C",
                    "HIV or AIDS");
            for (String answer : disqualifyQ24) {
                System.out.println("Select answer for Q24QS59: " + answer);
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
                    "Schizophrenia");
            for (String answer : disqualifyQ24pt2) {
                System.out.println("Select answer for Q24QS59: " + answer);
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
                    .setAll("5", "5", "250")
                    .clickNextButton(new LetMeSeePageCC());
            letMeSeePageCC
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                    .back(approximateHeightPageCC)
                    .waitForPageLoad()
                    .setLbs("150")
                    .clickNextButton(new LetMeSeePageCC());
            IdentificationPageCC identificationPageCC = new IdentificationPageCC();

//        if(site == AUT_AMS_JANRSV_Syn) {
//            DoyouExperienceHotFlashesCC doyouExperienceHotFlashesCC = letMeSeePageCC
//                    .waitForPageLoad()
//                    .clickNextButton(new DoyouExperienceHotFlashesCC());
//
//            doyouExperienceHotFlashesCC
//                    .waitForPageLoad()
//                    .clickOnAnswer("No")
//                    .clickNextButton(new NonQRtransitionPageCC())
//                    .waitForPageLoad()
//                    .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_CC())
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickNextButton(identificationPageCC);
//        }

//        if(site == AUT_AMS_JANRSV) {
            letMeSeePageCC
                    .waitForPageLoad()
                    .clickNextButton(/*doAnyOftheFollowingAdditionalDiagnosesCC*/identificationPageCC);
/*        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC())
                .waitForPageLoad()
                .clickNextButton(new DoyouExperienceHotFlashesCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(identificationPageCC);*/

//        }
//        DoYouExperienceAnyOfFollowingSymptoms_CC doYouExperienceAnyOfFollowingSymptoms_CC =
//                new DoYouExperienceAnyOfFollowingSymptoms_CC();
//            DoyouExperienceHotFlashesCC doyouExperienceHotFlashesCC = doYouExperienceAnyOfFollowingSymptoms_CC
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickNextButton(new DoyouExperienceHotFlashesCC());

//            doyouExperienceHotFlashesCC
//                    .waitForPageLoad()
//                    .clickOnAnswer("No")
//                    .clickNextButton(identificationPageCC);
//
//    CallCenterIntroductionPageCC
            SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                    .waitForPageLoad()
                    .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                            "9999999999", site.zipCode)
                    .clickNextButton(new SiteSelectionPageCC());

            siteSelectionPageCC
                    .waitForPageLoad(studyName)
                    .getPID();

            switch (site) {
                case AUT_AMS_JANRSV:
                    siteSelectionPageCC
                            .clickOnAnswer(site.name);
                    QualifiedClose1PageCC qualifiedClose1PageCC = siteSelectionPageCC
                            .clickNextButton(new QualifiedClose1PageCC());
                    ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = qualifiedClose1PageCC
                            .waitForPageLoad()
                            //.clickOnAnswer("No")
                            .clickNextButton(new ThankYouCloseSimplePageCC());

//                    ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = synexusHealthyMindsPageCC
//                            .waitForPageLoad()
//                            .clickOnAnswer("No")
//                            .clickNextButton(new ThankYouCloseSimplePageCC());

                    AlzheimerClosePageCC alzheimerClosePageCC = thankYouCloseSimplePageCC
                            .waitForPageLoad3()
                            .clickNextButton(new AlzheimerClosePageCC());

                    alzheimerClosePageCC
                            .waitForPageLoad()
                            .clickNextButton(selectActionPageCC);

                    selectActionPageCC
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env)
                            .dispoShouldMatch(site.dispo, site.dispo);
                    break;
                case AUT_AMS_JANRSV_Syn:
                    siteSelectionPageCC
                            .clickOnAnswer(site.name);
                    SynexusRadiantDirectScheduleCC synexusRadiantDirectScheduleCC = siteSelectionPageCC
                            .clickNextButton(new SynexusRadiantDirectScheduleCC());

                    synexusRadiantDirectScheduleCC
                            .waitForPageLoadSyn()
                            .assertVariablesNew("Acurian", "Trial", "01/01/1954", "US",
                                    "Blue Bell, PA", site.zipCode, "qa.acurian@gmail.com", "999-999-9999",
                                    " autJANRSVS ", " " + site.name, "JANIQVRSV001 - Janssen RSV Vaccine")
                            .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                            .clickNextButton(selectActionPageCC)
                            .waitForPageLoad()
                            .pidFromDbToLog(env)
                            .childPidFromDbToLog(env)
                            .dispoShouldMatch(site.dispo, site.dispo);
                    break;
            }
        }
    }
}
