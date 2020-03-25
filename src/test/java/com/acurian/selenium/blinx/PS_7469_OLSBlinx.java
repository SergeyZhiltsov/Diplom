package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.debug.ConfigPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.ps_7469.*;
import com.acurian.selenium.pages.blinx.ams.diabetes.SubquestionExperiencedHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.cv_study.HeartRelatedSurgeriesProceduresPageOLS;
import com.acurian.selenium.pages.blinx.ams.cv_study.MostRecentHeartRelatedSurgeryProcedurePageOLS;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.derm.HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class PS_7469_OLSBlinx extends BaseTest {

    private static Logger Log = LogManager.getLogger(PS_7469_OLSBlinx.class.getName());

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_S10484}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("New Psoriasis S10484(7469) EDP1815-201 (Evelo / PPD Psoriasis)")
    public void ps7469olsBlinxTest(Site site) {

        String phoneNumber = "AUTAMS1PSO";
        String studyName = "a psoriasis study";
        String env = System.getProperty("acurian.env", "STG");
        DebugPageOLS debugPageOLS = new DebugPageOLS();

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadCrohns(studyName, "350");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
                .getExpectedModifiedTitle(studyName, "350"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad()
                .setDate("09091948")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);

        genderPageOLS
                .waitForPageLoad();
        HasHealthcareProfessionalEverDiagnosedYouWithPsoriasis_OLS hasHealthcareProfessionalEverDiagnosedYouWithPsoriasis_ols = genderPageOLS
                .setDate("09091980")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithPsoriasis_OLS());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols =
                hasHealthcareProfessionalEverDiagnosedYouWithPsoriasis_ols
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_OLS());
        hasHealthcareProfessionalEverDiagnosedYouWithEczema_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7002", site.activeProtocols)
                .back(hasHealthcareProfessionalEverDiagnosedYouWithPsoriasis_ols);
        WhenDiagnosedWithPsoriasisOLS whenDiagnosedWithPsoriasisOLS = hasHealthcareProfessionalEverDiagnosedYouWithPsoriasis_ols
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenDiagnosedWithPsoriasisOLS());

        WhichTypeOfPsoriasisDoYouHaveOLS whichTypeOfPsoriasisDoYouHaveOLS = whenDiagnosedWithPsoriasisOLS
                .waitForPageLoad()
                .clickOnAnswer("5 or fewer months ago")
                .clickNextButton(new WhichTypeOfPsoriasisDoYouHaveOLS());

        whichTypeOfPsoriasisDoYouHaveOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7003", site.activeProtocols)
                .back(whenDiagnosedWithPsoriasisOLS);

        whenDiagnosedWithPsoriasisOLS
                .waitForPageLoad()
                .clickOnAnswer("1 year ago or more")
                .clickNextButton(whichTypeOfPsoriasisDoYouHaveOLS);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                whichTypeOfPsoriasisDoYouHaveOLS
                .waitForPageLoad()
                .clickOnAnswer("Another type of psoriasis (Guttate, Pustular, Erythtodermic, Inverse)")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7020", site.activeProtocols)
                .back(whichTypeOfPsoriasisDoYouHaveOLS);

        DoesYourPsoriasisLookLikeThisOLS doesYourPsoriasisLookLikeThisOLS = whichTypeOfPsoriasisDoYouHaveOLS
                .waitForPageLoad()
                .clickOnAnswer("I'm not sure")
                .clickNextButton(new DoesYourPsoriasisLookLikeThisOLS());

        //knees
        EnoughPsoriasisToEqualAtLeastOneHandprintOLS enoughPsoriasisToEqualAtLeastOneHandprintOLS = doesYourPsoriasisLookLikeThisOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EnoughPsoriasisToEqualAtLeastOneHandprintOLS());

        enoughPsoriasisToEqualAtLeastOneHandprintOLS
                .waitForPageLoad()
                .back(doesYourPsoriasisLookLikeThisOLS);

        //knees
        doesYourPsoriasisLookLikeThisOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doesYourPsoriasisLookLikeThisOLS);

        //body
        doesYourPsoriasisLookLikeThisOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doesYourPsoriasisLookLikeThisOLS);
        //head
        doesYourPsoriasisLookLikeThisOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doesYourPsoriasisLookLikeThisOLS);
        //elbow
        doesYourPsoriasisLookLikeThisOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(enoughPsoriasisToEqualAtLeastOneHandprintOLS);

        TreatYourPsoriasisPageOLS treatYourPsoriasisPageOLS = enoughPsoriasisToEqualAtLeastOneHandprintOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TreatYourPsoriasisPageOLS());

        treatYourPsoriasisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7026", site.activeProtocols)
                .back(enoughPsoriasisToEqualAtLeastOneHandprintOLS);

        enoughPsoriasisToEqualAtLeastOneHandprintOLS
                .waitForPageLoad()
                .clickOnAnswer("I'm not sure")
                .clickNextButton(treatYourPsoriasisPageOLS);

        InjectableMedicationToTreatPsoriasisOLS injectableMedicationToTreatPsoriasisOLS = treatYourPsoriasisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .back(treatYourPsoriasisPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Shots or IV infusion (injectable medications)")
                .clickNextButton(new InjectableMedicationToTreatPsoriasisOLS());

        PsoriaticArthritisConditionPageOLS psoriaticArthritisConditionPageOLS = injectableMedicationToTreatPsoriasisOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the last 6 months")
                .clickNextButton(new PsoriaticArthritisConditionPageOLS());

        psoriaticArthritisConditionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7013", site.activeProtocols)
                .back(injectableMedicationToTreatPsoriasisOLS)
                .waitForPageLoad()
                .clickOnAnswer("Between 7 months and 1 year ago")
                .clickNextButton(psoriaticArthritisConditionPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7013", site.activeProtocols)
                .back(injectableMedicationToTreatPsoriasisOLS)
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //--------------------------------------GENERAL HEALTH QUESTIONS----------------------------------------------
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());

        SubquestionExperiencedHeartPageOLS subquestionExperiencedHeartPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());

        HeartrelatedMedicalProceduresPageOLS haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS = subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("Less than 30 days ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageOLS());
        haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .clickOnAnswerForAllSubQuestion("4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Stroke")
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected2)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickOnAnswers("Stroke")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected3)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(new SubquestionExperiencedHeartPageOLS());
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 30 days ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickNextButton(haveYouUndergoneAnyOfFollowingHeartRelatedProcOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageOLS);
        subquestionExperiencedHeartPageOLS
                .waitForPageLoad(1, subquestionExperiencedHeartPageOLS.titleExpected4)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS);

        HeartRelatedSurgeriesProceduresPageOLS heartRelatedSurgeriesProceduresPageOLS = haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageOLS());

        MostRecentHeartRelatedSurgeryProcedurePageOLS mostRecentHeartRelatedSurgeryProcedurePageOLS = heartRelatedSurgeriesProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageOLS());


        List<String> disqualifyQS49 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago");
        for (String answer : disqualifyQS49) {
            Log.info("Select answer for QS49: " + answer);
            mostRecentHeartRelatedSurgeryProcedurePageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS49", site.activeProtocols)
                    .back(mostRecentHeartRelatedSurgeryProcedurePageOLS);
        }

        mostRecentHeartRelatedSurgeryProcedurePageOLS
                .waitForPageLoad()
                .back(heartRelatedSurgeriesProceduresPageOLS)
                .waitForPageLoad()
                .back(haveYouEverExperiencedHeartRelatedMedicalCondOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesOLS();

        List<String> disqualifyQS44 = Arrays.asList("Crohn's disease", "Ulcerative colitis", "Gastroparesis, or delayed gastric emptying");
        for (String answer : disqualifyQS44) {
            Log.info("Select answer for QS44: " + answer);
            whichOfFollowingDigestiveConditionPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back(whichOfFollowingDigestiveConditionPageOLS);
        }

        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("Seizure disorder such as epilepsy")
                .clickNextButton(approximateHeightPageOLS);

        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "190") //BMI > 30
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();

        (env.equals("STG") ? identificationPageOLS.waitForPageLoadSTG() : identificationPageOLS.waitForPageLoad2())
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .waitForPageLoad5(studyName + "!")
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS());
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                .waitForPageLoad3()
                .clickNextButton(new ThankYouCloseSimplePageOLS());
        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
