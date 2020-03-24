package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.oab_4867.DoYouTakeAnyMedicationsControlHypertension_OLS;
import com.acurian.selenium.pages.blinx.ams.MostRecentHeartProcedurePageOLS;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.derm.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.blinx.gmega.AboutHealthPageOLS;
import com.acurian.selenium.pages.blinx.gmega.ApproximateHeightWeightPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class DERM_7157_OLSBlinx extends BaseTest {


    @DataProvider(name = "sites")
    public Object[][] getData() {
        return new Object[][]{
                {Site.AUT_AMS1_7157_site},
                {Site.AUT_AMS1_7157S_site}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("DERM 7157 Glenmark Atopic Derm")
    public void DERM_7157_Blinx(Site site) {
        final String phoneNumber = "AUTAMS1KAD";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String studyName = "an eczema (atopic dermatitis) study";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad0("an eczema (atopic dermatitis) study", "600");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                        .getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "600"),
                "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS);

        IdentificationPageOLS identificationPageOLS = dateOfBirthPageOLS
                .waitForPageLoad0("an eczema (atopic dermatitis) study", "600")
                .clickOnAnswer("Yes")
                .getPage(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols =
                genderPageOLS
                        .waitForPageLoad()
                        .setDate("04042001")
                        .clickOnAnswer("Female")
                        .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());

        HealthcareDiagnosedPsoriasisPageOLS healthcareDiagnosedPsoriasisPageOLS =
                hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HealthcareDiagnosedPsoriasisPageOLS());

        healthcareDiagnosedPsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5802", site.activeProtocols)
                .back(hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols);

        HowLongHaveYouBeenSufferingFromEczema_OLS howLongHaveYouBeenSufferingFromEczema_OLS =
                hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_OLS());

        HowMuchEczemaYouHaveOnYourBody_OLS howMuchEczemaYouHaveOnYourBody_OLS = new HowMuchEczemaYouHaveOnYourBody_OLS();
//        List<String> disqualifyQ3 = Arrays.asList("2 months or less",
//                "3 - 6 months",
//                "7 - 11 months");
//        for (String answer : disqualifyQ3) {
//            System.out.println(answer);
//            howLongHaveYouBeenSufferingFromEczema_OLS
//                    .waitForPageLoad()
//                    .clickOnAnswer(answer)
//                    .clickNextButton(howMuchEczemaYouHaveOnYourBody_OLS)
//                    .waitForPageLoad()
//                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS5831", site.activeProtocols)
//                    .back(howLongHaveYouBeenSufferingFromEczema_OLS);
//        }
        howLongHaveYouBeenSufferingFromEczema_OLS
                .waitForPageLoad()
                .clickOnAnswer("3 years or more")
                .clickNextButton(howMuchEczemaYouHaveOnYourBody_OLS);

        HowWouldYouDescribeTheEczemaCurrentlyPageOLS howWouldYouDescribeTheEczemaCurrentlyPageOLS =
                new HowWouldYouDescribeTheEczemaCurrentlyPageOLS();
        List<String> disqualifyQ4 = Arrays.asList("0", "1", "2", "3", "4", "5");
        for (String answer : disqualifyQ4) {
            System.out.println("Select answer for Q4: " + answer);
            howMuchEczemaYouHaveOnYourBody_OLS
                    .waitForPageLoad()
                    .selectFromDropDown(answer)
                    .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5832", site.activeProtocols)
                    .back(howMuchEczemaYouHaveOnYourBody_OLS);
        }
//-----------STATUS SET validation:  PATIENT_PRIORITY_YES = 8 14 -------------
        List<String> studyLevelStatus = Arrays.asList("13", "14", "15", "16", "17", "18", "19", "20");
        for (String answer : studyLevelStatus) {
            System.out.println("Select answer to get study level status logic for Q4: " + answer);
            howMuchEczemaYouHaveOnYourBody_OLS
                    .waitForPageLoad()
                    .selectFromDropDown(answer)
                    .clickNextButton(howWouldYouDescribeTheEczemaCurrentlyPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
//                    .checkProtocolsContainsForQNumber("QS5845", site.activeProtocols)
//                    .checkStudyStatusContainsForQNumber(env.equals("PRD") ? "12-18" : "8-14")
                    .back(howMuchEczemaYouHaveOnYourBody_OLS);
        }
        howMuchEczemaYouHaveOnYourBody_OLS
                .waitForPageLoad()
                .selectFromDropDown("21+")
                .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS());

        HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS =
                howWouldYouDescribeTheEczemaCurrentlyPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Minor: Mostly clear or almost clear")
                        .clickNextButton(new HaveYouTriedAnyFollowingTreatmentsForEczemaPageOLS());

        SatisfiedEczemaTreatmentsOLS satisfiedEczemaTreatmentsOLS = haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Creams, ointments, or sprays applied directly to the skin (topical treatments)",
                        "Medications taken by mouth (oral medications)",
                        "Shots or IV infusions (injectable medications)",
                        "Self-treatment with tanning beds or sunbathing",
                        "Phototherapy (Ultraviolet or UV light treatment)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Self-treatment with tanning beds or sunbathing",
                        "Phototherapy (Ultraviolet or UV light treatment)")
                .clickNextButton(new SatisfiedEczemaTreatmentsOLS());


        satisfiedEczemaTreatmentsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5845", site.activeProtocols)
                .back(haveYouTriedAnyFollowingTreatmentsForEczemaPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Shots or IV infusions (injectable medications)")
                .clickNextButton(satisfiedEczemaTreatmentsOLS);


        AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS =
                satisfiedEczemaTreatmentsOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickOnAnswer("No")
                        .clickOnAnswer("I am not using any treatments right now")
                        .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS());


        //-------------------------------------QS31 "bilolgics" with radiobuttons -------------------------------------
        DupixentInjectionPageOLS dupixentInjectionPageOLS = areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DupixentInjectionPageOLS());
        dupixentInjectionPageOLS
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS5850", site.activeProtocols)
                .back(areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS);


        areYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(dupixentInjectionPageOLS);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                dupixentInjectionPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes, currently taking")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5847", site.activeProtocols)
                .back(dupixentInjectionPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("No, never took")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
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
                .clickNextButton(new WhatKindOfArthritisPageOLS());
        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        //Q2: QS38

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("ADHD or attention deficit hyperactivity disorder") //skip to Q24
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickNextButton(whatKindOfArthritisPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system " +
                        "attacking your joints")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisPageOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                        .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());

        whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS); //Back to Q2: QS38

        WhichOfTheFollowingBreathingLungPageOLS whichOfTheFollowingBreathingLungPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                        .clickNextButton(new WhichOfTheFollowingBreathingLungPageOLS());
        //Q5: QS41
        whichOfTheFollowingBreathingLungPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new OtherThanSkinCancerPageOLS());
