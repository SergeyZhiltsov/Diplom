package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class DIA_4241_OLS extends BaseTest{

    @Test
    @TestCaseId("00007")
    @Description("Diabetes_4241")
    public void tc007Test() {
        String phoneNumberLBP = "AUTAMS1DIA";
        List<String> protocols = Arrays.asList("EFC14822");
        String protocol1 = "EFC14822";
        String studyName = "Diabetes";
        String siteName = "AUT_DIA_4241";
        String debugSiteName = "QSC9004_4356A_AUT_MIG_4356A";
        String env = "STG";
        String zipCode = "19044";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleDiabetes_4356A_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageOLS.getTitleText(),diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, "Title is diff");
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());

        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, protocol1);
        debugPageOLS.back();

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageOLS.getTitleText(),whatKindOfDiabetesPageOLS.titleExpected, "Title is diff");
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(hasHealthcareProfessionalPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(whatKindOfDiabetesPageOLS.titleExpected, protocol1)
                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        withType2DiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageOLS.getTitleText(),withType2DiabetesPageOLS.titleExpected, "Title is diff");
        TreatingYourDiabetesPageOLS treatingYourDiabetesPageOLS = withType2DiabetesPageOLS
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new TreatingYourDiabetesPageOLS());

        treatingYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(treatingYourDiabetesPageOLS.getTitleText(),treatingYourDiabetesPageOLS.titleExpected, "Title is diff");
        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = treatingYourDiabetesPageOLS
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new FollowingToLoseWeightPageOLS());
        followingToLoseWeightPageOLS
                .waitForPageLoad()
                .back();
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)// copy text from previous question until "..."(white space should be include)
                .checkProtocolsEquals("How are you currently treating your diabetes?Agent Note: Select all that applyHow are you currently ", protocol1)
                .back();
        LastTimeYouTookPageOLS lastTimeYouTookPageOLS = treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medication")
                .clickNextButton(new LastTimeYouTookPageOLS());

        lastTimeYouTookPageOLS
                .waitForPageLoad();
        Assert.assertEquals(lastTimeYouTookPageOLS.getTitleText(),lastTimeYouTookPageOLS.titleExpected, "Title is diff");
        lastTimeYouTookPageOLS
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, protocol1)
                .back();
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageOLS());
        metforminMedicationsPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(lastTimeYouTookPageOLS.titleExpected, protocol1)
                .back();
        lastTimeYouTookPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(metforminMedicationsPageOLS);

        metforminMedicationsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(metforminMedicationsPageOLS.getTitleText(),metforminMedicationsPageOLS.titleExpected, "Title is diff");
        ApartFromMetforminPageOLS apartFromMetforminPageOLS = metforminMedicationsPageOLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApartFromMetforminPageOLS());

        InsulinForYourDiabetesPageOLS insulinForYourDiabetesPageOLS = apartFromMetforminPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InsulinForYourDiabetesPageOLS());

        insulinForYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(insulinForYourDiabetesPageOLS.getTitleText(),insulinForYourDiabetesPageOLS.titleExpected, "Title is diff");
        SubquestionsHumalogPageOLS subquestionsHumalogPageOLS = insulinForYourDiabetesPageOLS
                .clickOnAnswers("Humalog","Humulin","Novolin","Novolog")
                .clickNextButton(new SubquestionsHumalogPageOLS());

        subquestionsHumalogPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(1),subquestionsHumalogPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(2),subquestionsHumalogPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(3),subquestionsHumalogPageOLS.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(4),subquestionsHumalogPageOLS.titleExpected4, "Title is diff");
        subquestionsHumalogPageOLS
                .clickOnAnswersForSubQuestion(1,"Humalog Mix 50/50","Humalog Mix 75/25")
                .clickOnAnswersForSubQuestion(2,"Humulin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolin do you currently use?","Novolin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolog do you currently use?","Novolog Mix 70/30")
                .back();

        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());

        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(injectableMedicationsForYourDiabetesPageOLS.getTitleText(),injectableMedicationsForYourDiabetesPageOLS.titleExpected, "Title is diff");
        CombinationWithEachOtherPageOLS combinationWithEachOtherPageOLS = injectableMedicationsForYourDiabetesPageOLS
                .clickOnAnswers("Adlyxin (lixisenatide)", "Another injectable medication not listed above")
                .clickNextButton(new CombinationWithEachOtherPageOLS());
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic", protocol1)
                .back();
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(combinationWithEachOtherPageOLS);

        combinationWithEachOtherPageOLS
                .waitForPageLoad();
        Assert.assertEquals(combinationWithEachOtherPageOLS.getTitleText(),combinationWithEachOtherPageOLS.titleExpected, "Title is diff");
        combinationWithEachOtherPageOLS
                .clickNextButton(followingToLoseWeightPageOLS);

        followingToLoseWeightPageOLS
                .waitForPageLoad();
        Assert.assertEquals(followingToLoseWeightPageOLS.getTitleText(),followingToLoseWeightPageOLS.titleExpected, "Title is diff");
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
                .clickOnAnswers("Prescription weight loss medication")
                .clickNextButton(new WeightLossSurgeryPageOLS());

        weightLossSurgeryPageOLS
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageOLS.getTitleText(),weightLossSurgeryPageOLS.titleExpected, "Title is diff");
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        procedureForWeightLossPageOLS
                .waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageOLS.getTitleText(),procedureForWeightLossPageOLS.titleExpected, "Title is diff");
        PoundsOrMorePageOLS poundsOrMorePageOLS = procedureForWeightLossPageOLS
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PoundsOrMorePageOLS());
        poundsOrMorePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(poundsOrMorePageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(procedureForWeightLossPageOLS.titleExpected, protocol1)
                .back();
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .back();

        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(poundsOrMorePageOLS);

        poundsOrMorePageOLS
                .waitForPageLoad();
        Assert.assertEquals(poundsOrMorePageOLS.getTitleText(),poundsOrMorePageOLS.titleExpected, "Title is diff");
        AreYouCurrentlyOnPageOLS areYouCurrentlyOnPageOLS = poundsOrMorePageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyOnPageOLS());
        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(poundsOrMorePageOLS.titleExpected, protocol1)
                .back();
        poundsOrMorePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(areYouCurrentlyOnPageOLS);

        areYouCurrentlyOnPageOLS
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyOnPageOLS.getTitleText(),areYouCurrentlyOnPageOLS.titleExpected, "Title is diff");
        StatinMedicationsOnPageOLS statinMedicationsOnPageOLS = areYouCurrentlyOnPageOLS
                .clickOnAnswer("Yes, for arthritis")
                .clickNextButton(new StatinMedicationsOnPageOLS());
        statinMedicationsOnPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(areYouCurrentlyOnPageOLS.titleExpected, protocol1)
                .back();
        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, for low back pain")
                .clickNextButton(statinMedicationsOnPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(areYouCurrentlyOnPageOLS.titleExpected, protocol1)
                .back();
        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, for another chronic condition")
                .clickNextButton(statinMedicationsOnPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(areYouCurrentlyOnPageOLS.titleExpected, protocol1)
                .back();
        areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(statinMedicationsOnPageOLS);

        CongestiveHeartFailurePageOLS congestiveHeartFailurePageOLS = statinMedicationsOnPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DiabeticNephropathyPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ForYourKidneysPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new CongestiveHeartFailurePageOLS());

        congestiveHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new AffectingYourMetabolismPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ConditionsRelatedToYourDiabetesPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AffectYourLungsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SleepRelatedConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new SkinConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ViralConditionsPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new MentalHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WomensHealthPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new OtherThanSkinCancerPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SmokedCigarettesPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I never smoked")
                .clickNextButton(new HistoryOfDrugPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new ChildrenUnderPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();

    }
}
