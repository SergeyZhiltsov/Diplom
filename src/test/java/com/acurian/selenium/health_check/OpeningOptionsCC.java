package com.acurian.selenium.health_check;

import com.acurian.selenium.CC.PSA_5071_CC;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.utils.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class OpeningOptionsCC extends BaseTest {

    private static Logger Log = LogManager.getLogger(OpeningOptionsCC.class.getName());

    @Test
    @Description("Opening Options CC check")
    public void openingOptionsCC() {
        final String phoneNumber = "AUTGRA1UAP";
        final String loginStudyName = "GRA1";
        final String zipCode = "19901";
        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();

        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName(loginStudyName)
                .clickPopupStudy(loginStudyName)
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);

        Log.info("Clicking Call Back");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Call Back")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoadGmega()
                .back();

        Log.info("Clicking General Information");
        ThankYouCloseGeneralInformationPageCC thankYouCloseGeneralInformationPageCC = callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("General Information")
                .clickNextButton(new ThankYouCloseGeneralInformationPageCC());

        thankYouCloseGeneralInformationPageCC
                .waitForPageLoad()
                .back();

        Log.info("Clicking Media");
        callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Media")
                .clickNextButton(thankYouCloseGeneralInformationPageCC)
                .waitForPageLoad()
                .back();

        Log.info("Clicking Physician");
        callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Physician")
                .clickNextButton(new ThankYouClosePhysicianPageCC())
                .waitForPageLoad()
                .back();

        Log.info("Clicking Site Has Not Contacted Patient");
        callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Site Has Not Contacted Patient")
                .clickNextButton(new ThankYouCloseSiteContactPageCC())
                .waitForPageLoad()
                .back();

        Log.info("Clicking Opt-Out of Database");
        OptOutOfDatabaseClosePageCC optOutOfDatabaseClosePageCC = callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Opt-Out of Database")
                .clickNextButton(new OptOutOfDatabaseClosePageCC());
        ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = optOutOfDatabaseClosePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageCC());
        OptOutOfDatabaseIdentificationClosePageCC optOutOfDatabaseIdentificationClosePageCC = thankYouCloseSimplePageCC
                .waitForPageLoad()
                .back(optOutOfDatabaseClosePageCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new OptOutOfDatabaseIdentificationClosePageCC());
        DeceasedThankYouClosePageCC deceasedThankYouClosePageCC = optOutOfDatabaseIdentificationClosePageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new DeceasedThankYouClosePageCC());
        deceasedThankYouClosePageCC
                .waitForPageLoad()
                .back(optOutOfDatabaseIdentificationClosePageCC)
                .waitForPageLoad()
                .back(optOutOfDatabaseClosePageCC)
                .waitForPageLoad()
                .back();

        Log.info("Clicking Auto-Call Opt out");
        AutoCallOptOutIdentificationClosePageCC autoCallOptOutIdentificationClosePageCC = callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Auto-Call Opt out")
                .clickNextButton(new AutoCallOptOutIdentificationClosePageCC());
        autoCallOptOutIdentificationClosePageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", "9999999999")
                .clickNextButton(new AutoCallOptOutThankYouClosePageCC())
                .waitForPageLoad()
                .back(autoCallOptOutIdentificationClosePageCC)
                .waitForPageLoad()
                .back();

        Log.info("Clicking Person with Condition is Deceased");
        DeceasedIdentificationClosePageCC deceasedIdentificationClosePageCC = callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Person with Condition is Deceased")
                .clickNextButton(new DeceasedIdentificationClosePageCC());

        deceasedIdentificationClosePageCC
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", zipCode)
                .clickNextButton(deceasedThankYouClosePageCC)
                .waitForPageLoad()
                .back(deceasedIdentificationClosePageCC)
                .waitForPageLoad()
                .back();

        Log.info("Clicking Other - Write reason in Notes Section");
        callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Other - Write reason in Notes Section")
                .clickNextButton(thankYouCloseGeneralInformationPageCC)
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad();
    }
}
