package com.api.automation.unitTests;

import com.api.automation.helper.UserApiHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserApiHelperTest {

    @ParameterizedTest
    @ValueSource(strings = {"/src/test/resources/users/createUsers.json"})
    public void testCreateUsersWithValidRequest(String reqFilePath) throws IOException {
        UserApiHelper userApiHelper = new UserApiHelper();
        assertNotNull(userApiHelper.createUsers(reqFilePath));
    }

    @ParameterizedTest(name = "userName={0}, reqFilePath={1}")
    @CsvSource(value = {"eve.holt, /src/test/resources/users/updateUser.json"})
    public void testUpdateUserByUserNameWithValidRequest(String userName, String reqFilePath) throws IOException {
        UserApiHelper userApiHelper = new UserApiHelper();
        assertNotNull(userApiHelper.updateUserByUserName(userName, reqFilePath));
    }

    @ParameterizedTest
    @ValueSource(strings = {"eve.holt"})
    public void testGetUserByUserNameWithValidUserName(String userName) {
        UserApiHelper userApiHelper = new UserApiHelper();
        assertNotNull(userApiHelper.getUserByUserName(userName));
    }
}
