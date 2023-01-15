package com.api.automation.test;

import com.api.automation.data.UserDataProvider;
import com.api.automation.helper.UserApiHelper;
import com.api.automation.validation.UserValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;

public class UserTest {

    @Test(description = "Create users", dataProvider = "createUsersData", dataProviderClass = UserDataProvider.class)
    public void testCreateUsers(String reqFilePath) throws IOException {

        UserApiHelper userApiHelper = new UserApiHelper();
        Response response = userApiHelper.createUsers(reqFilePath);

        UserValidation.validateCreateUsersResponse(response);
    }

    @Test(description = "Update user by user name", dataProvider = "updateUserData", dataProviderClass = UserDataProvider.class)
    public void testUpdateUserByUserName(String userName, String reqFilePath) throws IOException {

        UserApiHelper userApiHelper = new UserApiHelper();
        Response response = userApiHelper.updateUserByUserName(userName, reqFilePath);

        UserValidation.validateUpdateUserResponse(response);

    }

    @Test(description = "Get user by user name", dataProvider = "getUserData", dataProviderClass = UserDataProvider.class)
    public void testGetUserByUserName(String userName) throws JsonProcessingException {

        UserApiHelper userApiHelper = new UserApiHelper();
        Response response = userApiHelper.getUserByUserName(userName);

        UserValidation.validateGetUserResponse(response, userName);
    }
}
