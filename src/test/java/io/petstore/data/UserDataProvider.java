package io.petstore.data;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name="createUserData")
    public Object[][] createUserData() {

        return new Object[][] {
                {0, "prem"},
                {1, "kumar"}
        };
    }

    @DataProvider(name="updateUserData")
    public Object[][] updateUserData() {

        return new Object[][] {
                {0, "prem", "first", "last"},
                {1, "kumar", "second", "secondLast"}
        };
    }

    @DataProvider(name="getUserData")
    public Object[][] getUserData() {

        return new Object[][] {
                {"prem", "application/json"},
                {"kumar", "application/json"}
        };
    }

}
