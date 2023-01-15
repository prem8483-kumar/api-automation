package com.api.automation.unitTests;

import com.api.automation.service.UserService;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserServiceTest {

    @Test
    public void testCreateUsersWithValidRequest() throws IOException {
        UserService userService = new UserService();
        Assert.assertNotNull(userService.createUsers(new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/users/createUsers.json")))));
    }

    @Test
    public void testUpdateUserByUserNameWithValidRequest() throws IOException {
        UserService userService = new UserService();
        Assert.assertNotNull(userService.updateUserByUserName("", new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/users/updateUser.json")))));
    }

    @Test
    public void testGetUserByUserNameWithValidUserName() {
        UserService userService = new UserService();
        Assert.assertNotNull(userService.getUserByUserName("eve.holt"));
    }
}
