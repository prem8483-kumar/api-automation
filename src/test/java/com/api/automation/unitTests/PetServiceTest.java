package com.api.automation.unitTests;

import com.api.automation.service.PetService;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetServiceTest {

    @Test
    public void testCreatePetWithValidRequest() throws IOException {
        PetService petService = new PetService();
        Assert.assertNotNull(petService.createPet(new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/pets/createPet.json")))));
    }

    @Test
    public void testUpdatePetStatusWithValidRequest() throws IOException {
        PetService petService = new PetService();
        Assert.assertNotNull(petService.updatePetStatus(new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/pets/updatePet.json")))));
    }

    @Test
    public void testGetPetByStatusWithValidStatus() {
        PetService petService = new PetService();
        Assert.assertNotNull(petService.getPetByStatus("sold"));
    }
}
