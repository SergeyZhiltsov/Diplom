package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.outer.AcurianHealthPage;
import com.acurian.selenium.pages.outer.OlsLegacyDateOfBirthPage;
import com.acurian.selenium.pages.outer.OlsLegacyNumberPage;
import com.acurian.selenium.pages.outer.TheStudyPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class WLPvalidation extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @Description("WLP URL Validation & Re-direct Validation, only for PROD")
    public void wlpOlsTest() {
        String phoneNumber = "AUTGMEGA01";

        TheStudyPage theStudyPage = new TheStudyPage();
        theStudyPage
                .openPage()
                .waitForPageLoad();
        Assert.assertEquals(theStudyPage.getTitleText(), "Have MIGRAINES?", "Title text is diff");
        theStudyPage
                .clickGetStartedButton();

        OlsLegacyNumberPage olsLegacyNumberPage = new OlsLegacyNumberPage();
        OlsLegacyDateOfBirthPage olsLegacyDateOfBirthPage = olsLegacyNumberPage
                .waitForPageLoad()
                .typePhone(phoneNumber)
                .clickGoButton();

        olsLegacyDateOfBirthPage
                .waitForPageLoad();
    }

    @Test
    @Description("WLP URL Validation & Re-direct Validation, only for PROD")
    public void wlpOlsWsTest() {

        AcurianHealthPage acurianHealthPage = new AcurianHealthPage();
        DateOfBirthPageOLS dateOfBirthPageOLS = acurianHealthPage
                .openPage()
                .waitForPageLoad()
                .clickSeeIfYouQualifyButton()
                .switchTab();
        dateOfBirthPageOLS
                .waitForPageLoad2Ver();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextVer3(), dateOfBirthPageOLS.getExpectedModifiedTitle("a study", "1,000", true), "Title is diff");
    }
}
