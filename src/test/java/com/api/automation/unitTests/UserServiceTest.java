package com.api.automation.unitTests;

import com.api.automation.service.UserService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    @ParameterizedTest
    @ValueSource(strings = {"/src/test/resources/users/createUsers.json"})
    public void testCreateUsersWithValidRequest(String reqFilePath) throws IOException {
        UserService userService = new UserService();
        assertNotNull(userService.createUsers(new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + reqFilePath)))));
    }

    @ParameterizedTest(name = "userName={0}, reqFilePath={1}")
    @CsvSource(value = {"eve.holt, /src/test/resources/users/updateUser.json"})
    public void testUpdateUserByUserNameWithValidRequest(String userName, String reqFilePath) throws IOException {
        UserService userService = new UserService();
        assertNotNull(userService.updateUserByUserName(userName, new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + reqFilePath)))));
    }

    @ParameterizedTest
    @ValueSource(strings = {"eve.holt"})
    public void testGetUserByUserNameWithValidUserName(String userName) {
        UserService userService = new UserService();
        assertNotNull(userService.getUserByUserName(userName));
    }
}
