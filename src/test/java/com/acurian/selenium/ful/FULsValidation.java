package com.acurian.selenium.ful;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class FULsValidation extends BaseTest {

    /*
    This class should follow after all screener tests
     */
    @Test()
    @Description("Validate all FULs sent during test session")
    public void validateAllFuls() {
        FollowupLetter ful = new FollowupLetter();
        String env = System.getProperty("acurian.env", "STG");

        ful.assertAllFULs(env);
    }
}
