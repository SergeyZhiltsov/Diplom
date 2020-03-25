package com.acurian.selenium.CC.no_indication;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ChronicCough.HowLongYouHadChronicCoughCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class NoIndication3889_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)
    @TestCaseId("00035")
    @Description("No Indication 3889 CC")
    public void crohns_3889_CC_NI(final String username, final String password) {
        String phoneNumber = "AUTAMS1GEN";
        String protocol1 = "M14_431";
        String protocol2 = "M14_433";
        String protocol3 = "M15_991";
        String protocol4 = "M16_006";
        String studyName = "a chronic cough study";
        String siteName = "AUT_MCC";
        String zipCode = "19341";

        String env = System.getProperty("acurian.env", "STG");


        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
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
                .waitForPageLoad("a Crohn's study", "700");
//        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle
//                ("a Crohn's study", "700"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Autism spectrum",
                        "High cholesterol, triglycerides, or lipids",
                        "Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES",protocol1,protocol2,protocol3,protocol4)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES",protocol1,protocol2,protocol3,protocol4)
                .back();
        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
                        "Cancer",
                        "Kidney disease",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        WhichOfFollowingDigestiveConditionPageCC whichOfFollowingDigestiveConditionPageCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageCC());
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(whichOfFollowingDigestiveConditionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(whichOfFollowingDigestiveConditionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfFollowingDigestiveConditionPageCC);

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015126-QS44-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        HeartRelatedSurgeriesProceduresPageCC heartRelatedSurgeriesProceduresPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedSurgeriesProceduresPageCC());
        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .back();
        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC = haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("Heart attack", "Stroke", "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4)
                .clickOnAnswerForSubQuestion(1,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"Less than 30 days ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "Less than 30 days ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015129-QS47-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .clickOnAnswerForSubQuestion(1,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(2,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(3,"More than 1 year ago")
                .clickOnAnswerForSubQuestion(4, "More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesProceduresPageCC);

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC whichOfTheFollowingHaveRequiredForKidneyDiseaseCC = heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseCC());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC = whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseCC());
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealth_Page_cc = whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());
        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealth_Page_cc);

        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocol1, protocol2, protocol3, protocol4)
                .back();
        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();
        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .back();
        whichOfFollowingHaveYouDiagnosedWithLiverDiseaseCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseCC
                .waitForPageLoad()
                .back();
        heartRelatedSurgeriesProceduresPageCC
                .waitForPageLoad()
                .back();
        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .back();
        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .back();
        whichOfFollowingDigestiveConditionPageCC
                .waitForPageLoad()
                .back();
        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)")
                .clickNextButton(whichOfFollowingDigestiveConditionPageCC)
                .waitForPageLoad()
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        HowLongYouHadChronicCoughCC howLongYouHadChronicCoughCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new HowLongYouHadChronicCoughCC());

    }
}
