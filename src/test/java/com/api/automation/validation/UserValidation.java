package com.api.automation.validation;

import io.restassured.response.Response;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;

public class UserValidation {

    public static void validateCreateUsersResponse(Response response) {

        assertEquals(200, response.getStatusCode());

        //Validate body
        JSONObject responseObject = new JSONObject(response.asString());

    }

    public static void validateUpdateUserResponse(Response response) {

        assertEquals(200, response.getStatusCode());

        //Validate body
        JSONObject responseObject = new JSONObject(response.asString());
    }

    public static void validateGetUserResponse(Response response) {

        assertEquals(200, response.getStatusCode());

        //Validate body
        JSONObject responseObject = new JSONObject(response.asString());
    }
}
