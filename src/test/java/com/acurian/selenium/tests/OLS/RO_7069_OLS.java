package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.OLS.Osteoporosis.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.cv_study.SubquestionHeartPageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouGoneThroughMenopauseOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class RO_7069_OLS extends BaseTest {

    @Test
    @Description("7069 BA058-05-021 Radius Osteoporosis OLS")
    public void ro7069OLSTest() {
        final Site site = Site.AUT_AMS1_7069_site;
        final String phoneNumber = "AUTAMS1OST";
        final String studyName = "an osteoporosis study";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad(studyName, "500");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
                dateOfBirthPageOLS.getExpectedModifiedTitle(studyName, "500"), "Title is diff");


        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        ZipCodePageOLS zipCodePageOLS = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad(studyName, "500")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());


        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());


        genderPageOLS
                .waitForPageLoad()
                .setDate("01012003") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                        .waitForPageLoad()
                        .setDate("01011971") //Disqualify ("Age") if < 50
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("01011932")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        EverDiagnosedWithOsteoporosisOLS everDiagnosedWithOsteoporosisOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("01011960")
                .clickNextButton(new EverDiagnosedWithOsteoporosisOLS());

        //Q2
        OsteoporosisRelatedFracturesOLS osteoporosisRelatedFracturesOLS = everDiagnosedWithOsteoporosisOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new OsteoporosisRelatedFracturesOLS());
        osteoporosisRelatedFracturesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7703", site.activeProtocols)
                .back();
        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = osteoporosisRelatedFracturesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hip fracture",
                        "Spine (vertebral) fracture",
                        "Wrist fracture",
                        "Pelvic fracture",
                        "Other fracture")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());

        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7704", site.activeProtocols)
                .back(haveYouGoneThroughMenopauseOLS)
                .waitForPageLoad()
                .back(osteoporosisRelatedFracturesOLS)
                .waitForPageLoad()
                .back(everDiagnosedWithOsteoporosisOLS);

        everDiagnosedWithOsteoporosisOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(osteoporosisRelatedFracturesOLS);

        //Q3
        osteoporosisRelatedFracturesOLS
                .waitForPageLoad()
//                .clickOnAnswers("Hip fracture",
//                        "Spine (vertebral) fracture",
//                        "Wrist fracture",
//                        "Pelvic fracture",
//                        "Other fracture")
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouGoneThroughMenopauseOLS);

        //Q4
        HowLongAgoReachMenopauseOLS howLongAgoReachMenopauseOLS = haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new HowLongAgoReachMenopauseOLS());
//        howLongAgoReachMenopauseOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS7704", site.activeProtocols)
//                .back(haveYouGoneThroughMenopauseOLS)
//                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(new HowLongAgoReachMenopauseOLS());

        //Q5
        CurrentlyTakingMedicationsOsteoporosisOLS currentlyTakingMedicationsOsteoporosisOLS =
                new CurrentlyTakingMedicationsOsteoporosisOLS();
        List<String> disqualifyQ5 = Arrays.asList("Within the past year", "1 - 4 years ago");
        for (String answer : disqualifyQ5) {
            System.out.println("Select answer for Q5: " + answer);
            howLongAgoReachMenopauseOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(currentlyTakingMedicationsOsteoporosisOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7705", site.activeProtocols)
                    .back();
        }
        howLongAgoReachMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("5 years ago or more")
                .clickNextButton(currentlyTakingMedicationsOsteoporosisOLS);

        //Q6
        InjectionsForteoOrTymlosOsteoporosisOLS injectionsForteoOrTymlosOsteoporosisOLS =
                new InjectionsForteoOrTymlosOsteoporosisOLS();
        List<String> disqualifyQ6 = Arrays.asList("Actonel or Atelvia (risedronate)", "Binosto or Fosamax (alendronate)",
                "Boniva (ibandronate)", "Reclast or Zometa (zoledronic acid)", "Evista (raloxifene)",
                "Soltamox (tamoxifen)", "Rayaldee (calcifediol)", "Rocaltrol (calcitriol)",
                "Prolia or Xgeva (denosumab)", "Miacalcin (calcitonin)");
        for (String answer : disqualifyQ6) {
            System.out.println("Select answer for Q6: " + answer);
            currentlyTakingMedicationsOsteoporosisOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(injectionsForteoOrTymlosOsteoporosisOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7706", site.activeProtocols)
                    .back();
        }
        currentlyTakingMedicationsOsteoporosisOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(injectionsForteoOrTymlosOsteoporosisOLS);

        //Q7
        IntravenousMedicationOsteoporosisOLS intravenousMedicationOsteoporosisOLS = injectionsForteoOrTymlosOsteoporosisOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IntravenousMedicationOsteoporosisOLS());
        intravenousMedicationOsteoporosisOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7707", site.activeProtocols)
                .back(injectionsForteoOrTymlosOsteoporosisOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickNextButton(intravenousMedicationOsteoporosisOLS);

        //Q8
        intravenousMedicationOsteoporosisOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7708", site.activeProtocols)
                .back(intravenousMedicationOsteoporosisOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //-------------------New GENERAL HEALTH---------------------------
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                        "Women's health issues (endometriosis, uterine fibroids)",
                        "None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());


        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        List<String> disqualifyQ6QS42 = Arrays.asList("Within the past 5 years", "6 - 10 years ago",
                "11 or more years ago");
        for (String answer : disqualifyQ6QS42) {
            System.out.println("Select answer for Q6:QS42: " + answer);
            whenDiagnosedWithCancerOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                    .back();
        }
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .back();
        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)")
                        .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());


        List<String> disqualifyQ8QS44 = Arrays.asList("Crohn's disease", "Ulcerative colitis");
        for (String answer : disqualifyQ8QS44) {
            System.out.println("Select answer for Q8:QS44: " + answer);
            whichOfFollowingDigestiveConditionPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back();
        }
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back();
        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());


        SubquestionHeartPageOLS subquestionHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionHeartPageOLS());


        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS =
                new HeartrelatedMedicalProceduresPageOLS();
        List<String> disqualifyQ12GH = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.1GH: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageOLS);


        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.2GH: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionHeartPageOLS);


        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.3GH: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected3)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected3)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageOLS);

        for (String answer : disqualifyQ12GH) {
            System.out.println("Select answer for Q12.4GH: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .back();
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());


        List<String> disqualifyQ6QS51 = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQ6QS51) {
            System.out.println("Select answer for Q6:QS51: " + answer);
            kidneyProblemsPage
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back();
        }
        kidneyProblemsPage
                .waitForPageLoad()
                .back();
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
                .back();
        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());


        //Q18: QS53
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQ18) {
            System.out.println("Select answer for Q18:QS53: " + answer);
            followingMentalEmotionalHealthPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back();
        }
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);


        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQ24_QS59 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis", "Drug or alcohol abuse within the past year", "Hepatitis B",
                "Hepatitis C", "HIV or AIDS");
        for (String answer : disqualifyQ24_QS59) {
            System.out.println("Select answer for Q24_QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQ24_QS59p2 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer : disqualifyQ24_QS59p2) {
            System.out.println("Select answer for Q24_QS59p2: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
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


        DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_OLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "107") //Disqualify ("Low BMI") if < 18
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS());
        doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setLbs("220") //Disqualify ("High BMI") if > 33.5
                .clickNextButton(new CardiovascularDiseaseThanOthersPageOLS());
        IdentificationPageOLS identificationPageOLS = cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .setLbs("150")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS912", site.activeProtocols)
                .back(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS913", site.activeProtocols)
                .back(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());


        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());


        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .waitForPageLoad2(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS());


        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS());

//        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = synexusHealthyMindsPageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("No, I am not interested in receiving information")
//                .clickNextButton(new ThankYouCloseSimplePageOLS());


        AlzheimerClosePageOLS alzheimerClosePageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AlzheimerClosePageOLS());

        AboutHealthPageOLS aboutHealthPageOLS = alzheimerClosePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());


        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo)
                .assertGeneratedFul(env, site);
    }
}