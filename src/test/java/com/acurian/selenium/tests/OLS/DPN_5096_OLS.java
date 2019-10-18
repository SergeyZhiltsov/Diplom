package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.CurrentlyTreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.LessThan18YearsOldPageOLS;
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

public class DPN_5096_OLS extends BaseTest {

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
                {Site.AUT_DPN_5096_site},
                {Site.AUT_DPN_5096S_site}
        };
    }

    @Test(dataProvider = "sites", enabled = true)

    @Description("Diabetic Peripheral Neuropath (DPN)- 5096 OLS")
    public void dpn_5096_OLS(Site site) {

        String phoneNumber = "AUTAMS1DPN";
        String studyName = "a study for diabetics"; //todo https://jira.acurian.com/browse/SCREEN-11041
        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
                dateOfBirthPageOLS.getExpectedModifiedTitle("a study for diabetics", "300"),
                "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                        .waitForPageLoad()
                        .setDate("09091943")
                        .clickOnAnswer("Female")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();

        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .setDate("09091981")
                .clickOnAnswer("Male")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        //------------Q2 Have you been diagnosed with any type of diabetes?---------------
        diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5502", site.activeProtocols)
                .back(diagnosedAnyTypeOfDiabetesPageOLS);

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        //-----------Q3 -What kind of diabetes do you have?? ---------------
        CardiovascularDiseaseThanOthersPageOLS cardiovascularDiseaseThanOthersPageOLS = new CardiovascularDiseaseThanOthersPageOLS();
        List<String> disqualifyQ3 = Arrays.asList("Type 1 diabetes (sometimes called Juvenile diabetes)",
                "High blood sugar only",
                "Unsure");
        for (String answer : disqualifyQ3) {
            System.out.println("Select answer for Q3: " + answer);
            whatKindOfDiabetesPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5503", site.activeProtocols)
                    .back();
        }

        DoYouExperienceDPN_OLS doYouExperienceDPN_OLS = whatKindOfDiabetesPageOLS.waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new DoYouExperienceDPN_OLS())
                .waitForPageLoad();

        //----------Q4 - Do you experience diabetic peripheral neuropathy or diabetic nerve pain? -  Page ---------------
        doYouExperienceDPN_OLS
                .waitForPageLoad()
                .clickOnAnswer("No, none of the above")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5504", site.activeProtocols)
                .back(doYouExperienceDPN_OLS);

        WhereDoYouExperienceDiabeticNervePain_OLS whereDoYouExperienceDiabeticNervePain_OLS =
                doYouExperienceDPN_OLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes, and I have been diagnosed by a healthcare professional")
                        .clickNextButton(new WhereDoYouExperienceDiabeticNervePain_OLS());

        whereDoYouExperienceDiabeticNervePain_OLS
                .waitForPageLoad()
                .back(doYouExperienceDPN_OLS)
                .clickOnAnswer("I have not been diagnosed by a healthcare professional, but I do experience these symptoms")
                .clickNextButton(whereDoYouExperienceDiabeticNervePain_OLS);

        //----------Q5 - "Where do you experience diabetic nerve pain symptoms or sensations?" Page ---------------
        whereDoYouExperienceDiabeticNervePain_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5522", site.activeProtocols)
                .back(whereDoYouExperienceDiabeticNervePain_OLS);

        whereDoYouExperienceDiabeticNervePain_OLS
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right foot", "Left leg", "Right hand or arm", "Left hand or arm", "Other")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5522", site.activeProtocols)
                .back(whereDoYouExperienceDiabeticNervePain_OLS);

        whereDoYouExperienceDiabeticNervePain_OLS
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right leg", "Left foot")
                .clickOnAnswers("Right hand or arm", "Left hand or arm", "Other")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5522", site.activeProtocols)
                .back(whereDoYouExperienceDiabeticNervePain_OLS);

        HowWouldYouDescribeTheSymptoms_OLS howWouldYouDescribeTheSymptoms_OLS = whereDoYouExperienceDiabeticNervePain_OLS
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right foot", "Left foot")
                .clickNextButton(new HowWouldYouDescribeTheSymptoms_OLS());

        howWouldYouDescribeTheSymptoms_OLS
                .waitForPageLoad()
                .back(whereDoYouExperienceDiabeticNervePain_OLS);

        whereDoYouExperienceDiabeticNervePain_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right leg", "Left leg", "Left foot", "Right hand or arm", "Left hand or arm", "Other")
                .clickNextButton(howWouldYouDescribeTheSymptoms_OLS);

        //----------Q6 - How would you describe the symptoms or sensations you feel in your feet, legs, hands, or arms? ---------
        ApproxHowlongYouBeenExpSymptomsOLS approxHowlongYouBeenExpSymptomsOLS =
                howWouldYouDescribeTheSymptoms_OLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new ApproxHowlongYouBeenExpSymptomsOLS());

        approxHowlongYouBeenExpSymptomsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5506", site.activeProtocols)
                .back(howWouldYouDescribeTheSymptoms_OLS);

        howWouldYouDescribeTheSymptoms_OLS
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(approxHowlongYouBeenExpSymptomsOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5506", site.activeProtocols)
                .back(howWouldYouDescribeTheSymptoms_OLS);

        howWouldYouDescribeTheSymptoms_OLS
                .waitForPageLoad()
                .clickOnAnswers("Burning", "Painful cold", "Electric", "Tingling", "Pins and needles", "Numbness",
                        "Itching", "An increase in these symptoms or sensations when something brushes against your skin")
                .clickNextButton(approxHowlongYouBeenExpSymptomsOLS);

        //----------Q9 -Approximately how long have you been experiencing symptoms or sensations of diabetic nerve pain?-  Page ---------------
        HowWouldYouRateYourPain_OLS howWouldYouRateYourPain_OLS = new HowWouldYouRateYourPain_OLS();
        List<String> disqualifyQ9 = Arrays.asList("5 months or less", "6 - 11 months", "1 - 3 years");
        for (String answer : disqualifyQ9) {
            System.out.println("Select answer for Q9: " + answer);
            approxHowlongYouBeenExpSymptomsOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howWouldYouRateYourPain_OLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS5509", site.activeProtocols)
                    .back();
        }
        approxHowlongYouBeenExpSymptomsOLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 years")
                .clickOnAnswer("7 - 10 years")
                .clickOnAnswer("11 or more years")
                .clickNextButton(howWouldYouRateYourPain_OLS);

        //----------Q10 - How would you rate your pain or discomfort on a scale of 0 to 10? - page
        HaveYouHadAnyOfTheFollowingAmputatedPageOLS haveYouHadAnyOfTheFollowingAmputatedPageOLS = howWouldYouRateYourPain_OLS
                .waitForPageLoad()
                .selectPainRating("0")
                .clickNextButton(new HaveYouHadAnyOfTheFollowingAmputatedPageOLS());

        haveYouHadAnyOfTheFollowingAmputatedPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5510", site.activeProtocols)
                .back(howWouldYouRateYourPain_OLS);

        howWouldYouRateYourPain_OLS
                .waitForPageLoad()
                .selectPainRating("5")
                .clickNextButton(haveYouHadAnyOfTheFollowingAmputatedPageOLS);

        //----------Q14 -Which of the following have you had amputated or surgically removed because of your diabetes?-  Page ---------------
        CurrentlyTreatingYourDiabetesPageOLS currentlyTreatingYourDiabetesPageOLS = haveYouHadAnyOfTheFollowingAmputatedPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Leg")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLS());

        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5523", site.activeProtocols)
                .back(haveYouHadAnyOfTheFollowingAmputatedPageOLS);

        haveYouHadAnyOfTheFollowingAmputatedPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Foot")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS);

        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5523", site.activeProtocols)
                .back(haveYouHadAnyOfTheFollowingAmputatedPageOLS);

        haveYouHadAnyOfTheFollowingAmputatedPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Toe", "Other")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS);

        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .back(haveYouHadAnyOfTheFollowingAmputatedPageOLS);

        haveYouHadAnyOfTheFollowingAmputatedPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTreatingYourDiabetesPageOLS);

        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(cardiovascularDiseaseThanOthersPageOLS);

        cardiovascularDiseaseThanOthersPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5524")
                .back(currentlyTreatingYourDiabetesPageOLS);

        currentlyTreatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise", "Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //----------------------GENERAL HEALTH Questions -----------------------------
        CancerPage cancerPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer", "Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new CancerPage());

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = cancerPage
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(cancerPage);

        cancerPage
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS =
                haveYouEverExperiencedHeartRelatedMedicalCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack", "Stroke",
                                "Mini-Stroke or TIA",
                                "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                        .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageOLS.titleExpected4);

        HeartrelatedMedicalProceduresPageOLS heartrelatedMedicalProceduresPageOLS = subquestionExperiencedHeartPageOLS
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected2, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected3, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageOLS.titleExpected4, "4 - 6 months ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());

        heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageOLS);

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = heartrelatedMedicalProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder",
                        "Cirrhosis",
                        "Drug or alcohol abuse within the past year",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia")
                .clickNextButton(new ApproximateHeightPageOLS());

        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B", "Hepatitis C", "Neuropathy (nerve damage due to diabetes or another condition)")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad2(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForSENRPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env, "5096")
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}