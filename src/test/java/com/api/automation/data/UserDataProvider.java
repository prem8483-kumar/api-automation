package com.api.automation.data;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "createUsersData")
    public Object[][] createUsersData() {
        return new Object[][] {
                {"/src/test/resources/users/createUsers.json"},
        };
    }

    @DataProvider(name = "updateUserData")
    public Object[][] updateUserData() {
        return new Object[][] {
                {"eve.holt", "/src/test/resources/users/updateUser.json"},
        };
    }

    @DataProvider(name = "getUserData")
    public Object[][] getUserData() {
        return new Object[][] {
                {"eve.holt"},
        };
    }
}
