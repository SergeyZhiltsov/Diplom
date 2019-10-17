package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Gout.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class CG_4960_CC extends BaseTest {
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
    @Description("4960 LG-GDCL002 LG Chem Gout CC")
    public void cg4960CCTest(Site site) {
        EverDiagnosedWithGoutCC everDiagnosedWithGoutCC = new EverDiagnosedWithGoutCC();
        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        NonQRtransitionPageCC nonQRtransitionPageCC = new NonQRtransitionPageCC();
        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = new DoAnyOftheFollowingAdditionalDiagnosesCC();

        final String phoneNumber = "AUTAMSGOUT";
        final String studyName = "a gout study";
        final String transitionStudyName = "gout";
        final String env = System.getProperty("acurian.env", "STG");


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


        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
                .getExpectedModifiedTitle(studyName, "450"), "Title is diff");
        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        ZipCodePageCC zipCodePageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("2")
                .setYear("2002")
                .clickOnAnswer("Female")
                .clickNextButton(new LessThan18YearsOldPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        genderPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("2")
                .setYear("1943")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        genderPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("2")
                .setYear("1960")
                .clickNextButton(everDiagnosedWithGoutCC);


        //Q2
        HowManyGoutAttacksCC howManyGoutAttacksCC = everDiagnosedWithGoutCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7902", site.activeProtocols)
                .back(everDiagnosedWithGoutCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyGoutAttacksCC());

        //Q3
        EverTakenMedicationCC everTakenMedicationCC = new EverTakenMedicationCC();
        howManyGoutAttacksCC
                .waitForPageLoad()
                .clickOnAnswer("No gout attacks in the past year")
                .clickNextButton(everTakenMedicationCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7903", site.activeProtocols)
                .back(howManyGoutAttacksCC)
                .waitForPageLoad()
                .clickOnAnswer("1")
                .clickNextButton(everTakenMedicationCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7903", site.activeProtocols)
                .back(howManyGoutAttacksCC)
                .waitForPageLoad()
                .clickOnAnswer("2 or more")
                .clickNextButton(everTakenMedicationCC);

        //Q4
        EverTakenFollowingMedicationsCurrentlyOrPastCC everTakenFollowingMedicationsCurrentlyOrPastCC = everTakenMedicationCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoadWithCurves("gout")
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7904", site.activeProtocols)
                .back(everTakenMedicationCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EverTakenFollowingMedicationsCurrentlyOrPastCC());

        PastThreeMonthsTakenKrystexxaCC pastThreeMonthsTakenKrystexxaCC = new PastThreeMonthsTakenKrystexxaCC();
        //Q5,6,7
        CurrentlyTakingUloricCC currentlyTakingUloriCCC = new CurrentlyTakingUloricCC();
        everTakenFollowingMedicationsCurrentlyOrPastCC
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Uloric, also called febuxostat")
                .clickNextButton(currentlyTakingUloriCCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(pastThreeMonthsTakenKrystexxaCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(currentlyTakingUloriCCC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastCC)
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Uloric, also called febuxostat")
                .clickNextButton(currentlyTakingUloriCCC)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(pastThreeMonthsTakenKrystexxaCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(currentlyTakingUloriCCC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastCC)
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickNextButton(pastThreeMonthsTakenKrystexxaCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(everTakenFollowingMedicationsCurrentlyOrPastCC)
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Allopurinol, also called Aloprim or Zyloprim")
                .clickNextButton(pastThreeMonthsTakenKrystexxaCC);

        //Q8
        pastThreeMonthsTakenKrystexxaCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new NonQRtransitionPageCC())
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7908", site.activeProtocols)
                .back(pastThreeMonthsTakenKrystexxaCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadWithCurves(transitionStudyName)
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);
        //#############General_Health ###########################
        BoneOrJointConditionsPageCC boneOrJointConditionsPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
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
                .clickNextButton(new BoneOrJointConditionsPageCC());

        boneOrJointConditionsPageCC
                .waitForPageLoad2()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());


        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(new LetMeSeePageCC());

        IdentificationPageCC identificationPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC());


        SiteSelectionPageCC siteSelectionPageCC = identificationPageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());

        siteSelectionPageCC
                .waitForPageLoad(studyName)
                .clickOnAnswer(site.name)
                .getPID()
                .clickNextButton(new QualifiedClose1PageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SynexusHealthyMindsPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
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
