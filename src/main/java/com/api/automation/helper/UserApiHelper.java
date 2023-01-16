package com.api.automation.helper;

import com.api.automation.pojo.User;
import com.api.automation.pojo.Users;
import com.api.automation.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

public class UserApiHelper {

    public UserApiHelper() {

    }

    public Response createUsers(String reqFilePath) throws IOException {

        reqFilePath = System.getProperty("user.dir") + reqFilePath;
        File reqFile = new File(reqFilePath);

        ObjectMapper objectMapper = new ObjectMapper();
        Users users = objectMapper.readValue(reqFile, Users.class);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users.getUsers());

        UserService userService = new UserService();
        Response response = userService.createUsers(reqBody);
        return response;
    }

    public Response updateUserByUserName(String userName, String reqFilePath) throws IOException {

        reqFilePath = System.getProperty("user.dir") + reqFilePath;
        File reqFile = new File(reqFilePath);

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(reqFile, User.class);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        UserService userService = new UserService();
        Response response = userService.updateUserByUserName(userName, reqBody);
        return response;

    }

    public Response getUserByUserName(String userName) {

        UserService userService = new UserService();
        Response response = userService.getUserByUserName(userName);
        return  response;

    }

}
