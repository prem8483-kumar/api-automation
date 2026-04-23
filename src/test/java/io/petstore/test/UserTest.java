package io.petstore.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.petstore.data.UserDataProvider;
import io.petstore.helper.UserHelper;
import io.petstore.validation.UserResponseValidation;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    @Test(groups = {"smoke", "regression"}, dataProvider = "createUserData", dataProviderClass = UserDataProvider.class)
    public void createUserTest(int userId, String userName) throws JsonProcessingException {

        Response response = UserHelper.creteUser(userId, userName);
        UserResponseValidation.validateCreateUserResponse(response);
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "updateUserData",
            dataProviderClass = UserDataProvider.class)
    public void updateUserTest(int userId, String userName, String firstName, String lastName) throws JsonProcessingException {

        Response response = UserHelper.updateUser(userId, userName, firstName, lastName);
        UserResponseValidation.validateUpdateUserResponse(response);

    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "getUserData",
            dataProviderClass = UserDataProvider.class)
    public void getUserTest(String userName, String contentType) throws JsonProcessingException {

        Response response = UserHelper.getUser(userName, contentType);
        UserResponseValidation.validateGetUserResponse(response, userName);


    }

    @Test(groups = {"regression"},dataProvider = "getUserData", dataProviderClass = UserDataProvider.class)
    public void deleteUserTest(String userName, String contentType) {

        Response response = UserHelper.deleteUser(userName, contentType);
        UserResponseValidation.validateDeleteUserResponse(response);

    }

}
