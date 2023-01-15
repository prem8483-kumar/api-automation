package com.api.automation.service;

import com.api.automation.constant.EnvConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserService {


    String createUsersEndPoint = "/user/createWithArray";
    String updateUserNameEndPoint = " /user/{userName}";
    String getUserByUserNameEndPoint = " /user/{userName}";


    RequestSpecBuilder requestSpecBuilder;

    UserService() {
        requestSpecBuilder = new RequestSpecBuilder().setBaseUri(EnvConstants.BASE_URL);
    }

    public Response createUsers(String reqBody) {

        RequestSpecification requestSpecification = requestSpecBuilder
                .setBasePath(createUsersEndPoint)
                .setContentType(ContentType.JSON)
                .setBody(reqBody)
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

    public Response updateUserName(String userName, String reqBody) {

        RequestSpecification requestSpecification = requestSpecBuilder
                .setBasePath(updateUserNameEndPoint)
                .addPathParam("userName", userName)
                .setContentType(ContentType.JSON)
                .setBody(reqBody)
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


    public Response getUserByUserName(String userName) {

        RequestSpecification requestSpecification = requestSpecBuilder
                .setBasePath(getUserByUserNameEndPoint)
                .addPathParam("userName", userName)
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

}
