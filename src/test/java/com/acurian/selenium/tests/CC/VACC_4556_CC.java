package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.VACC_4556_CC.AreYouInterestedInPneumoniaVaccineStudyCC;
import com.acurian.selenium.pages.CC.VACC_4556_CC.DiagnosedWithAnyOfTheFollowingTypesOfCancerCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.ArrayList;

public class VACC_4556_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("VACC_4556_CC")
    public void vacc4556cc(final String username, final String password) {
        final String phoneNumber = "AUTAMS1VAC";
        final String protocol1 = "B7471006";
        final String protocol2 = "B7471007";
        final String protocol3 = "B7471008";
        final String[] protocols = {protocol1, protocol2, protocol3};
        final String studyName = "a pneumonia vaccine study";
        final String siteName = "AUT_VAC_4556_Site";
        final String zipCode = "19901";
        DebugPageCC debugPageCC = new DebugPageCC();
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleVaccineExpected, "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("15")
                .setYear("2005")
                .clickNextButton(new LessThan18YearsOldPageCC());

        ZipCodePageCC zipCodePageOLS = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad()
                .setYear("1965")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1, protocol3)
                .back(dateOfBirthPageCC)
                .waitForPageLoad()
                .setYear("1990")
                .clickNextButton(zipCodePageOLS)
                .waitForPageLoad()
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());

        AreYouInterestedInPneumoniaVaccineStudyCC areYouInterestedInPneumoniaVaccineStudyCC = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new AreYouInterestedInPneumoniaVaccineStudyCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = areYouInterestedInPneumoniaVaccineStudyCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());

        DiagnosedWithAnyOfTheFollowingTypesOfCancerCC diagnosedWithAnyOfTheFollowingTypesOfCancerCC = nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018854-QS6902-STUDYQUES", protocols)
                .back(areYouInterestedInPneumoniaVaccineStudyCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DiagnosedWithAnyOfTheFollowingTypesOfCancerCC());

        TransitionStatementCC transitionStatementCC = diagnosedWithAnyOfTheFollowingTypesOfCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Leukemia")
                .clickNextButton(new TransitionStatementCC());
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithInitialQuestions()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018855-QS6903-STUDYQUES", protocols)
                .back(diagnosedWithAnyOfTheFollowingTypesOfCancerCC)
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickOnAnswer("Lymphoma")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithInitialQuestions()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0018855-QS6903-STUDYQUES", protocols)
                .back(diagnosedWithAnyOfTheFollowingTypesOfCancerCC)
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithInitialQuestions()
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer", "Kidney disease", "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)"
                )
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        KidneyProblemsPage kidneyProblemsPage = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new KidneyProblemsPage());

        WhichOfTheFollowingLiverProblemsPageСС whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = kidneyProblemsPage
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocols)
                .back(whenDiagnosedWithCancerCC)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(kidneyProblemsPage)
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());

        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocols)
                .back(kidneyProblemsPage)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocols)
                .back(kidneyProblemsPage)
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

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);

    }
}
