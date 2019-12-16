package com.specsavers.examples.stepdefinition;

import com.specsavers.examples.jsonobjects.SASPostBody;
import com.jayway.restassured.RestAssured;
import com.specsavers.examples.steplibrary.APIStepLib;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class APISteps {

    @Steps
    APIStepLib Generic_Step_Lib;
    SASPostBody postBody = new SASPostBody();

    @Given("^a clean session$")
    public void cleanSession() {

        try {
            RestAssured.reset();
        }catch (RuntimeException e) {

        }
    }

    @When("^a POST Request is performed (.*), (.*)$")
    public void aSASPOSTRequestIsPerformedData(String storeID, String slotID) {
        String json = postBody.returnMockBookBody(slotID, "2017-08-10");
        String endpoint = storeID + "/diary";
        Generic_Step_Lib.formatPostRequest(json, endpoint);
    }

    @And("^the response message is equal to (.*)$")
    public void theResponseMessageIsEqualToBooked(String assertResponseMessage) {

        Generic_Step_Lib.assert_Response_Message(assertResponseMessage);
    }

    @When("^a GET Request is performed for Weekly Diary (.*), (.*)$")
    public void aNegativeSASGETRequestIsPerformedForWeeklyDiaryStoreIDMarket(String store_id, String errorID) {
        Generic_Step_Lib.getJSONResponse(store_id + "/diary?date=2018-" + errorID + "&room_id=1&type=2000&days=1");
    }

    @Then("^the response status code is (.*)$")
    public void theResponseStatusCodeIs(int statusCode) {

        Generic_Step_Lib.assert_Response_Code(statusCode);
    }
}