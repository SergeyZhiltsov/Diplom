package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class Crohns_3485_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00011")
    @Description("Crohn's_3485 for CC")
    public void tc004Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1CRN";
        List<String> protocols = Arrays.asList("APD371_004","RF_I6T_MC_AMAG","I6T_MC_AMAG");
        String protocol1 = "APD371_004";
        String protocol2 = "RF_I6T_MC_AMAG";
        String protocol3 = "I6T_MC_AMAG";
        String studyName = "Crohn's";
        String siteName = "AUT_CRN_3638C_Site";
        String debugSiteName = "";
        String env = "STG";
        String zipCode = "19044";

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
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedCrohns_3485, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
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
        DiagnosedWithCrohnsPageCC diagnosedWithCrohnsPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedWithCrohnsPageCC());

        diagnosedWithCrohnsPageCC
                .waitForPageLoad();
        Assert.assertEquals(diagnosedWithCrohnsPageCC.getTitleText(),diagnosedWithCrohnsPageCC.titleExpected, "Title is diff");
        FollowingMedicalConditionsPageCC followingMedicalConditionsPageCC = diagnosedWithCrohnsPageCC
                .clickOnAnswer("No")
                .clickNextButton(new FollowingMedicalConditionsPageCC());
        followingMedicalConditionsPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsEquals(diagnosedWithCrohnsPageCC.titleExpected, protocol1, protocol2, protocol3);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(followingMedicalConditionsPageCC);

        followingMedicalConditionsPageCC
                .waitForPageLoad();
        Assert.assertEquals(followingMedicalConditionsPageCC.getTitleText(), followingMedicalConditionsPageCC.titleExpected, "Title is diff");
        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = followingMedicalConditionsPageCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhenDiagnosedCrohnsPageCC());

        whenDiagnosedCrohnsPageCC
                .waitForPageLoad();
        Assert.assertEquals(whenDiagnosedCrohnsPageCC.getTitleText(), whenDiagnosedCrohnsPageCC.titleExpected, "Title is diff");
        TypeOfDoctorPageCC typeOfDoctorPageCC = whenDiagnosedCrohnsPageCC
                .clickOnAnswer("Not officially diagnosed with Crohn’s by a doctor")
                .clickNextButton(new TypeOfDoctorPageCC());
        typeOfDoctorPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Next, please tell me, when were you diagnosed with Crohn’s disease by a doctor at a hospital or doct", protocol1, protocol2, protocol3)
                .back();
        whenDiagnosedCrohnsPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 or more years ago")
                .clickNextButton(typeOfDoctorPageCC);

        typeOfDoctorPageCC
                .waitForPageLoad();
        Assert.assertEquals(typeOfDoctorPageCC.getTitleText(), typeOfDoctorPageCC.titleExpected, "Title is diff");
        TypeOfTestsPageCC typeOfTestsPageCC = typeOfDoctorPageCC
                .clickOnAnswers("I do not see a doctor regularly")
                .clickNextButton(new TypeOfTestsPageCC());
        typeOfTestsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(typeOfDoctorPageCC.titleExpected, protocol2, protocol3)
                .back();
        typeOfDoctorPageCC
                .waitForPageLoad()
                .clickOnAnswers("Family doctor or general practitioner")
                .clickNextButton(typeOfTestsPageCC);



    }
}
