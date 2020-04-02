package com.acurian.selenium.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Vaccine.AreYouInterestedInPneumoniaVaccineStudyCC;
import com.acurian.selenium.pages.CC.Vaccine.CalledPrevnarPageCC;
import com.acurian.selenium.pages.CC.Vaccine.DiagnosedWithAnyOfTheFollowingTypesOfCancerCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.ArrayList;

public class VACC_4556_CC extends BaseTest {



    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_VAC_4556M},
//                {Site.AUT_VAC_4556_Site},
                {Site.AUT_VAC_4556_A}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("VACC_4556_CC")
    public void vacc4556cc(Site site) {
        final String phoneNumber = "AUTAMS1VAC";
        final String[] protocols = site.activeProtocols;
        final String studyName = "a pneumonia vaccine study";
        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");

        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a pneumonia vaccine study", "170");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("a pneumonia vaccine study", "170"), "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("May")
                .setDay("1")
                .setYear("2006")
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocols)
                .back();
        ZipCodePageCC zipCodePageCC = new ZipCodePageCC();
        switch (site) {
            case AUT_VAC_4556M:
                dateOfBirthPageCC
                        .waitForPageLoad("a pneumonia vaccine study", "170")
                        .setYear("1959")//64
                        .clickNextButton(zipCodePageCC)
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocols[0])
                        .back(dateOfBirthPageCC)
                        .waitForPageLoad("a pneumonia vaccine study", "170")
                        .setYear("1954")//65
                        .clickNextButton(zipCodePageCC);
                break;
//            case AUT_VAC_4556_Site:
//                dateOfBirthPageCC
//                        .waitForPageLoad()
//                        .setYear("1968")//50
//                        .clickNextButton(zipCodePageCC)
//                        .waitForPageLoad()
//                        .getPage(debugPageCC)
//                        .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocols)
//                        .back(dateOfBirthPageCC)
//                        .waitForPageLoad()
//                        .setYear("1969")//49
//                        .clickNextButton(zipCodePageCC);
//                break;
            case AUT_VAC_4556_A:
                dateOfBirthPageCC
                        .waitForPageLoad("a pneumonia vaccine study", "170")
                        .setYear("1940")//<80
                        .clickNextButton(zipCodePageCC)
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocols)
                        .back(dateOfBirthPageCC)
                        .waitForPageLoad("a pneumonia vaccine study", "170")
                        .setYear("1939")//>=80
                        .clickNextButton(zipCodePageCC);
        }

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        AreYouInterestedInPneumoniaVaccineStudyCC areYouInterestedInPneumoniaVaccineStudyCC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new AreYouInterestedInPneumoniaVaccineStudyCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = areYouInterestedInPneumoniaVaccineStudyCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018854-QS6902-STUDYQUES", protocols)
                .back(areYouInterestedInPneumoniaVaccineStudyCC);
        areYouInterestedInPneumoniaVaccineStudyCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new CalledPrevnarPageCC());

        DiagnosedWithAnyOfTheFollowingTypesOfCancerCC diagnosedWithAnyOfTheFollowingTypesOfCancerCC = new DiagnosedWithAnyOfTheFollowingTypesOfCancerCC();
        CalledPrevnarPageCC calledPrevnarPageCC = new CalledPrevnarPageCC();
         switch (site) {
            case AUT_VAC_4556M:
                calledPrevnarPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(diagnosedWithAnyOfTheFollowingTypesOfCancerCC);
                diagnosedWithAnyOfTheFollowingTypesOfCancerCC
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkProtocolsContainsForQNumber("Q0019390-QS6907-STUDYQUES", site.activeProtocols)
                        .back();
                break;
//            case AUT_VAC_4556_Site:
//                diagnosedWithAnyOfTheFollowingTypesOfCancerCC
//                        .waitForPageLoad()
//                        .getPage(debugPageCC)
//                        .checkProtocolsContainsForQNumber("Q0019390-QS6907-STUDYQUES", protocols)
//                        .back();
//                break;
            case AUT_VAC_4556_A:
                calledPrevnarPageCC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(diagnosedWithAnyOfTheFollowingTypesOfCancerCC)
                        .waitForPageLoad()
                        .getPage(debugPageCC)
                        .checkProtocolsContainsForQNumber("Q0019390-QS6907-STUDYQUES", site.activeProtocols)
                        .back();
        }
        calledPrevnarPageCC
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(diagnosedWithAnyOfTheFollowingTypesOfCancerCC);

        TransitionStatementCC transitionStatementCC = diagnosedWithAnyOfTheFollowingTypesOfCancerCC
                .waitForPageLoad()
                .clickOnAnswers("Leukemia")
                .clickNextButton(new TransitionStatementCC());
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithInitialQuestions()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018855-QS6903-STUDYQUES", protocols)
                .back(diagnosedWithAnyOfTheFollowingTypesOfCancerCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Lymphoma")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithInitialQuestions()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018855-QS6903-STUDYQUES", protocols)
                .back(diagnosedWithAnyOfTheFollowingTypesOfCancerCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithInitialQuestions()
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer", "Kidney disease", "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)"
                )
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocols)
                .back(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());

        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseCC)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());

        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageCC);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocols)
                .back(followingMentalEmotionalHealthPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocols)
                .back(followingMentalEmotionalHealthPageCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ArrayList<String> additionalDiagnoses = new ArrayList<>();
        ApproximateHeightPageCC approximateHeightPageOLS = new ApproximateHeightPageCC();
        additionalDiagnoses.add("Drug or alcohol abuse within the past year");
        additionalDiagnoses.add("Hepatitis B");
        additionalDiagnoses.add("Hepatitis C");
        additionalDiagnoses.add("HIV or AIDS");
        for (String diagnose : additionalDiagnoses) {
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(diagnose)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "250")
                .clickNextButton(new LetMeSeePageCC());

        SiteSelectionPageCC siteSelectionPageCC = letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID();
        switch (site) {
            case AUT_VAC_4556M:
            case AUT_VAC_4556_A:
                siteSelectionPageCC
                        .clickOnAnswer(site.name)
//                        .clickNextButton(new HSGeneralCC())
//                        .waitForPageLoadByTitle(new HSGeneralCC().titleExpected4556)
                        .clickNextButton(new DoctorInformationCollectionPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new HSMedicalRecordsPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new SynexusHealthyMindsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo)
                        .assertGeneratedFul(env, site)
                        .queueSiteForFULCheck(site.name);
                break;
//            case AUT_VAC_4556_Site:
//                siteSelectionPageCC
//                        .clickOnAnswer(site.name)
//                        .clickNextButton(new QualifiedClose2PageCC())
//                        .waitForPageLoad()
//                        .clickNextButton(new ThankYouCloseSimplePageCC())
//                        .waitForPageLoad()
//                        .clickNextButton(selectActionPageCC)
//                        .waitForPageLoad()
//                        .pidFromDbToLog(env)
//                        .childPidFromDbToLog(env)
//                        .dispoShouldMatch(site.dispoBlinx, site.dispoBlinx)
//                        .queueSiteForFULCheck(site.name);
        }

    }
}
