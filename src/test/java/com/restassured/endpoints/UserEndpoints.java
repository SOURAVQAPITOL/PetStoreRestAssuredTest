package com.restassured.endpoints;

import com.restassured.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndpoints {

    static Response response;

    public static Response createUser(User userPayload) {

        response = given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(userPayload)
                .when().post(Routes.postUrl);

        return response;
    }

    public static Response getUserByUserName(String userName) {

        response = given().pathParam("username", userName)
                .when().get(Routes.getUrl);

        return response;
    }

    public static Response updateUserByUserName(User userPayload, String userName) {

        response = given().pathParam("username",userName).header("Content-Type", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(userPayload)
                .when().put(Routes.putUrl);

        return response;
    }

    public static Response deleteUserByUserName(String userName) {

        response = given().pathParam("username", userName)
                .when().delete(Routes.deleteUrl);

        return response;
    }
}
