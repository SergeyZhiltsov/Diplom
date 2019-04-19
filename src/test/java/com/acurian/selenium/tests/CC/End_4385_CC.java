package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.END_4385.*;
import com.acurian.selenium.pages.CC.SUI_3923.HaveYouGoneThroughMenopauseCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.TheStudySitePageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class End_4385_CC extends BaseTest {

    @Test()
    public void end4385cc() {
        Site site = Site.AUT_END_4385;
        String phoneNumber = "AUTAMS1END";
        String studyName = "an endometriosis";
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
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
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle("an endometriosis study", "1775"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        FollowingGynecologicalConditionСС followingGynecologicalConditionСС = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new FollowingGynecologicalConditionСС());

        DebugPageCC debugPageCC = new DebugPageCC();

        NonQRtransitionPageCC nonQRtransitionPageCC = followingGynecologicalConditionСС
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0014078-QS4902-STUDYQUES", site.activeProtocols)
                .back();
        TreatYourEndometriosisPageСС treatYourEndometriosisPageСС = followingGynecologicalConditionСС
                .waitForPageLoad()
                .clickOnAnswers("Endometriosis")
                .clickNextButton(new TreatYourEndometriosisPageСС());

        HaveYouGoneThroughMenopauseCC haveYouGoneThroughMenopauseCC = treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickNextButton(new HaveYouGoneThroughMenopauseCC());
        haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .back();
        DiagnoseYourEndometriosisCC diagnoseYourEndometriosisCC = treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("Ultrasound")
                .clickNextButton(new DiagnoseYourEndometriosisCC());
        diagnoseYourEndometriosisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020254-QS4928-STUDYQUES", site.activeProtocols)
                .back();
        treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickOnAnswers("CT scan")
                .clickNextButton(diagnoseYourEndometriosisCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020254-QS4928-STUDYQUES", site.activeProtocols)
                .back();
        treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickOnAnswers("MRI")
                .clickNextButton(diagnoseYourEndometriosisCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0020254-QS4928-STUDYQUES", site.activeProtocols)
                .back();
        treatYourEndometriosisPageСС
                .waitForPageLoad()
                .clickOnAnswers("Surgery, but unsure what type",
                        "Laparoscopy, which is a surgical procedure in which a scope is inserted through a small cut in the abdomen",
                        "Laparotomy, which is a surgical procedure in which a large cut is made into the abdomen",
                        "Seen or biopsied during an examination of the vagina, cervix, or other location (such as a cesarean section scar)")
                .clickNextButton(diagnoseYourEndometriosisCC);

        diagnoseYourEndometriosisCC
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(haveYouGoneThroughMenopauseCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015212-QS4921-STUDYQUES", site.activeProtocols)
                .back();
        diagnoseYourEndometriosisCC
                .waitForPageLoad()
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(haveYouGoneThroughMenopauseCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015212-QS4921-STUDYQUES", site.activeProtocols)
                .back();
        diagnoseYourEndometriosisCC
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(haveYouGoneThroughMenopauseCC);

        HaveYouHadHysterectomyСС haveYouHadHysterectomyСС = haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickNextButton(new HaveYouHadHysterectomyСС());
        haveYouHadHysterectomyСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0013713-QS4905-STUDYQUES", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                .clickNextButton(haveYouHadHysterectomyСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0013713-QS4905-STUDYQUES", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(haveYouHadHysterectomyСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0013713-QS4905-STUDYQUES", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouHadHysterectomyСС);

        haveYouHadHysterectomyСС
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0014084-QS4906-STUDYQUES", site.activeProtocols)
                .back();
        PlzDescribeYourMenstrualCyclesCC plzDescribeYourMenstrualCyclesCC = haveYouHadHysterectomyСС
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PlzDescribeYourMenstrualCyclesCC());

        ApproxHowManyDaysInYourMenstrualCycle_CC approxHowManyDaysInYourMenstrualCycle_cc = plzDescribeYourMenstrualCyclesCC
                .waitForPageLoad()
                .clickOnAnswer("Never regular")
                .clickNextButton(new ApproxHowManyDaysInYourMenstrualCycle_CC());

        HowManyTimesDidYouGetYourPeriodInThreeMons_CC howManyTimesDidYouGetYourPeriodInThreeMons_cc = approxHowManyDaysInYourMenstrualCycle_cc
                .waitForPageLoad()
                .setDays("15")
                .clickNextButton(new HowManyTimesDidYouGetYourPeriodInThreeMons_CC());

        PelvicPainCC pelvicPainCC = howManyTimesDidYouGetYourPeriodInThreeMons_cc
                .waitForPageLoad()
                .clickOnAnswer("Did not get period at all in the past 3 months")
                .clickNextButton(new PelvicPainCC());

        PelvicPainOtherTimesCC pelvicPainOtherTimesCC = pelvicPainCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PelvicPainOtherTimesCC());
        pelvicPainOtherTimesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0014086-QS4908-STUDYQUES", site.activeProtocols)
                .back();
        DescribesPelvicPainCC describesPelvicPainCC = pelvicPainCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesPelvicPainCC());

        describesPelvicPainCC
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(new PelvicPainOtherTimesCC());

        HormonalBirthControlCC hormonalBirthControlCC = pelvicPainOtherTimesCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HormonalBirthControlCC());
        hormonalBirthControlCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015214-QS4923-STUDYQUES", site.activeProtocols)
                .back();
        DescribesNonMenstrualPelvicPainCC describesNonMenstrualPelvicPainCC = pelvicPainOtherTimesCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesNonMenstrualPelvicPainCC());

        describesNonMenstrualPelvicPainCC
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(hormonalBirthControlCC);

        DiagnosedWithGynecologicalConditionCC diagnosedWithGynecologicalConditionCC = hormonalBirthControlCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithGynecologicalConditionCC());
        diagnosedWithGynecologicalConditionCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEqualsForQNumber("Q0015753-QS4925-STUDYQUES", site.activeProtocols)
                .back();
        BirthControlMethodPageCC birthControlMethodPageCC = hormonalBirthControlCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BirthControlMethodPageCC());

        birthControlMethodPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(diagnosedWithGynecologicalConditionCC);

        AreYouCurrentlyPregnantCC areYouCurrentlyPregnantCC = diagnosedWithGynecologicalConditionCC
                .waitForPageLoad()
                .clickOnAnswers("Vaginismus, also known as vaginal muscle spasm")
                .clickNextButton(new AreYouCurrentlyPregnantCC());

        TransitionStatementCC transitionStatementCC = areYouCurrentlyPregnantCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadWithTitle(transitionStatementCC.titleExpectedEndo)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0008690-QS4916-STUDYQUES", site.activeProtocols)
                .back();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = areYouCurrentlyPregnantCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoadWithTitle(transitionStatementCC.titleExpectedEndo)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        //-------------------New GENERAL HEALTH---------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
                //----------Q23 - Do any of the following additional diagnoses apply to you?--------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
                //----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new TheStudySitePageCC())
                //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("an endometriosis study")
                .getPID()
                .clickOnAnswer(site.name)
//                .clickNextButton(new HSGeneralCC())
//                .waitForPageLoad(site_Indication)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
