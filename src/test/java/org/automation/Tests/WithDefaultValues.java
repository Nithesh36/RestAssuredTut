package org.automation.Tests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WithDefaultValues {

    @BeforeTest
    public void setup()
    {
        System.out.println(Thread.currentThread().getId());
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        RestAssured.basePath = "booking";
        System.out.println("In Setup");
        RestAssured.requestSpecification = RestAssured.given().log().all();
        RestAssured.responseSpecification = RestAssured.expect().statusCode(200);
    }

    @Test
    public void createBooking1()
    {
        System.out.println(Thread.currentThread().getName());
        RestAssured
                .given()
                .body("{\r\n" +
                        "    \"firstname\" : \"muni\",\r\n" +
                        "    \"lastname\" : \"Mahajan\",\r\n" +
                        "    \"totalprice\" : 15,\r\n" +
                        "    \"depositpaid\" : false,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2021-01-01\",\r\n" +
                        "        \"checkout\" : \"2021-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Lunch\"\r\n" +
                        "}")
                .contentType(ContentType.JSON)
                .post()
                .then()
                .log()
                .all();
    }

    @Test
    public void createBooking2()
    {
        System.out.println(Thread.currentThread().getName());
        RestAssured
                .given()
                .body("{\r\n" +
                        "    \"firstname\" : \"Loki\",\r\n" +
                        "    \"lastname\" : \"Mahajan1\",\r\n" +
                        "    \"totalprice\" : 15,\r\n" +
                        "    \"depositpaid\" : false,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2021-01-01\",\r\n" +
                        "        \"checkout\" : \"2021-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Lunch\"\r\n" +
                        "}")
                .contentType(ContentType.JSON)
                .post()
                .then()
                .log()
                .all();
    }
}
