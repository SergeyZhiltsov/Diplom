package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.DoctorInformationCollectionPageOLS;
import com.acurian.selenium.pages.OLS.closes.HS1PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class END_4385_OLS extends BaseTest {

    @Test
    @Description("a cluster headache study 3237 - OLS")
    public void end4385ols() {
        Site site = Site.AUT_END_4385;
        String phoneNumber = "AUTAMS1END";
        String studyName = "an endometriosis";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("an endometriosis study", "1775"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        FollowingGynecologicalConditionOLS followingGynecologicalConditionOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new FollowingGynecologicalConditionOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4902", site.activeProtocols)
                .back();
        TreatYourEndometriosisPageOLS treatYourEndometriosisPageOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Endometriosis")
                .clickNextButton(new TreatYourEndometriosisPageOLS());

        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .back();
        DiagnoseYourEndometriosisOLS diagnoseYourEndometriosisOLS = treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Ultrasound")
                .clickNextButton(new DiagnoseYourEndometriosisOLS());
        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4928", site.activeProtocols)
                .back();
        treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickOnAnswers("CT scan")
                .clickNextButton(diagnoseYourEndometriosisOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4928", site.activeProtocols)
                .back();
        treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I have never had a procedure to confirm my diagnosis or treat my endometriosis")
                .clickOnAnswers("MRI")
                .clickNextButton(diagnoseYourEndometriosisOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4928", site.activeProtocols)
                .back();
        treatYourEndometriosisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Surgery, but unsure what type",
                        "Laparoscopy, which is a surgical procedure in which a scope is inserted through a small cut in the abdomen",
                        "Laparotomy, which is a surgical procedure in which a large cut is made into the abdomen",
                        "Seen or biopsied during an examination of the vagina, cervix, or other location (such as a cesarean section scar)")
                .clickNextButton(diagnoseYourEndometriosisOLS);

        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(haveYouGoneThroughMenopauseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4921", site.activeProtocols)
                .back();
        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(haveYouGoneThroughMenopauseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4921", site.activeProtocols)
                .back();
        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(haveYouGoneThroughMenopauseOLS);

        HaveYouHadHysterectomyOLS haveYouHadHysterectomyOLS = haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4905", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                .clickNextButton(haveYouHadHysterectomyOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4905", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(haveYouHadHysterectomyOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4905", site.activeProtocols)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouHadHysterectomyOLS);

        haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4906", site.activeProtocols)
                .back();
        PlzDescribeYourMenstrualCyclesOLS plzDescribeYourMenstrualCyclesOLS = haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PlzDescribeYourMenstrualCyclesOLS());

        ApproxHowManyDaysInYourMenstrualCycle_OLS approxHowManyDaysInYourMenstrualCycle_OLS = plzDescribeYourMenstrualCyclesOLS
                .waitForPageLoad()
                .clickOnAnswer("Never regular")
                .clickNextButton(new ApproxHowManyDaysInYourMenstrualCycle_OLS());

        HowManyTimesDidYouGetYourPeriodInThreeMons_OLS howManyTimesDidYouGetYourPeriodInThreeMons_OLS = approxHowManyDaysInYourMenstrualCycle_OLS
                .waitForPageLoad()
                .setDays("15")
                .clickNextButton(new HowManyTimesDidYouGetYourPeriodInThreeMons_OLS());

        PelvicPainOLS pelvicPainOLS = howManyTimesDidYouGetYourPeriodInThreeMons_OLS
                .waitForPageLoad()
                .clickOnAnswer("Did not get period at all in the past 3 months")
                .clickNextButton(new PelvicPainOLS());

        PelvicPainOtherTimesOLS pelvicPainOtherTimesOLS = pelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PelvicPainOtherTimesOLS());
        pelvicPainOtherTimesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4908", site.activeProtocols)
                .back();
        DescribesPelvicPainOLS describesPelvicPainOLS = pelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesPelvicPainOLS());

        describesPelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(new PelvicPainOtherTimesOLS());

        HormonalBirthControlOLS hormonalBirthControlOLS = pelvicPainOtherTimesOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HormonalBirthControlOLS());
        hormonalBirthControlOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4923", site.activeProtocols)
                .back();
        DescribesNonMenstrualPelvicPainOLS describesNonMenstrualPelvicPainOLS = pelvicPainOtherTimesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesNonMenstrualPelvicPainOLS());

        describesNonMenstrualPelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(new HormonalBirthControlOLS());

        DiagnosedWithGynecologicalConditionOLS diagnosedWithGynecologicalConditionOLS = hormonalBirthControlOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithGynecologicalConditionOLS());
        diagnosedWithGynecologicalConditionOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS4925", site.activeProtocols)
                .back();
        BirthControlMethodPageOLS birthControlMethodPageOLS = hormonalBirthControlOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BirthControlMethodPageOLS());

        birthControlMethodPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(diagnosedWithGynecologicalConditionOLS);

        AreYouCurrentlyPregnantOLS areYouCurrentlyPregnantOLS = diagnosedWithGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Vaginismus, also known as vaginal muscle spasm")
                .clickNextButton(new AreYouCurrentlyPregnantOLS());

        areYouCurrentlyPregnantOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4916", site.activeProtocols)
                .back();
        areYouCurrentlyPregnantOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        //----------*******NEW GENERAL HEALTH Questions********----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();

/*                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
                .waitForPageLoad()
                .connectBTN()
                .switchToAPI()
                .waitForProvider()
                .clickANY()
                .waitSearchAll()
                .search("cleveland clinic")
                .waitProvider()
                .clickProvider()
                .typeUserName("democlinical@gmail.com")
                .typePWD("password")
                .clickConnect()

                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS())*/

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}