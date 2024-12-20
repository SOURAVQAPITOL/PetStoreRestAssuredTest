package com.restassured.endpoints;

public class Routes {

    public static String baseURI = "https://petstore.swagger.io/v2";
    public static String postUrl = baseURI + "/user";
    public static String getUrl = baseURI + "/user/{username}";
    public static String putUrl = baseURI + "/user/{username}";
    public static String deleteUrl = baseURI + "/user/{username}";

    public static String get_Store = baseURI +"/store/inventory";
    public static String post_Order = baseURI +"/store/order";
    public static String get_Order = baseURI +"/store/order/{orderId}";
    public static String delete_Order = baseURI +"/store/order/{orderId}";

}
