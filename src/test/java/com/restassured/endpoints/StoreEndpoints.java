package com.restassured.endpoints;

import com.restassured.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.restassured.endpoints.Routes.post_Order;
import static io.restassured.RestAssured.given;

public class StoreEndpoints {

    static Response response;

    public static Response getStore() {

        response = given().when().get(Routes.get_Store);
        return response;
    }

    public static Response createOrder(Store storePayload) {

        response = given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(storePayload)
                .when().post(post_Order);

        return response;
    }

    public static Response getOrderByOrderID(int orderID) {

        response = given().pathParam("orderId", orderID)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get(Routes.get_Order);

        return response;
    }

    public static Response deleteOrderByOrderID(int orderID) {

        response = given().pathParam("orderId", orderID)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().delete(Routes.delete_Order);

        return response;
    }


}
