package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AUTI_3973.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class AUT_3973_OLS extends BaseTest {

    @Test(enabled = true)
    @Description("Akcea_4691 OLS")
    public void AUT_3973_OLS_EmailAtPII() {
        Site site = Site.AUT_ROC_3973_site;
        String phoneNumber = "AUTAMS1ROC";
        String studyName = "an autism spectrum disorder";
        String siteIndication = "Autism";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("an autism spectrum disorder study", "800");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("an autism spectrum disorder study", "800"), "Title is diff");

        // --------------DOB Question------------
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                // ------------Disqualify (“Age < 18 years old”) if <18
                // -----------------------------------------
                .waitForPageLoad("an autism spectrum disorder study", "800")
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        lessThan18YearsOldPage_OLS
                .getPage(debugPageOLS).checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols).back();
        dateOfBirthPageOLS
                .waitForPageLoad("an autism spectrum disorder study", "800");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS.clickOnAnswer("Yes").clickNextButton(new ZipCodePageOLS());

        // --------------ZIP_CODE Question------------
        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        // --------------GENDER Question------------
        genderPageOLS
                .waitForPageLoad();
        HaveYouEverBeenToldByDoctorAutism_OLS haveYouEverBeenToldByDoctorAutism_OLS = genderPageOLS
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenToldByDoctorAutism_OLS());


        // --------------Q2: Have you ever been told by a doctor that you have
        // autism or an autism spectrum disorder?------------
        haveYouEverBeenToldByDoctorAutism_OLS
                .waitForPageLoad();
        //Assert.assertEquals(haveYouEverBeenToldByDoctorAutism_OLS.getTitleText(),haveYouEverBeenToldByDoctorAutism_OLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = haveYouEverBeenToldByDoctorAutism_OLS
                .clickOnAnswer("No, my doctor has not told me that I have autism or an autism spectrum disorder")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS.waitForPageLoad();
        debugPageOLS
                .checkProtocolsContainsForQNumber("QS5902", site.activeProtocols)
                .back();
        InThePast3MonthsHaveYouExperienced_OLS inThePast3MonthsHaveYouExperienced_OLS = haveYouEverBeenToldByDoctorAutism_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, my doctor has told me that I have autism or an autism spectrum disorder")
                .clickNextButton(new InThePast3MonthsHaveYouExperienced_OLS());


        // --------------Q3: In the past three months, have you experienced any
        // of the following?------------
        inThePast3MonthsHaveYouExperienced_OLS
                .waitForPageLoad();
        Assert.assertEquals(inThePast3MonthsHaveYouExperienced_OLS.getTitleText(), inThePast3MonthsHaveYouExperienced_OLS.titleExpected, "Title is diff");
        inThePast3MonthsHaveYouExperienced_OLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouHadSeizureInLast6Mon_OLS()).waitForPageLoad().getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5903", site.activeProtocols).back();
        inThePast3MonthsHaveYouExperienced_OLS
                .waitForPageLoad();
        HaveYouHadSeizureInLast6Mon_OLS haveYouHadSeizureInLast6Mon_OLS = inThePast3MonthsHaveYouExperienced_OLS
                .clickOnAnswers("Trouble understanding what other people are feeling",
                        "Trouble understanding facial expressions or what other preople want",
                        "Trouble communicating feelings to others, or being able to keep up with conversations",
                        "Trouble starting conversations with other people, or wanting to be alone instead of being with other people",
                        "Trouble with changes in routine, or preoccupation with certain topics or items")
                .clickNextButton(new HaveYouHadSeizureInLast6Mon_OLS());


        // --------------Q4: Have you had a seizure in the last 6
        // months?------------
        haveYouHadSeizureInLast6Mon_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouHadSeizureInLast6Mon_OLS.getTitleText(), haveYouHadSeizureInLast6Mon_OLS.titleExpected, "Title is diff");
        haveYouHadSeizureInLast6Mon_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverHadAnIQtest_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5904", site.activeProtocols)
                .back();
        haveYouHadSeizureInLast6Mon_OLS
                .waitForPageLoad();
        HaveYouEverHadAnIQtest_OLS haveYouEverHadAnIQtest_OLS = haveYouHadSeizureInLast6Mon_OLS.clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadAnIQtest_OLS());


        // --------------Q5: Have you ever had an IQ test? It is also called an
        // intelligence test.-----------
        haveYouEverHadAnIQtest_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverHadAnIQtest_OLS.getTitleText(), haveYouEverHadAnIQtest_OLS.titleExpected, "Title is diff");
        // Skip to Q7 if selected other than "Yes", otherwise continue to Q6
        haveYouEverHadAnIQtest_OLS
                .clickOnAnswer("Unsure")
                .clickOnAnswer("No")
                .clickNextButton(new DoYouKnowSomeoneStudyPartner_OLS())
                .waitForPageLoad()
                .back();
        haveYouEverHadAnIQtest_OLS
                .waitForPageLoad();
        HowDidYouScoreOnTheTest_OLS howDidYouScoreOnTheTest_OLS = haveYouEverHadAnIQtest_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HowDidYouScoreOnTheTest_OLS());


        // --------------Q6: How did you score on the test?---------
        howDidYouScoreOnTheTest_OLS
                .waitForPageLoad();
        Assert.assertEquals(howDidYouScoreOnTheTest_OLS.getTitleText(), howDidYouScoreOnTheTest_OLS.titleExpected, "Title is diff");
        howDidYouScoreOnTheTest_OLS
                .clickOnAnswer("Below 70")
                .clickNextButton(new DoYouKnowSomeoneStudyPartner_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS5906", site.activeProtocols)
                .back();
        howDidYouScoreOnTheTest_OLS
                .waitForPageLoad();
        DoYouKnowSomeoneStudyPartner_OLS doYouKnowSomeoneStudyPartner1_OLS = haveYouEverHadAnIQtest_OLS
                .clickOnAnswer("I am not sure")
                .clickOnAnswer("90 to 109")
                .clickOnAnswer("70 to 89")
                .clickOnAnswer("110 or more")
                .clickNextButton(new DoYouKnowSomeoneStudyPartner_OLS());


        // ----------Q7: Do you know someone a person that you usually regularly
        // spend time with (for example, a parent or spouse) who can would be
        // able to attend visits with you as a study partner?
        doYouKnowSomeoneStudyPartner1_OLS
                .waitForPageLoad();
        Assert.assertEquals(doYouKnowSomeoneStudyPartner1_OLS.getTitleText(), doYouKnowSomeoneStudyPartner1_OLS.titleExpected, "Title is diff");
        doYouKnowSomeoneStudyPartner1_OLS
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


        // ----------Q8: Ghost Question - Autism End of module logic----------
        // If in Call Center AND if General Health Module not answered ==> Go to
        // Transition Statement
        // If in OLS, Go to Decision Module Q1


        //----------------------GENERAL HEALTH Questions -----------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Kidney disease",
                        "Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());


        //----CANCER DQ Check----------
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer") // Un-Check 'Cancer'
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());


        //----KIDNEY DQ Check----------
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad();
        FollowingMentalEmotionalHealthPageOLS following_MentalEmotionalHealthPageOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                // ---DQ if selected "Dialysis"-----
                .clickOnAnswers("Dialysis", "Kidney transplant")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
        following_MentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());


        //----Check mental or emotional health condition DQ check----
        following_MentalEmotionalHealthPageOLS
                .waitForPageLoad();
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = following_MentalEmotionalHealthPageOLS
                // ---DQ if selected "Dialysis"-----
                .clickOnAnswers("Bipolar disorder", "Schizophrenia")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                .back();
        following_MentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        //----Do any of the following additional diagnoses apply to you? ------------
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad();
        //HormonalBirthControlOLS hormonalBirthControlOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis C",
                        "HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());


        //----HEIGHT and WEIGHT Question ------------
        approximateHeightPageOLS
                .waitForPageLoad()
                //EthnicBackgroundPageOLS ethnicBackgroundPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
//                .clickNextButton(new EthnicBackgroundPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                //----------SiteSelection Page--------------------
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
//                .clickNextButton(new HSGeneralPageOLS())
//                .waitForPageLoadEmailNotProvided()
                .clickNextButton(new MedicalRecordsOptionPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
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
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}