//        Q6: QS42
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(otherThanSkinCancerPageOLS);
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes (type 1 or type 2)")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());
//        Q6: QS42
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Headaches (migraine, cluster, tension)")
                .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());
//        Q10: QS45
        whichTypeOfHeadacheDoYouGetOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        //Q11: QS46
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS =
                haveYouEverExperiencedHeartRelatedMedicalCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                                "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                                "Heart failure or congestive heart failure (CHF)")
                        .clickNextButton(new SubquestionExperiencedHeartPageOLS()); //Display Q12.1: QS47A
        //Q12
        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(3, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(4, "7 - 12 months ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        //Q13: QS48
        MostRecentHeartProcedurePageOLS mostRecentHeartProcedurePageOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs",
                        "Heart bypass surgery or Coronary Artery Bypass Graft (CABG)",
                        "Any other surgery on the arteries in your legs, neck or heart")
                .clickNextButton(new MostRecentHeartProcedurePageOLS());
        //Q14: QS49
        mostRecentHeartProcedurePageOLS
                .waitForPageLoad()
                .back(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                .back(subquestionExperiencedHeartPageOLS)
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        DoYouTakeAnyMedicationsControlHypertension_OLS doYouTakeAnyMedicationsControlHypertension_OLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("High blood pressure or hypertension")
                        .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_OLS());
        //Q15: QS50
        doYouTakeAnyMedicationsControlHypertension_OLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, " +
                                "Crohn's disease, ulcerative colitis)")
                        .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());

        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Kidney disease")
                        .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        List<String> disqualifyQ16 = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQ16) {
            System.out.println(answer);
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
        //Q17: QS52
        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS);
        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder," +
                                " depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        //Q18: QS53
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQ18) {
            System.out.println(answer);
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
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
        //Q19: QS54
        whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                .waitForPageLoad()
                .clickOnAnswers("Alzheimer's disease",
                        "Memory loss",
                        "Parkinson's disease",
                        "Multiple sclerosis (MS)",
                        "Seizure disorder, such as epilepsy",
                        "Fibromyalgia")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)")
                        .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());
        //Q20: QS55
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .clickOnAnswers("Psoriasis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS55", site.activeProtocols)
                .back(whichOfTheFollowingSkinConditionsDoYouSufferOLS);
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WomenHealthConditions womenHealthConditions =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                        .clickNextButton(new WomenHealthConditions());

        womenHealthConditions
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        //Q24: QS59
        ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder",
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
                .clickNextButton(new ApproximateHeightWeightPageOLS());
        //Q28: QS60
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        //Q24: QS59
        List<String> disqualifyQ24 = Arrays.asList("Bipolar disorder",
                "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS");
        for (String answer : disqualifyQ24) {
            System.out.println(answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightWeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        }
        //Q24: QS59
        List<String> disqualifyQ24second = Arrays.asList("Kidney disease requiring dialysis",
                "Schizophrenia");
        for (String answer : disqualifyQ24second) {
            System.out.println(answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightWeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        }

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightWeightPageOLS);
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("3", "2", "33")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                //----------PII (IdentificationPageOLS) Page--------------------
                .clickNextButton(identificationPageOLS);

        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad2()
//                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
//                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                .waitForPageLoad5("an eczema (atopic dermatitis) study!")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS());

        DoctorInformationCollectionPageOLS doctorInformationCollectionPageOLS = medicalRecordsOptionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS());

        HS1PageOLS hs1PageOLS = doctorInformationCollectionPageOLS
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS());

        hs1PageOLS
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();

        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
