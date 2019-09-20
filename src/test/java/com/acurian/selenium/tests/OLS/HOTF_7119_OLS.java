package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Derm.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.HOTF_7119.AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS;
import com.acurian.selenium.pages.OLS.HOTF_7119.DoyouExperienceHotFlashesOLS;
import com.acurian.selenium.pages.OLS.HOTF_7119.HowWouldYouDescribeYourHotFlashesOLS;
import com.acurian.selenium.pages.OLS.HOTF_7119.OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.CurrentlyTakingFollowingMedicationsOLS;
import com.acurian.selenium.pages.OLS.LPS_4442.EitherOfFollowingMedicationsOLS;
import com.acurian.selenium.pages.OLS.PS_4656.HealthcareDiagnosedPsoriasisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose1PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
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
        String[] protocols = site.activeProtocols;
        List<String> protocols_subset = Arrays.asList("2693_CL_0301","2693_CL_0302");
        String studyName = "a study for menopausal women with hot flashes";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                .getExpectedModifiedTitle("an eczema (atopic dermatitis) study", "750"),
                "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());


        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09091953")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        genderPageOLS
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", protocols)
                .back();
        genderPageOLS
                .waitForPageLoad();
        DoyouExperienceHotFlashesOLS doyouExperienceHotFlashesOLS = genderPageOLS
                .setDate("09091954")
                .clickOnAnswer("Female")
                .clickNextButton(new DoyouExperienceHotFlashesOLS());

        //---------Q2 - Do you experience hot flashes?-----------------------------------------
        doyouExperienceHotFlashesOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7602", protocols)
                .back();
        doyouExperienceHotFlashesOLS
                .waitForPageLoad();
        OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS onAvgHowManyHotFlashesDoYouExperiencePerDayOLS = doyouExperienceHotFlashesOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS());


        //---------Q3 - On average, how many hot flashes do you experience per day?--------------
        List<String> disqualifyQ3 = Arrays.asList("0 (I do not have hot flashes every day)");
        for(String answer: disqualifyQ3) {
            System.out.println(answer);
            onAvgHowManyHotFlashesDoYouExperiencePerDayOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(new HowWouldYouDescribeYourHotFlashesOLS())
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7603", "2693_CL_0301","2693_CL_0302")
                    .back();
        }
        onAvgHowManyHotFlashesDoYouExperiencePerDayOLS
                .waitForPageLoad();
        HowWouldYouDescribeYourHotFlashesOLS howWouldYouDescribeYourHotFlashesOLS = onAvgHowManyHotFlashesDoYouExperiencePerDayOLS
                .clickOnAnswer("7 - 8")
                .clickNextButton(new HowWouldYouDescribeYourHotFlashesOLS());


        //------------Q4:  How would you describe your hot flashes? ---------------------------------------------
        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = howWouldYouDescribeYourHotFlashesOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Mild - minimal or no effect on daily life or usual activities")
                        .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
        haveYouGoneThroughMenopauseOLS
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS7604", "2693_CL_0301","2693_CL_0302")
                        .back();
        howWouldYouDescribeYourHotFlashesOLS
                .waitForPageLoad()
                .clickOnAnswer("Moderate - noticeable effect on daily life, or some interference with usual activities")
                .clickOnAnswer("Severe - serious effect on daily life, or constant interference with usual activities")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());


        //------------Q5:  HaveYouGoneThroughMenopauseOLS ---------------------------------------------
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7605", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad();
        AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS = haveYouGoneThroughMenopauseOLS
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process")
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed")
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(new AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS());


        //------------Q6:  AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS ---------------------------------------------
        areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7606", site.activeProtocols)
                .back();
        areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());




//#############General_Health ###########################
        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocols)
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());


        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "1 - 3 months ago")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS)
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS47", protocols)
                .back();
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocols)
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
                .checkProtocolsContainsForQNumber("QS52", protocols)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(following_mentalEmotionalHealthPageOLS);

        WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS = following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", protocols)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(whichOfTheFollowingSkinConditionsDoYouSufferOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", protocols)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whichOfTheFollowingSkinConditionsDoYouSufferOLS);

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .clickOnAnswers("Psoriasis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                //.getPage(debugPageOLS)
                //.checkProtocolsContainsForQNumber("QS55", protocols)
                .back();
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();
        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back();
        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        AboutHealthPageOLS aboutHealthPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "144")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad1(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        switch (site) {
            case AUT_AMS1_7119_site: //41C
                aboutHealthPageOLS
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo)
                        .assertGeneratedFul(env, site)
                        //.assertChildDOBIsNull(env, "7193")
                        .childPidFromDbToLog(env, "7119");
                break;
        }
    }
}