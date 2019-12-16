package com.specsavers.examples.steplibrary;

import com.specsavers.core.DSPCustomApiRequests;
import com.specsavers.core.Properties;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.steps.ScenarioSteps;
import org.springframework.util.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class APIStepLib extends ScenarioSteps {

    private String JSONResponseBody = new String();
    private DSPCustomApiRequests DSPcustomApiRequests = new DSPCustomApiRequests();
    private String AWSVersion = Properties.SASAWSVersion();
    private String AWSKey = Properties.SASAWSKey();

    public void getJSONResponse(String endpoint)
    {
        StringBuilder url = new StringBuilder();
        String host = AWSVersion;
        url.append(host); url.append(endpoint);
        JSONResponseBody = DSPcustomApiRequests.GETMethod(url.toString(),AWSKey);
    }

    public void assert_Response_Message(String ResultSearch)
    {
        assertThat(StringUtils.countOccurrencesOf(JSONResponseBody,ResultSearch)).isGreaterThan(0);
    }

    public void formatPostRequest(String json, String endpoint) {
        StringBuilder url = new StringBuilder();
        String host = AWSVersion;
        url.append(host); url.append(endpoint);
        JSONResponseBody = DSPcustomApiRequests.POSTMethod(json, url.toString(),AWSKey);
    }

    public void assert_Response_Code(int statusCode)
    {
        assertThat(SerenityRest.then().extract().statusCode()).isEqualTo(statusCode);
    }
}