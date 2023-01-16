package com.api.automation.test;

import com.api.automation.data.UserDataProvider;
import com.api.automation.helper.UserApiHelper;
import com.api.automation.validation.UserValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import java.io.IOException;

public class UserTest {
    private static final Logger log = LogManager.getLogger(UserTest.class);

    @Test(groups = {"user"}, description = "Create users", dataProvider = "createUsersData", dataProviderClass = UserDataProvider.class)
    public void testCreateUsers(String reqFilePath) throws IOException {

        log.info("Create users");
        UserApiHelper userApiHelper = new UserApiHelper();
        Response response = userApiHelper.createUsers(reqFilePath);

        UserValidation.validateCreateUsersResponse(response);
    }

    @Test(groups = {"user"}, description = "Update user by user name", dataProvider = "updateUserData", dataProviderClass = UserDataProvider.class)
    public void testUpdateUserByUserName(String userName, String reqFilePath) throws IOException {

        log.info("Update user by user name");
        UserApiHelper userApiHelper = new UserApiHelper();
        Response response = userApiHelper.updateUserByUserName(userName, reqFilePath);

        UserValidation.validateUpdateUserResponse(response);

    }

    @Test(groups = {"user"}, description = "Get user by user name", dataProvider = "getUserData", dataProviderClass = UserDataProvider.class)
    public void testGetUserByUserName(String userName) throws JsonProcessingException {

        log.info("Get user by user name");
        UserApiHelper userApiHelper = new UserApiHelper();
        Response response = userApiHelper.getUserByUserName(userName);

        UserValidation.validateGetUserResponse(response, userName);
    }
}
