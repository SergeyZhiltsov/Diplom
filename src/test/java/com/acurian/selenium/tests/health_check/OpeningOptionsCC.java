package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class OpeningOptionsCC extends BaseTest {

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

        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Call Back")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad()
                .back();

        ThankYouCloseGeneralInformationPageCC thankYouCloseGeneralInformationPageCC = callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("General Information")
                .clickNextButton(new ThankYouCloseGeneralInformationPageCC());

        thankYouCloseGeneralInformationPageCC
                .waitForPageLoad()
                .back();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Media")
                .clickNextButton(thankYouCloseGeneralInformationPageCC)
                .waitForPageLoad()
                .back();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Physician")
                .clickNextButton(new ThankYouClosePhysicianPageCC())
                .waitForPageLoad()
                .back();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Site Has Not Contacted Patient")
                .clickNextButton(new ThankYouCloseSiteContactPageCC())
                .waitForPageLoad()
                .back();

        OptOutOfDatabaseClosePageCC optOutOfDatabaseClosePageCC = callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Opt-Out of Database")
                .clickNextButton(new OptOutOfDatabaseClosePageCC());
        ThankYouCloseSimplePageCC thankYouCloseSimplePageCC = optOutOfDatabaseClosePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageCC());
        OptOutOfDatabaseIdentificationClosePageCC optOutOfDatabaseIdentificationClosePageCC = thankYouCloseSimplePageCC
                .waitForPageLoadV2()
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

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .clickOnAnswer("Other - Write reason in Notes Section")
                .clickNextButton(thankYouCloseGeneralInformationPageCC)
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad();
    }
}
