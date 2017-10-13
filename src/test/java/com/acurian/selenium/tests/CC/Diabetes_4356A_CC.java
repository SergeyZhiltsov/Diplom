package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class Diabetes_4356A_CC extends BaseTest{

    @Test
    @TestCaseId("00004")
    @Description("Diabetes_4356A_Synexus for CC")
    public void tc004Test() {
        String phoneNumberLBP = "AUTAMS1HFL";
        List<String> protocols = Arrays.asList("EFC14835", "ITCA 650_CLP_203","K_877_302","17530","EFC13794","NN2211_4315","NN9535_4269");
        String protocol1 = "17530";
        String protocol2 = "NN9535_4269";
        String protocol3 = "NN2211_4315";
        String protocol4 = "EFC13794";
        String protocol5 = "EFC14835";
        String protocol6 = "ITCA 650_CLP_203";
        String protocol7 = "K_877_302";
        String studyName = "Diabetes";//Diabetes study
        String siteName = "AUT_DIA_4356A";
        String debugSiteName = "QSC9004_4356A_AUT_MIG_4356A";
        String env = "STG";
        String zipCode = "19044";



    }

}
