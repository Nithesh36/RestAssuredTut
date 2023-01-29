package org.automation.Tests;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class UsingResponseSpecMuliplePostCalls {

    ResponseSpecification responseSpecification;

    @BeforeSuite
    public void setUpExpectations()
    {
        responseSpecification = RestAssured.expect();
        responseSpecification.statusCode(200);
        responseSpecification.contentType(ContentType.JSON);
        //responseSpecification.time(Matchers.lessThan(9800L));
    }

    @Test(priority = 1)
    public void createBooking() {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .body("{\r\n" +
                        "    \"firstname\" : \"abi\",\r\n" +
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
                // Hit the request and get the response
                .post()
                // Validate the response
                .then()
                .log()
                .all()
                .spec(responseSpecification);
    }

    @Test(priority = 2)
    public void createBooking2() {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .body("{\r\n" +
                        "    \"firstname\" : \"madhan\",\r\n" +
                        "    \"lastname\" : \"Otwani\",\r\n" +
                        "    \"totalprice\" : 15,\r\n" +
                        "    \"depositpaid\" : false,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2021-01-01\",\r\n" +
                        "        \"checkout\" : \"2021-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Lunch\"\r\n" +
                        "}")
                .contentType(ContentType.JSON)
                // Hit the request and get the response
                .post()
                // Validate the response
                .then()
                .log()
                .all()
                .spec(responseSpecification);
    }
}
