package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.HFL_4722.HeartTransplantPageOLS;
import com.acurian.selenium.pages.OLS.HFL_4722.SymptomsOfHeartFailurePageOLS;
import com.acurian.selenium.pages.OLS.HFL_4722.TreatYourHeartFailurePageOLS;
import com.acurian.selenium.pages.OLS.Vaccine.AreYouInterestedVaccineResearchStudyOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class HFL_4722_OLS extends BaseTest {

    @Test
    @Description("Heart_Failure 4722 OLS")
    public void hfl4722olsTest() {
        Site site = Site.AUT_HFL_4722_Site;
        String phoneNumber = "AUTAMS1HFL";
        String studyName = "a heart failure";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a heart failure study", "500"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        CongestiveHeartFailurePageOLS congestiveHeartFailurePageOLS = genderPageOLS
                .setDate("09091940")
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
                .checkProtocolsEqualsForQNumber("QS6402", site.activeProtocols)
                .back();
        congestiveHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I have experienced other heart problems, but not CHF")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS6402", site.activeProtocols)
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
                .checkProtocolsEqualsForQNumber("QS6403", site.activeProtocols)
                .back();
        symptomsOfHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("I have some mild symptoms when going about my normal daily activities")
                .clickNextButton(treatYourHeartFailurePageOLS);

        HeartTransplantPageOLS heartTransplantPageOLS = treatYourHeartFailurePageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HeartTransplantPageOLS());
//        heartTransplantPageOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsEqualsForQNumber("QS6404", protocol1)
//                .back();
//        treatYourHeartFailurePageOLS
//                .waitForPageLoad()
//                .clickOnAnswer("Yes")
//                .clickNextButton(heartTransplantPageOLS);

        heartTransplantPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS6405", site.activeProtocols)
                .back();
        heartTransplantPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //TO DQ for 4450_EX9536-4388 (CV)
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .setAll("5", "5", "170")
                .clickNextButton(new AreYouInterestedVaccineResearchStudyOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS66", site.activeProtocols)
                .back(new ApproximateHeightPageOLS())
                .setLbs("190")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SynexusHealthyMindsPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, I am not interested in receiving information")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
