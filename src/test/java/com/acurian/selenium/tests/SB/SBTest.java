package com.acurian.selenium.tests.SB;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.SB.HomePage;
import com.acurian.selenium.pages.SB.LoginSBPage;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class SBTest extends BaseTest {

    final String study = "AUTSBMG - Research Study (Copy)";

    @Test(dataProvider = "SBUserCredentials", dataProviderClass = DataProviderPool.class)
    @Description("SBClear test")
    public void checkSb(String username, String password) {
        String env = System.getProperty("acurian.env", "QA");

        LoginSBPage loginSBPage = new LoginSBPage();

        loginSBPage.openPage(env).loginAs(username, password)
                .searchForStudy(study)
                .clickOnStudyName(study)
                .deleteIndication("Arthritis")
                .clickSave()
                .checkSaveAlertMessage("AUTSBMG saved Successfully")
                .clickDashboard()
                .clickPublishStudySetup(study, HomePage.SetupEnv.valueOf(env))
                .clickPublish()
                .clickOnSaveAndPublish()
                .clickConfirmPublishOnPopUp()
                .checkAlertMessage("");
    }

}
