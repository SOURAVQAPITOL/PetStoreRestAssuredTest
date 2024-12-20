package com.restassured.testcases;

import com.github.javafaker.Faker;
import com.restassured.endpoints.UserEndpoints;
import com.restassured.payload.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {

    Faker faker;
    User user;
    Response response;

    @BeforeClass
    public void setUP() {
        faker = new Faker();
        user = new User();

        user.setId(faker.idNumber().hashCode());
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().toString());
        user.setUserStatus(faker.number().hashCode());
    }

    @Test(priority = 1)
    public void verifyCreateUser() {
        response = UserEndpoints.createUser(user);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void verifyGetUserByUserName() {
        response = UserEndpoints.getUserByUserName(user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void updateUserName() {
        user.setId(faker.idNumber().hashCode());
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().toString());
        user.setUserStatus(faker.number().hashCode());
        response = UserEndpoints.updateUserByUserName(user, user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void deleteUser() {
        response = UserEndpoints.deleteUserByUserName(user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
