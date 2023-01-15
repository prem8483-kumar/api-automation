package com.api.automation.test;

import com.api.automation.data.PetDataProvider;
import com.api.automation.helper.PetApiHelper;
import com.api.automation.validation.PetValidation;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;

public class PetTest {

    @Test(description = "Create pet", dataProvider = "createPetData", dataProviderClass = PetDataProvider.class)
    public void testCreatePet(String reqFilePath) throws IOException {

        PetApiHelper petApiHelper = new PetApiHelper();
        Response response = petApiHelper.createPet(reqFilePath);

        PetValidation.validateCreatePetResponse(response);
    }

    @Test(description = "Update pet", dataProvider = "updatePetData", dataProviderClass = PetDataProvider.class)
    public void testUpdatePet(String reqFilePath, String petStatus) throws IOException {

        PetApiHelper petApiHelper = new PetApiHelper();
        Response response = petApiHelper.updatePet(reqFilePath, petStatus);

        PetValidation.validateUpdatePetResponse(response, petStatus);
    }

    @Test(description = "Get pet by status", dataProvider = "getPetData", dataProviderClass = PetDataProvider.class)
    public void testGetPet(String petStatus) {

        PetApiHelper petApiHelper = new PetApiHelper();
        Response response = petApiHelper.getPet(petStatus);

        PetValidation.validateGetPetResponse(response, petStatus);
    }
}
