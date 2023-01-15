package com.api.automation.validation;

import com.api.automation.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserValidation {

    public static void validateCreateUsersResponse(Response response) {

        assertEquals(200, response.getStatusCode());

        //Validate body
        JSONObject responseObject = new JSONObject(response.asString());
        assertEquals(200, responseObject.getInt("code"));
        assertTrue(responseObject.has("type"));
        assertTrue(responseObject.has("message"));

    }

    public static void validateUpdateUserResponse(Response response) {

        assertEquals(200, response.getStatusCode());

        //Validate body
        JSONObject responseObject = new JSONObject(response.asString());
        assertEquals(200, responseObject.getInt("code"));
        assertTrue(responseObject.has("type"));
        assertTrue(responseObject.has("message"));
    }

    public static void validateGetUserResponse(Response response, String userName) throws JsonProcessingException {

        assertEquals(200, response.getStatusCode());

        //Validate body
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(response.asString(), User.class);
        assertEquals(userName, user.getUsername());
    }
}
