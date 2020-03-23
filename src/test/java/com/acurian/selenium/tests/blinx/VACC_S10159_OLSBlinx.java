package com.acurian.selenium.tests.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.blinx.ams.vaccine.AreYouInterestedInVaccineStudyOLS;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class VACC_S10159_OLSBlinx extends BaseTest {


    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_S10159}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("VACC_S10159_BLINX FBP00004 (Sanofi Flu Vaccine)")
    public void vaccS10159BlinxTest(Site site) {
        final String phoneNumber = "AUTAMS1VAC";
        final String studyName = "a vaccine study";
        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a vaccine study", "650")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS())
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS())
                .waitForPageLoad()
                .setDate("05051985")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS);


    }
}
