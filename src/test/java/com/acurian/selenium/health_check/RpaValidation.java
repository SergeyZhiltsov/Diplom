package com.acurian.selenium.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.rpa.RpaGeneratePage;
import com.acurian.selenium.pages.rpa.RpaLoginPage;
import com.acurian.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class RpaValidation extends BaseTest {

    @Test(priority = 1)
    @Description("RPA validation only for submit button is shown")
    public void rpaValidationTest() {
        String siteName = "AUT_GMEGA_New - Test PI";
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

        Assert.assertTrue(rpaGeneratePage.isSubmitButtonPresent(), "Submit button is not present , probably site does not have IDs");
//        Assert.assertTrue(rpaGeneratePage.isPidIncluded(pid), "Pid is "+pid+" not included");
    }
}
