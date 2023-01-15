package com.api.automation.test;

import com.api.automation.data.UserDataProvider;
import com.api.automation.pojo.User;
import com.api.automation.service.UserService;
import com.api.automation.validation.UserValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserTest {

    @Test(description = "Create users", dataProvider = "createUsersData", dataProviderClass = UserDataProvider.class)
    public void testCreateUsers(String reqFile) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        reqFile = System.getProperty("user.dir") + reqFile;
        User user = objectMapper.readValue(reqFile, User.class);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        UserService userService = new UserService();
        Response response = userService.createUsers(reqBody);

        UserValidation.validateCreateUsersResponse(response);
    }

    @Test(description = "Update user by user name", dataProvider = "updateUserData", dataProviderClass = UserDataProvider.class)
    public void testUpdateUserByUserName(String userName, String reqFile) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        reqFile = System.getProperty("user.dir") + reqFile;
        User user = objectMapper.readValue(reqFile, User.class);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        UserService userService = new UserService();
        Response response = userService.updateUserByUserName(userName, reqBody);

        UserValidation.validateUpdateUserResponse(response);

    }

    @Test(description = "Get user by user name", dataProvider = "getUserData", dataProviderClass = UserDataProvider.class)
    public void testGetUserByUserName(String userName) {

        UserService userService = new UserService();
        Response response = userService.getUserByUserName(userName);

        UserValidation.validateGetUserResponse(response);
    }
}
