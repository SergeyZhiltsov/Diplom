package com.acurian.selenium.tests.ful;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class FULsValidation extends BaseTest {

    /*
    This class should follow after all screener tests
     */
    @Test()
    @Description("Validate all FULs sent during test session")
    public void validateFul() {
        FollowupLetter ful = new FollowupLetter();
        String env = System.getProperty("acurian.env", "STG");

        ful.assertAllFULs(env);
    }
}
