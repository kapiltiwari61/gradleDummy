package com.specsavers.examples.stepdefinition;

import com.specsavers.examples.steplibrary.UIStepLib;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.Scenario;
import net.thucydides.core.annotations.Steps;
import java.io.FileNotFoundException;

public class UISteps {

    @Steps
    private UIStepLib UIStepLib;
    private Scenario Scenario;

    @Given("^user has accessed (.*) Version GDPR Landing Page (.*), (.*)$")
    public void userHasAccessedTST1GDPRLandingPageRegionDOB(String base, String region, int age) throws FileNotFoundException {

        UIStepLib.GDPR_Navigation(region,age,base);
    }

    @And("^user has accessed GDPR Landing Page for Under 16$")
    public void userHasAccessedGDPRLandingPageForUnder16() {

        UIStepLib.assert_Next_Button_Not_Clickable();
        UIStepLib.click_Acting_On_Behalf_Danger();
    }

    @And("^user submits application$")
    public void userSubmitsApplication() {
        UIStepLib.update_Right_to_Withdraw_Screen();
    }

    @Then("^user will get confirmation screen$")
    public void userWillGetConfirmationScreen(){
        UIStepLib.assert_Confirmation_Screen();
    }

    @When("^user navigates through GDPR Application with (.*) Responses$")
    public void userNavigatesThroughGDPRApplicationWithResponses(String responses) {

        UIStepLib.update_Application_With_Responses(responses);
    }

    @When("^Consent on Behalf is Given$")
    public void consentOnBehalfIsGiven()  {
        UIStepLib.create_Consent("Automation", "Test");
        UIStepLib.assert_Date();
        UIStepLib.click_Consent_Submit();
    }

    @And("^consent has been persisted (.*), (.*), (.*)$")
    public void consentHasBeenPersistedRegionDOB(String region, int age, String link)  {
        UIStepLib.navigate_to_Consent_Page(region, age, link);
        UIStepLib.assert_Consent_Stored();
    }
}
