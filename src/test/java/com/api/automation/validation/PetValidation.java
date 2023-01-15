package com.api.automation.validation;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;

public class PetValidation {

    public static void validateCreatePetResponse(Response response) {

        assertEquals(200, response.getStatusCode());

        //Validate body
        JSONObject responseObject = new JSONObject(response.asString());

    }

    public static void validateUpdatePetResponse(Response response) {

        assertEquals(200, response.getStatusCode());

        //Validate body
        JSONObject responseObject = new JSONObject(response.asString());
    }

    public static void validateGetPetResponse(Response response) {

        assertEquals(200, response.getStatusCode());

        //Validate body
        JSONArray responseArray = new JSONArray(response.asString());
    }
}
