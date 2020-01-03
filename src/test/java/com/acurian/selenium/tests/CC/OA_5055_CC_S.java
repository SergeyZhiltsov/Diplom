package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.OA_3138.AreYouCurrentlyTakingCC;
import com.acurian.selenium.pages.CC.OA_3138.HowManyTotalDaysCC;
import com.acurian.selenium.pages.CC.closes.CurrentlyParticipatingInStudy;
import com.acurian.selenium.pages.CC.closes.RequirePassDrugTest;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.generalHealth.WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class OA_5055_CC_S extends BaseTest {

    @Test
    @Description("OA_5055_CC_S")
    public void oa_5055_cc_s() {
        Site site = Site.AUT_OA_5055_S;
        final String phoneNumber = "AUTAMS1OA1";
        final String studyName = "an osteoarthritis study";
        final String transitionStudyName = "osteoarthritis";
        DebugPageCC debugPageCC = new DebugPageCC();

        String env = System.getProperty("acurian.env", "STG");

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Call Back")
                .clickNextButton(new DateOfBirthPageCC());


        dateOfBirthPageCC
                .waitForPageLoad("an osteoarthritis study", "850");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
//                        .getExpectedModifiedTitle("an osteoarthritis study", "850"),
//                "Title is diff");

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());


        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());


        DoYouSufferFromArthritisCC doYouSufferFromArthritisCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritisCC());


        WhatKindOfArthritisPageCC whatKindOfArthritisPage = doYouSufferFromArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageCC());


        WhereYouHaveArthritisCC whereYouHaveArthritis = whatKindOfArthritisPage
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereYouHaveArthritisCC());


        TransitionStatementCC transitionStatementCC = whereYouHaveArthritis
                .waitForPageLoad()
                .clickOnAnswers("Spine or shoulders")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoad(transitionStudyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4504", site.activeProtocols)
                .back();
        AnyTypeOfMedicationForYourArthritisCC anyTypeOfMedicationForYourArthritisCC = whereYouHaveArthritis
                .waitForPageLoad()
                .clickOnAnswers("Spine or shoulders")
                .clickOnAnswers("Left Hip")
                .clickOnAnswers("Right Hip")
                .clickNextButton(new AnyTypeOfMedicationForYourArthritisCC());


        NSAIDMedicationsForArthritisPainCC nSAIDMedicationsForArthritisPainCC = anyTypeOfMedicationForYourArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("I do not take any medication for arthritis pain")
                .clickOnAnswer("1 - 2 days per week or less")
                .clickNextButton(new NSAIDMedicationsForArthritisPainCC());
        nSAIDMedicationsForArthritisPainCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4520", site.activeProtocols)
                .back();
        anyTypeOfMedicationForYourArthritisCC
                .waitForPageLoad()
                .clickOnAnswer("3 days per week")
                .clickNextButton(new NSAIDMedicationsForArthritisPainCC());


        AreYouCurrentlyTakingCC areYouCurrentlyTakingCC = nSAIDMedicationsForArthritisPainCC
                .waitForPageLoad()
                .clickOnAnswers("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)")
                .clickNextButton(new AreYouCurrentlyTakingCC());


        HowManyTotalDaysCC howManyTotalDaysCC = areYouCurrentlyTakingCC
                .waitForPageLoad()
                .clickOnAnswers("Yes")
                .clickNextButton(new HowManyTotalDaysCC());


        MedicationsContainingAcetaminophenCC medicationsContainingAcetaminophenCC = howManyTotalDaysCC
                .waitForPageLoad()
                .clickOnAnswers("2 days")
                .clickNextButton(new MedicationsContainingAcetaminophenCC());


        HaveYouEverTakenPrescriptionPainCC haveYouEverTakenPrescriptionPainCC = medicationsContainingAcetaminophenCC
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new HaveYouEverTakenPrescriptionPainCC());


        HasYourDoctorEverPrescribedOpioidNarcotic_CC hasYourDoctorEverPrescribedOpioidNarcotic_CC = haveYouEverTakenPrescriptionPainCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcotic_CC());


        hasYourDoctorEverPrescribedOpioidNarcotic_CC
                .waitForPageLoad()
                .clickOnAnswer("No, my doctor never offered me a prescription for opioids or narcotics for pain")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        transitionStatementCC
                .waitForPageLoad(transitionStudyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4511", site.activeProtocols)
                .back();
        AreYouCurrentlyOnPageCC areYouCurrentlyOnPageCC = hasYourDoctorEverPrescribedOpioidNarcotic_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes, and I have taken an opioid or narcotic for pain")
                .clickNextButton(new AreYouCurrentlyOnPageCC());


        areYouCurrentlyOnPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, for arthritis")
                .clickOnAnswer("Yes, for another chronic condition")
                .clickOnAnswer("I am currently taking a short course of steroids (10 days or less)")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoad(transitionStudyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS4513", site.activeProtocols)
                .back();
        HaveYouEverHadKneeReplacementSurgery_CC haveYouEverHadKneeReplacementSurgery_CC = areYouCurrentlyOnPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgery_CC());


        //-----------HaveYouEverHadKneeReplacementSurgery_CC--------------------
        haveYouEverHadKneeReplacementSurgery_CC
                .waitForPageLoad();
        HaveYouEverReceivedInjectionIntoYourKnee_CC haveYouEverReceivedInjectionIntoYourKnee_CC = haveYouEverHadKneeReplacementSurgery_CC
                .clickOnAnswer("Yes, both knees have been replaced")
                .clickOnAnswer("Yes, one knee has been replaced")
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverReceivedInjectionIntoYourKnee_CC());


        //-----------HaveYouEverReceivedInjectionIntoYourKnee_CC--------------------
        haveYouEverReceivedInjectionIntoYourKnee_CC
                .waitForPageLoad();
        HaveYouReceivedKneeInjection_CC haveYouReceivedKneeInjection_CC = haveYouEverReceivedInjectionIntoYourKnee_CC
                .clickOnAnswers("Yes, a corticosteroid or \"steroid\" injection")
                .clickOnAnswers("Yes, a joint fluid supplement injection such as Synvisc or Hyalgan")
                .clickNextButton(new HaveYouReceivedKneeInjection_CC());


        //-------------------------HaveYouReceivedKneeInjection_CC---------------
        haveYouReceivedKneeInjection_CC
                .waitForPageLoad();
        DevicesInYourBodyCC followingDevicesInYourBody = haveYouReceivedKneeInjection_CC
                .clickOnAnswer("No")
                .clickNextButton(new DevicesInYourBodyCC());


        //---------------------------FollowingDevicesInYourBody--------------------
        followingDevicesInYourBody
                .waitForPageLoad();
        CarpalTunnelSyndromeCC carpalTunnelSyndromeCC = followingDevicesInYourBody
                .clickOnAnswers("None of the above")
                .clickNextButton(new CarpalTunnelSyndromeCC());


        //---------------------DiagnosedwithCarpalTunnelSyndrome--------------
        carpalTunnelSyndromeCC
                .waitForPageLoad();
        AreYouCurrentlyReceivingWorkersPageCC areYouCurrentlyReceivingWorkersPageCC = carpalTunnelSyndromeCC
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPageCC());


        //------------------AreYouCurrentlyReceivingWorkersPage_CC-------------
        areYouCurrentlyReceivingWorkersPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoad(transitionStudyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        //----------*******NEW GENERAL HEALTH Questions**************************----------
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                .clickOnAnswers("Cancer")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC());

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                .waitForPageLoad()
                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS40", site.activeProtocols)
                .back();

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad();
        Assert.assertEquals(subquestionExperiencedHeartPageCC.getTitleText(1), subquestionExperiencedHeartPageCC.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageCC.getTitleText(2), subquestionExperiencedHeartPageCC.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionExperiencedHeartPageCC.getTitleText(3), subquestionExperiencedHeartPageCC.titleExpected4, "Title is diff");
        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = subquestionExperiencedHeartPageCC
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "More than 1 year ago")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());

        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "1 - 3 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "4 - 6 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "Less than 30 days ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "1 - 3 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "4 - 6 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "7 - 12 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC);

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "Less than 30 days ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "1 - 3 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "4 - 6 months ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back();

        subquestionExperiencedHeartPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC whichOfFollowingHaveYouDiagnosedWith_neurologicalCC = whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalCC());

        whichOfFollowingHaveYouDiagnosedWith_neurologicalCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_neurologicalCC);

        whichOfFollowingHaveYouDiagnosedWith_neurologicalCC
                .waitForPageLoad()
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back();

        whichOfFollowingHaveYouDiagnosedWith_neurologicalCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Fibromyalgia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back();

        whichOfFollowingHaveYouDiagnosedWith_neurologicalCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);


        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ26 = Arrays.asList("Drug or alcohol abuse within the past year", "Hepatitis B",
                "Hepatitis C", "HIV or AIDS");
        for (String answer : disqualifyQ26) {
            System.out.println("Select answer for Q26: " + answer);
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
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Neuropathy (nerve damage due to diabetes or another condition)")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        //----------ProvideHeight-Weight Page--------------------
        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "250") // if BMI >= 40 - DQ
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();

        IdentificationPageCC identificationPageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setLbs("150")
                .clickNextButton(letMeSeePageCC)
                .waitForPageLoad()
                .clickNextButton(new CurrentlyParticipatingInStudy())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTest())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageCC());
        //----------PII (IdentificationPageOLS) Page--------------------
        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());
        //----------SITE Selection Page--------------------
        siteSelectionPageCC
                .waitForPageLoad(studyName)
                .getPID();
        siteSelectionPageCC
                .clickOnAnswer(site.name)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .assertVariablesNew("Acurian", "Trial", "09/09/1980", "US",
                        "Dover, DE", site.zipCode, "qa.acurian@gmail.com", "999-999-9999",
                        " aut5055test ", " AUT_OA_5055_Syn", "REGICNOSA602 - Regeneron Osteoarthritis")
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .childPidFromDbToLog(env, "5055")
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
