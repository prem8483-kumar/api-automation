package com.api.automation.test;

import com.api.automation.data.PetDataProvider;
import com.api.automation.helper.PetApiHelper;
import com.api.automation.validation.PetValidation;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import java.io.IOException;

public class PetTest {
    private static final Logger log = LogManager.getLogger(UserTest.class);

    @Test(groups = {"pet"}, description = "Create pet", dataProvider = "createPetData", dataProviderClass = PetDataProvider.class)
    public void testCreatePet(String reqFilePath) throws IOException {

        log.info("Create pet");
        PetApiHelper petApiHelper = new PetApiHelper();
        Response response = petApiHelper.createPet(reqFilePath);

        PetValidation.validateCreatePetResponse(response);
    }

    @Test(groups = {"pet"}, description = "Update pet", dataProvider = "updatePetData", dataProviderClass = PetDataProvider.class)
    public void testUpdatePet(String reqFilePath, String petStatus) throws IOException {

        log.info("Update pet status");
        PetApiHelper petApiHelper = new PetApiHelper();
        Response response = petApiHelper.updatePet(reqFilePath, petStatus);

        PetValidation.validateUpdatePetResponse(response, petStatus);
    }

    @Test(groups = {"pet"}, description = "Get pet by status", dataProvider = "getPetData", dataProviderClass = PetDataProvider.class)
    public void testGetPet(String petStatus) {

        log.info("Get pet by status");
        PetApiHelper petApiHelper = new PetApiHelper();
        Response response = petApiHelper.getPet(petStatus);

        PetValidation.validateGetPetResponse(response, petStatus);
    }
}
