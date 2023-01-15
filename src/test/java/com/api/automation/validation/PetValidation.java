package com.api.automation.validation;

import com.api.automation.pojo.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;

public class PetValidation {
    private static final Logger log = LogManager.getLogger(PetValidation.class);

    public static void validateCreatePetResponse(Response response) throws JsonProcessingException {

        assertEquals(200, response.getStatusCode());

        log.info("Validating response body");
        ObjectMapper objectMapper = new ObjectMapper();
        Pet pet = objectMapper.readValue(response.asString(), Pet.class);
    }

    public static void validateUpdatePetResponse(Response response, String petStatus) throws JsonProcessingException {

        assertEquals(200, response.getStatusCode());

        log.info("Validating response body");
        ObjectMapper objectMapper = new ObjectMapper();
        Pet pet = objectMapper.readValue(response.asString(), Pet.class);
        assertEquals(petStatus, pet.getStatus());
    }

    public static void validateGetPetResponse(Response response, String petStatus) {

        assertEquals(200, response.getStatusCode());

        log.info("Validating response body");
        JSONArray petArray = new JSONArray(response.asString());
        for(Object pet : petArray) {
            JSONObject petObject = (JSONObject)pet;
            assertEquals(petStatus, petObject.getString("status"));
        }
    }
}
