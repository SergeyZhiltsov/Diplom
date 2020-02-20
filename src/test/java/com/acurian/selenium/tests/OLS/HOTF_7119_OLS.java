package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.HOTF_7119.AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS;
import com.acurian.selenium.pages.OLS.HOTF_7119.DoyouExperienceHotFlashesOLS;
import com.acurian.selenium.pages.OLS.HOTF_7119.HowWouldYouDescribeYourHotFlashesOLS;
import com.acurian.selenium.pages.OLS.HOTF_7119.OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouGoneThroughMenopauseOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class HOTF_7119_OLS extends BaseTest {

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
                {Site.AUT_AMS1_7119_site}
        };
    }


    @Test(enabled = true, dataProvider = "sites")
    @Description("HOTF_7119_OLS")
    public void HOTF_7119_OLS(final Site site) {
        String phoneNumber = "AUTAMS1HOT";
        String studyName = "a study for menopausal women with hot flashes";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad(studyName, "750");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                        .getExpectedModifiedTitle(studyName, "750"),
//                "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());


        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09092002")
                .clickOnAnswer("Female")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                        .waitForPageLoad()
                        .setDate("09091953")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        DoyouExperienceHotFlashesOLS doyouExperienceHotFlashesOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09091954")
                .clickNextButton(new DoyouExperienceHotFlashesOLS());

        //---------Q2 - Do you experience hot flashes?-----------------------------------------
        doyouExperienceHotFlashesOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7602", site.activeProtocols)
                .back();
        OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS onAvgHowManyHotFlashesDoYouExperiencePerDayOLS =
                doyouExperienceHotFlashesOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS());


        //---------Q3 - On average, how many hot flashes do you experience per day?--------------
        HowWouldYouDescribeYourHotFlashesOLS howWouldYouDescribeYourHotFlashesOLS = new HowWouldYouDescribeYourHotFlashesOLS();
        List<String> disqualifyQ3 = Arrays.asList("0 (I do not have hot flashes every day)", "1 - 2", "3 - 4", "5 - 6");
        for (String answer : disqualifyQ3) {
            System.out.println("Select answer for Q3: " + answer);
            onAvgHowManyHotFlashesDoYouExperiencePerDayOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howWouldYouDescribeYourHotFlashesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7603", site.activeProtocols[0],
                            site.activeProtocols[1])
                    .back();
        }
        onAvgHowManyHotFlashesDoYouExperiencePerDayOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 8")
                .clickNextButton(howWouldYouDescribeYourHotFlashesOLS);


        //------------Q4:  How would you describe your hot flashes? ---------------------------------------------
        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = howWouldYouDescribeYourHotFlashesOLS
                .waitForPageLoad()
                .clickOnAnswer("Mild - minimal or no effect on daily life or usual activities")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7604", site.activeProtocols[0],
                        site.activeProtocols[1])
                .back();
        howWouldYouDescribeYourHotFlashesOLS
                .waitForPageLoad()
                .clickOnAnswer("Moderate - noticeable effect on daily life, or some interference with usual activities")
                .clickOnAnswer("Severe - serious effect on daily life, or constant interference with usual activities")
                .clickNextButton(haveYouGoneThroughMenopauseOLS);


        //------------Q5:  HaveYouGoneThroughMenopauseOLS ---------------------------------------------
        AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS =
                haveYouGoneThroughMenopauseOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS());
        areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7605", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process")
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed")
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS);


        //------------Q6:  AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS ---------------------------------------------
        areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7606", site.activeProtocols)
                .back();
        areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


//#############General_Health ###########################
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
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());


        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesCC =
                new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        List<String> disqualifyQ6QS42 = Arrays.asList("Within the past 5 years", "6 - 10 years ago",
                "11 or more years ago");
        for (String answer : disqualifyQ6QS42) {
            System.out.println("Select answer for QS42: " + answer);
            whenDiagnosedWithCancerOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                    .back();
        }
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .back();
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = 
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        List<String> disqualifyQ16 = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQ16) {
            System.out.println("Select answer for Q16: " + answer);
            whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back();
        }
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
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
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS)
                .waitForPageLoad()
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
            System.out.println(answer);
            followingMentalEmotionalHealthPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
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
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
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
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQ24pt2 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer : disqualifyQ24pt2) {
            System.out.println("Select answer for Q24QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "144")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());
        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .waitForPageLoad1(studyName + "!") //todo
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS());
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                .waitForPageLoad()
//                .clickNextButton(new SynexusHealthyMindsPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS());
        AboutHealthPageOLS aboutHealthPageOLS =  thankYouCloseSimplePageOLS
                .waitForPageLoad2()
                .clickNextButton(new AlzheimerClosePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .dispoShouldMatch(site.dispo)
                .assertGeneratedFul(env, site)
                .childPidFromDbToLog(env, "7119");
    }
}