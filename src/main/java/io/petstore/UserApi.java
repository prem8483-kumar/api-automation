package io.petstore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserApi {

    public static void creteUser() {

        String petStoreServiceBaseUrl = "https://petstore.swagger.io";
        String createUserEndPoint = "/v2/user";

        Map<String, String> headers  = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");

        String createUserRequestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"string\",\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

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

    }

    public static void updateUser() {

        String petStoreServiceBaseUrl = "https://petstore.swagger.io";
        String updateUserEndPoint = "/v2/user/{userName}";

        Map<String, String> headers  = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");

        String createUserRequestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"string\",\n" +
                "  \"firstName\": \"variable\",\n" +
                "  \"lastName\": \"variable\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(petStoreServiceBaseUrl)
                .setBasePath(updateUserEndPoint)
                .addPathParam("userName", "string")
                .addHeaders(headers)
                .setBody(createUserRequestBody)
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

    }

    public static void getUser() {

        String petStoreServiceBaseUrl = "https://petstore.swagger.io";
        String getUserEndPoint = "/v2/user/{userName}";

        Map<String, String> headers  = new HashMap<>();
        headers.put("accept", "application/json");

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(petStoreServiceBaseUrl)
                .setBasePath(getUserEndPoint)
                .addPathParam("userName", "string")
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

    }

    public static void deleteUser() {

        String petStoreServiceBaseUrl = "https://petstore.swagger.io";
        String deleteUserEndPoint = "/v2/user/{userName}";

        Map<String, String> headers  = new HashMap<>();
        headers.put("accept", "application/json");

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(petStoreServiceBaseUrl)
                .setBasePath(deleteUserEndPoint)
                .addPathParam("userName", "string")
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

    }

    public static void main(String[] args) {
        creteUser();
        updateUser();
        getUser();
        deleteUser();
    }
}
