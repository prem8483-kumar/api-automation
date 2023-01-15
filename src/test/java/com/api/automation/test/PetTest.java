package com.api.automation.test;

import com.api.automation.data.PetDataProvider;
import com.api.automation.pojo.User;
import com.api.automation.service.PetService;
import com.api.automation.validation.PetValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PetTest {


    @Test(description = "Create pet", dataProvider = "createPetData", dataProviderClass = PetDataProvider.class)
    public void testCreatePet(String reqFile) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        reqFile = System.getProperty("user.dir") + reqFile;
        User user = objectMapper.readValue(reqFile, User.class);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        PetService petService = new PetService();
        Response response = petService.createPet(reqBody);

        PetValidation.validateCreatePetResponse(response);
    }

    @Test(description = "Update pet", dataProvider = "updatePetData", dataProviderClass = PetDataProvider.class)
    public void testUpdatePet(String reqFile) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        reqFile = System.getProperty("user.dir") + reqFile;
        User user = objectMapper.readValue(reqFile, User.class);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        PetService petService = new PetService();
        Response response = petService.updatePetStatus(reqBody);

        PetValidation.validateUpdatePetResponse(response);

    }

    @Test(description = "Get pet by status", dataProvider = "getPetData", dataProviderClass = PetDataProvider.class)
    public void testGetPet(String petStatus) {

        PetService petService = new PetService();
        Response response = petService.getPetByStatus(petStatus);

        PetValidation.validateGetPetResponse(response);
    }
}
