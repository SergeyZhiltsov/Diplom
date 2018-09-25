package com.acurian.selenium.tests.CC;

import org.testng.annotations.Test;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.utils.DataProviderPool;

public class SAR_3793_CC extends BaseTest {

    @Test(enabled = false, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    public void AS_4319_cc(final String username, final String password) {

    }


}
