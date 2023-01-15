package com.api.automation.data;

import org.testng.annotations.DataProvider;

public class PetDataProvider {

    @DataProvider(name = "createPetData")
    public Object[][] createUsersData() {
        return new Object[][] {
                {"/src/test/resources/pets/createPet.json"},
        };
    }

    @DataProvider(name = "updatePetData")
    public Object[][] updateUserData() {
        return new Object[][] {
                {"/src/test/resources/pets/updatePet.json"},
        };
    }

    @DataProvider(name = "getPetData")
    public Object[][] getUserData() {
        return new Object[][] {
                {"available"},
                {"pending"},
                {"sold"},
        };
    }
}
