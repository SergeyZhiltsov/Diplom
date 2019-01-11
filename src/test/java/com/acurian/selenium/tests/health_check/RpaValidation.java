package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.rpa.RpaGeneratePage;
import com.acurian.selenium.pages.rpa.RpaLoginPage;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class RpaValidation extends BaseTest {

    @Test
    @Description("RPA validation only for submit button is shown")
    public void rpaValidationTest() {
        String siteName = "AUT_GRA_FUL - OriFName OriLName";
        String projectName = "GRA1-Rheumatoid Arthritis (RA) ";
        String pid = "63323079";

        String env = System.getProperty("acurian.env", "STG");

        RpaLoginPage rpaLoginPage = new RpaLoginPage();
        RpaGeneratePage rpaGeneratePage = rpaLoginPage
                .openPage(env)
                .waitForPageLoad()
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton()
                .waitForPageLoad()
                .clickGenerateLink()
                .clickOnBySite()
                .waitForPageLoad()
                .clickSelectProjectByName(projectName)
                .clickSelectSiteByName(siteName);

        Assert.assertTrue(rpaGeneratePage.isSubmitButtonPresent(), "Submit button is not present , probably site doestnot have IDs");
//        Assert.assertTrue(rpaGeneratePage.isPidIncluded(pid), "Pid is "+pid+" not included");
    }
}
