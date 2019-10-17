package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Gout.*;
import com.acurian.selenium.pages.OLS.IBD_Crohns_UC.HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class CG_4960_OLS extends BaseTest {
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
                {Site.AUT_AMS1_4960_site},
                {Site.AUT_AMS1_4960S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("4960 LG-GDCL002 LG Chem Gout OLS")
    public void cg4960OLSTest(Site site) {
        EverDiagnosedWithGoutOLS everDiagnosedWithGoutOLS = new EverDiagnosedWithGoutOLS();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();

        final String phoneNumber = "800AMS1MTA";
        final String studyName = "Gout";

        String env = System.getProperty("acurian.env", "STG");
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadCG();
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
        //        dateOfBirthPageOLS.getExpectedModifiedTitle(studyName, "1000"), "Title is diff");


        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        PersonalDetails personalDetails = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoadCG()
                .clickOnAnswer("Yes")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());


        genderPageOLS
                .waitForPageLoad()
                .setDate("01012002") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        genderPageOLS
                .waitForPageLoad()
                .setDate("01011943") //Disqualify ("Age") if > 76
                .clickNextButton(new HaveYouEverBeenOfficiallyDiagnosedByDoctor_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        genderPageOLS
                .waitForPageLoad()
                .setDate("01011960")
                .clickNextButton(everDiagnosedWithGoutOLS);

        //Q2
        HowManyGoutAttacksOLS howManyGoutAttacksOLS = everDiagnosedWithGoutOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7902", site.activeProtocols)
                .back(everDiagnosedWithGoutOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyGoutAttacksOLS());

        //Q3
        EverTakenMedicationOLS everTakenMedicationOLS = new EverTakenMedicationOLS();
        howManyGoutAttacksOLS
                .waitForPageLoad()
                .clickOnAnswer("No gout attacks in the past year")
                .clickNextButton(everTakenMedicationOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7903", site.activeProtocols)
                .back(howManyGoutAttacksOLS)
                .waitForPageLoad()
                .clickOnAnswer("1")
                .clickNextButton(everTakenMedicationOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7903", site.activeProtocols)
                .back(howManyGoutAttacksOLS)
                .waitForPageLoad()
                .clickOnAnswer("2 or more")
                .clickNextButton(everTakenMedicationOLS);

        //Q4
        EverTakenFollowingMedicationsCurrentlyOrPastOLS everTakenFollowingMedicationsCurrentlyOrPastOLS = everTakenMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7904", site.activeProtocols)
                .back(everTakenMedicationOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EverTakenFollowingMedicationsCurrentlyOrPastOLS());

        PastThreeMonthsTakenKrystexxaOLS pastThreeMonthsTakenKrystexxaOLS = new PastThreeMonthsTakenKrystexxaOLS();
        //Q5,6,7
        CurrentlyTakingUloricOLS currentlyTakingUloriOLSC = new CurrentlyTakingUloricOLS();
        everTakenFollowingMedicationsCurrentlyOrPastOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Uloric, also called febuxostat")
                .clickNextButton(currentlyTakingUloriOLSC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(pastThreeMonthsTakenKrystexxaOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(currentlyTakingUloriOLSC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Uloric, also called febuxostat")
                .clickNextButton(currentlyTakingUloriOLSC)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(pastThreeMonthsTakenKrystexxaOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(currentlyTakingUloriOLSC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(pastThreeMonthsTakenKrystexxaOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(everTakenFollowingMedicationsCurrentlyOrPastOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Allopurinol, also called Aloprim or Zyloprim")
                .clickNextButton(pastThreeMonthsTakenKrystexxaOLS);

        //Q8
        pastThreeMonthsTakenKrystexxaOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7908", site.activeProtocols)
                .back(pastThreeMonthsTakenKrystexxaOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //#############General_Health ###########################
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
                                "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                                "Skin problems (eczema or atopic dermatitis, psoriasis)",
                                "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                                "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                                "Women's health issues (endometriosis, uterine fibroids)")
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                        .clickNextButton(new BoneOrJointConditionsPageOLS());


        boneOrJointConditionsPageOLS
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        ApproximateHeightPageOLS approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());


        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(personalDetails);

        SiteSelectionPageOLS siteSelectionPageCC = personalDetails
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClose1PageOLS qualifiedClose1PageOLS = siteSelectionPageCC
                .waitForPageLoad("a gout")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS());

        SynexusHealthyMindsPageOLS synexusHealthyMindsPageOLS = qualifiedClose1PageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SynexusHealthyMindsPageOLS());

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = synexusHealthyMindsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS());


        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());


        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo)
                .assertGeneratedFul(env, site);

        if (site == Site.AUT_AMS1_4960_site) {
            aboutHealthPageOLS
                    .getRadiantDbToLog(env)
                    .getAnomalyDbToLog(env);
        }
    }
    
}
