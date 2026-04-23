package io.petstore.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.petstore.model.User;
import io.restassured.response.Response;
import org.json.JSONObject;

import static org.testng.Assert.*;

public class UserResponseValidation {

    public static void validateCreateUserResponse(Response response) {

        assertEquals(response.getStatusCode(), 200);

        JSONObject responseJson = new JSONObject(response.asString());
        assertEquals(responseJson.getInt("code"), 200);
        assertEquals(responseJson.getString("type"), "unknown");
        assertTrue(responseJson.has("message"));

    }

    public static void validateUpdateUserResponse(Response response) {

        assertEquals(response.getStatusCode(), 200);

        JSONObject responseJson = new JSONObject(response.asString());
        assertEquals(responseJson.getInt("code"), 200);
        assertEquals(responseJson.getString("type"), "unknown");
        assertTrue(responseJson.has("message"));

    }

    public static void validateGetUserResponse(Response response,
                                               String userName) throws JsonProcessingException {

        assertEquals(response.getStatusCode(), 200);

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(response.asString(), User.class);

        assertEquals(user.getUserName(), userName);
        assertNotNull(user.getId());
        assertNotNull(user.getFirstName());

    }

    public static void validateDeleteUserResponse(Response response) {

        assertEquals(response.getStatusCode(), 200);

        JSONObject responseJson = new JSONObject(response.asString());
        assertEquals(responseJson.getInt("code"), 200);
        assertEquals(responseJson.getString("type"), "unknown");
        assertTrue(responseJson.has("message"));

    }

}
