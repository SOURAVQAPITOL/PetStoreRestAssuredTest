package com.restassured.testcases;

import com.github.javafaker.Faker;
import com.restassured.endpoints.StoreEndpoints;
import com.restassured.payload.Store;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreTest {

    Faker faker;
    Store store;
    Response response;

    @BeforeClass
    public void setUP() {
        faker = new Faker();
        store = new Store();

        store.setStoreId(faker.idNumber().hashCode());
        store.setPetId(faker.number().hashCode());
        store.setQuantity(faker.number().hashCode());
        store.setShipDate("2024-12-19T04:31:38.082Z");
        store.setStatus("placed");
        store.setComplete(true);
    }

    @Test(priority = 1)
    public void verifyTheStoreInventory() {
        response = StoreEndpoints.getStore();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void verifyThePurchaseOrder(){
        response = StoreEndpoints.createOrder(store);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode() , 200);
    }

    @Test(priority = 3)
    public void verifyGetOrderByOrderID(){

        response = StoreEndpoints.getOrderByOrderID(store.getStoreId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 4)
    public void verifyTheDeleteOrder(){

        response = StoreEndpoints.deleteOrderByOrderID(store.getStoreId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
