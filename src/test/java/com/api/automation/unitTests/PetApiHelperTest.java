package com.api.automation.unitTests;

import com.api.automation.helper.PetApiHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PetApiHelperTest {

    @ParameterizedTest
    @ValueSource(strings = {"/src/test/resources/pets/createPet.json"})
    public void testCreatePetWithValidRequest(String reqFilePath) throws IOException {
        PetApiHelper petApiHelper = new PetApiHelper();
        assertNotNull(petApiHelper.createPet(reqFilePath));
    }

    @ParameterizedTest(name = "reqFilePath={0}, petStatus={1}")
    @CsvSource(value = {"/src/test/resources/pets/updatePet.json, sold"})
    public void testUpdatePetStatusWithValidRequest(String reqFilePath, String petStatus) throws IOException {
        PetApiHelper petApiHelper = new PetApiHelper();
        assertNotNull(petApiHelper.updatePet(reqFilePath, petStatus));
    }

    @ParameterizedTest
    @ValueSource(strings = {"sold"})
    public void testGetPetByStatusWithValidStatus(String petStatus) {
        PetApiHelper petApiHelper = new PetApiHelper();
        assertNotNull(petApiHelper.getPet(petStatus));
    }
}
