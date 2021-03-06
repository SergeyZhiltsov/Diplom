package com.acurian.selenium.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.outer.AcurianHealthPage;
import com.acurian.selenium.pages.outer.OlsLegacyDateOfBirthPage;
import com.acurian.selenium.pages.outer.OlsLegacyNumberPage;
import com.acurian.selenium.pages.outer.TheStudyPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.util.ArrayList;

public class WLPvalidation extends BaseTest {



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

        acurianHealthPage
                .openPage()
                .waitForPageLoad()
                .clickSeeIfYouQualifyButton();

        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());

        getDriver().switchTo().window(tabs2.get(1));

        String title = getDriver().getTitle();

        if (title.equals("Acurian Clinical Screener")) { //OLS-WS
            com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS dateOfBirthPageOLS = new com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS();
            dateOfBirthPageOLS.logTextToAllureAndConsole("OLS-WS");
            dateOfBirthPageOLS.waitForPageLoad("a study", "1,000");
            Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.
                    getExpectedModifiedTitle("a study", "1,000"), "Title is diff");
        } else if (title.equals("Screener")) { //BLINX
            DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
            dateOfBirthPageOLS.logTextToAllureAndConsole("BLINX");
            dateOfBirthPageOLS.waitForPageLoad("a study", "1,000");
        } else {
            Assert.assertTrue(false, "Nor OLS-WS, nor BLINX");
        }
    }
}



