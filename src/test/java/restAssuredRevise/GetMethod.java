package restAssuredRevise;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GetMethod {
    public static void main(String[] args) {
        //        RestAssured.baseURI = "https://mp9ea90aa28cf5d1d362.free.beeceptor.com";
//        RequestSpecification request = RestAssured.given();
//        Response response = request.request(Method.GET, "/data");
//        System.out.println(response.asPrettyString());
//        System.out.println(response.getStatusLine());

        Response response = RestAssured.given().get("https://run.mocky.io/v3/1615c792-dbf9-4dc0-a999-366bca6c13d2");
//         ResponseBody body = RestAssured.given().get("").getBody();
//        ValidatableResponse body1 = RestAssured.given().get("").then().body("body", Matchers.hasLength(4));
//        JsonPath jsonPath = RestAssured.given().get("").jsonPath();
        Headers headers = response.getHeaders();
        System.out.println(headers.get("Content-Type"));

    }




}

