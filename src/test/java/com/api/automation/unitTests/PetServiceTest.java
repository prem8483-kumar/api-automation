package com.api.automation.unitTests;

import com.api.automation.service.PetService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PetServiceTest {

    @ParameterizedTest
    @ValueSource(strings = {"/src/test/resources/pets/createPet.json"})
    public void testCreatePetWithValidRequest(String reqFilePath) throws IOException {
        PetService petService = new PetService();
        assertNotNull(petService.createPet(new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + reqFilePath)))));
    }

    @ParameterizedTest
    @ValueSource(strings = {"/src/test/resources/pets/updatePet.json"})
    public void testUpdatePetStatusWithValidRequest(String reqFilePath) throws IOException {
        PetService petService = new PetService();
        assertNotNull(petService.updatePetStatus(new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + reqFilePath)))));
    }

    @ParameterizedTest
    @ValueSource(strings = {"sold"})
    public void testGetPetByStatusWithValidStatus(String petStatus) {
        PetService petService = new PetService();
        assertNotNull(petService.getPetByStatus(petStatus));
    }
}
