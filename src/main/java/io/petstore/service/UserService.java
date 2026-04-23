package io.petstore.service;

import io.petstore.util.ReadEnv;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserService {

    static String petStoreServiceBaseUrl = ReadEnv.getProperty("petStoreServiceBaseUrl");

    public static Response creteUser(String createUserRequestBody) {

        String createUserEndPoint = "/v2/user";

        Map<String, String> headers  = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(petStoreServiceBaseUrl)
                .setBasePath(createUserEndPoint)
                .addHeaders(headers)
                .setBody(createUserRequestBody)
                .build();

        Response response = given(requestSpecification)
                .log()
                .all()

                .post()
                .then()

                .log()
                .all()

                .extract()
                .response();

        return response;

    }

    public static Response updateUser(String userName,
                                      String updateUserRequestBody) {

        String updateUserEndPoint = "/v2/user/{userName}";

        Map<String, String> headers  = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(petStoreServiceBaseUrl)
                .setBasePath(updateUserEndPoint)
                .addPathParam("userName", userName)
                .addHeaders(headers)
                .setBody(updateUserRequestBody)
                .build();

        Response response = given(requestSpecification)
                .log()
                .all()

                .put()

                .then()
                .log()
                .all()

                .extract()
                .response();

        return response;

    }

    public static Response getUser(String userName, Map<String, String> headers) {

        String getUserEndPoint = "/v2/user/{userName}";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(petStoreServiceBaseUrl)
                .setBasePath(getUserEndPoint)
                .addPathParam("userName", userName)
                .addHeaders(headers)
                .build();

        Response response = given(requestSpecification)
                .log()
                .all()

                .get()

                .then()
                .log()
                .all()

                .extract()
                .response();

        return response;

    }

    public static Response deleteUser(String userName, Map<String, String> headers) {

        String deleteUserEndPoint = "/v2/user/{userName}";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(petStoreServiceBaseUrl)
                .setBasePath(deleteUserEndPoint)
                .addPathParam("userName", userName)
                .addHeaders(headers)
                .build();

        Response response = given(requestSpecification)
                .log()
                .all()

                .delete()

                .then()
                .log()
                .all()

                .extract()
                .response();

        return response;

    }
}
