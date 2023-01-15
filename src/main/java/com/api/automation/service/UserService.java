package com.api.automation.service;

import com.api.automation.constant.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserService {


    String createUsersEndPoint = "/user/createWithArray";
    String updateUserByUserNameEndPoint = " /user/{userName}";
    String getUserByUserNameEndPoint = " /user/{userName}";


    RequestSpecBuilder requestSpecBuilder;

    public UserService() {
        requestSpecBuilder = new RequestSpecBuilder().setBaseUri(Constants.USER_SERVICE_BASE_URL);
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

    public Response updateUserByUserName(String userName, String reqBody) {

        RequestSpecification requestSpecification = requestSpecBuilder
                .setBasePath(updateUserByUserNameEndPoint)
                .addPathParam("userName", userName)
                .setContentType(ContentType.JSON)
                .setBody(reqBody)
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
