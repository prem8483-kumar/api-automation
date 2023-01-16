package com.api.automation.service;

import com.api.automation.constant.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetService extends Service{


    String createPetEndPoint = "/pet";
    String updatePetStatusEndPoint = "/pet";
    String getPetByStatusEndPoint = "/pet/findByStatus";

    RequestSpecBuilder requestSpecBuilder;

    public PetService() {
        requestSpecBuilder = new RequestSpecBuilder().setBaseUri(Constants.PET_SERVICE_BASE_URL);
    }

    public Response createPet(String reqBody) {

        RequestSpecification requestSpecification = requestSpecBuilder
                .setBasePath(createPetEndPoint)
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

    public Response updatePetStatus(String reqBody) {

        RequestSpecification requestSpecification = requestSpecBuilder
                .setBasePath(updatePetStatusEndPoint)
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


    public Response getPetByStatus(String status) {

        RequestSpecification requestSpecification = requestSpecBuilder
                .setBasePath(getPetByStatusEndPoint)
                .addQueryParam("status", status)
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
