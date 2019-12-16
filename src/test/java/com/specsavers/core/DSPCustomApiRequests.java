package com.specsavers.core;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class DSPCustomApiRequests extends ScenarioSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(DSPCustomApiRequests.class);
    private DSPSpecificHeaders DSPheaders = new DSPSpecificHeaders();
    private Response response;
    String returnedResponseBody = new String();


    public String POSTMethod(String json, String url, String apiKey) {
        try {
            response = SerenityRest
                    .given()
                    .headers(DSPheaders.getHeaders(apiKey))
                    .baseUri(url)
                    .body(json)
                    .post();
            returnedResponseBody=response.getBody().asString();
        }catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        assertThat(returnedResponseBody).isNotBlank();
        return returnedResponseBody;
    }

    public String GETMethod(String url, String apiKey) {
        try {
            response = SerenityRest.given()
                    .headers(DSPheaders.getHeaders(apiKey))
                    .get(url);
            returnedResponseBody=response.getBody().asString();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        assertThat(returnedResponseBody).isNotBlank();
        return returnedResponseBody;
    }

    public String DELETEMethod(String url, String apiKey) {
        try {
            response = SerenityRest.given().headers(DSPheaders.getHeaders(apiKey))
                    .delete(url);
            returnedResponseBody=response.getBody().asString();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        assertThat(returnedResponseBody).isNotBlank();
        return returnedResponseBody;
    }
}