package com.api.automation.helper;

import com.api.automation.pojo.Pet;
import com.api.automation.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

public class PetApiHelper {

    public PetApiHelper() {

    }

    public Response createPet(String reqFilePath) throws IOException {

        reqFilePath = System.getProperty("user.dir") + reqFilePath;
        File reqFile = new File(reqFilePath);

        ObjectMapper objectMapper = new ObjectMapper();
        Pet pet = objectMapper.readValue(reqFile, Pet.class);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pet);

        PetService petService = new PetService();
        Response response = petService.createPet(reqBody);

        return response;

    }

    public Response updatePet(String reqFilePath) throws IOException {

        reqFilePath = System.getProperty("user.dir") + reqFilePath;
        File reqFile = new File(reqFilePath);

        ObjectMapper objectMapper = new ObjectMapper();
        Pet pet = objectMapper.readValue(reqFile, Pet.class);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pet);

        PetService petService = new PetService();
        Response response = petService.updatePetStatus(reqBody);

        return response;
    }

    public Response getPet(String petStatus) {

        PetService petService = new PetService();
        Response response = petService.getPetByStatus(petStatus);
        return response;

    }

}
