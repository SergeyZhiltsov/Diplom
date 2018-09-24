package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.HFL_4722.HeartTransplantPageOLS;
import com.acurian.selenium.pages.OLS.HFL_4722.SymptomsOfHeartFailurePageOLS;
import com.acurian.selenium.pages.OLS.HFL_4722.TreatYourHeartFailurePageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class HFL_4722_OLS extends BaseTest {

    @Test
    @TestCaseId("00017")
    @Description("Heart_Failure 4722 OLS")
    public void hfl4722olsTest() {
        String phoneNumber = "AUTAMS1HFL";
        List<String> protocols = Arrays.asList("EFC14822");
        String protocol1 = "C1973_204";
        String studyName = "a heart failure";
        String siteName = "AUT_HFL_4722_Site";
        String zipCode = "19044";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleHeartFailure4722_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091940")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        CongestiveHeartFailurePageOLS congestiveHeartFailurePageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new CongestiveHeartFailurePageOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = congestiveHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS6402", protocol1)
                .back();
        congestiveHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I have experienced other heart problems, but not CHF")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS6402", protocol1)
                .back();
        SymptomsOfHeartFailurePageOLS symptomsOfHeartFailurePageOLS = congestiveHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new SymptomsOfHeartFailurePageOLS());

        TreatYourHeartFailurePageOLS treatYourHeartFailurePageOLS = symptomsOfHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I do not have any symptoms when going about my normal daily activities")
                .clickNextButton(new TreatYourHeartFailurePageOLS());
        treatYourHeartFailurePageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS6403", protocol1)
                .back();
        symptomsOfHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I have some mild symptoms when going about my normal daily activities")
                .clickNextButton(treatYourHeartFailurePageOLS);

        HeartTransplantPageOLS heartTransplantPageOLS = treatYourHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartTransplantPageOLS());
        heartTransplantPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS6404", protocol1)
                .back();
        treatYourHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(heartTransplantPageOLS);

        heartTransplantPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS6405", protocol1)
                .back();
        heartTransplantPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS6405", protocol1)
                .back(new ApproximateHeightPageOLS())
                .setLbs("250")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new SynexusHealthyMindsPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);

    }
}
