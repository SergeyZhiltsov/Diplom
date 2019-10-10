package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.HasDoctorEverDiagnosedYouMedicalCond_OLS;
import com.acurian.selenium.pages.OLS.Osteoporosis.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.LessThan18YearsOldPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClosedPageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouGoneThroughMenopauseOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class Osteoporosis_7069_OlS extends BaseTest {
    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test()
    @Description("AUT_AMS1_7069_site_OLS")
    public void Osteoporosis_7069_OLSTest() {
        final Site site = Site.AUT_AMS1_7069_site;
        final String phoneNumber = "AUTAMS1OST";
        DebugPageOLS debugPageOLS = new DebugPageOLS();

        final String studyName = "an osteoporosis study";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
                dateOfBirthPageOLS.getExpectedModifiedTitle(studyName, "others "), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = new LessThan18YearsOldPageOLS();
        lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(lessThan18YearsOldPageOLS);
        ZipCodePageOLS zipCodePageOLS = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());


        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
        EverDiagnosedWithOsteoporosisOLS everDiagnosedWithOsteoporosisOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("05051990")
                .clickOnAnswer("Female")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("05051930")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("05051965")
                .clickOnAnswer("Male")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("05051965")
                .clickOnAnswer("Female")
                .clickNextButton(new EverDiagnosedWithOsteoporosisOLS());

        //Q2
        OsteoporosisRelatedFracturesOLS osteoporosisRelatedFracturesOLS = everDiagnosedWithOsteoporosisOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7702", site.activeProtocols)
                .back(everDiagnosedWithOsteoporosisOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new OsteoporosisRelatedFracturesOLS());

        //Q3
        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = osteoporosisRelatedFracturesOLS
                //.waitForPageLoad()
                .clickOnAnswers("Hip fracture",
                        "Spine (vertebral) fracture",
                        "Wrist fracture",
                        "Pelvic fracture",
                        "Other fracture")
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());

        //Q4
        HowLongAgoReachMenopauseOLS howLongAgoReachMenopauseOLS = haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HowLongAgoReachMenopauseOLS());
        howLongAgoReachMenopauseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7704", site.activeProtocols)
                .back(haveYouGoneThroughMenopauseOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(howLongAgoReachMenopauseOLS);

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
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = intravenousMedicationOsteoporosisOLS
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
        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                .clickNextButton(new BoneOrJointConditionsPageOLS());


        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        boneOrJointConditionsPageOLS
                .waitForPageLoad2()
                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis", "Gout", "Low back pain", "None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        List<String> disqualifyQ24_QS59 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis", "Drug or alcohol abuse within the past year", "Hepatitis B",
                "Hepatitis C", "HIV or AIDS");
        for (String answer : disqualifyQ24_QS59) {
            System.out.println("Select answer for Q24_QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
            approximateHeightPageOLS
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
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
            approximateHeightPageOLS
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        IdentificationPageOLS identificationPageOLS = new IdentificationPageOLS();
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "250")
                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "105")
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .setAll("5", "5", "150")
                .clickNextButton(identificationPageOLS);


        QualifiedClosedPageOLS qualifiedClosedPageOLS = identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad2(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClosedPageOLS());


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