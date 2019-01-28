package com.acurian.selenium.tests.ful;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class FULsValidation extends BaseTest {

    @Test(priority = 99)
    @Description("Validate all FULs sent during test session")
    public void validateFul() {
        FollowupLetter ful = new FollowupLetter();
        String env = System.getProperty("acurian.env", "STG");
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, "AUTAMS1AKC")
                .waitForPageLoadGROUP()
                .maximizePage();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGROUP(), dateOfBirthPageOLS.titleAKC_4691_Expected, "Title is diff");

        //--------------DOB Question------------
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        //--------------ZIP_CODE Question------------
        zipCodePageOLS
                .waitForPageLoad();

        zipCodePageOLS
                .queueStudyForFULCheck("AUT_VAC_4556_Site");

        ful.assertFULDbRecords(env);

    }
}
