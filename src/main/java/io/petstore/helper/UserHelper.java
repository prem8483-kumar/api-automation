package io.petstore.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.petstore.model.User;
import io.petstore.service.UserService;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserHelper {

    public static Response creteUser(int userId, String userName) throws JsonProcessingException {

        User user = User.builder()
                .id(userId)
                .userName(userName)
                .firstName("prem")
                .lastName("kumar")
                .phone("8888888888")
                .email("prem.kumar@gmail.com")
                .password("pass")
                .userStatus(1)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String createUserRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        return UserService.creteUser(createUserRequest);

    }

    public static Response updateUser(int userId, String userName,
                                      String firstName, String lastName) throws JsonProcessingException {

        User user = User.builder()
                .id(userId)
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .phone("8888888888")
                .email("prem.kumar@gmail.com")
                .password("pass")
                .userStatus(1)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String createUserRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        return UserService.updateUser(userName, createUserRequest);


    }

    public static Response getUser(String userName,  String contentType) {

        Map<String, String> headers  = new HashMap<>();
        headers.put("accept", contentType);

        return UserService.getUser(userName, headers);

    }

    public static Response deleteUser(String userName, String contentType) {

        Map<String, String> headers  = new HashMap<>();
        headers.put("accept", contentType);

        return UserService.deleteUser(userName, headers);

    }

}
