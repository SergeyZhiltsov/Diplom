package com.acurian.selenium.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.SubquestionLastReceivedPageOLS;
import com.acurian.selenium.pages.OLS.Derm.HaveYouEverTakenEitherAnyOfFollowingMeds_OLS;
import com.acurian.selenium.pages.OLS.GERD.HowLongHaveYouBeenTaking_OLS;
import com.acurian.selenium.pages.OLS.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_OLS;
import com.acurian.selenium.pages.OLS.RA.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RA_4835_OLS extends BaseTest {

    @Test(enabled = false)
    public void ra_4835_OLS() {
        Site site = Site.AUT_RA_4835_Site;
        String phoneNumberRA = "AUTAMS1RA1";
        String studyName = "a rheumatoid arthritis (RA)";
        String Siteindicator = "Rheumatoid Arthritis";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
//        dateOfBirthPageOLS.openPage(env, phoneNumberRA)
//                .waitForPageLoad();
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText().contains("Let's get started to see if you qualify for a rheumatoid arthritis (RA) study!"), true);
        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .setDate("03/21/2002") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .back();

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
               // .waitForPageLoad()
                .setDate("03/21/2001")
                .clickNextButton(new ZipCodePageOLS());


        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageOLS());

        DoYouSufferFromArthritis doYouSufferFromArthritis = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Male")
                .clickNextButton(new DoYouSufferFromArthritis());

        //Module RA
        //Q2
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No arthritis")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7102", site.activeProtocols)
                .back();
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        //Q3 Check if all checkbox option are available
                whatKindOfArthritisPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging",
                                "Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints",
                                "Psoriatic Arthritis",
                                "Unsure")
                        .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7103", site.activeProtocols)
                .back();

        WhereYouHaveArthritisOLS whereYouHaveArthritisOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                // Disqualify (“Psoriatic arthritis”)
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints",
                        "Psoriatic Arthritis",
                        "Unsure")
                .clickNextButton(new WhereYouHaveArthritisOLS());
        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7103", site.activeProtocols)
                .back();

        WhenYouDiagnosedWithRaPageOLS whenYouDiagnosedWithRaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging",
                        "Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints") //Check QR //If selected "RA", continue to Q4
                .clickNextButton(new WhenYouDiagnosedWithRaPageOLS()); //If selected "RA", continue to Q4

        //Q4
        AgeWhenDiagnosedWithRA ageWhenDiagnosedWithRA = whenYouDiagnosedWithRaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months") //Disqualify ("Recent RA diagnosis")
                .clickNextButton(new AgeWhenDiagnosedWithRA());
        ageWhenDiagnosedWithRA
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7104", site.activeProtocols)
                .back();

        whenYouDiagnosedWithRaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(ageWhenDiagnosedWithRA);
        //Q5
        AreYouCurrentlyExperiencing areYouCurrentlyExperiencing = ageWhenDiagnosedWithRA
                .waitForPageLoad()
                .setAge("16") //If age of onset is < 17, disqualify (“Juvenile RA”)
                .clickNextButton(new AreYouCurrentlyExperiencing());

        areYouCurrentlyExperiencing
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7105", site.activeProtocols)
                .back();

        ageWhenDiagnosedWithRA
                .waitForPageLoad()
                .setAge("18")
                .clickNextButton(areYouCurrentlyExperiencing);

        //Q6
        CurrentlyTakingMethotrexate currentlyTakingMethotrexate = areYouCurrentlyExperiencing
                .waitForPageLoad()
                .clickOnAnswer("No") //Disqualify ("No swollen/tender joints")
                .clickNextButton(new CurrentlyTakingMethotrexate());
        currentlyTakingMethotrexate
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(areYouCurrentlyExperiencing.titleExpected, site.activeProtocols)
                .back();

        areYouCurrentlyExperiencing
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(currentlyTakingMethotrexate);
        //Q7
        MedicationsToTreatYourRA medicationsToTreatYourRA = currentlyTakingMethotrexate
                .waitForPageLoad()
                .clickOnAnswer("I am not taking methotrexate") //Skip to Q9
                .clickNextButton(new MedicationsToTreatYourRA());
        //Q9
        medicationsToTreatYourRA
                .waitForPageLoad()
                .back(); //Back to Q7

        //Q7
       HowLongTakingMethotrexate howLongTakingMethotrexate = currentlyTakingMethotrexate
                .waitForPageLoad()
                .clickOnAnswer("Yes, I am taking methotrexate tablets or pills") //Continue to Q8
                .clickNextButton(new HowLongTakingMethotrexate());

        //Q8
       howLongTakingMethotrexate
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(medicationsToTreatYourRA);

        //Q9
        //Disqualify ("Excluded csDMARD")
        BiologicMedications biologicMedications = new BiologicMedications();
        HashMap<String, List<String>> disqualifyQ9 = new HashMap<>();
        disqualifyQ9.put("CellCept or Myfortic (mycophenolate mofetil)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Cuprimine or Depen (penicillamine)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Cytoxan (cyclophosphamide)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Imuran or Azasan (azathioprine)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Leukeran (chlorambucil)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Neoral, Gengraf, or Sandimmune (cyclosporine)", Arrays.asList(site.activeProtocols));
        disqualifyQ9.put("Gold salts such as Myochrysine, Solganal, or Ridaura (auranofin)", Arrays.asList(site.activeProtocols));
       for (Map.Entry<String, List<String>> entry : disqualifyQ9.entrySet()) {
            System.out.println(entry.getKey());
            medicationsToTreatYourRA
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(biologicMedications)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7109", site.activeProtocols)
                    .back();
        }

        //Continue to Q10
       HowLongHaveYouBeenTaking_OLS howLongHaveYouBeenTaking_OLS = medicationsToTreatYourRA
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Aralen (chloroquine)", "Arava (leflunomide)",
                        "Azulfidine or Sulfazine (sulfasalazine)", "Plaquenil (hydroxychloroquine)") //Continue to Q10
                .clickNextButton(new HowLongHaveYouBeenTaking_OLS());
        //Q10 Check that all Q10.1 - 10.4 displayed on the same page
       howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howLongHaveYouBeenTaking_OLS.titleExpected5)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_OLS.titleExpected6)
                .waitForPageLoad(3, howLongHaveYouBeenTaking_OLS.titleExpected7)
                .waitForPageLoad(4, howLongHaveYouBeenTaking_OLS.titleExpected8)
                .back();

        //Q9
       medicationsToTreatYourRA
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Arava (leflunomide)")
                //Disqualify in Q11	Ghost Question - RA csDMARD Protocol Logic:
                // ("Excluded csDMARD combo") if selected ["Yes, I am taking methotrexate tablets or pills" OR "Yes, I am taking methotrexate as injections or shots" in Q7] AND ["Arava (leflunomide)" in Q9]
                .clickNextButton(howLongHaveYouBeenTaking_OLS);
        //Q10.2
       howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howLongHaveYouBeenTaking_OLS.titleExpected6)
                .clickOnAnswerForSubQuestion(1, "Less than 1 month")
                .clickNextButton(biologicMedications);
       biologicMedications
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7111", site.activeProtocols)
                .back();
        //Back to Q9
       howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howLongHaveYouBeenTaking_OLS.titleExpected6)
                .back();
        //Q9
       medicationsToTreatYourRA
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Aralen (chloroquine)",
                        "Azulfidine or Sulfazine (sulfasalazine)")
                //Disqualify in Q11	Ghost Question - RA csDMARD Protocol Logic:
                //Disqualify ... OR 2 medications in Q9 AND ("Yes, I am taking methotrexate tablets or pills" OR "Yes, I am taking methotrexate as injections or shots" in Q7)"
                .clickNextButton(howLongHaveYouBeenTaking_OLS);
       howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howLongHaveYouBeenTaking_OLS.titleExpected5)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_OLS.titleExpected7)
                .clickOnAnswerForSubQuestion(1, "1 month")
                .clickOnAnswerForSubQuestion(2, "1 month")
                .clickNextButton(biologicMedications);
       biologicMedications
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7111", site.activeProtocols);

        //Back to Q7 to set "I am not taking methotrexate"
       biologicMedications
                .waitForPageLoad()
                .back();
       howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howLongHaveYouBeenTaking_OLS.titleExpected5)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_OLS.titleExpected7)
                .back();
       medicationsToTreatYourRA
                .waitForPageLoad()
                .back();
       medicationsToTreatYourRA
                .waitForPageLoad()
                .back();
        //Q7
       currentlyTakingMethotrexate
                .waitForPageLoad()
                .clickOnAnswer("I am not taking methotrexate") //Skip to Q9
                .clickNextButton(medicationsToTreatYourRA);
       medicationsToTreatYourRA
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                //Disqualify in Q11	Ghost Question - RA csDMARD Protocol Logic:
                //("3+ current csDMARDs") if selected: More than 2 medications in Q9 (3 or more csDMARDs)
                .clickOnAnswers("Aralen (chloroquine)",
                        "Azulfidine or Sulfazine (sulfasalazine)",
                        "Plaquenil (hydroxychloroquine)")
                .clickNextButton(howLongHaveYouBeenTaking_OLS);
        //Q10 Check that all Q10.1, Q10.3 and Q10.4 displayed on the same page
       howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howLongHaveYouBeenTaking_OLS.titleExpected5)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_OLS.titleExpected7)
                .waitForPageLoad(3, howLongHaveYouBeenTaking_OLS.titleExpected8)
                .clickOnAnswerForSubQuestion(1, "1 month")
                .clickOnAnswerForSubQuestion(2, "1 month")
                .clickOnAnswerForSubQuestion(3, "1 month")
                .clickNextButton(biologicMedications);
       biologicMedications
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7111", site.activeProtocols)
                .back();
        //Back to Q9
       howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howLongHaveYouBeenTaking_OLS.titleExpected5)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_OLS.titleExpected7)
                .waitForPageLoad(3, howLongHaveYouBeenTaking_OLS.titleExpected8)
                .back();

        //Q9
       medicationsToTreatYourRA
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                //Q From Q9: "Aralen (chloroquine)" OR "Arava (leflunomide)" OR "Azulfidine or Sulfazine (sulfasalazine)"
                // OR "Plaquenil (hydroxychloroquine)"
                //AND
                //From Q10.1 or Q10.2 or Q10.3 or Q10.4:
                //"1 month" OR "2 months" OR "3 months" OR "4 - 6 months" OR "7 months or longer"]"
                .clickOnAnswers("Azulfidine or Sulfazine (sulfasalazine)")
                .clickNextButton(howLongHaveYouBeenTaking_OLS);
        //Q10.3
       howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howLongHaveYouBeenTaking_OLS.titleExpected7)
                .clickOnAnswerForSubQuestion(1, "Less than 1 month")
                .clickNextButton(biologicMedications);
       biologicMedications
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEqualsForQNumber("QS7111", site.activeProtocols)
                .back();
       howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howLongHaveYouBeenTaking_OLS.titleExpected7)
                .clickOnAnswerForSubQuestion(1, "2 month")
                .clickNextButton(biologicMedications);

        //Q12
       SubquestionLastReceivedPageOLS subquestionLastReceivedPageOLS = biologicMedications
                .waitForPageLoad()
                .clickOnAnswers( //Select all values to check it presence in the page
                        "Actemra",
                        "Benlysta",
                        "Cimzia",
                        "Cosentyx",
                        "Enbrel",
                        "Entyvio",
                        "Humira",
                        "Kineret",
                        "Orencia",
                        "Prolia or Xgeva",
                        "Raptiva",
                        "Remicade",
                        "Rituxan", //Continue to Q13
                        "Simponi",
                        "Stelara",
                        "Taltz",
                        "Tysabri")
                .clickNextButton(new SubquestionLastReceivedPageOLS());
       subquestionLastReceivedPageOLS
                .waitForPageLoad(1, subquestionLastReceivedPageOLS.titleExpected16) //Q13
                .back();
       HaveYouEverTakenEitherAnyOfFollowingMeds_OLS haveYouEverTakenEitherAnyOfFollowingMeds_OLS = biologicMedications
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Disqualify ("No qualifying biologic therapy”)
                .clickNextButton(new HaveYouEverTakenEitherAnyOfFollowingMeds_OLS());
       haveYouEverTakenEitherAnyOfFollowingMeds_OLS
                .waitForPageLoad() //Q14
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7112", site.activeProtocols)
                .back();
        //Q12
       biologicMedications
                .waitForPageLoad()
                .clickOnAnswers("Actemra") //Skip to Q14
                .clickNextButton(haveYouEverTakenEitherAnyOfFollowingMeds_OLS);

        //Q14
        //Disqualify ("History of JAK inhibitor")
       HashMap<String, List<String>> disqualifyQ14 = new HashMap<>();
       disqualifyQ14.put("Jakafi", Arrays.asList(site.activeProtocols));
       disqualifyQ14.put("Olumiant", Arrays.asList(site.activeProtocols));
       disqualifyQ14.put("Xeljanz", Arrays.asList(site.activeProtocols));
       for (Map.Entry<String, List<String>> entry : disqualifyQ14.entrySet()) {
            System.out.println(entry.getKey());
            haveYouEverTakenEitherAnyOfFollowingMeds_OLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7114", site.activeProtocols)
                    .back();
        }
       haveYouEverTakenEitherAnyOfFollowingMeds_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

//-------------------New GENERAL HEALTH---------------------------
        //Q2: QS38
       DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder") //If exclusively selected, skip to Q24)
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        //Check flow logic for Q2
        //Q4: QS40
       doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();

       WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")//Select
                .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());
        //Q4: QS40
       whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .waitForPageLoad()
                .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis") //Disqualify ("Ankylosing spondylitis") if selected this option OR "Yes" in AS Q2
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

       doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS40", site.activeProtocols)
                .back();

        //Q4: QS40
       whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Gout") //Disqualify ("Gout")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

       doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS40", site.activeProtocols)
                .back();

       whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                .waitForPageLoad()
                .back(); //Back to Q2: QS38


       WhichOfFollowingHaveYouDiagnosedWithOLS whichOfFollowingHaveYouDiagnosedWithOLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)") //Deselect
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWithOLS());
        //Q5: QS41
       whichOfFollowingHaveYouDiagnosedWithOLS
                .waitForPageLoad()
                .back();

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")//Select
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        //Q6: QS42
       HashMap<String, List<String>> disqualifyQ6 = new HashMap<>();
       disqualifyQ6.put("Within the past 5 years", Arrays.asList(site.activeProtocols)); //Disqualify ("Cancer <= 5 years")
       disqualifyQ6.put("6 - 10 years ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Cancer > 5 years")
       disqualifyQ6.put("11 or more years ago", Arrays.asList(site.activeProtocols)); //Disqualify ("Cancer > 5 years")
       WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = new WhatKindOfDiabetesPageOLS();
       for (Map.Entry<String, List<String>> entry : disqualifyQ6.entrySet()) {
            System.out.println(entry.getKey());
           whenDiagnosedWithCancerOLS
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                    .back();
        }
        //Back to haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .back();

       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes (type 1 or type 2)")//Deselect
                .clickNextButton(new WhatKindOfDiabetesPageOLS());
        //Q6: QS42
                whatKindOfDiabetesPageOLS
                        .waitForPageLoad()
                        .back();

       WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Digestive disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)")
                .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());
        //Q8: QS44
       whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back();

       WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Headaches (migraine, cluster, tension)") //Select
                        .clickNextButton(new WhichTypeOfHeadacheDoYouGetOLS());
        //Q10: QS45
       whichTypeOfHeadacheDoYouGetOLS
                .waitForPageLoad()
                .back();

       HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)") //Select
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS());
        //Q11: QS46
       haveYouEverExperiencedHeartRelatedMedicalCondOLS
                .waitForPageLoad()
                .back();

       DoYouTakeAnyMedicationsControlHypertension_OLS doYouTakeAnyMedicationsControlHypertension_OLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("High blood pressure or hypertension") //Deselect
                        .clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_OLS());
        //Q15: QS50
       doYouTakeAnyMedicationsControlHypertension_OLS
                .waitForPageLoad()
                .back();

        //Q16: QS51
       WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
       whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
       doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
       whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();

       WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)") //Select
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
       //Q17: QS52
       whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .back();

       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                 .waitForPageLoad()
                 .clickOnAnswers("None of the above")
                 .clickOnAnswers("Lupus") //Disqualify ("Lupus")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
       doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();

       FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        //Q18: QS53
       followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back();

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());
        //Q19: QS54
       whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                .waitForPageLoad()
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back();
       whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Fibromyalgia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back();
       whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                .waitForPageLoad()
                .back();
       WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)") //Select
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());
        //Q20: QS55
       whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .back();

       WhichOfTheFollowingMensHealthConditions_OLS whichOfTheFollowingMensHealthConditions_OLS =
       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)") //Select
                .clickNextButton(new WhichOfTheFollowingMensHealthConditions_OLS());
        //Q22: QS57
       whichOfTheFollowingMensHealthConditions_OLS
                .waitForPageLoad()
                .back();

       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Men's health issues (prostate enlargement or BPH, low testosterone)") //Select
                        .clickNextButton(whichOfTheFollowingMensHealthConditions_OLS);
        //Q22: QS57
       whichOfTheFollowingMensHealthConditions_OLS
                .waitForPageLoad()
                .back();

       haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        //Flow for Q2: QS38 was checked

         //Q24: QS59
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers( //Select all to check quantity
                        "Bipolar disorder",
                        "Cancer in the past 5 years, except skin cancer",
                        "Cirrhosis",
                        "Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis C",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS)",
                        "Neuropathy (nerve damage due to diabetes or another condition)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia",
                        "None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());
        //Q28: QS60
        approximateHeightPageOLS
                .waitForPageLoad()
                .back();
        //Q24: QS59
        HashMap<String, List<String>> disqualifyQ24 = new HashMap<>();
        disqualifyQ24.put("Cancer in the past 5 years, except skin cancer", Arrays.asList(site.activeProtocols)); //Cancer in the past 5 years, except skin cancer
        disqualifyQ24.put("Drug or alcohol abuse within the past year", Arrays.asList(site.activeProtocols)); //Disqualify ("Substance abuse")
        disqualifyQ24.put("Hepatitis B", Arrays.asList(site.activeProtocols)); //Disqualify ("HBV")
        disqualifyQ24.put("Hepatitis C", Arrays.asList(site.activeProtocols)); //Disqualify ("HCV")
        disqualifyQ24.put("HIV or AIDS", Arrays.asList(site.activeProtocols)); //Disqualify ("HIV")
        //disqualifyQ24.put("Kidney disease requiring dialysis", Arrays.asList((site.activeProtocols))); //Disqualify ("Dialysis")
        for (Map.Entry<String, List<String>> entry : disqualifyQ24.entrySet()) {
            System.out.println(entry.getKey());
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(entry.getKey())
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59" , site.activeProtocols)
                    .back();
        }

        //Q24: QS59
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                //.clickNextButton(selectActionPageOLS)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}